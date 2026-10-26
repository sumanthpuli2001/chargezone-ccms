<%-- 
    Document   : ApproveOneVendorView
    Created on : 3 Nov, 2025, 3:38:52 PM
    Author     : fnp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>Buyer Approval</title>        

    </head>

    <body>
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
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

            <section class="main-content">
                <form:form action="vendorInformation.htm?act=ButtonBuyerFinalApproval" method="post" name='form1' class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)" alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)" alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Buyer Approval</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>
                            <!--<button type="submit" class="btn theme-btn" id="submit1" title="submit1">Send To Approve</button>-->
                        </div>
                    </div>
                    <hr>
                    
        
                    <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <strong>Note:</strong> Ensure your file size is within <strong>5MB</strong> for a smooth upload. <br>
                            <span style="font-weight: bold;">*</span>  Indicate That Attachment Are Mandatory
                        </div>
                    </div>
                    <br>
                    
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

                                                <table class="table table-bordered custom-table mb-3" id="" style="width:100%;">                                                        <thead> 
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
                                                                    <c:if test="${vendorInformation1.policy1File!=null && not empty vendorInformation1.policy1File}">                                        
                                                                        <span class="file-wrapper">
                                                                            <span class="file-name text-break">${vendorInformation1.policy1File}</span>
                                                                            <span class="file-actions">
                                                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation1.policy1File}&id=${vendorInformation1.id}"><span class="fa fa-download"></span></a>
                                                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/${vendorInformation1.policy1File}"><span class="fa fa-solid fa-eye"></span></a>
                                                                            </span>
                                                                        </span>
                                                                    </c:if>
                                                                </td>
                                                                <th style="">    <c:if test="${list.ndaPolicyAccept=='1'}">NDA (Sign & Stamp in all Pages)</c:if>
                                                                    <c:if test="${list.ndaPolicyAccept=='0'}">NDA Policy</c:if></th> 
                                                                <td><c:if test="${list.ndaPolicyAccept=='1'}">Accept</c:if>
                                                                    <c:if test="${list.ndaPolicyAccept=='0'}"><span style="color: red;">Not Accept</span></c:if><br>
                                                                    <c:if test="${vendorInformation1.ndaPolicyFile!=null && not empty vendorInformation1.ndaPolicyFile}">                                        
                                                                        <span class="file-wrapper">
                                                                            <span class="file-name text-break">${vendorInformation1.ndaPolicyFile}</span>
                                                                            <span class="file-actions">
                                                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation1.ndaPolicyFile}&id=${vendorInformation1.id}"><span class="fa fa-download"></span></a>
                                                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/${vendorInformation1.ndaPolicyFile}"><span class="fa fa-solid fa-eye"></span></a>
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
                                                                    <c:if test="${vendorInformation1.companyProof!=null && not empty vendorInformation1.companyProof}">                                        
                                                                        <span class="file-wrapper">
                                                                            <span class="file-name text-break">${vendorInformation1.companyProof}</span>
                                                                            <span class="file-actions">
                                                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation1.companyProof}&id=${vendorInformation1.id}"><span class="fa fa-download"></span></a>
                                                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/${vendorInformation1.companyProof}"><span class="fa fa-solid fa-eye"></span></a>
                                                                            </span>
                                                                        </span>
                                                                    </c:if>
                                                                    <c:if test="${vendorInformation1.companyProof2!=null && not empty vendorInformation1.companyProof2}">
                                                                        <br>
                                                                        <span class="file-wrapper">
                                                                            <span class="file-name text-break">${vendorInformation1.companyProof2}</span>
                                                                            <span class="file-actions">
                                                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation1.companyProof2}&id=${vendorInformation1.id}"><span class="fa fa-download"></span></a>
                                                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/${vendorInformation1.companyProof2}"><span class="fa fa-solid fa-eye"></span></a>
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

                                           <div class="table-responsive">
                                                <table class="table table-bordered custom-table mb-3" id="" style="width:100%;">                                                        <thead> 
                                                            <thead <tr class="table-title">
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

                                                <table class="table table-bordered custom-table mb-3" id="" style="width:100%;">                                                        <thead> 
                                                                <tr class="table-title">
									  <td colspan="3" style="font-weight: bold; background-color: skyblue;  text-align: center; ">TYPES OF VENDORS </td>
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

                                           <div class="table-responsive">
                                                <table class="table table-bordered custom-table mb-3" id="" style="width:100%;">                                                        <thead> 
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
                                                                        All Attachments <a  href="vendorInformation.htm?act=pastWorkingExpDetailsDocxdownloadzip&id1=${list.id}" style="text-decoration: none; color: black; font-size: 16px;">
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

                                        
                                                    <div class="table-responsive">
                                                <table class="table table-bordered custom-table mb-3" id="" style="width:100%;">                                                        <thead> 
                                                            <thead>
                                                                <tr class="table-title">
									  <td colspan="3" style="font-weight: bold; background-color: skyblue; text-align: center;">COMPANY REGISTRATION DETAILS </td>
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
                                                                    <c:if test="${vendorInformation1.msmeStatus=='0'}"><strong>MSME Not Available</strong></c:if>
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
                                                                    <c:if test="${vendorInformation1.esicStatus=='0'}"><strong>ESIC Not Available</strong></c:if>
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
                                                                    <c:if test="${vendorInformation1.epfoStatus=='0'}"><strong>EPFO Not Available</strong></c:if>
                                                                    ${vendorInformation1.pfNo}<br>
                                                                    <c:if test="${vendorInformation1.pfAttachment!=null && not empty vendorInformation1.pfAttachment}">                                        
                                                                        <span class="file-wrapper">
                                                                            <span class="file-name text-break">${vendorInformation1.pfAttachment}</span>
                                                                            <span class="file-actions">
                                                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation1.pfAttachment}&id=${vendorInformation1.id}"><span class="fa fa-download"></span></a>
                                                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation1.id}/${vendorInformation1.pfAttachment}"><span class="fa fa-solid fa-eye"></span></a>
                                                                            </span>
                                                                        </span>
                                                                    </c:if>
                                                                </td>
                                                                <th style="width: 20%;">Import Export Code </th>
                                                                <td> 
                                                                    <c:if test="${vendorInformation1.eccStatus == '0'}"><strong>ECC Not Available</strong></c:if>
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
                                             </c:forEach>

                                                <table class="table table-bordered custom-table mb-3" id="" style="width:100%;">                                                       
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

                                           <div class="table-responsive">
                                                <table class="table table-bordered custom-table mb-3" id="" style="width:100%;">                                                        <thead> 
                                                        <thead>
                                                            <tr class="table-title">
                                                                <td colspan="3" style="font-weight: bold; background-color: skyblue; text-align: center;">FINANCIAL STATEMENT (PROFIT AND LOSS / BALANCE SHEET)</td>
                                                                    <td style="font-weight: bold; background-color: skyblue;">
                                                                    All Attachments <a  href="vendorInformation.htm?act=financialStatementDetailsDocxdownloadzip&id1=${vendorInformation1.id}" style="text-decoration: none; color: black; font-size: 16px;">
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
                                                <c:if test="${vendorInformation1.auditorAttachment!=null && not empty vendorInformation1.auditorAttachment && not empty vendorInformation1.riskBand}">                                        

                                                    <table class="table table-bordered custom-table mb-3" id="" style="width:100%;">                                                         
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
                                                                <th>Risk Evaluator's Comment</th>
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

                                             <div class="main-container">
                                                <table class="table table-bordered custom-table mb-3" id="" style="width:100%;">                                                        <thead> 
                                                        <thead>
                                                            <tr class="table-title">
                                                                <td colspan="7" style="font-weight: bold; background-color: skyblue; text-align: center;">EXTERNAL VENDOR EMAIL</td>
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

                                                <table class="table table-bordered custom-table mb-3" id="" style="width:100%;">                                                        <thead> 

                                                        <!-- COMPANY DETAILS TITLE -->
                                                        <tr class="table-title">
                                                            <td colspan="7" style="font-weight: bold; background-color: skyblue; text-align: center;">COMPANY DETAILS</td>
                                                        </tr>

                                                        <tr>
                                                            <th colspan="2">Company</th>
                                                            <th colspan="2">Purchasing Organization</th>
                                                            <th>Action</th>
                                                        </tr>

                                                        <tr id="companyRow1">
                                                            <td colspan="2">
                                                                <select class="select-input" name="companyCode" id="companyCode" onchange="populatePurchasing(this, 1)">
                                                                    <option value="">--Select--</option>
                                                                    <c:forEach var="company" items="${companyList}">
                                                                        <option value="${company.companyCode}">${company.companyCode}</option>
                                                                    </c:forEach>
                                                                </select>
                                                            </td>

                                                            <td colspan="2">
                                                                <select class="select-input" name="purchasingOrganisation" id="purchasingOrganisation1">
                                                                    <option value="">--Select--</option>
                                                                </select>
                                                            </td>

<!--                                                            <td>
                                                                <input type="button" value="+" id="addCompanyRowBtn" />
                                                            </td>-->
                                                          <td style=" text-align: center">
                                                        <div class="d-flex justify-content-center align-items-center">
                                                            <div class="clone-action clone-new-field d-flex justify-content-center align-items-center mb-2" id="addCompanyRowBtn" style="cursor:pointer;">
                                                                <img src="StorageYard/assets/images/clone-btn.svg" onload="SVGInject(this)" alt="Clone Btn" />
                                                            </div>
                                                        </div>
                                                    </td>
                                                        </tr>

                                                        <tr id="companyRowsEndMarker" style="display:none;"></tr>

                                                        <tr class="table-title" id="sapDetailsRow">
                                                            <td colspan="7" style="font-weight: bold; background-color: skyblue; text-align: center;">SAP DETAILS</td>
                                                        </tr>

                                                        <tr >
                                                            <td>Currency : <span style="color: red;font-size: 12px;">*</span></td>
                                                            <td>
                                                                <select class="select-input" required="true" name="currency" id="currency">
                                                                    <option value="">--Select--</option>
                                                                    <c:forEach var="currencyList" items="${currencyList}">
                                                                        <option value="${currencyList.currencyCode}">${currencyList.currencyCode}</option>
                                                                    </c:forEach>
                                                                </select>
                                                            </td>
                                                            <td colspan="1">BP Group : <span style="color: red;font-size: 12px;">*</span></td>
                                                            <td colspan="2">
                                                                <select class="select-input" name="bpGroup" required="true" id="bpGroup">
                                                                    <option value="">--Select--</option>
                                                                    <c:forEach var="list333" items="${list333}">
                                                                        <option value="${list333.bpGroupName}  - ${list333.discription}">${list333.bpGroupName}  -  ${list333.discription}</option>
                                                                    </c:forEach>
                                                                </select>
                                                            </td>
                                                        </tr>

                                                        <tr>
                                                            <td>Search Term : <span style="color: red;font-size: 12px;">*</span></td>
                                                            <td>
                                                                <input type="text" required="true" name="searchTerm" id="searchTerm" class="input-field">
                                                            </td>
                                                            <td colspan="1"> </td>
                                                            <td colspan="2"></td>
                                                        </tr>
                                                    </table>

                                                    <input type="hidden" name="companyRowCount" id="companyRowCount" value="1" />

                                                    <script>
                                                        var companyRowCount = 1;

                                                        $(function () {
                                                            $("#addCompanyRowBtn").on("click", function () {

                                                                companyRowCount++;

                                                                var row = "<tr id='companyRow" + companyRowCount + "'>"
                                                                        + "<td colspan='2'>"
                                                                        + "<select class='select-input' name='companyCode' id='companyCode" + companyRowCount + "'"
                                                                        + " onchange='populatePurchasing(this, " + companyRowCount + ")'>"
                                                                        + "<option value=''>--Select--</option>"
                                                                        + "<c:forEach var='company' items='${companyList}'>"
                                                                        + "<option value='${company.companyCode}'>${company.companyCode}</option>"
                                                                        + "</c:forEach>"
                                                                        + "</select>"
                                                                        + "</td>"

                                                                        + "<td colspan='2'>"
                                                                        + "<select class='select-input' name='purchasingOrganisation' id='purchasingOrganisation" + companyRowCount + "'>"
                                                                        + "<option value=''>--Select--</option>"
                                                                        + "</select>"
                                                                        + "</td>"

//                                                                        + "<td>"
//                                                                        + "<input type='button' value='-' onclick='removeCompanyRow(\"companyRow" + companyRowCount + "\")' />"
//                                                                        + "</td>"
            + "<td style=' text-align: center; vertical-align: middle;'>" 
            +"<span style='margin-top: 5px; display: inline-block;'>" 
               + "<div class='clone-action delete-parent-field removeRowBtn' title='Remove' style='cursor: pointer; display:inline-flex; align-items: center; justify-content: center;' onclick='removeCompanyRow(\"companyRow" + companyRowCount + "\")';>" 
                   + "<img src='StorageYard/assets/images/clone-delete-btn.svg' onload='SVGInject(this)' alt='Remove' style='width: 300%;'>" 
             +  "</div>" 
          +  "</span>" 
      +  "</td>"
                                                                        + "</tr>";

                                                                // ********** IMPORTANT: insert the new company row BEFORE the SAP details row **********
                                                                $("#sapDetailsRow").before(row);

                                                                // update hidden counter
                                                                $("#companyRowCount").val(companyRowCount);
                                                            });
                                                        });

                                                        // Remove row logic
                                                        function removeCompanyRow(rowId) {
                                                            var row = document.getElementById(rowId);
                                                            if (row) {
                                                                row.parentNode.removeChild(row);
                                                            }
                                                        }

                                                        // Cascading purchasing organization logic
                                                        function populatePurchasing(selectElement, rowIndex) {
                                                            var selectedCompany = selectElement.value;
                                                            var purchasingSelect = document.getElementById("purchasingOrganisation" + rowIndex);
                                                            purchasingSelect.innerHTML = "<option value=''>--Select--</option>";

                                                            if (selectedCompany !== "") {
                                                        <c:forEach var="purchasing" items="${purchasingList}">
                                                                if ("${purchasing.companyCode}" === selectedCompany) {
                                                                    var opt = document.createElement("option");
                                                                    opt.value = "${purchasing.purchasingOrganisation}";
                                                                    opt.text = "${purchasing.purchasingOrganisation}";
                                                                    purchasingSelect.appendChild(opt);
                                                                }
                                                        </c:forEach>
                                                            }
                                                        }
                                                    </script>

                                                <table class="table table-bordered custom-table mb-3" id="" style="width:100%;">                                                        <thead> 
                                                        <tr>
                                                        <tr class="table-title">
                                                            <td colspan="4" style="font-weight: bold; background-color: skyblue; text-align: center;">APPROVALS</td>
                                                        </tr>
                                                        <td>Financial Approval :<span style="color: red;font-size: 12px;">*</span></td>
                                                        <td>
                                                            <select class="select-input" id="financialApproval" name="financialApproval" style="font-size: 12px; padding: 5px;" required="required">
                                                                <option value="">--SELECT--</option>
                                                                <c:forEach var="financialList" items="${financialList}">
                                                                    <option value="${financialList}">${financialList}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </td>
                                                        <c:if test="${!empty technicalList}">
                                                            <td>Technical Approval :<span style="color: red;font-size: 12px;">*</span></td>
                                                            <td>
                                                                <select class="select-input" id="technicalApproval" name="technicalApproval" style="font-size: 12px; padding: 5px;" required="required">
                                                                    <option value="">--SELECT--</option>
                                                                    <c:forEach var="technicalList" items="${technicalList}">
                                                                        <option value="${technicalList}">${technicalList}</option>
                                                                    </c:forEach>
                                                                </select>
                                                            </td>
                                                        </c:if>
                                                        </tr>

                                                        <tr>
                                                            <c:if test="${!empty hrList}">
                                                                <td>HR Approval :<span style="color: red;font-size: 12px;">*</span></td>
                                                                <td>
                                                                    <select class="select-input" id="hrApproval" name="hrApproval" style="font-size: 12px; padding: 5px;" required="required">
                                                                        <option value="">--SELECT--</option>
                                                                        <c:forEach var="hrList" items="${hrList}">
                                                                            <option value="${hrList}">${hrList}</option>
                                                                        </c:forEach>
                                                                    </select>
                                                                </td>
                                                            </c:if>

                                                            <c:if test="${!empty safetyList}">
                                                                <td>Safety Approval :<span style="color: red;font-size: 12px;">*</span></td>
                                                                <td>
                                                                    <select class="select-input" id="safetyApproval" name="safetyApproval" style="font-size: 12px; padding: 5px;" required="required">
                                                                        <option value="">--SELECT--</option>
                                                                        <c:forEach var="safetyList" items="${safetyList}">
                                                                            <option value="${safetyList}">${safetyList}</option>
                                                                        </c:forEach>
                                                                    </select>
                                                                </td>
                                                            </c:if>
                                                        </tr>

                                                        <tr>
                                                            <c:if test="${!empty itList}">
                                                                <td>IT Approval :<span style="color: red;font-size: 12px;">*</span></td>
                                                                <td>
                                                                    <select class="select-input" id="itApproval" name="itApproval" style="font-size: 12px; padding: 5px;" required="required">
                                                                        <option value="">--SELECT--</option>
                                                                        <c:forEach var="itList" items="${itList}">
                                                                            <option value="${itList}">${itList}</option>
                                                                        </c:forEach>
                                                                    </select>
                                                                </td>
                                                            </c:if>
                                                        </tr>

                                                    </table><br>

                        <script>
                            var companyRowCount = 1;

                            // ✅ Convert purchasingList to JS object
                            var purchasingMap = {};
                            <c:forEach var="p" items="${purchasingList}">
                            if (!purchasingMap["${p.companyCode}"]) {
                                purchasingMap["${p.companyCode}"] = [];
                            }
                            purchasingMap["${p.companyCode}"].push("${p.purchasingOrganisation}");
                            </c:forEach>

                            $(function () {
                                $("#addCompanyRowBtn").on("click", function () {
                                    companyRowCount++;

                                    var row = `
                                            < tr id = "companyRow${companyRowCount}" >
                                            < td class = "pl-0" >
                                            < select class = "select-input" name = "companyCode" id = "companyCode${companyRowCount}" onchange = "populatePurchasing(this, ${companyRowCount})" >
                                            < option value = "" > --Select-- < /option>
                            <%-- this part is rendered by server once --%>
                            <c:forEach var="company" items="${companyList}">
                                    < option
                                    value = "${company.companyCode}" >${company.companyCode} < /option>
                            </c:forEach>
                                    < /select>
                                            < /td>
                                            < td >
                                            < select class = "select-input" name = "purchasingOrganisation" id = "purchasingOrganisation${companyRowCount}" >
                                            < option value = "" > --Select-- < /option>
                                    
                                            < /select>
                                            < /td>
                                            < td class = "pr-0" >
                                            < div class = "clone-action delete-parent-field mx-auto" title = "Remove" onclick = "removeCompanyRow('companyRow${companyRowCount}')" >
                                            < img src = "StorageYard/assets/images/clone-delete-btn.svg" onload = "SVGInject(this)" alt = "Remove" / >
                                            < /div>
                                            < /td>
                                            < /tr>`;

                                            $("#companyTable").append(row);
                                    $('.select-input').selectpicker('refresh');
                                    $("#companyRowCount").val(companyRowCount);
                                });
                            });

                            function removeCompanyRow(rowId) {
                                $("#" + rowId).remove();
                            }

                            // ✅ JS function to populate purchasing list
                            function populatePurchasing(selectElement, rowIndex) {
                                var selectedCompany = selectElement.value;
                                var purchasingSelect = document.getElementById("purchasingOrganisation" + rowIndex);
                                purchasingSelect.innerHTML = "<option value=''>--Select--</option>";

                                if (selectedCompany && purchasingMap[selectedCompany]) {
                                    purchasingMap[selectedCompany].forEach(function (org) {
                                        var opt = document.createElement("option");
                                        opt.value = org;
                                        opt.text = org;
                                        purchasingSelect.appendChild(opt);
                                    });
                                }

                                $('.select-input').selectpicker('refresh');
                            }
                        </script>


                                    <div class="col-lg-12 p-0">
                                        <div class="form-group">
                                            <label class="control-label">Comment :<span class="text-danger">*</span></label>
                                            <textarea name="comment" style="text-transform: uppercase;" class="textarea-field comment" maxlength="250" required="required"></textarea>
                                        </div>
                                    </div>
                                        <div class="cta d-flex align-items-center justify-content-center">
                                            <button type="submit" class="btn theme-btn" id="submit1" title="submit1">
                                                Send To Accept
                                            </button>
                                        </div>
                                        <br>
                                        <table class="table table-bordered custom-table mb-3" id="" style="width:100%;">                                                        

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
                                 </div>


                </form:form>
            </section>
        </main> 
    </body>

    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
