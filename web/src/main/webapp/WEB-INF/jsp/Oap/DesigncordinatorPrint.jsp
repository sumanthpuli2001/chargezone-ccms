
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNewPrint.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delivery Details Print</title>
      
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

                            <h5 class="fw-600 mb-0  no-print">Delivery Details Print</h5>
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
                    <input type="hidden" name="id1" value="${oapid}">
                    <input type="hidden" name="id2" value="${aocid}">
                    <input type="hidden" name="id5" id="id5" value="${flag}">
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


                                                    <c:if test="${list6.oapId == 0}">
                                                        <tr class="table-title">
                                                            <td colspan="7" style="text-align: center; font-size: 12px;padding: 3px 5px;">AOC Form Details</td>
                                                        </tr>

                                                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">

                                                            <td colspan="1" style="padding: 3px 5px;"><strong>Document Number</strong></td>
                                                            <td colspan="2" style="padding: 3px 5px;">${list3.documentNo}</td>
                                                            <td style="padding: 3px 5px;"><strong>Depo.Name</strong></td>
                                                            <td colspan="3" style="padding: 3px 5px;">${list3.hubDepoName}</td>

                                                        </tr> 
                                                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                                            <td  style="padding: 3px 5px;"><strong>Project Name</strong></td>
                                                            <td colspan="2" style="padding: 3px 5px;">${list3.clientProjectName}</td>
                                                            <td style="padding: 3px 5px;"><strong>Created By</strong></td>
                                                            <td colspan="3" style="padding: 3px 5px;">${list3.userId}</td>
                                                        </tr> 
                                                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                                            <td  style="padding: 3px 5px;"><strong>Client Name</strong></td>
                                                            <td colspan="2" style="padding: 3px 5px;">${list3.mobileNo}</td>
                                                            <td style="padding: 3px 5px;"><strong>Date</strong></td>
                                                            <td colspan="3" style="padding: 3px 5px;">${list3.createdDate}</td>
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
                                                            <td  style="padding: 3px 5px;"><strong>Project Name</strong></td>
                                                            <td colspan="2" style="padding: 3px 5px;">${kickOffForm.projectName}</td>
                                                            <td style="padding: 3px 5px;"><strong>Designation</strong></td>
                                                            <td colspan="3" style="padding: 3px 5px;">${kickOffForm.designation}</td>
                                                        </tr> 







                                                    </c:if> 

                                                    <c:if test="${list6.aocId == 0}">
                                                        <tr class="table-title">
                                                            <td colspan="7" style="text-align: center; font-size: 12px;padding: 3px 5px;">OAP Form Details</td>
                                                        </tr>
                                                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                                            <td  style="padding: 3px 5px;"><strong>Document Number</strong></td>
                                                            <td colspan="2" style="padding: 3px 5px;">${list2.documentNo}</td>
                                                            <td style="padding: 3px 5px;"><strong>Project Name</strong></td>
                                                            <td colspan="3" style="padding: 3px 5px;">${list2.projectName}</td>
                                                        </tr> 
                                                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                                            <td  style="padding: 3px 5px;"><strong>Pcs Name</strong></td>
                                                            <td colspan="2" style="padding: 3px 5px;">${list2.pcsName}</td>
                                                            <td style="padding: 3px 5px;"><strong> CoOrdinates</strong></td>
                                                            <td colspan="3" style="padding: 3px 5px;">${list2.pcsCoordinates}</td>
                                                        </tr> 
                                                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                                            <td  style="padding: 3px 5px;"><strong>Client Name</strong></td>
                                                            <td colspan="2" style="padding: 3px 5px;">${list2.mobileNo}</td>
                                                            <td style="padding: 3px 5px;"><strong>Department</strong></td>
                                                            <td colspan="3" style="padding: 3px 5px;">${list2.department}</td>
                                                        </tr> 
                                                        <tr class="table-title">
                                                            <td colspan="7" style="text-align: center; font-size: 12px;padding: 3px 5px;">CRC Form Details</td>
                                                        </tr>
                                                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                                            <td  style="padding: 3px 5px;"><strong>Document No</strong></td>
                                                            <td colspan="2" style="padding: 3px 5px;">${crcForm.documentNo}</td>
                                                            <td style="padding: 3px 5px;"><strong>PCS Name</strong></td>
                                                            <td colspan="3" style="padding: 3px 5px;">${crcForm.pcsName}</td>
                                                        </tr> 
                                                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                                            <td  style="padding: 3px 5px;"><strong>PCS Drawing Number</strong></td>
                                                            <td colspan="2" style="padding: 3px 5px;">${crcForm.pcsDrawingNumber}</td>
                                                            <td style="padding: 3px 5px;"><strong>Prepared By</strong></td>
                                                            <td colspan="3" style="padding: 3px 5px;">${crcForm.preparedBy}</td>
                                                        </tr> 
                                                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                                            <td  style="padding: 3px 5px;"><strong>Scope Of Work</strong></td>
                                                            <td colspan="2" style="padding: 3px 5px;">${crcForm.scopeWork}</td>
                                                            <td style="padding: 3px 5px;"><strong>Designation</strong></td>
                                                            <td colspan="3" style="padding: 3px 5px;">${crcForm.designation}</td>
                                                        </tr> 

                                                    </c:if>






                                                    <c:if test="${GoodsContract4.size()>0}">
                                                        <tr class="table-title">
                                                            <td colspan="7" style="text-align: center; font-size: 11px;padding: 3px 5px;">Item Details</td>
                                                        </tr>
                                                        <tr>
                                                            <th style=" vertical-align: middle; font-size: 9px; padding: 2px 4px; min-width: 40px; white-space: nowrap;">Sr. No</th>
                                                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Item Code</th>
                                                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Item Description</th>
                                                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Purpose</th>
                                                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Make</th>
                                                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">UOM</th>
                                                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Qty</th>
                                                        </tr>


                                                        <tbody>
                                                            <c:forEach var="list7" items="${list7}" varStatus="status">
                                                                <tr style="" >
                                                                    <td style="font-size: 9px; padding: 3px 5px;">${list7.sno}</td> <!-- Serial Number -->
                                                                    <td style="font-size: 9px; padding: 3px 5px;"> ${list7.iteamCode}</td> <!-- User ID -->
                                                                    <td style="font-size: 9px; padding: 3px 5px;">${list7.iteamDescription}</td> <!-- Approval Comment -->
                                                                    <td style="font-size: 9px; padding: 3px 5px;">${list7.purpose}</td> <!-- Approval Status -->
                                                                    <td style="font-size: 9px; padding: 3px 5px;">${list7.make}</td> <!-- Approval Status -->
                                                                    <td style="font-size: 9px; padding: 3px 5px;">${list7.uom}</td> <!-- Approval Status -->
                                                                    <td style="font-size: 9px; padding: 3px 5px;">${list7.qty}</td> <!-- Approval Status -->


                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </c:if>

                                                    <c:if test="${Contract1.size()>0}">
                                                        <tr class="table-title">
                                                            <td colspan="7" style="text-align: center; font-size: 11px;padding: 3px 5px;">Item Details For Service</td>
                                                        </tr>
                                                        <tr>
                                                            <th style=" vertical-align: middle; font-size: 9px; padding: 2px 4px; min-width: 40px; white-space: nowrap;">Sr. No</th>
                                                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Item Code</th>
                                                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Item Description</th>
                                                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Purpose</th>
                                                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Make</th>
                                                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">UOM</th>
                                                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Qty</th>
                                                        </tr>
                                                        <tbody>
                                                            <c:forEach var="list5" items="${list5}" varStatus="status">
                                                                <tr style="" >
                                                                    <td style="font-size: 9px; padding: 3px 5px;">${list5.sno}</td> <!-- Serial Number -->
                                                                    <td style="font-size: 9px; padding: 3px 5px;"> ${list5.iteamCode}</td> <!-- User ID -->
                                                                    <td style="font-size: 9px; padding: 3px 5px;">${list5.iteamDescription}</td> <!-- Approval Comment -->
                                                                    <td style="font-size: 9px; padding: 3px 5px;">${list5.purpose}</td> <!-- Approval Status -->
                                                                    <td style="font-size: 9px; padding: 3px 5px;">${list5.make}</td> <!-- Approval Status -->
                                                                    <td style="font-size: 9px; padding: 3px 5px;">${list5.uom}</td> <!-- Approval Status -->
                                                                    <td style="font-size: 9px; padding: 3px 5px;">${list5.qty}</td> <!-- Approval Status -->


                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>


                                                    </c:if>
                                                    <c:if test="${Goods.size()>0}">

                                                        <tr class="table-title">
                                                            <td colspan="7" style="text-align: center; font-size: 11px;padding: 3px 5px;">Item Details</td>
                                                        </tr>
                                                        <tr>
                                                            <th style=" vertical-align: middle; font-size: 9px; padding: 2px 4px; min-width: 40px; white-space: nowrap;">Sr. No</th>
                                                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Item Code</th>
                                                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Item Description</th>
                                                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Purpose</th>
                                                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Make</th>
                                                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">UOM</th>
                                                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Qty</th>
                                                        </tr>
                                                        <tbody>
                                                            <c:forEach var="list0" items="${list0}" varStatus="status">
                                                                <tr style="" >
                                                                    <td style="font-size: 9px; padding: 3px 5px;">${list0.sno}</td> <!-- Serial Number -->
                                                                    <td style="font-size: 9px; padding: 3px 5px;"> ${list0.iteamCode}</td> <!-- User ID -->
                                                                    <td style="font-size: 9px; padding: 3px 5px;">${list0.iteamDescription}</td> <!-- Approval Comment -->
                                                                    <td style="font-size: 9px; padding: 3px 5px;">${list0.purpose}</td> <!-- Approval Status -->
                                                                    <td style="font-size: 9px; padding: 3px 5px;">${list0.make}</td> <!-- Approval Status -->
                                                                    <td style="font-size: 9px; padding: 3px 5px;">${list0.uom}</td> <!-- Approval Status -->
                                                                    <td style="font-size: 9px; padding: 3px 5px;">${list0.qty}</td> <!-- Approval Status -->


                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>


                                                    </c:if>
                                                    <c:if test="${Service.size()>0}">

                                                        <tr class="table-title">
                                                            <td colspan="7" style="text-align: center; font-size: 11px;padding: 3px 5px;">Service Details</td>
                                                        </tr>
                                                        <tr>
                                                            <th style=" vertical-align: middle; font-size: 9px; padding: 2px 4px; min-width: 40px; white-space: nowrap;">Sr. No</th>
                                                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Item Code</th>
                                                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Item Description</th>
                                                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Purpose</th>
                                                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Make</th>
                                                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">UOM</th>
                                                            <th style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Qty</th>
                                                        </tr>
                                                        <tbody>
                                                            <c:forEach var="list4" items="${list4}" varStatus="status">
                                                                <tr style="" >
                                                                    <td style="font-size: 9px; padding: 3px 5px;">${list4.sno}</td> <!-- Serial Number -->
                                                                    <td style="font-size: 9px; padding: 3px 5px;"> ${list4.iteamCode}</td> <!-- User ID -->
                                                                    <td style="font-size: 9px; padding: 3px 5px;">${list4.iteamDescription}</td> <!-- Approval Comment -->
                                                                    <td style="font-size: 9px; padding: 3px 5px;">${list4.purpose}</td> <!-- Approval Status -->
                                                                    <td style="font-size: 9px; padding: 3px 5px;">${list4.make}</td> <!-- Approval Status -->
                                                                    <td style="font-size: 9px; padding: 3px 5px;">${list4.uom}</td> <!-- Approval Status -->
                                                                    <td style="font-size: 9px; padding: 3px 5px;">${list4.qty}</td> <!-- Approval Status -->


                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>


                                                    </c:if>

                                                    <c:if test="${aocformid == -1}"> 
                                                        <tr class="table-title">
                                                            <td colspan="7" style="text-align: center; font-size: 11px;padding: 3px 5px;">OAP Deliverable Multi Attachment </td>
                                                        </tr>
                                                        <tr>
                                                            <th style=" vertical-align: middle; font-size: 9px; padding: 2px 4px; min-width: 40px; white-space: nowrap;">Sr. No</th>
                                                            <th colspan="2"  style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Description</th>
                                                            <th  colspan="4" style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Attachment</th>

                                                        </tr>
                                                        <tbody>
                                                            <c:forEach var="list50" items="${list50}" varStatus="status">
                                                                <tr style="" >
                                                                    <td style="font-size: 9px; padding: 3px 5px;">${status.count}</td> <!-- Serial Number -->
                                                                    <td colspan="2"style="font-size: 9px; padding: 3px 5px;"> ${list50.description}</td> <!-- User ID -->
                                                                    <td colspan="4" style="font-size: 9px; padding: 3px 5px;"> 
                                                                        <a href="oapForm.htm?act=delivmultiDocxdownload&fileName=${list50.attachement}&id1=${list50.oapId}">${list50.attachement}</a>
                                                                    </td> <!-- Approval Comment -->


                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </c:if>
                                                    <c:if test="${oapformid == -1}">  
                                                        <tr class="table-title">
                                                            <td colspan="7" style="text-align: center; font-size: 11px;padding: 3px 5px;">AOC Deliverable Multi Attachment</td>
                                                        </tr>
                                                        <tr>
                                                            <th style=" vertical-align: middle; font-size: 9px; padding: 2px 4px; min-width: 40px; white-space: nowrap;">Sr. No</th>
                                                            <th  colspan="2"style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Description</th>
                                                            <th   colspan="4" style=" vertical-align: middle; font-size: 9px; padding: 3px 5px;">Attachment</th>

                                                        </tr>

                                                        <tbody>
                                                            <c:forEach var="list40" items="${list40}" varStatus="status">
                                                                <tr style="" >
                                                                    <td style="font-size: 9px; padding: 3px 5px;">${status.count}</td> <!-- Serial Number -->
                                                                    <td colspan="2"style="font-size: 9px; padding: 3px 5px;"> ${list40.description}</td> <!-- User ID -->
                                                                    <td colspan="4" style="font-size: 9px; padding: 3px 5px;">                                                        <a href="oapForm.htm?act=delivmultiDocxdownload&fileName=${list40.attachement}&id1=${list40.aocId}">${list40.attachement}</a>
                                                                    </td> <!-- Approval Comment -->


                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </c:if>

                                                    <tr class="table-title">
                                                        <td colspan="7" style="text-align: center; font-size: 11px;padding: 3px 5px;">Approval Status</td>
                                                    </tr>
                                                    <tr>
                                                        <th style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px;">Sr. No</th> 
                                                        <th colspan="2" style="text-align: center; vertical-align: middle ; font-size: 9px; padding: 3px 5px;">User</th>
                                                        <th colspan="2" style="text-align: center; vertical-align: middle ; font-size: 9px; padding: 3px 5px;">Comments</th>
                                                        <th colspan="4" style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px;">Action</th>

                                                    </tr>
                                                     <tbody>
                                    <c:forEach var="list" items="${list10}" varStatus="status">
                                        <tr style="" >
                                            <td style="font-size: 9px; padding: 3px 5px;">${status.count}</td> <!-- Serial Number -->
                                            <td colspan="2" style="font-size: 9px; padding: 3px 5px;">${list[2]}</td> <!-- User ID -->
                                            <td colspan="2" style="font-size: 9px; padding: 3px 5px;">${list[1]}</td> <!-- Approval Comment -->
                                            <td  colspan="4"style="font-size: 9px; padding: 3px 5px;">
                                                 <c:if test="${list[4] == '2'}">
                                                            Recycle
                                                        </c:if>
                                                            
                                               <c:if test="${list[4] == '1'||list[4] == '5'}">
                                                            Approved
                                                        </c:if>
                                               <c:if test="${list[4] == '3'}">
                                                            Reject
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
