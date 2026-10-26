
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TENDER TECHNICAL COMPARISON</title>
    </head>
     <style>
        .buyer-info .form-group p {
    white-space: normal;
    overflow-wrap: anywhere;
}
    </style>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action=".htm?act=" commandName="departmentMaster" method="post">

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">TENDER TECHNICAL COMPARISON</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>                            
                            <a class="btn theme-btn" href="tenderMaster.htm?act=techBidComparisonViewPrint&refNo=${refNo}" class="btn btn-primary" onclick="printCustom()" title="Print this page">
                                <i class="fa fa-arrow-right"></i>&nbsp;&nbsp;Print
                            </a>
                        </div>
                    </div>
                    <br>
                    <h5 class="fw-600">Tender information</h5>
                    <hr>                    
                   

 
                        <div class="rounded-4 mt-4"> 
                        <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                            <div class="row buyer-info">
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Tender No</label>
                                        <p class="fw-600">${tenderMaster.refNo}</p>

                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Project Name</label>
                                        <p class="fw-600">${tenderMaster.title}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Project ID</label>
                                        <p class="fw-600">${tenderMaster.projectId}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Vendor Code</label>
                                        <p class="fw-600">${vendorCode}- ${vendorName}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Department</label>
                                        <p class="fw-600">${tenderMaster.department}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Tender Date Time</label>
                                        <p class="fw-600">${tenderMaster.announceDate}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Due Date Time</label>
                                        <p class="fw-600">${tenderMaster.submitLastdate}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>PR No</label>
                                        <p class="fw-600">${tenderMaster.prNo}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Mode Of Transport</label>
                                        <p class="fw-600">${tenderMaster.modeOfTransport}</p>
                                    </div>
                                </div>


                            </div>
                        </div>  
                    </div>
                                    
                    <c:if test="${!empty vendorTechnicalBidTech1}">
                        <h5 class="fw-600">Technical Specification For Item</h5>
                        <hr>
                        <table id="commonNoPageTable" class="table table-striped bg-white" style="min-width: 100%" align="Center" >
                            <thead>                                
                                <tr data-dt-order="disable">
                                    <th rowspan="2" style="min-width: 80px;">Sr No.</th>
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
                                <tr data-dt-order="disable">
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
                            
                            <tbody>

                                <c:set var="count" value="0" scope="page" />
                                <c:forEach var="vendorTechnicalBidTech1" items="${vendorTechnicalBidTech1}" varStatus="status">
                                    <tr>
                                        <td class="text-center">${status.count}</td>
                                        <td style="padding: 0px 0px;">${vendorTechnicalBidTech1.description}</td>

                                        <c:if test="${vendor_code1 != ''}">
                                            <td class="text-center" style="padding: 0px 0px;">
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
                                                    <td class="text-center" style="padding: 0px 0px;">
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
                                                    <td class="text-center" style="padding: 0px 0px;">
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
                                                    <td class="text-center" style="padding: 0px 0px;">
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
                                                    <td class="text-center" style="padding: 0px 0px;">
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
                                                    <td class="text-center" style="padding: 0px 0px;">
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
                    </c:if>

                    <c:if test="${!empty vendorTechnicalBidTerms1}">
                        <br>
                        <h5 class="fw-600">Technical Specification For Service</h5>                        
                        <hr>
                        <table id="commonNoPageTable1" class="table table-striped bg-white" style="min-width: 100%" align="Center" >
                            <thead>                                
                                <tr data-dt-order="disable">
                                    <th rowspan="2" style="min-width: 80px;">Sr No.</th>
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
                                <tr data-dt-order="disable">
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
                            
                            <tbody>                                

                                <c:forEach var="vendorTechnicalBidTerms1" items="${vendorTechnicalBidTerms1}" varStatus="status1">
                                    <tr>
                                        <td class="text-center">${status1.count}</td>
                                        <td style="padding: 0px 0px;">${vendorTechnicalBidTerms1.description}</td>

                                        <c:if test="${vendor_code1 != ''}">
                                            <td class="text-center" style="padding: 0px 0px;">
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
                                                    <td class="text-center" style="padding: 0px 0px;">
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
                                                    <td class="text-center" style="padding: 0px 0px;">
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
                                                    <td class="text-center" style="padding: 0px 0px;">
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
                                                    <td class="text-center" style="padding: 0px 0px;">
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
                                                    <td class="text-center" style="padding: 0px 0px;">
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
                    </c:if>
                    
                    <c:if test="${!empty vendorTechnicalBidAttachment1}">
                        <br>
                        <h5 class="fw-600">Document Attachment</h5>                        
                        <hr>

                        <table id="commonNoPageTable2" class="table table-striped bg-white" style="min-width: 100%" align="center">
                            <thead>                                
                                <tr data-dt-order="disable">
                                    <th rowspan="2">Sr No.</th>
                                    <th rowspan="2">Description</th>

                                    <c:if test="${vendor_code1 != ''}"><th class="text-center">${vendor_code1}</th></c:if>
                                    <c:if test="${vendor_code2 != ''}"><th class="text-center">${vendor_code2}</th></c:if>
                                    <c:if test="${vendor_code3 != ''}"><th class="text-center">${vendor_code3}</th></c:if>
                                    <c:if test="${vendor_code4 != ''}"><th class="text-center">${vendor_code4}</th></c:if>
                                    <c:if test="${vendor_code5 != ''}"><th class="text-center">${vendor_code5}</th></c:if>
                                    <c:if test="${vendor_code6 != ''}"><th class="text-center">${vendor_code6}</th></c:if>
                                </tr>

                                <tr data-dt-order="disable">
                                    
                                    <c:if test="${vendor_code1 != ''}"><th class="text-center">${vendor_name1}</th></c:if>
                                    <c:if test="${vendor_code2 != ''}"><th class="text-center">${vendor_name2}</th></c:if>
                                    <c:if test="${vendor_code3 != ''}"><th class="text-center">${vendor_name3}</th></c:if>
                                    <c:if test="${vendor_code4 != ''}"><th class="text-center">${vendor_name4}</th></c:if>
                                    <c:if test="${vendor_code5 != ''}"><th class="text-center">${vendor_name5}</th></c:if>
                                    <c:if test="${vendor_code6 != ''}"><th class="text-center">${vendor_name6}</th></c:if>
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach var="att1" items="${vendorTechnicalBidAttachment1}" varStatus="status2">
                                    <tr>
                                        <td>${status2.count}</td>

                                        <td>${att1.description}</td>

                                        <c:if test="${vendor_code1 != ''}">
                                            <td class="text-center">
                                                ${att1.venderResponse == '0' ? 'Yes' : att1.venderResponse == '1' ? 'No' : 'Na'}
                                            </td>
                                        </c:if>

                                        <c:if test="${vendor_code2 != ''}">
                                            <td class="text-center">
                                                ${vendorTechnicalBidAttachment2[status2.index].venderResponse == '0' ? 'Yes' : vendorTechnicalBidAttachment2[status2.index].venderResponse == '1' ? 'No' : 'Na'}
                                            </td>
                                        </c:if>

                                        <c:if test="${vendor_code3 != ''}">
                                            <td class="text-center">
                                                ${vendorTechnicalBidAttachment3[status2.index].venderResponse == '0' ? 'Yes' : vendorTechnicalBidAttachment3[status2.index].venderResponse == '1' ? 'No' : 'Na'}
                                            </td>
                                        </c:if>

                                        <c:if test="${vendor_code4 != ''}">
                                            <td class="text-center">
                                                ${vendorTechnicalBidAttachment4[status2.index].venderResponse == '0' ? 'Yes' : vendorTechnicalBidAttachment4[status2.index].venderResponse == '1' ? 'No' : 'Na'}
                                            </td>
                                        </c:if>

                                        <c:if test="${vendor_code5 != ''}">
                                            <td class="text-center">
                                                ${vendorTechnicalBidAttachment5[status2.index].venderResponse == '0' ? 'Yes' : vendorTechnicalBidAttachment5[status2.index].venderResponse == '1' ? 'No' : 'Na'}
                                            </td>
                                        </c:if>

                                        <c:if test="${vendor_code6 != ''}">
                                            <td class="text-center">
                                                ${vendorTechnicalBidAttachment6[status2.index].venderResponse == '0' ? 'Yes' : vendorTechnicalBidAttachment6[status2.index].venderResponse == '1' ? 'No' : 'Na'}
                                            </td>
                                        </c:if>

                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                    

                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
