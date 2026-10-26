<%-- 
    Document   : AuditorApprovalActiveDetailsView
    Created on : 7 Jan, 2025, 1:37:51 PM
    Author     : bulwarks-2
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>Risk Evaluator Approval</title>
        <script>            
            function recycle() {
                var id = document.getElementsByName('id1');
                y = id[0].value;
                var comment = document.getElementsByName('comment');
                comment1 = comment[0].value;
                window.location = 'vendorInformation.htm?act=RecycleButtonApproval&id=' + y + '&comment=' + comment1;
            }
            function reject() {
                var id = document.getElementsByName('id1');
                y = id[0].value;
                var comment = document.getElementsByName('comment');
                comment1 = comment[0].value;
                window.location = 'vendorInformation.htm?act=rejectvendor&id=' + y + '&comment=' + comment1;
            }

            function viewClick(id) {
                var loginName = $('#loginName' + id).val();
                window.location = 'approvalSetting.htm?act=viewClick&id=' + loginName;
            }
            function deleteCheck11() {
                var checkboxes = "";
                checkboxes = document.getElementsByName('checkId');
                for (var i = 0, n = checkboxes.length; i < n; i++) {
                    if (checkboxes[i].checked) {
                        return true;
                    }
                }
                alert("Please, Select one or more record(s).");
                return false;
            }

        </script>
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
    </head>

    <body>
        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNewAuditor.jsp"%>

            <section class="main-content">
                <form:form action="vendorInformation.htm?act=ButtonActiveApprovals" method="post"
                           name='form1' class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)" alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)" alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Risk Evaluator Approval</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>
                            <!--<button type="button" class="btn theme-btn" title="" style="width: 100px;" onclick="print()">&nbsp;&nbsp;print</button>-->
  <!--                        <a href="vendorInformation.htm?act=ProcurementHeadApprovalDetailsViewPrint&id=${checkId}" 
                                 class="btn theme-btn">
                                  Print
                              </a> -->
                            <a href="vendorInformation.htm?act=RiskEvaluatorApprovalPrint&id=${checkId}" 
                               class="btn theme-btn">
                                Print
                            </a> 

                        </div>
                    </div>
                    <hr>
                    <c:if test="${!empty successMessage}">
                        <div id="successMsg" class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                    </c:if>
                    <c:if test="${!empty failureMessage}">
                        <div id="failureMsg" class="fadeOutEffect alert alert-danger" style="padding: 0px" role="alert">${failureMessage}</div>
                    </c:if>

                    <c:forEach var="list" items="${list}" varStatus="status">
                        <input type="hidden" id="id" name="id" value="${list.id}">
                        <input type="hidden" id="id1" name="id1" value="${list.id}">

                        <table class="table table-bordered custom-table mb-3" id="policyTable" style="width:100%;">                                                        <thead> 
                            <thead>
                                <tr class="table-title">
                                    <td colspan="3" style="font-weight: bold; background-color: skyblue;">Vendor Details</td>
                                    <td style="font-weight: bold; background-color: skyblue;">
                                        All Attachments <a  href="vendorInformation.htm?act=vendorDetailsDocxdownloadzip&id1=${list.id}" style="text-decoration: none; color: black; font-size: 16px;">
                                            &nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                        </a>
                                    </td>
                                </tr>
                                <tr >
                                    <th>Company Name</th>
                                    <td>${list.companyName}</td>
                                    <th>Email Id </th>
                                    <td>${list.vendorEmailId}</td>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th>   <c:if test="${list.policyAccept=='1'}">Code of COnduct (Sign & Stamp in all Pages)</c:if>
                                        <c:if test="${list.policyAccept=='0'}">Deviation Policy</c:if></th>
                                        <td>
                                        <c:if test="${list.policyAccept=='1'}">Accept</c:if>
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

                                    <th>   
                                        <c:if test="${list.ndaPolicyAccept=='1'}">NDA (Sign & Stamp in all Pages)</c:if>
                                        <c:if test="${list.ndaPolicyAccept=='0'}">NDA Policy</c:if></th>
                                        <td>
                                        <c:if test="${list.ndaPolicyAccept=='1'}">Accept</c:if>
                                        <c:if test="${list.ndaPolicyAccept=='0'}">
                                            <span style="color: red;">Not Accept</span>
                                        </c:if>
                                        <br>
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
                                <tr >
                                    <th>Type of Company</th>
                                    <td>${list.typeOfConcern}</td>
                                    <th>Proof Of Attachment</th>
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
                                    <th>Year of Establishment of Company</th>
                                    <td>${list.establishment}</td>
                                    <th>Risk Category</th>
                                    <td class="riskCategory">${list.riskCategory}</td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="table-responsive">
                            <table class="table table-bordered custom-table mb-3" id="policyTable" style="width:100%;">                                                        

                                <thead>

                                    <tr class="table-title">
                                        <td colspan="8" style="font-weight: bold; background-color: skyblue;">Register Address</td>
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
                                        <th>Postal Code</th>
                                        <td>${list.officePin}</td>
                                    </tr>

                                    <tr>
                                        <th>Mobile No</th>
                                        <td>+${list.countryCodeoffTele}-${list.officeTelephone}</td>
                                        <th>Email</th>
                                        <td>${list.officeEmail}</td>
                                    </tr>
                                    <tr>
                                        <th>Website</th> 
                                        <td>${list.officeWebsite}</td>
                                        <th></th> 
                                        <td></td>
                                    </tr>

                                </tbody>
                            </table>
                        </div>
                        <div class="table-responsive">
                            <table class="table table-bordered custom-table mb-3" id="policyTable" style="width:100%;">                                                      
                                <thead>

                                    <tr class="table-title">
                                        <td colspan="8" style="font-weight: bold; background-color: skyblue;">Communication Address</td>
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
                                        <th>Postal Code</th>
                                        <td>${declaration.altPostalCode}</td>
                                    </tr>

                                    <tr>
                                        <th>Mobile No</th>
                                        <td>+${list.countryCodeNewMobiles}-${declaration.altTelephone}</td>
                                        <th>Email</th>
                                        <td>${declaration.altEmail}</td>
                                    </tr>

                                    <tr>                                                                    
                                        <th>Website</th>
                                        <td>${declaration.altWebsite}</td>
                                        <th></th>
                                        <td></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>

                        <div class="form-group">       
                            <table class="table table-bordered custom-table mb-3" id="policyTable" style="width:100%;">                                                        <thead> 
                                <tr class="table-title">
                                    <td colspan="8" style="font-weight: bold; background-color: skyblue;">Type Of Vendors</td>
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
                        </div>


                        <div class="table-responsive">
                            <table class="table table-bordered custom-table mb-3" id="policyTable" style="width:100%;">                                                     
                                <thead>
                                    <tr class="table-title">
                                        <td colspan="7" style="font-weight: bold; background-color: skyblue;">Vendor Contacts</td>
                                    </tr>
                                    <tr>
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
                            <table class="table table-bordered custom-table mb-3" id="policyTable" style="width:100%;">                                                        <thead> 
                                <thead>
                                    <tr class="table-title">
                                        <td colspan="7" style="font-weight: bold; background-color: skyblue;">MANAGERIAL PERSON DETAILS</td>
                                    </tr>
                                    <tr>
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
                            <table class="table table-bordered custom-table mb-3" id="policyTable" style="width:100%;">                                                       
                                <thead>
                                    <tr class="table-title">
                                        <td colspan="5" style="font-weight: bold; background-color: skyblue;">  PAST WORKING EXPERIENCE DETAILS </td>
                                        <td style="font-weight: bold; background-color: skyblue;">
                                            All Attachments <a  href="vendorInformation.htm?act=pastWorkingExpDetailsDocxdownloadzip&id1=${vendorInformation1.id}" style="text-decoration: none; color: black; font-size: 16px;">
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

                        <div class="table-responsive">
                            <table class="table table-bordered custom-table mb-3" id="policyTable" style="width:100%;">                                                       
                                <thead >
                                    <tr class="table-title">
                                        <td colspan="3" style="font-weight: bold; background-color: skyblue;">Company Registration Details</td>
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
                            <table class="table table-bordered custom-table mb-3" id="policyTable" style="width:100%;">                                                        <thead> 
                                <thead>
                                    <tr class="table-title">
                                        <td colspan="3" style="font-weight: bold; background-color: skyblue;">FINANCIAL STATEMENT (PROFIT AND LOSS / BALANCE SHEET)</td>
                                        <td style="font-weight: bold; background-color: skyblue;">
                                            All Attachments <a  href="vendorInformation.htm?act=financialStatementDetailsDocxdownloadzip&id1=${vendorInformation1.id}" style="text-decoration: none; color: black; font-size: 16px;">
                                                &nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                            </a>
                                        </td>
                                    </tr>
                                    <tr>
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

                        <table class="table table-bordered custom-table mb-3" id="policyTable" style="width:100%;">                                                        
                            <thead>
                                <tr class="table-title">
                                    <td colspan="7" style="font-weight: bold; background-color: skyblue;">Self Declaration Form</td>
                                </tr>
                                <tr>
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
                        <table class="table table-bordered custom-table mb-3" id="policyTable" style="width:100%;">                                                        
                            <thead>
                                <tr class="table-title">
                                    <td colspan="7" style="font-weight: bold; background-color: skyblue;">External Vendor Email</td>
                                </tr>
                                <tr>
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
                        <br>

                        <div class="table-responsive">
                            <table class="table table-bordered custom-table mb-3">                                                        
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
                                </thead>
                                <tbody>
                                    <tr>
                                        <th>Attachment</th>
                                        <td>
                                            <c:if test="${list.auditorAttachment!=null && not empty list.auditorAttachment}">                                        
                                                <span class="file-wrapper">
                                                    <span class="file-name text-break">${list.auditorAttachment}</span>
                                                      <span class="file-actions">
                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.auditorAttachment}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.auditorAttachment}"><span class="fa fa-solid fa-eye"></span></a>
                                                    </span>
                                                </span>
                                            </c:if>
                                        </td>
                                        <th>Band</th>
                                        <td>${list.riskBand}</td>
                                        <th>Comment</th>
                                        <td>${list.auditorRemark}</td>
                                    </tr>
                                </tbody>

                            </table>
                        </div>

                        <table class="table table-bordered custom-table mb-3" id="policyTable" style="width:100%;">                                                        
                            <thead>
                                <tr class="table-title">
                                    <td colspan="7" style="font-weight: bold; background-color: skyblue;">Approval History</td>
                                </tr>
                                <tr>
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

                    </c:forEach>
                </form:form>
            </section>
        </main> 
    </body>

    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>