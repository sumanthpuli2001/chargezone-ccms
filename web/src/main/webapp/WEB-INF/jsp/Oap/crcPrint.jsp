
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNewPrint.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRC Details Print</title>
    </head>
  
    <style>
        p {
            word-wrap: break-word; /* Allows words to break if necessary */
            max-width: 100ch; /* Restricts the paragraph to 20 characters wide */
        }
        .break-after-80 {
            word-wrap: break-word;
            overflow-wrap: break-word;
            max-width: 100ch; /* Limits to approximately 80 characters per line */
        }
        @media print {
    @page {
        margin: 0;
    }

    body {
        margin: 0;
        padding: 0;
    }
    #table_1 {
        margin-top: -80px;
    }
}
@media print {
    .no-print {
        display: none !important;
    }
}
    </style>

    <style>
        .table-title td {
            font-size: 12px; /* Adjust as needed */
        }
    </style>
   
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="employeeMaster.htm?act=submitDepartment" commandName="departmentMaster" method="post">

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2 d-print-none">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0 no-print">CRC Details Print</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3 d-print-none">Back</a>
<!--                            <a href="#" class="btn theme-btn" style="background-color: #4CAF50; border-color: #4CAF50;" onclick="printPage()">
                                <i class="fa fa-print"></i>&nbsp;&nbsp;Print
                            </a>-->
                            <a href="#" onclick="window.print();" class="btn btn theme-btn no-print" style="background-color: #4CAF50; border-color: #4CAF50;" >
                                <i class="fa fa-print"></i>&nbsp;&nbsp;Print
                            </a> 
                        </div>
                    </div>

                    <hr>
                    <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                    <input type="hidden" name="id" value="${id}">


                <table class="table table-bordered" id="table_1" style="width: 100%; border-collapse: collapse;">
                        <tbody>
                            <tr>
                                <td colspan="3" style="height: 40px; text-align: center; vertical-align: middle;">
                                    <img src="StorageYard/Images/logo.png" style="max-height: 30px;">
                                </td>

                                <td colspan="4" style="text-align: center; vertical-align: middle; padding: 6px; font-weight: bold; font-size: 16px;">
                                    Contract Review Checklist
                                </td>
                            </tr>
                        </tbody>
                    </table>
                                
                    <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                        <tr>

                        <tr class="table-title">
                            <td colspan="4" style="text-align:  center; background-color: #e0e7ff;padding: 3px 5px;">PCS Order Details</td>
                        </tr>
                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                            <td style="padding: 3px 5px;"><strong>Document No:</strong></td>
                            <td style="padding: 3px 5px;">${list.documentNo}</td>
                            <td style="padding: 3px 5px;"><strong>PCS Name:</strong></td>
                            <td style="padding: 3px 5px;">${list.pcsName}</td>
                        </tr>    
                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                            <td style="padding: 3px 5px;"><strong>Document Revision No:</strong></td>
                            <td style="padding: 3px 5px;">${list.documentRevisionNo}</td>
                            <td style="padding: 3px 5px;"><strong>OAP Number:</strong></td>
                            <td style="padding: 3px 5px;">${list.oapNumber}</td>
                        </tr> 
                        <tr class="table-title">
                            <td colspan="4" style="text-align: center;padding: 3px 5px;">Document Verification Details</td>
                        </tr>
                        <tr>
                            <td style="height: 6px; padding: 2px 4px;">
    <label style="display:block; color:#333; font-size:10px; line-height:1;">
        <input type="checkbox"
               name="site"
               id="site"
               value="${list.siteSurveyAcceptance}"
               ${list.siteSurveyAcceptance == '1' ? 'checked' : ''}
               disabled
               style="transform: scale(0.7); margin-right:4px;">
        Site Survey acceptance
    </label>
</td>

                            <td style="height: 6px; padding: 2px 4px;">
                                 <label style="display:block; color:#333; font-size:10px; line-height:1;">
                                    <input type="checkbox" name="agreement" id="agreement" 
                                           value="${list.aggrementAcceptance}" 
                                           ${list.aggrementAcceptance == '1' ? 'checked' : ''} 
                                           disabled> 
                                    Agreement acceptance
                                </label>
                            </td>
                             <td style="height: 6px; padding: 2px 4px;">
                                <label style="display:block; color:#333; font-size:10px; line-height:1;">
                                    <input type="checkbox" name="land" id="land" 
                                           value="${list.landOwnerShipDocument}" 
                                           ${list.landOwnerShipDocument == '1' ? 'checked' : ''} 
                                           disabled> 
                                    Land Ownership Document
                                </label>
                            </td>
                           <td style="height: 6px; padding: 2px 4px;">
                                 <label style="display:block; color:#333; font-size:10px; line-height:1;">
                                    <input type="checkbox" name="noc" id="noc" 
                                           value="${list.nocConsent}" 
                                           ${list.nocConsent == '1' ? 'checked' : ''} 
                                           disabled> 
                                    NOC/Consent
                                </label>
                            </td>
                        </tr>

                        <tr>
                            <td style="font-size: 10px; height: 19px; padding: 2px 4px;"><strong>Comment if Unviable:</strong></td>
                            <td colspan="3" style="font-size: 9px; padding: 2px 4px;">
                                <p style="margin: 0;">${list.comment}</p>
                            </td>
                        </tr>
                        <tr class="table-title">
                            <td colspan="4" style="text-align: center;background-color: #e0e7ff; padding: 3px 5px;">Approval Receipt Details</td>
                        </tr>
                        <tr>
                             <td style="height: 6px; padding: 2px 4px;">
                                <label style="display:block; color:#333; font-size:10px; line-height:1;">
                                    <input type="checkbox" name="plan" id="plan" 
                                           value="${list.planLayoutSigned}" 
                                           ${list.planLayoutSigned == '1' ? 'checked' : ''} disabled> Plan Layout Signed by Ownership
                                </label>
                            </td>
                             <td style="height: 6px; padding: 2px 4px;">
                                <label style="display:block; color:#333; font-size:10px; line-height:1;">
                                    <input type="checkbox" name="projectOap" id="projectOap" 
                                           value="${list.projectBudgetOap}" 
                                           ${list.projectBudgetOap == '1' ? 'checked' : ''} disabled> Project Budget in Line  OAP
                                </label>
                            </td>
                            <td colspan="2"  style="height: 6px; padding: 2px 4px;">
                                 <label style="display:block; color:#333; font-size:10px; line-height:1;">
                                    <input type="checkbox" name="timeline" id="timeline" 
                                           value="${list.projectTimelineOap}" 
                                           ${list.projectTimelineOap == '1' ? 'checked' : ''} disabled> Project Timeline in Line OAP
                                </label>
                            </td>
                        </tr>

                        <tr>
                            <td style="font-size: 10px; height: 19px; padding: 2px 4px;"><strong>Comment if Unviable:</strong></td>
                            <td colspan="3" style="font-size: 9px; padding: 2px 4px;">
                                <p style="margin: 0;">${list.aaprovalComment}</p>
                            </td>
                        </tr>
                        <tr class="table-title">
                            <td colspan="4" style="text-align: center;padding: 3px 5px;">Order Review & Engineering details</td>
                        </tr>
                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                            <td style="padding: 3px 5px;"><strong>Bill of Material No:</strong></td>
                            <td style="padding: 3px 5px;">${list.billMaterialNo}</td>
                            <td style="padding: 3px 5px;"><strong>PCS Drawing Number:</strong></td>
                            <td style="padding: 3px 5px;">${list.pcsDrawingNumber}</td>
                        </tr> 

                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                            <td style="padding: 3px 5px;"><strong>Scope of Work No:</strong></td>
                            <td style="padding: 3px 5px;">${list.scopeWork}</td>
                            <td style="padding: 3px 5px;"><strong>Deliverable Released Date:</strong></td>
                            <td style="padding: 3px 5px;">${list.deliverableReleaseDate}</td>
                        </tr> 
                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                            <td style="padding: 3px 5px;"><strong>New Revision No:</strong></td>
                            <td  colspan="3" style="font-size: 9px; padding: 3px 5px;">${list.newRevisionNumber}</td>

                        </tr> 
                        <tr>
                            <td style="font-size: 10px; height: 19px; padding: 2px 4px;"><strong>Reviewer Comment:</strong></td>
                            <td colspan="3" style="font-size: 9px; padding: 2px 4px;">
                                <p style="margin: 0;">${list.reviewerComment}</p>
                            </td>
                        </tr>

                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                            <td style="padding: 3px 5px;"><strong>Prepared By:</strong></td>
                            <td style="padding: 3px 5px;">${list.preparedBy}</td>
                            <td style="padding: 3px 5px;"><strong>Designation:</strong></td>
                            <td style="padding: 3px 5px;">${list.designation}</td>
                        </tr> 

                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                            <td style="padding: 3px 5px;"><strong>Project Engineer:</strong></td>
                            <td colspan="3" style="padding: 3px 5px;">${list.projectEngineer}</td>
                        </tr> 

                        <tr  class="table-title">
                            <td colspan="4" style=" font-size: 11px; padding: 3px 4px;  text-align: center; background-color: #e0e7ff;"><strong>Approval Status</strong></td>
                        </tr>

                        <tr>
                            <th style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px;">Sr.No</th>
                            <th style="text-align: center; vertical-align: middle ; font-size: 9px; padding: 3px 5px;">User</th>
                            <th style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px;">Comment</th>
                            <th style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px;">Action</th>
                        </tr>

                        <tbody>
                            <c:forEach var="list0" items="${list0}" varStatus="status">
                                <tr style="" >
                                    <td style="font-size: 9px; padding: 3px 5px;">${status.count}</td> <!-- Serial Number -->
                                    <td style="font-size: 9px; padding: 3px 5px;">${list0.userId}</td> <!-- User ID -->
                                    <td style="font-size: 9px; padding: 3px 5px;">${list0.approvalComment}</td> <!-- Approval Comment -->
                                    <td style="font-size: 9px; padding: 3px 5px;">
                                        <c:if test="${list0.approvalStatus == '1'}">
                                            Approved
                                        </c:if>           
                                        <c:if test="${list0.approvalStatus == '2'}">
                                            Recycle
                                        </c:if>
                                        <c:if test="${list0.approvalStatus == '3'}">
                                            Rejected
                                        </c:if>
                                        <c:if test="${list0.approvalStatus == '4'}">
                                            Partially Approve
                                        </c:if>
                                    </td> <!-- Approval Status -->
                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>


                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooterPrint.jsp"%>
</html>
