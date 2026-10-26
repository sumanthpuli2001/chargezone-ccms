
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNewPrint.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kick Off Details Print</title>
        
        <style>
            p {
                word-wrap: break-word; /* Allows words to break if necessary */
                max-width: 100ch; /* Restricts the paragraph to 20 characters wide */
            }
            .break-after-20 {
                word-wrap: break-word;
                overflow-wrap: break-word;
                max-width: 50ch; /* Approximately 20 characters per line */
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
        margin-top: -75px;
    }
}
@media print {
    .no-print {
        display: none !important;
    }
}
        </style>
           
    </head>
</head>
<body>

    <main class="d-flex align-items-end justify-content-end">
        <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
        <section class="main-content">
            <form:form action=".htm?act=" commandName="departmentMaster" method="post">

                <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                    <div class="page-title d-flex align-items-center">
                        <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2  d-print-none">
                            <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                 alt="Menu collapse">
                            <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                 alt="Menu collapse">
                        </div>

                        <h5 class="fw-600 mb-0  no-print">Kick Off Details Print</h5>
                    </div>

                    <div class="cta d-flex align-items-center">
                        <a onclick="history.back();" class="btn theme-btn light-btn mr-3 no-print">Back</a>

                        <a href="#" onclick="window.print();" class="btn btn theme-btn no-print" style="background-color: #4CAF50; border-color: #4CAF50;" >
                            <i class="fa fa-print"></i>&nbsp;&nbsp;Print
                        </a>  

                    </div>
                </div>


                <hr>

                <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                <input type="hidden" name="id" value="${id}">
                <input type="hidden" name="oapFormId" value="${list55.id}">

                <table class="table table-bordered" id="table_1" style="width: 100%; border-collapse: collapse;">
                    <tbody>
                        <tr>
                            <td colspan="3" style="height: 40px; text-align: center; vertical-align: middle;">
                                <img src="StorageYard/Images/logo.png" style="max-height: 30px;">
                            </td>

                            <td colspan="4" style="text-align: center; vertical-align: middle; padding: 6px; font-weight: bold; font-size: 16px;">
                                Kick Off Meeting Report
                            </td>
                        </tr>
                    </tbody>
                </table>

                    <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                    <tr class="table-title">
                        <td colspan="5" style="text-align: center; font-size: 12px;padding: 3px 5px;">B2B Hub Order Details</td>
                    </tr>

                    <tr>
                        <td style="font-size: 11px; height: 20px; padding: 2px 4px;"><strong>Document No</strong></td>
                        <td colspan="4" style="padding: 2px 4px;">
                            <p style="margin: 0;font-size: 11px;">${list55.documentNo}</p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="1" style="font-size: 11px; height: 20px; padding: 2px 4px;"><strong>B2B Hub Location</strong></td>
                        <td colspan="2" style="padding: 2px 4px;">
                            <p style="margin: 0;font-size: 11px;">${list55.hubLocation}</p>
                        </td>
                        <td style="font-size: 11px; height: 20px; padding: 2px 4px;"><strong>Date&Time</strong></td>
                        <td style="padding: 2px 4px;">
                            <p style="margin: 0;font-size: 11px;">${list55.dateTime}</p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="1" style="font-size: 11px; height: 20px; padding: 2px 4px;"><strong>Project Name</strong></td>
                        <td colspan="2" style="padding: 2px 4px;">
                            <p style="margin: 0;font-size: 11px;">${list55.projectName}</p>
                        </td>
                        <td style="font-size: 11px; height: 20px; padding: 2px 4px;"><strong>Minutes Prepared By</strong></td>
                        <td style="padding: 2px 4px;">
                            <p style="margin: 0;font-size: 11px;">${list55.minutues}</p>
                        </td>
                    </tr>
                    
                    
                    
                    
                    <tr class="table-title">
                        <td colspan="5" style="text-align: center; font-size: 12px;padding: 3px 5px;">Attendance</td>
                    </tr>
                    <tr>
                        <th style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px;">Sr.No</th>
                        <th style="text-align: center; vertical-align: middle ; font-size: 9px; padding: 3px 5px;">Name</th>
                        <th style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px;">Roll In Project</th>
                        <th style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px;">Email</th>
                        <th style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px;">Cell No</th>

                    </tr>
                    <tbody>
                        <c:forEach var="list44" items="${list44}" varStatus="status">
                            <tr style="" >
                                <td style="font-size: 9px; padding: 3px 5px;">${status.count}</td> <!-- Serial Number -->
                                <td style="font-size: 9px; padding: 3px 5px;">${list44.name}</td> <!-- User ID -->
                                <td style="font-size: 9px; padding: 3px 5px;">${list44.rollInProject}</td> <!-- Approval Comment -->
                                <td style="font-size: 9px; padding: 3px 5px;">${list44.email}</td> <!-- Approval Status -->
                                <td style="font-size: 9px; padding: 3px 5px;">${list44.cellNo}</td> <!-- Approval Status -->


                            </tr>
                        </c:forEach>
                    </tbody>
                    <tr class="table-title">
                        <td colspan="5" style="text-align: center; font-size: 12px;padding: 3px 5px;">B2B Hub Deliverables Verification Details</td>
                    </tr>

                    <td style="font-size: 9px; padding: 2px;"> 
                        <label style="display: inline; font-size: 9px;">
                            <input type="checkbox" name="design" id="design" 
                                   value="${list55.designBasic}" disabled
                                   ${list55.designBasic == '1' ? 'checked' : ''} 
                                   style="width: 10px; height: 10px;"> A. Design Basis Report
                        </label>
                    </td>

                    <td style="font-size: 9px; padding: 2px;"> 
                        <label style="display: inline; font-size: 9px;">
                            <input type="checkbox" name="boq" id="boq" disabled
                                   value="${list55.boq}" 
                                   ${list55.boq == '1' ? 'checked' : ''} 
                                   style="width: 10px; height: 10px;"> B. BOQ
                        </label>
                    </td>

                    <td style="font-size: 9px; padding: 2px;"> 
                        <label style="display: inline; font-size: 9px;">
                            <input type="checkbox" name="loa" id="loa" disabled
                                   value="${list55.laoLoi}" 
                                   ${list55.laoLoi == '1' ? 'checked' : ''} 
                                   style="width: 10px; height: 10px;"> C. LOA / LOI
                        </label>
                    </td>

                    <td style="font-size: 9px; padding: 2px;"> 
                        <label style="display: inline; font-size: 9px;">
                            <input type="checkbox" name="agreement" id="agreement" disabled 
                                   value="${list55.agreement}" 
                                   ${list55.agreement == '1' ? 'checked' : ''} 
                                   style="width: 10px; height: 10px;"> D. Agreement
                        </label>
                    </td>

                    <td style="font-size: 9px; padding: 2px;"> 
                        <label style="display: inline; font-size: 9px;">
                            <input type="checkbox" name="approved" id="approved" disabled
                                   value="${list55.approvedLayout}" 
                                   ${list55.approvedLayout == '1' ? 'checked' : ''} 
                                   style="width: 10px; height: 10px;"> E. Approved Layout Drawings
                        </label>
                    </td>

                    <tr>
                        <td style="font-size: 11px; height: 20px; padding: 2px 4px;"><strong>Agendas:</strong></td>
                        <td colspan="4" style="padding: 2px 4px;">
                            <p style="margin: 0;font-size: 11px;">${list55.agendas}</p>
                        </td>
                    </tr>
                    <tr>
                        <td style="font-size: 11px; height: 20px; padding: 2px 4px;"><strong>Issues:</strong></td>
                        <td colspan="4" style="padding: 2px 4px;">
                            <p style="margin: 0;font-size: 11px;">${list55.issues}</p>
                        </td>
                    </tr>
                    <tr>
                        <td style="font-size: 11px; height: 20px; padding: 2px 4px;"><strong>Decisions:</strong></td>
                        <td colspan="4" style="padding: 2px 4px;">
                            <p style="margin: 0;font-size: 11px;">${list55.decisions}</p>
                        </td>
                    </tr>
                    <tr class="table-title">
                        <td colspan="5" style="text-align: center; font-size: 12px;background-color: #e0e7ff; padding: 3px 5px;">Approval Receipt Details</td>
                    </tr>

                    <td colspan="2" style="font-size: 9px; padding: 2px;"> 
                        <div style="display: inline; font-size: 9px;">
                            <input type="checkbox" name="design" id="design" 
                                   value="${list55.planLayout}" disabled
                                   ${list55.planLayout == '1' ? 'checked' : ''} 
                                   style="width: 10px; height: 10px;">    A. Plan Layout Signed by Client
                        </div>
                    </td>


                    <td colspan="2"  style="font-size: 9px; padding: 2px;"> 
                        <label style="display: inline; font-size: 9px;">
                            <input  type="checkbox" name="boq" id="boq" disabled
                                    value="${list55.projectBudget}" 
                                    ${list55.projectBudget == '1' ? 'checked' : ''} 
                                    style="width: 10px; height: 10px;">   B. Project Budget in Line With AOC
                        </label>
                    </td>

                    <td style="font-size: 9px; padding: 2px;"> 
                        <label style="display: inline; font-size: 9px;">
                            <input type="checkbox" name="loa" id="loa" disabled
                                   value="${list55.projectTimeLine}" 
                                   ${list55.projectTimeLine == '1' ? 'checked' : ''} 
                                   style="width: 10px; height: 10px;">  C. Project Timeline in Line With AOC
                        </label>
                    </td>

                    <tr>
                        <td style="font-size: 11px; height: 20px; padding: 2px 4px;"><strong>Comment if Unviable:</strong></td>
                        <td colspan="4" style="padding: 2px 4px;">
                            <p style="margin: 0;font-size: 11px;">${list55.comments}</p>
                        </td>
                    </tr>
                    
                    
                    
                    <tr class="table-title">
                        <td colspan="5" style="text-align: center; font-size: 12px;padding: 3px 5px;">Order Review & Design Engineering details</td>
                    </tr>

                    <tr>
                        <td style="font-size: 11px; height: 20px; padding: 2px 4px;"><strong>Design Basis Report No</strong></td>
                        <td colspan="4" style="padding: 2px 4px;">
                            <p style="margin: 0;font-size: 11px;">${list55.designBasicReport}</p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="1" style="font-size: 11px; height: 20px; padding: 2px 4px;"><strong>Approved Layout Drawing Number</strong></td>
                        <td colspan="2" style="padding: 2px 4px;">
                            <p style="margin: 0;font-size: 11px;">${list55.approvedLayoutDrawings}</p>
                        </td>
                        <td style="font-size: 11px; height: 20px; padding: 2px 4px;"><strong>BOQ No</strong></td>
                        <td style="padding: 2px 4px;">
                            <p style="margin: 0;font-size: 11px;">${list55.boqNo}</p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="1" style="font-size: 11px; height: 20px; padding: 2px 4px;"><strong>Deliverable released date</strong></td>
                        <td colspan="2" style="padding: 2px 4px;">
                            <p style="margin: 0;font-size: 11px;">${list55.deliverableReleaseDate}</p>
                        </td>
                        <td style="font-size: 11px; height: 20px; padding: 2px 4px;"><strong>Reviewer Comment</strong></td>
                        <td style="padding: 2px 4px;">
                            <p style="margin: 0;font-size: 11px;">${list55.designation}</p>
                        </td>
                    </tr>
                    
                    <tr class="table-title">
                        <td colspan="5" style="text-align: center; font-size: 12px;padding: 3px 5px;">Approval Status</td>
                    </tr>

                    <tr>
                        <th style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px;">Sr.No</th>
                        <th style="text-align: center; vertical-align: middle ; font-size: 9px; padding: 3px 5px;">User</th>
                        <th colspan="2" style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px;">Comment</th>
                        <th style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px;">Action</th>
                    </tr>

                    <tbody>
                        <c:forEach var="list0" items="${list0}" varStatus="status">
                            <tr style="" >
                                <td style="font-size: 9px; padding: 3px 5px;">${status.count}</td> <!-- Serial Number -->
                                <td style="font-size: 9px; padding: 3px 5px;">${list0.userId}</td> <!-- User ID -->
                                <td colspan="2"style="font-size: 9px; padding: 3px 5px;">${list0.approvalComment}</td> <!-- Approval Comment -->
                                <td style="font-size: 9px; padding: 3px 5px;">
                                    <c:if test="${list0.approvalStatus == '1'}">
                                        Approved
                                    </c:if>           
                                    <c:if test="${list0.approvalStatus == '8'}">
                                        Recycle
                                    </c:if>
                                    <c:if test="${list0.approvalStatus == '3'}">
                                        Rejected
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
