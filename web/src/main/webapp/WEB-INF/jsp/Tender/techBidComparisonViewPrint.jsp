<%-- 
    Document   : techBidComparisonViewPrint
    Created on : Apr 3, 2026, 9:28:32 AM
    Author     : Sumanth
--%>





<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNewPrint.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TENDER TECHNICAL COMPARISON PRINT</title>       
    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="" commandName="departmentMaster" method="post">

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between  sticky-model0 no-print">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2  d-print-none">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0  no-print">TENDER TECHNICAL COMPARISON PRINT</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3 no-print">Back</a>

                            <a href="#" onclick="window.print();" class="btn btn theme-btn no-print" style="background-color: #4CAF50; border-color: #4CAF50;" >
                                <i class="fa fa-print"></i>&nbsp;&nbsp;Print
                            </a>  

                        </div>
                    </div>  
                    
                    <br>
                    <table class="table table-bordered printup" id="table_1" style="width: 100%; border-collapse: collapse;">
                        <tbody>
                            <tr>
                                <td colspan="3" style="height: 40px; text-align: center; vertical-align: middle;border: 1px solid black !important;">
                                    <img src="StorageYard/Images/logo.png" style="max-height: 30px;">
                                </td>

                                <td colspan="4" style="text-align: center; vertical-align: middle; padding: 6px; font-weight: bold; font-size: 16px;border: 1px solid black !important;">
                                    Price Bid Comparison With Revise
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <br>
                    
                    <table class="flex-table" class="table table-bordered" style="" align="Center"  >
                        <thead style="font-size: 12px;">

                            <tr class="table-title">
                                <th colspan="8" style="text-align: center;">Tender Details</th>
                            </tr>
                        </thead>
                         <tbody>

                            <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                <th colspan="1" style="padding: 3px 5px;"><strong>Tender No</strong></th>
                                <td colspan="2" style="padding: 3px 5px;">${tenderMaster.refNo}</td>

                                <th colspan="2" style="padding: 3px 5px;"><strong>Project ID</strong></th>
                                <td colspan="3" style="padding: 3px 5px;">${tenderMaster.projectId}</td>
                            </tr>

                            <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                <th colspan="1" style="padding: 3px 5px;"><strong>Project Name</strong></th>
                                <td colspan="7" style="padding: 3px 5px;">${tenderMaster.title}</td>
                            </tr>

                            <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                <th colspan="1" style="padding: 3px 5px;"><strong>Vendor Code</strong></th>
                                <td colspan="2" style="padding: 3px 5px;">${vendorCode}- ${vendorName}</td>

                                <th colspan="2" style="padding: 3px 5px;"><strong>Department</strong></th>
                                <td colspan="3" style="padding: 3px 5px;">${tenderMaster.department}</td>
                            </tr>

                            <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                <th colspan="1" style="padding: 3px 5px;"><strong>Tender Date</strong></th>
                                <td colspan="2" style="padding: 3px 5px;">${tender_date}</td>

                                <th colspan="2" style="padding: 3px 5px;"><strong>Tender Due Date</strong></th>
                                <td colspan="3" style="padding: 3px 5px;">${tender_due_date}</td>
                            </tr>

                            <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                <th colspan="1" style="padding: 3px 5px;"><strong>PR No</strong></th>
                                <td colspan="2" style="padding: 3px 5px;">${tenderMaster.prNo}</td>

                                <th colspan="2" style="padding: 3px 5px;"><strong>Mode Of Transport</strong></th>
                                <td colspan="3" style="padding: 3px 5px;">${tenderMaster.modeOfTransport}</td>
                            </tr>

<!--                            <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                <th colspan="1" style="padding: 3px 5px;"><strong>Bid Sent From No. Of Vendor</strong></th>
                                <td colspan="2" style="padding: 3px 5px;">${total_vendor}</td>

                                <th colspan="2" style="padding: 3px 5px;"><strong>Bid Received From No. Of Vendor</strong></th>
                                <td colspan="3" style="padding: 3px 5px;">${total_bid}</td>
                            </tr>-->
                        </tbody>
                    </table> 
                    
                    <c:if test="${!empty vendorTechnicalBidTech1}">
                        <br>
                        <div class="table-responsive">
                        <table class="flex-table" class="table table-bordered" style="" align="Center"  >
                            <thead style="font-size: 12px;">
                                <tr class="table-title">
                                    <th colspan="8" style="text-align: center;">Technical Specification For Item</th>
                                </tr>

                                <tr> 
                                    <th rowspan="2">Sr No.</th>
                                    <th>Vendor Code</th>
                                    <c:if test="${vendor_code1 != ''}">
                                        <th>${vendor_code1}</th>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <th>${vendor_code2}</th>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <th>${vendor_code3}</th>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <th>${vendor_code4}</th>
                                    </c:if>
                                    <c:if test="${vendor_code5 != ''}">
                                        <th>${vendor_code5}</th>
                                    </c:if>
                                    <c:if test="${vendor_code6 != ''}">
                                        <th>${vendor_code6}</th>
                                    </c:if>
                                </tr>

                                <tr> 
                                    <th>Vendor Name</th>
                                    <c:if test="${vendor_code1 != ''}">
                                        <th>${vendor_name1}</th>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <th>${vendor_name2}</th>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <th>${vendor_name3}</th>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <th>${vendor_name4}</th>
                                    </c:if>
                                    <c:if test="${vendor_code5 != ''}">
                                        <th>${vendor_name5}</th>
                                    </c:if>
                                    <c:if test="${vendor_code6 != ''}">
                                        <th>${vendor_name6}</th>
                                    </c:if>
                                </tr>
                            </thead>
                            <tbody style="font-size: 10px;">
                                
                                <c:set var="count" value="0" scope="page" />                                
                                <c:forEach var="vendorTechnicalBidTech1" items="${vendorTechnicalBidTech1}" varStatus="status">
                                    <tr>
                                        
                                        <td>${status.count}</td>
                                        <td style="min-width: 180px; font-size: 8px;">${vendorTechnicalBidTech1.description}</td>

                                        <c:if test="${vendor_code1 != ''}">
                                            <td >
                                                <c:if test="${vendorTechnicalBidTech1.vendorResponse == '0'}">
                                                    Yes
                                                </c:if>
                                                <c:if test="${vendorTechnicalBidTech1.vendorResponse == '1'}">
                                                    No
                                                </c:if>
                                                <c:if test="${vendorTechnicalBidTech1.vendorResponse == '2'}">
                                                    NA
                                                </c:if>
                                            </td>
                                        </c:if>
                                        <c:if test="${vendor_code2 != ''}">
                                            <c:forEach var="vendorTechnicalBidTech2" items="${vendorTechnicalBidTech2}" varStatus="status1">
                                                <c:if test="${vendorTechnicalBidTech1.srNo == vendorTechnicalBidTech2.srNo}">
                                                    <td>
                                                        <c:if test="${vendorTechnicalBidTech2.vendorResponse == '0'}">
                                                            Yes
                                                        </c:if>
                                                        <c:if test="${vendorTechnicalBidTech2.vendorResponse == '1'}">
                                                            No
                                                        </c:if>
                                                        <c:if test="${vendorTechnicalBidTech2.vendorResponse == '2'}">
                                                            NA
                                                        </c:if>
                                                    </td>
                                                </c:if>
                                            </c:forEach>
                                        </c:if>


                                        <c:if test="${vendor_code3 != ''}">
                                            <c:forEach var="vendorTechnicalBidTech3" items="${vendorTechnicalBidTech3}" varStatus="status1">
                                                <c:if test="${vendorTechnicalBidTech1.srNo == vendorTechnicalBidTech3.srNo}">
                                                    <td>
                                                        <c:if test="${vendorTechnicalBidTech3.vendorResponse == '0'}">
                                                            Yes
                                                        </c:if>
                                                        <c:if test="${vendorTechnicalBidTech3.vendorResponse == '1'}">
                                                            No
                                                        </c:if>
                                                        <c:if test="${vendorTechnicalBidTech3.vendorResponse == '2'}">
                                                            NA
                                                        </c:if>
                                                    </td>
                                                </c:if>
                                            </c:forEach>
                                        </c:if>

                                        <c:if test="${vendor_code4 != ''}">
                                            <c:forEach var="vendorTechnicalBidTech4" items="${vendorTechnicalBidTech4}" varStatus="status1">
                                                <c:if test="${vendorTechnicalBidTech1.srNo == vendorTechnicalBidTech4.srNo}">
                                                    <td>
                                                        <c:if test="${vendorTechnicalBidTech4.vendorResponse == '0'}">
                                                            Yes
                                                        </c:if>
                                                        <c:if test="${vendorTechnicalBidTech4.vendorResponse == '1'}">
                                                            No
                                                        </c:if>
                                                        <c:if test="${vendorTechnicalBidTech4.vendorResponse == '2'}">
                                                            NA
                                                        </c:if>
                                                    </td>
                                                </c:if>
                                            </c:forEach>
                                        </c:if>

                                        <c:if test="${vendor_code5 != ''}">
                                            <c:forEach var="vendorTechnicalBidTech5" items="${vendorTechnicalBidTech5}" varStatus="status1">
                                                <c:if test="${vendorTechnicalBidTech1.srNo == vendorTechnicalBidTech5.srNo}">
                                                    <td>
                                                        <c:if test="${vendorTechnicalBidTech5.vendorResponse == '0'}">
                                                            Yes
                                                        </c:if>
                                                        <c:if test="${vendorTechnicalBidTech5.vendorResponse == '1'}">
                                                            No
                                                        </c:if>
                                                        <c:if test="${vendorTechnicalBidTech5.vendorResponse == '2'}">
                                                            NA
                                                        </c:if>
                                                    </td>
                                                </c:if>
                                            </c:forEach>
                                        </c:if>

                                        <c:if test="${vendor_code6 != ''}">
                                            <c:forEach var="vendorTechnicalBidTech6" items="${vendorTechnicalBidTech6}" varStatus="status1">
                                                <c:if test="${vendorTechnicalBidTech1.srNo == vendorTechnicalBidTech6.srNo}">
                                                    <td>
                                                        <c:if test="${vendorTechnicalBidTech6.vendorResponse == '0'}">
                                                            Yes
                                                        </c:if>
                                                        <c:if test="${vendorTechnicalBidTech6.vendorResponse == '1'}">
                                                            No
                                                        </c:if>
                                                        <c:if test="${vendorTechnicalBidTech6.vendorResponse == '2'}">
                                                            NA
                                                        </c:if>
                                                    </td>
                                                </c:if>
                                            </c:forEach>
                                        </c:if>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        </div>
                    </c:if>                            

                    <c:if test="${!empty vendorTechnicalBidTerms1}">
                        <br>
                        <div class="table-responsive">
                        <table class="flex-table page-break-section" class="table table-bordered" style="" align="Center"  >
                            <thead style="font-size: 12px;">
                                <tr class="table-title">
                                    <th colspan="8" style="text-align: center;">Technical Specification For Service</th>
                                </tr>

                                <tr> 
                                    <th rowspan="2">Sr No.</th>
                                    <th>Vendor Code</th>
                                    <c:if test="${vendor_code1 != ''}">
                                        <th>${vendor_code1}</th>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <th>${vendor_code2}</th>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <th>${vendor_code3}</th>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <th>${vendor_code4}</th>
                                    </c:if>
                                    <c:if test="${vendor_code5 != ''}">
                                        <th>${vendor_code5}</th>
                                    </c:if>
                                    <c:if test="${vendor_code6 != ''}">
                                        <th>${vendor_code6}</th>
                                    </c:if>
                                </tr>

                                <tr> 
                                    <th>Vendor Name</th>
                                    <c:if test="${vendor_code1 != ''}">
                                        <th>${vendor_name1}</th>
                                    </c:if>
                                    <c:if test="${vendor_code2 != ''}">
                                        <th>${vendor_name2}</th>
                                    </c:if>
                                    <c:if test="${vendor_code3 != ''}">
                                        <th>${vendor_name3}</th>
                                    </c:if>
                                    <c:if test="${vendor_code4 != ''}">
                                        <th>${vendor_name4}</th>
                                    </c:if>
                                    <c:if test="${vendor_code5 != ''}">
                                        <th>${vendor_name5}</th>
                                    </c:if>
                                    <c:if test="${vendor_code6 != ''}">
                                        <th>${vendor_name6}</th>
                                    </c:if>
                                </tr>
                            </thead>
                            <tbody style="font-size: 10px;">                                

                                <c:forEach var="vendorTechnicalBidTerms1" items="${vendorTechnicalBidTerms1}" varStatus="status1">
                                    <tr>

                                        <td>${status1.count}</td>
                                        <td style="min-width: 180px; font-size: 8px;">${vendorTechnicalBidTerms1.description}</td>

                                        <c:if test="${vendor_code1 != ''}">
                                            <td>
                                                <c:if test="${vendorTechnicalBidTerms1.vendorResponse == '0'}">
                                                    Yes
                                                </c:if>
                                                <c:if test="${vendorTechnicalBidTerms1.vendorResponse == '1'}">
                                                    No
                                                </c:if>
                                                <c:if test="${vendorTechnicalBidTerms1.vendorResponse == '2'}">
                                                    NA
                                                </c:if>
                                            </td>
                                        </c:if>

                                        <c:if test="${vendor_code2 != ''}">
                                            <c:forEach var="vendorTechnicalBidTerms2" items="${vendorTechnicalBidTerms2}" varStatus="status1">
                                                <c:if test="${vendorTechnicalBidTerms1.srNo == vendorTechnicalBidTerms2.srNo}">
                                                    <td>
                                                        <c:if test="${vendorTechnicalBidTerms2.vendorResponse == '0'}">
                                                            Yes
                                                        </c:if>
                                                        <c:if test="${vendorTechnicalBidTerms2.vendorResponse == '1'}">
                                                            No
                                                        </c:if>
                                                        <c:if test="${vendorTechnicalBidTerms2.vendorResponse == '2'}">
                                                            NA
                                                        </c:if>
                                                    </td> 
                                                </c:if>
                                            </c:forEach>
                                        </c:if>

                                        <c:if test="${vendor_code3 != ''}">
                                            <c:forEach var="vendorTechnicalBidTerms3" items="${vendorTechnicalBidTerms3}" varStatus="status1">
                                                <c:if test="${vendorTechnicalBidTerms1.srNo == vendorTechnicalBidTerms3.srNo}">
                                                    <td>
                                                        <c:if test="${vendorTechnicalBidTerms3.vendorResponse == '0'}">
                                                            Yes
                                                        </c:if>
                                                        <c:if test="${vendorTechnicalBidTerms3.vendorResponse == '1'}">
                                                            No
                                                        </c:if>
                                                        <c:if test="${vendorTechnicalBidTerms3.vendorResponse == '2'}">
                                                            NA
                                                        </c:if>
                                                    </td>
                                                </c:if>
                                            </c:forEach>
                                        </c:if>

                                        <c:if test="${vendor_code4 != ''}">
                                            <c:forEach var="vendorTechnicalBidTerms4" items="${vendorTechnicalBidTerms4}" varStatus="status1">
                                                <c:if test="${vendorTechnicalBidTerms1.srNo == vendorTechnicalBidTerms4.srNo}">
                                                    <td>
                                                        <c:if test="${vendorTechnicalBidTerms4.vendorResponse == '0'}">
                                                            Yes
                                                        </c:if>
                                                        <c:if test="${vendorTechnicalBidTerms4.vendorResponse == '1'}">
                                                            No
                                                        </c:if>
                                                        <c:if test="${vendorTechnicalBidTerms4.vendorResponse == '2'}">
                                                            NA
                                                        </c:if>
                                                    </td>
                                                </c:if>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${vendor_code5 != ''}">
                                            <c:forEach var="vendorTechnicalBidTerms5" items="${vendorTechnicalBidTerms5}" varStatus="status1">
                                                <c:if test="${vendorTechnicalBidTerms1.srNo == vendorTechnicalBidTerms5.srNo}">
                                                    <td>
                                                        <c:if test="${vendorTechnicalBidTerms5.vendorResponse == '0'}">
                                                            Yes
                                                        </c:if>
                                                        <c:if test="${vendorTechnicalBidTerms5.vendorResponse == '1'}">
                                                            No
                                                        </c:if>
                                                        <c:if test="${vendorTechnicalBidTerms5.vendorResponse == '2'}">
                                                            NA
                                                        </c:if>
                                                    </td>
                                                </c:if>
                                            </c:forEach>
                                        </c:if>

                                        <c:if test="${vendor_code6 != ''}">
                                            <c:forEach var="vendorTechnicalBidTerms6" items="${vendorTechnicalBidTerms6}" varStatus="status1">
                                                <c:if test="${vendorTechnicalBidTerms1.srNo == vendorTechnicalBidTerms6.srNo}">
                                                    <td>
                                                        <c:if test="${vendorTechnicalBidTerms6.vendorResponse == '0'}">
                                                            Yes
                                                        </c:if>
                                                        <c:if test="${vendorTechnicalBidTerms6.vendorResponse == '1'}">
                                                            No
                                                        </c:if>
                                                        <c:if test="${vendorTechnicalBidTerms6.vendorResponse == '2'}">
                                                            NA
                                                        </c:if>
                                                    </td>
                                                </c:if>
                                            </c:forEach>
                                        </c:if>

                                    </tr>

                                </c:forEach>
                            </tbody>
                        </table>
                        </div>
                    </c:if>
                        
                    <c:if test="${!empty vendorTechnicalBidAttachment1}">
                        <br>
                        <div class="table-responsive">
                            <table class="flex-table page-break-section" class="table table-bordered" style="" align="Center"  >
                                <thead style="font-size: 12px;">
                                    <tr class="table-title">
                                        <th colspan="8" style="text-align: center;">Document Attachment</th>
                                    </tr>

                                    <tr>
                                        <th rowspan="2">Sr No.</th>
                                        <th rowspan="2">Description</th>

                                        <c:if test="${vendor_code1 != ''}">
                                            <th>${vendor_code1}</th>
                                            </c:if>
                                            <c:if test="${vendor_code2 != ''}">
                                            <th>${vendor_code2}</th>
                                            </c:if>
                                            <c:if test="${vendor_code3 != ''}">
                                            <th>${vendor_code3}</th>
                                            </c:if>
                                            <c:if test="${vendor_code4 != ''}">
                                            <th>${vendor_code4}</th>
                                            </c:if>
                                            <c:if test="${vendor_code5 != ''}">
                                            <th>${vendor_code5}</th>
                                            </c:if>
                                            <c:if test="${vendor_code6 != ''}">
                                            <th>${vendor_code6}</th>
                                            </c:if>
                                    </tr>

                                    <tr>
                                        <c:if test="${vendor_code1 != ''}">
                                            <th>${vendor_name1}</th>
                                            </c:if>
                                            <c:if test="${vendor_code2 != ''}">
                                            <th>${vendor_name2}</th>
                                            </c:if>
                                            <c:if test="${vendor_code3 != ''}">
                                            <th>${vendor_name3}</th>
                                            </c:if>
                                            <c:if test="${vendor_code4 != ''}">
                                            <th>${vendor_name4}</th>
                                            </c:if>
                                            <c:if test="${vendor_code5 != ''}">
                                            <th>${vendor_name5}</th>
                                            </c:if>
                                            <c:if test="${vendor_code6 != ''}">
                                            <th>${vendor_name6}</th>
                                            </c:if>
                                    </tr>
                                </thead>

                                <tbody style="font-size: 10px;">
                                    <c:forEach var="att1" items="${vendorTechnicalBidAttachment1}" varStatus="status2">
                                        <tr>

                                            <td>${status2.count}</td>
                                            <td style="min-width: 180px; font-size: 8px;">${att1.description}</td>

                                            <c:if test="${vendor_code1 != ''}">
                                                <td>${att1.venderResponse == '0' ? 'Yes' : att1.venderResponse == '1' ? 'No' : 'Na'}</td>
                                            </c:if>

                                            <c:if test="${vendor_code2 != ''}">
                                                <td>${vendorTechnicalBidAttachment2[status2.index].venderResponse == '0' ? 'Yes' : vendorTechnicalBidAttachment2[status2.index].venderResponse == '1' ? 'No' : 'Na'}</td>
                                            </c:if>

                                            <c:if test="${vendor_code3 != ''}">
                                                <td>${vendorTechnicalBidAttachment3[status2.index].venderResponse == '0' ? 'Yes' : vendorTechnicalBidAttachment3[status2.index].venderResponse == '1' ? 'No' : 'Na'}</td>
                                            </c:if>

                                            <c:if test="${vendor_code4 != ''}">
                                                <td>${vendorTechnicalBidAttachment4[status2.index].venderResponse == '0' ? 'Yes' : vendorTechnicalBidAttachment4[status2.index].venderResponse == '1' ? 'No' : 'Na'}</td>
                                            </c:if>

                                            <c:if test="${vendor_code5 != ''}">
                                                <td>${vendorTechnicalBidAttachment5[status2.index].venderResponse == '0' ? 'Yes' : vendorTechnicalBidAttachment5[status2.index].venderResponse == '1' ? 'No' : 'Na'}</td>
                                            </c:if>

                                            <c:if test="${vendor_code6 != ''}">
                                                <td>${vendorTechnicalBidAttachment6[status2.index].venderResponse == '0' ? 'Yes' : vendorTechnicalBidAttachment6[status2.index].venderResponse == '1' ? 'No' : 'Na'}</td>
                                            </c:if>                                        

                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:if>


                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUiComparisonFooterPrint.jsp"%>
</html>



