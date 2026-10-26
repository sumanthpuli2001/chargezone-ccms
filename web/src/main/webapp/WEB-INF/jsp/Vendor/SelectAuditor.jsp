<%-- 
    Document   : SelectAuditor
    Created on : 14 Oct, 2025, 09:52:57 AM
    Author     : fnp
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

    <head>
        <title>Buyer Approval</title>
    </head>

    <body>
        <style>           
            input[type="text"], textarea {
                text-transform: uppercase;
            }
            .wrap-text {
                display: block;
                white-space: normal;
                word-break: break-word;
                overflow-wrap: anywhere;
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

            <section id="printSection" class="main-content">
                <form:form action="vendorInformation.htm?act=ButtonBuyerApproval" method="post"
                           name='form1' class="form-horizontal" role="form">
                    <c:forEach var="list" items="${list}" varStatus="status">
                        <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                            <div class="page-title d-flex align-items-center">
                                <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                    <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                         alt="Menu collapse">
                                    <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                         alt="Menu collapse">
                                </div>
                                <h5 class="fw-600 mb-0">Buyer Approval</h5>
                            </div>
                            <div class="cta d-flex align-items-center">
                                <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>                                            
                            </div>
                        </div>
                        <hr>                        

                        <input type="hidden" id="vendorInformationid" name="vendorInformationid" value="${list.id}">
                        <input type="hidden" id="id" name="id" value="${list.id}">
                        <input type="hidden" id="id1" name="id1" value="${list.id}">

                        <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">
                            <thead>
                                <tr>
                                    <td colspan="4" style="border:1px solid black; background-color:skyblue; text-align:center;">
                                        <strong>VENDOR DETAILS</strong>
                                    </td>
                                </tr>
                            </thead>

                            <tbody>
                                <tr>
                                    <th style="width:20%">Company Name</th>
                                    <td style="width:30%">${list.companyName}</td>

                                    <th style="width:20%">Email Id</th>
                                    <td style="width:30%">${list.vendorEmailId}</td>
                                </tr>
                                <tr>
                                    <th style="width:20%">Type of Company</th>
                                    <td style="width:30%">${list.typeOfConcern}</td>

                                    <th style="width:20%">Year of Establishment</th>
                                    <td style="width:30%">${list.establishment}</td>
                                </tr>

                                <tr>
                                    <th>
                                        <c:if test="${list.policyAccept=='1'}">Code of Conduct (Sign & Stamp in all Pages)</c:if>
                                        <c:if test="${list.policyAccept=='0'}">Deviation Policy</c:if>
                                        </th>
                                        <td>
                                        <c:if test="${list.policyAccept=='1'}">Accept</c:if>
                                        <c:if test="${list.policyAccept=='0'}"><span style="color:red;">Not Accept</span></c:if><br>
                                        <c:if test="${list.policy1File!=null && not empty list.policy1File}">                                        
                                            <span class="file-wrapper">
                                                <span class="file-name text-break">${list.policy1File}</span>
                                                <span class="file-actions">
                                                    <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.policy1File}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.policy1File}"><span class="fa fa-solid fa-eye"></span></a>
                                                </span>
                                            </span>
                                        </c:if>
                                        <br>
                                        <label><input type="radio" class="radio" required name="cocStatuss" value="accept" onclick="toggleRemark(this)" <c:if test="${bApproval.cocStatuss=='accept'}">checked</c:if>>Accept</label>
                                        <label><input type="radio" class="radio" required name="cocStatuss" value="reject" onclick="toggleRemark(this)" <c:if test="${bApproval.cocStatuss=='reject'}">checked</c:if>>Reject</label>
                                            <div class="remark-box" style="display:none; margin-top:5px;">
                                                <textarea  class="textarea-field" style="text-transform: uppercase;" name="cocRemarkk" placeholder="Enter remark" rows="2" cols="30" maxlength="250" required>${bApproval.cocRemarkk}</textarea>
                                            <c:if test="${not empty bApproval.cocResponse}">
                                                <textarea  class="textarea-field" style="text-transform: uppercase;"  name="cocResponse" placeholder="Enter remark" rows="2" cols="30" maxlength="250" readonly>${bApproval.cocResponse}</textarea>                                                        
                                            </c:if>
                                        </div>                                            
                                    </td>

                                    <th>
                                        <c:if test="${list.ndaPolicyAccept=='1'}">NDA (Sign & Stamp in all Pages)</c:if>
                                        <c:if test="${list.ndaPolicyAccept=='0'}">NDA Policy</c:if>
                                        </th>
                                        <td>
                                        <c:if test="${list.ndaPolicyAccept=='1'}">Accept</c:if>
                                        <c:if test="${list.ndaPolicyAccept=='0'}"><span style="color:red;">Not Accept</span></c:if><br>
                                        <c:if test="${list.ndaPolicyFile!=null && not empty list.ndaPolicyFile}">                                        
                                            <span class="file-wrapper">
                                                <span class="file-name text-break">${list.ndaPolicyFile}</span>
                                                <span class="file-actions">
                                                    <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.ndaPolicyFile}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.ndaPolicyFile}"><span class="fa fa-solid fa-eye"></span></a>
                                                </span>
                                            </span>
                                        </c:if>
                                        <br>
                                        <label><input type="radio" class="radio" required name="ndaStatuss" value="accept" onclick="toggleRemark(this)" <c:if test="${bApproval.ndaStatuss=='accept'}">checked</c:if>>Accept</label>
                                        <label><input type="radio" class="radio" required name="ndaStatuss" value="reject" onclick="toggleRemark(this)" <c:if test="${bApproval.ndaStatuss=='reject'}">checked</c:if>>Reject</label>
                                            <div class="remark-box" style="display:none; margin-top:5px;">
                                                <textarea  class="textarea-field" name="ndaRemarkk" placeholder="Enter remark" style="text-transform: uppercase;" rows="2" cols="30" maxlength="250" required>${bApproval.ndaRemarkk}</textarea>
                                            <c:if test="${not empty bApproval.ndaResponse}">
                                                <textarea  class="textarea-field" style="text-transform: uppercase;" name="ndaResponse" placeholder="Enter remark" rows="2" cols="30" maxlength="250" readonly>${bApproval.ndaResponse}</textarea>                                                        
                                            </c:if>
                                        </div>
                                    </td>
                                </tr>

                                <tr>
                                    <th>
                                        <c:choose>
                                            <c:when test="${list.typeOfConcern == 'Sole Proprietorship'}">
                                                Shop & Establishment License
                                            </c:when>
                                            <c:when test="${list.typeOfConcern == 'Hindu Undivided Family ( HUF)'}">
                                                Shop & Establishment License and HUF Deed
                                            </c:when>
                                            <c:when test="${list.typeOfConcern == 'Partnership Firm'}">
                                                Shop & Establishment License and Partnership Deed
                                            </c:when>
                                            <c:when test="${list.typeOfConcern == 'Limited Liability Partnership ( LLP)'}">
                                                Shop & Establishment License and LLP Agreement
                                            </c:when>
                                            <c:when test="${list.typeOfConcern == 'Private/Public Company'}">
                                                Certificate of Incorporation (MCA)
                                            </c:when>
                                            <c:when test="${list.typeOfConcern == 'Free Lancer'}">
                                                Professional Profile / Resume
                                            </c:when>
                                            <c:otherwise>Proof Of Attachment</c:otherwise>
                                        </c:choose>
                                    </th>
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
                                        <br>
                                        <label><input type="radio" class="radio" required name="tocStatuss" value="accept" onclick="toggleRemark(this)" <c:if test="${bApproval.tocStatuss=='accept'}">checked</c:if>>Accept</label>
                                        <label><input type="radio" class="radio" required name="tocStatuss" value="reject" onclick="toggleRemark(this)" <c:if test="${bApproval.tocStatuss=='reject'}">checked</c:if>>Reject</label>
                                            <div class="remark-box" style="display:none; margin-top:5px;">
                                                <textarea  class="textarea-field"  style="text-transform: uppercase;" name="tocRemarkk" placeholder="Enter remark" rows="2" cols="30" maxlength="250" required>${bApproval.tocRemarkk}</textarea>
                                            <c:if test="${not empty bApproval.tocResponse}">
                                                <textarea  class="textarea-field"  style="text-transform: uppercase;" name="tocResponse" placeholder="Enter remark" rows="2" cols="30" maxlength="250" readonly>${bApproval.tocResponse}</textarea>                                                        
                                            </c:if>
                                        </div>
                                    </td>
                                    <c:if test="${!empty list.companyProof2}">
                                        <td>
                                            <c:if test="${list.companyProof2!=null && not empty list.companyProof2}">
                                                <span class="file-wrapper">
                                                    <span class="file-name text-break">${list.companyProof2}</span>
                                                    <span class="file-actions">
                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${list.companyProof2}&id=${list.id}"><span class="fa fa-download"></span></a>
                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${list.id}/${list.companyProof2}"><span class="fa fa-solid fa-eye"></span></a>
                                                    </span>
                                                </span>
                                            </c:if>                                            
                                            <br>
                                            <label><input type="radio" class="radio" required name="tocStatuss1" id="tocStatuss1" value="accept" onclick="toggleRemark(this)" <c:if test="${bApproval.tocStatuss1=='accept'}">checked</c:if>>Accept</label>
                                            <label><input type="radio" class="radio" required name="tocStatuss1" id="tocStatuss1" value="reject" onclick="toggleRemark(this)" <c:if test="${bApproval.tocStatuss1=='reject'}">checked</c:if>>Reject</label>
                                                <div class="remark-box" style="display:none; margin-top:5px;">
                                                    <textarea  class="textarea-field"  style="text-transform: uppercase;" name="tocRemarkk1" placeholder="Enter remark" rows="2" cols="30" maxlength="250" required>${bApproval.tocRemarkk1}</textarea>
                                                <c:if test="${not empty bApproval.tocResponse1}">
                                                    <textarea  class="textarea-field"  style="text-transform: uppercase;" name="tocResponse1" placeholder="Enter remark" rows="2" cols="30" maxlength="250" readonly>${bApproval.tocResponse1}</textarea>                                                        
                                                </c:if>
                                            </div>
                                        </td>
                                    </c:if>

                                </tr>

                            </tbody>
                        </table>
                        
                        <table class="table table-bordered custom-table mb-3" id="policyTable" style="width:100%;">
                            <thead>
                                <tr>
                                    <th id="policyTableHeader" colspan="6" style=" text-align: center; background-color: skyblue">
                                        <strong>TYPES OF VENDORS</strong>
                                    </th>
                                </tr>
                                <tr>                                    
                                    <th>Group Name</th>
                                    <th>Group Category Name</th>
                                    <th colspan="2">Group Sub Category Name</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list222" items="${list222}" varStatus="status">
                                    <tr>
                                        <input type="hidden"  class="input-field" id="groupId" name="groupId" value="${list222[2]}<" />
                                        <td>${list222[2]}</td>
                                        <td>${list222[3]}</td>
                                        <td>${list222[4]}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                        <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">
                            <thead>
                                <tr>
                                    <td colspan="4" style="border:1px solid black; background-color:skyblue; text-align:center;">
                                        <strong>REGISTER ADDRESS</strong>
                                    </td>
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

                        <div class="table-responsive">
                            <table class="table table-bordered custom-table mb-3" id="policyTable" style="width:100%;  ">
                                <thead>
                                    <tr>
                                        <th id="policyTableHeader" colspan="8" style=" text-align: center; background-color: skyblue">
                                            <strong>COMMUNICATION ADDRESS</strong>
                                        </th>
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

                        

                        <div class="table-responsive">
                            <table class="table table-bordered custom-table mb-3" id="policyTable" style="width:100%;  ">
                                <thead>
                                    <tr>
                                        <th id="policyTableHeader" colspan="6" style=" text-align: center; background-color: skyblue">
                                            <strong>VENDOR CONTACTS</strong>
                                        </th>
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
                            <table class="table table-bordered custom-table mb-3" id="policyTable" style="width:100%;  ">
                                <thead>
                                    <tr>
                                        <th id="policyTableHeader" colspan="6" style=" text-align: center; background-color: skyblue">
                                            <strong>MANAGERIAL PERSON DETAILS</strong>
                                        </th>
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
                            <table class="table table-bordered custom-table mb-3" id="policyTable" style="width:100%;">

                                <thead>
                                    <tr class="table-title">
                                        <th colspan="6" style="font-weight: bold; text-align: center; background-color: skyblue;">
                                            <strong>PAST WORKING EXPERIENCE DETAILS</strong>
                                        </th>
                                        <th style="font-weight: bold; background-color: skyblue;">
                                            All Attachments <a href="vendorInformation.htm?act=pastWorkingExpDetailsDocxdownloadzip&id1=${list.id}" style="text-decoration: none; color: black; font-size: 16px;">
                                                &nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                            </a>
                                        </th>
                                    </tr>
                                    <tr>
                                        <th>Company Name</th>
                                        <th>Contact Person Name</th>
                                        <th>Phone No.</th>
                                        <th>Email</th>
                                        <th>Designation</th>
                                        <th>UnPriced PO / Work Complition Certificate</th>
                                        <th>Response</th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <c:forEach var="lstwork" items="${lstwork}" varStatus="lst">

                                        <tr>
                                    <input type="hidden" name="lwId" value="${lstwork.id}"/>
                                    <td>${lstwork.companyName}</td>
                                    <td>${lstwork.contactPersonName}</td>
                                    <td>+${lstwork.countryCode}-${lstwork.mobileNumber}</td>
                                    <td>${lstwork.email}</td>
                                    <td>${lstwork.designation}</td>
                                    <td>
                                        <c:if test="${not empty lstwork.attchment}">
                                            <c:if test="${lstwork.attchment!=null && not empty lstwork.attchment}">                                        
                                                <span class="file-wrapper">
                                                    <span class="file-name text-break">${lstwork.attchment}</span>
                                                    <span class="file-actions">
                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadLastWorkingFileAprrove&fileName=${lstwork.attchment}&id=${lstwork.vendorInformationId}"><span class="fa fa-download"></span></a>
                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${lstwork.vendorInformationId}/LAST/${lstwork.attchment}"><span class="fa fa-solid fa-eye"></span></a>
                                                    </span>
                                                </span>
                                            </c:if>                           
                                            <br>
                                            <label><input type="radio" class="radio" required name="Statuss${lst.count}" id="Statuss${lst.count}" value="accept" onclick="toggleRemark(this)" <c:if test="${lstwork.statuss=='accept'}">checked</c:if>>Accept</label>
                                            <label><input type="radio" class="radio" required name="Statuss${lst.count}" id="Statuss${lst.count}" value="reject" onclick="toggleRemark(this)" <c:if test="${lstwork.statuss=='reject'}">checked</c:if>>Reject</label>
                                                <div class="remark-box" style="display:none; margin-top:5px;">
                                                    <textarea  class="textarea-field" style="text-transform: uppercase;" name="Remarkk" placeholder="Enter remark" rows="2" cols="30" maxlength="250" required>${lstwork.remarkk}</textarea>
                                            </div>
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:if test="${not empty lstwork.attchment && lstwork.statuss=='reject'}">
                                            ${lstwork.response}
                                        </c:if>
                                    </td>
                                    </tr>
                                </c:forEach>
                                </tbody>

                            </table>
                        </div>
                                                <div class="table-responsive">
                            <table class="table table-bordered custom-table mb-3" style="width:100%;">
                                <thead>
                                    <tr class="table-title">
                                        <td colspan="4" style="font-weight: bold; background-color: skyblue; text-align: center;">COMPANY REGISTRATION DETAILS</td>
                                        <td style="font-weight: bold; background-color: skyblue;">
                                            All Attachments <a href="vendorInformation.htm?act=companyRegDetailsDocxdownloadzip&id1=${list.id}" style="text-decoration: none; color: black; font-size: 16px;">
                                                &nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                            </a>
                                        </td>
                                    </tr>
                                    <tr>
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
                                            <label><input required type="radio" class="radio" name="gstStatuss" value="accept" onclick="toggleRemark(this)" <c:if test="${bApproval.gstStatuss=='accept'}">checked</c:if>> Accept</label>
                                            <label><input required type="radio" class="radio" name="gstStatuss" value="reject" onclick="toggleRemark(this)" <c:if test="${bApproval.gstStatuss=='reject'}">checked</c:if>> Reject</label>
                                                <div class="remark-box" style="display:none; margin-top:5px;">
                                                    <textarea  class="textarea-field" style="text-transform: uppercase;" name="gstRemarkk" placeholder="Enter remark" rows="2" cols="30" maxlength="250" required>${bApproval.gstRemarkk}</textarea>
                                            </div>                                                                            
                                        </td>
                                        <td>
                                            <c:if test="${bApproval.gstStatuss=='reject'}">
                                                ${bApproval.gstResponse}
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
                                            <label><input type="radio" class="radio" required name="panStatuss" value="accept" onclick="toggleRemark(this)" <c:if test="${bApproval.panStatuss=='accept'}">checked</c:if>>Accept</label>
                                            <label><input type="radio" class="radio" required name="panStatuss" value="reject" onclick="toggleRemark(this)" <c:if test="${bApproval.panStatuss=='reject'}">checked</c:if>>Reject</label>
                                                <div class="remark-box" style="display:none; margin-top:5px;">
                                                    <textarea  class="textarea-field" style="text-transform: uppercase;" name="panRemarkk" placeholder="Enter remark" rows="2" cols="30" maxlength="250" required>${bApproval.panRemarkk}</textarea>
                                            </div>                                                                            
                                        </td>
                                        <td>
                                            <c:if test="${bApproval.panStatuss=='reject'}">
                                                ${bApproval.panResponse}
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
                                            <label><input type="radio" class="radio" required name="msmeStatuss" value="accept" onclick="toggleRemark(this)" <c:if test="${bApproval.msmeStatuss=='accept'}">checked</c:if>>Accept</label>
                                            <label><input type="radio" class="radio" required name="msmeStatuss" value="reject" onclick="toggleRemark(this)" <c:if test="${bApproval.msmeStatuss=='reject'}">checked</c:if>>Reject</label>
                                                <div class="remark-box" style="display:none; margin-top:5px;">
                                                    <textarea  class="textarea-field" style="text-transform: uppercase;" name="msmeRemarkk" placeholder="Enter remark" rows="2" cols="30" maxlength="250" required>${bApproval.msmeRemarkk}</textarea>
                                            </div>                                                                            
                                        </td>
                                        <td>
                                            <c:if test="${bApproval.msmeStatuss=='reject'}">
                                                ${bApproval.msmeResponse}
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
                                            <label><input type="radio" class="radio" required name="esicStatuss" value="accept" onclick="toggleRemark(this)" <c:if test="${bApproval.esicStatuss=='accept'}">checked</c:if>>Accept</label>
                                            <label><input type="radio" class="radio" required name="esicStatuss" value="reject" onclick="toggleRemark(this)" <c:if test="${bApproval.esicStatuss=='reject'}">checked</c:if>>Reject</label>
                                                <div class="remark-box" style="display:none; margin-top:5px;">
                                                    <textarea  class="textarea-field" style="text-transform: uppercase;" name="esicRemarkk" placeholder="Enter remark" rows="2" cols="30" maxlength="250" required>${bApproval.esicRemarkk}</textarea>
                                            </div>                                                                            
                                        </td>
                                        <td>
                                            <c:if test="${bApproval.esicStatuss=='reject'}">
                                                ${bApproval.esicResponse}
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
                                            <label><input type="radio" class="radio" required name="epfoStatuss" value="accept" onclick="toggleRemark(this)" <c:if test="${bApproval.epfoStatuss=='accept'}">checked</c:if>>Accept</label>
                                            <label><input type="radio" class="radio" required name="epfoStatuss" value="reject" onclick="toggleRemark(this)" <c:if test="${bApproval.epfoStatuss=='reject'}">checked</c:if>>Reject</label>
                                                <div class="remark-box" style="display:none; margin-top:5px;">
                                                    <textarea  class="textarea-field"  style="text-transform: uppercase;" name="epfoRemarkk" placeholder="Enter remark" rows="2" cols="30" maxlength="250" required>${bApproval.epfoRemarkk}</textarea>
                                            </div>                                                                            
                                        </td>
                                        <td>
                                            <c:if test="${bApproval.epfoStatuss=='reject'}">
                                                ${bApproval.epfoResponse}
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
                                                <label><input type="radio" class="radio" required name="eccStatuss" value="accept" onclick="toggleRemark(this)" <c:if test="${bApproval.eccStatuss=='accept'}">checked</c:if>>Accept</label>
                                                <label><input type="radio" class="radio" required name="eccStatuss" value="reject" onclick="toggleRemark(this)" <c:if test="${bApproval.eccStatuss=='reject'}">checked</c:if>>Reject</label>
                                                    <div class="remark-box" style="display:none; margin-top:5px;">
                                                        <textarea  class="textarea-field"  style="text-transform: uppercase;" name="eccRemarkk" placeholder="Enter remark" rows="2" cols="30" maxlength="250" required>${bApproval.eccRemarkk}</textarea>
                                                </div>
                                            </c:if>
                                        </td>
                                        <td>
                                            <c:if test="${list.eccStatus!='0' && bApproval.eccStatuss=='reject'}">
                                                ${bApproval.eccResponse}
                                            </c:if>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>

                        <div class="table-responsive">
                            <table class="table table-bordered custom-table mb-3" id="policyTable" style="width:100%;">
                                <thead>
                                    <tr class="table-title">
                                        <td colspan="7" style="font-weight: bold; background-color: skyblue; text-align: center;">BANK DETAILS</td>
                                    </tr>
                                    <tr >
                                        <th style="" >Account Number</th>
                                        <td>${list.accountNumber}</td>
                                        <th style="">Bank Name </th>
                                        <td>${list.bankName}</td>
                                        <th style="">Branch</th>
                                        <td>${list.branch}</td>

                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th style="">IFSC Code</th>
                                        <td>${list.ifscCode}</td>
                                        <th colspan="1" style="">Swift Code (if any) </th>
                                        <td colspan="3"> ${list.swiftCode}</td>
                                    </tr>
                                    <tr>
                                        <th>Cancel Cheque </th>
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
                                            <label><input required type="radio" class="radio" name="cancelChequeStatuss" value="accept" onclick="toggleRemark(this)" <c:if test="${bApproval.cancelChequeStatuss=='accept'}">checked</c:if>> Accept</label>
                                            <label><input required type="radio" class="radio" name="cancelChequeStatuss" value="reject" onclick="toggleRemark(this)" <c:if test="${bApproval.cancelChequeStatuss=='reject'}">checked</c:if>> Reject</label>
                                                <div class="remark-box" style="display:none; margin-top:5px;">
                                                    <textarea class="textarea-field" name="cancelChequeRemarkk" placeholder="Enter remark" rows="2" cols="30" maxlength="250">${bApproval.cancelChequeRemarkk}</textarea>
                                            </div>
                                        </td>
                                        <th>Response:</th>
                                        <td colspan="2">
                                            <c:if test="${bApproval.cancelChequeStatuss=='reject'}">
                                                ${bApproval.cancelChequeResponse}
                                            </c:if>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>

                        <table class="table table-bordered custom-table mb-3" id="" style="width:100%;">                            
                            <thead>
                                <tr class="table-title">
                                    <td colspan="7" style="font-weight: bold;text-align: center; background-color: skyblue;">SELF DECLARATION FORM</td>
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
                                
                        

                        <div class="rounded-4 mt-4">
                            <div class="row mb-3">
                                <div class="col-lg-12 col-md-6">
                                    <div class="form-group">
                                        <label class="control-label">Buyer Comment :<span class="text-danger">*</span></label>
                                        <textarea name="comment" class="textarea-field comment" maxlength="250" required></textarea>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                    <div class="rounded-4 mt-4 align-items-center" id="acceptBuyer">
                        <div class="row mb-3">
                            <div class="col-lg-12 col-md-6">
                                <div class="form-group">
                                    <div style="display:flex; justify-content:center;">
                                        <button type="button" id="submit2" class="btn theme-btn mr-3" onclick="accept()">Accept</button>

                                        <button type="submit" class="btn theme-btn recycle-btn mr-3" id="reworkBtn" formaction="vendorInformation.htm?act=RecycleVendorBuyer&id=${vendorInformation1.id}">Rework</button>

                                        <button type="submit" class="btn theme-btn recycle-btn" id="rejectBtn" formaction="vendorInformation.htm?act=RejectVendorBuyer&id=${vendorInformation1.id}">Reject</button>
                                    </div>
                                        

                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="rounded-4 mt-4 d-none" id="acceptedBuyer">
                        <div class="row mb-3 m-0">
                            <table class="table table-bordered custom-table mb-3" style="width:100%;">
                                <thead>
                                    <tr class="table-title">
                                        <td colspan="7" style="text-align: center;font-weight: bold; background-color: skyblue;">AUDITOR DETAILS</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td width="25%">Risk Category : <span style="color:red;font-size:12px;">*</span></td>
                                        <td width="25%">
                                            <select class="select-input" name="riskCategory" id="riskCategory" required>
                                                <option value="">--Select--</option>
                                                <option value="low" ${vendorInformation1.riskCategory=='low' ? 'selected' : ''}>Low</option>
                                                <option value="medium" ${vendorInformation1.riskCategory=='medium' ? 'selected' : ''}>Medium</option>
                                                <option value="high" ${vendorInformation1.riskCategory=='high' ? 'selected' : ''}>High</option>
                                            </select>
                                        </td>
                                        <td id="auditorLabelTd"></td>
                                        <td id="auditorSelectTd">
                                            <select class="select-input " name="auditor" id="auditorHigh">
                                                <c:forEach var="a" items="${auditors}">
                                                    <option value="${a.auditorCode}" <c:if test="${vendorInformation1.riskCategory=='high' and vendorInformation1.auditorName==a.auditorName}">selected</c:if>>
                                                        ${a.auditorName}
                                                    </option>
                                                </c:forEach>
                                            </select>

                                        </td>
                                    </tr>                                    
                                </tbody>
                            </table>

                            <div class="col-lg-12 col-md-12">
                                <div class="form-group">
                                    <div style="display:flex; justify-content:center;">
                                        <button type="submit" id="sendForApproval" class="btn theme-btn">Accept</button>                                        
                                    </div>
                                </div>
                            </div>                         
                        </div>
                    </div>

                    <script>
                        $(document).ready(function () {

                            $("#auditorLabelTd").hide();
                            $("#auditorHigh").closest(".bootstrap-select").hide();

                            $("#riskCategory").on("change", function () {
                                updateAuditorDropdown();
                            });

                        });

                        function updateAuditorDropdown() {

                            var risk = $("#riskCategory").val();

                            $("#auditorLabelTd").hide();

                            if ($("#auditorHigh").closest(".bootstrap-select").length) {
                                $("#auditorHigh").closest(".bootstrap-select").hide();
                            } else {
                                $("#auditorHigh").hide();
                            }

                            $("#auditorHigh").prop("required", false);
                            $("#auditorHigh").prop("disabled", true);

                            if (risk === "high") {

                                $("#auditorLabelTd").html(
                                    'Risk Evaluator : <span style="color:red;font-size:12px;">*</span>'
                                ).show();

                                $("#auditorHigh").prop("required", true);
                                $("#auditorHigh").prop("disabled", false);

                                if ($("#auditorHigh").closest(".bootstrap-select").length) {
                                    $("#auditorHigh").closest(".bootstrap-select").show();
                                    $("#auditorHigh").selectpicker("refresh");
                                } else {
                                    $("#auditorHigh").show();
                                }
                            }
                        }

                        function accept() {

                            $("#acceptBuyer").addClass("d-none");
                            $("#acceptedBuyer").removeClass("d-none");

                            $('.select-input').selectpicker('refresh');

                            updateAuditorDropdown();
                        }
                        </script>
                                


                    <c:if test="${!empty vendorApproval}">
                        <table class="table table-bordered custom-table mb-3" id="policyTable" style="width:100%;">
                            <thead>
                                <tr class="table-title">
                                    <td colspan="7" style="font-weight: bold; background-color: skyblue;">APPROVAL HISTORY</td>
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

    <script>
        document.getElementById("reworkBtn").addEventListener('click', function () {
        const select = document.getElementById("auditorSelect");
        select.removeAttribute('required');
        });   
        document.getElementById("rejectBtn").addEventListener('click', function () {
        const select = document.getElementById("auditorSelect");
        select.removeAttribute('required');
        });   
    </script>
    <script>
    function toggleRemark(radio) {
    const container = radio.closest('td');
            const remarkBox = container.querySelector('.remark-box');
            const textarea = remarkBox.querySelector('textarea');
            if (radio.value === 'reject') {
    remarkBox.style.display = 'block';
            textarea.setAttribute('required', 'true');
    } else {
    remarkBox.style.display = 'none';
            textarea.removeAttribute('required');
    }

    initRejectRemark();
    }

function initRejectRemark() {
const checkedRadios = document.querySelectorAll(
    'input[type="radio"][value="reject"]:checked'
    );
    let rejectFound = false;
    checkedRadios.forEach(function (radio) {
    const container = radio.closest('td');
            const remarkBox = container.querySelector('.remark-box');
            const textarea = remarkBox.querySelector('textarea');
            if (remarkBox) {
    remarkBox.style.display = 'block';
            textarea.setAttribute('required', 'true');
            rejectFound = true;
    }
    });
    const approvedRadios = document.querySelectorAll(
            'input[type="radio"]:checked:not([value="reject"])'
            );
    approvedRadios.forEach(function (radio) {
    const container = radio.closest('td');
            const remarkBox = container.querySelector('.remark-box');
            const textarea = remarkBox.querySelector('textarea');
            if (remarkBox) {
    remarkBox.style.display = 'none';
            textarea.removeAttribute('required');
    }
    });
    // Disable submit if 'Reject' is selected, since it requires a remark.
//        const submitButton = document.getElementById('submit1');
//        if (submitButton) {
//            submitButton.disabled = rejectFound;
//        }
    const submitButton1 = document.getElementById('submit2');
    if (submitButton1) {
submitButton1.disabled = rejectFound;
}
}

document.addEventListener('DOMContentLoaded', function () {
initRejectRemark();
});
    </script>

    <!--<script src="StorageYard/assets/js/TableScript/commonTableScript.js" type="text/javascript"></script>-->

    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>


