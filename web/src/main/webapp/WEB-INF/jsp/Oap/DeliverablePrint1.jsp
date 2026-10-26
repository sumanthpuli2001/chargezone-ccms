
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNewPrint.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> AOC Deliverable Details Print</title>
       
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
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action=".htm?act=" commandName="departmentMaster" method="post">

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0 no-print">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2  d-print-none">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0  no-print"> AOC Deliverable Details  Print</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3 no-print">Back</a>

                            <a href="#" onclick="window.print();" class="btn btn theme-btn no-print" style="background-color: #4CAF50; border-color: #4CAF50;" >
                                <i class="fa fa-print"></i>&nbsp;&nbsp;Print
                            </a>  

                        </div>
                    </div>

                 

                    <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                    <br>
                    <table class="table table-bordered" id="table_1" style="width: 100%; border-collapse: collapse;">
                        <tbody>
                            <tr>
                                <td colspan="3" style="height: 40px; text-align: center; vertical-align: middle;">
                                    <img src="StorageYard/Images/logo.png" style="max-height: 30px;">
                                </td>

                                <td colspan="4" style="text-align: center; vertical-align: middle; padding: 6px; font-weight: bold; font-size: 16px;">
                                    Deliverable Details
                                </td>
                            </tr>
                        </tbody>
                    </table>
                  
                    <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >

                        <tr class="table-title">
                            <td colspan="7" style="text-align: center; font-size: 11px;padding: 3px 5px;">AOC Form Details</td>
                        </tr>
                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">

                            <td colspan="1" style="padding: 3px 5px;"><strong>Document Number</strong></td>
                            <td colspan="2" style="padding: 3px 5px;">${aocForm.documentNo}</td>
                            <td style="padding: 3px 5px;"><strong>Depo.Name</strong></td>
                            <td colspan="3" style="padding: 3px 5px;">${aocForm.hubDepoName}</td>

                        </tr> 
                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">

                            <td colspan="1" style="padding: 3px 5px;"><strong>Project Name</strong></td>
                            <td colspan="2" style="padding: 3px 5px;">${aocForm.clientProjectName}</td>
                            <td style="padding: 3px 5px;"><strong>Created By</strong></td>
                            <td colspan="3" style="padding: 3px 5px;">${aocForm.userId}</td>

                        </tr> 
                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">

                            <td colspan="1" style="padding: 3px 5px;"><strong>Client Name:</strong></td>
                            <td colspan="2" style="padding: 3px 5px;">${aocForm.mobileNo}</td>
                            <td style="padding: 3px 5px;"><strong>Date:</strong></td>
                            <td colspan="3" style="padding: 3px 5px;">${aocForm.createdDate}</td>

                        </tr> 

                        <tr class="table-title">
                            <td colspan="7" style="text-align: center; font-size: 12px;padding: 3px 5px;">Kick Off Form Details</td>
                        </tr>
                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                            <td  style="padding: 3px 5px;"><strong>Document No</strong></td>
                            <td colspan="2" style="padding: 3px 5px;">${kickOffForm.documentNo}</td>
                            <td style="padding: 3px 5px;"><strong>Hub Location</strong></td>
                            <td colspan="3" style="padding: 3px 5px;">${kickOffForm.hubLocation}</td>
                        </tr> 
                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                            <td  style="padding: 3px 5px;"><strong>Project Name:</strong></td>
                            <td colspan="2" style="padding: 3px 5px;">${kickOffForm.projectName}</td>
                            <td style="padding: 3px 5px;"><strong>Designation:</strong></td>
                            <td colspan="3" style="padding: 3px 5px;">${kickOffForm.designation}</td>
                        </tr> 







                        <tr class="table-title">
                            <td colspan="7" style="text-align: center; font-size: 11px;background-color: #e0e7ff; padding: 3px 5px;">Deliverable Details</td>
                        </tr>
                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">

                            <td colspan="1" style="padding: 3px 5px;"><strong>Date</strong></td>
                            <td  colspan="5"colspan="2" style="padding: 3px 5px;">${deliverable1.date}</td>
                        </tr> 
                        <tr>
                            <td style="font-size: 11px; height: 20px; padding: 2px 4px;"><strong>Description</strong></td>
                            <td colspan="4" style="padding: 2px 4px;">
                                <p style="margin: 0;font-size: 11px;">${deliverable1.description}</p>
                            </td>
                        </tr>
                        <tr>
                            <th colspan="3" style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px;">Description</th>
                            <th colspan="2"style="text-align: center; vertical-align: middle ; font-size: 9px; padding: 3px 5px;">Design Co- Ordinater</th>
                        </tr>
                        <tbody>
                            <c:forEach var="list12" items="${list12}" varStatus="status">
                                <tr style="" >
                                    <td  colspan="3" style="font-size: 9px; padding: 3px 5px;">
                                        <p style="margin: 0;font-size: 11px;"> ${list12.description}</p> </td> <!-- Serial Number -->

                                    <td  colspan="2" style="font-size: 9px; padding: 3px 5px;"> ${list12.designCoordinator}</td> <!-- User ID -->




                                </tr>
                            </c:forEach>
                        </tbody>
                        <tr class="table-title">
                            <td colspan="7" style="text-align: center; font-size: 10px;padding: 3px 5px;">AOC Deliverable Multi Attachment</td>
                        </tr>
                        <tr>
                            <th colspan="3" style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px;">Document Name</th>
                            <th colspan="2"style="text-align: center; vertical-align: middle ; font-size: 9px; padding: 3px 5px;">Attachment</th>
                        </tr>
                        <tbody>
                            <c:forEach var="list5" items="${list5}" varStatus="status">
                                <tr style="" >
                                    <td  colspan="3" style="font-size: 9px; padding: 3px 5px;">
                                        ${list5.description} </td> <!-- Serial Number -->

                                    <td  colspan="2" style="font-size: 9px; padding: 3px 5px;">
                                        <a href="oapForm.htm?act=delivmultiDocxdownload&fileName=${list5.attachement}&id1=${list5.oapId}">${list5.attachement}</a>
                                    </td> <!-- User ID -->




                                </tr>
                            </c:forEach>
                        </tbody>





                        <tr class="table-title">
                            <td colspan="7" style="text-align: center; font-size: 10px;padding: 3px 5px;">Approval Status</td>
                        </tr>

                        <tr>
                            <th style="vertical-align: middle; font-size: 9px; padding: 3px 5px;">Sr. No</th>
                            <th colspan="2" style=" vertical-align: middle ; font-size: 9px; padding: 3px 5px;">User</th>
                            <th colspan="2" style=" vertical-align: middle ; font-size: 9px; padding: 3px 5px;">Action</th>

                        </tr>
                        <tbody>
                            <c:forEach var="list1" items="${list1}" varStatus="status">
                                <tr style="" >
                                    <td   style="font-size: 9px; padding: 3px 5px;"> ${status.count}</td> <!-- User ID -->
                                    <td  colspan="2" style="font-size: 9px; padding: 3px 5px;"> ${list1.designAssign}</td> <!-- User ID -->
                                    <td  colspan="2" style="font-size: 9px; padding: 3px 5px;"> 
                                        <c:if test="${list1.flagStatus == '1'}">
                                            Approved
                                        </c:if>  
                                        <c:if test="${list1.flagStatus == '2'}">
                                            Recycle
                                        </c:if>  
                                        <c:if test="${list1.flagStatus == '3'}">
                                            Reject
                                        </c:if>

                                    </td> <!-- User ID -->




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
