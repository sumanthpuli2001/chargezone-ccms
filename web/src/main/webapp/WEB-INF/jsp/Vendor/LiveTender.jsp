<%-- 
    Document   : VendorPolicy
    Created on : 28 Oct, 2025, 03:00:57 PM
    Author     : fnp
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>Home page</title>

        <style>
            .textarea-field:disabled {
                background-color: #d6d8db !important;
                color: #495057 !important;           
                border: 1px solid #6c757d !important;
                opacity: 1;                          
            }
        </style>
        <style>
            .modal-body {
    max-height: calc(100vh - 180px);
    overflow-y: auto;
     overflow-x: hidden !important;
}

        </style>
        <script>
        function initResultContent(selector, obj = {}) {
        return $(selector).DataTable({
        paging: false,
                lengthChange: false,
                searching: false,
                info: false,
                autoWidth: true,
                ordering: false,
                scrollX: false,
                dom: 't<"table-bottom-info d-flex align-items-center justify-content-between pt-3"i p>',
                ...obj,
        });
        }
    </script>
        <script>
        function initResultContents(selector, obj = {}) {
        return $(selector).DataTable({
        paging: false,
                lengthChange: false,
                searching: false,
                info: false,
                autoWidth: true,
                ordering: false,
                scrollX: false,
                dom: 't<"table-bottom-info d-flex align-items-center justify-content-between pt-3"i p>',
                ...obj,
        });
        }
    </script>
    <script>
        function initDocTable(selector, obj = {}) {
        return $(selector).DataTable({
        paging: false,
                lengthChange: false,
                searching: false,
                info: false,
                autoWidth: true,
                ordering: false,
                scrollX: false,
                dom: 't<"table-bottom-info d-flex align-items-center justify-content-between pt-3"i p>',
                ...obj,
        });
        }
        
    </script>
    
    </head>

    <body>
        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNewVendor.jsp"%>

            <section id="printSection" class="main-content">
                <form:form action="employeeMaster.htm?act=disableEmployee" method="post" 
                           name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">                    
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">LIVE TENDER</h5>
                        </div>
<!--                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>                                            
                        </div>-->
                    </div>
                    <hr>
                    <c:if test="${!empty successMessage}">
                        <div id="successMsg" class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                    </c:if>
                    <c:if test="${!empty failureMessage}">
                        <div id="failureMsg" class="fadeOutEffect alert alert-danger" style="padding: 0px" role="alert">${failureMessage}</div>
                    </c:if>

                        
                        
                        <table  id="commonDocTable"class="table table-striped bg-white dt-scroll" style="min-width:  100%;" align="center">       
                                            <c:choose>
                                                <c:when test="${list.size() == 0 && list11.size() == 0}">
                                                  
                                                </c:when>
                                                <c:otherwise>
                                                    <thead>
                                                        <tr>
                                                            <th>Tender Ref No.</th>
                                                            <th>Project Name</th>
                                                            <th>Tender Date </th>
                                                            <th>Tender Due Date </th>
                                                            <th>Tender Type </th>
                                                            <th>Tender Communication</th> 
                                                            <th>Bid</th>
                                                            <th style="min-width: 190px;">Regret / Print</th>

                                                        </tr>
                                                    </thead>
                                                    <c:set var="count" value="0" scope="page" />
                                                    <tbody>
                                                        <c:forEach var="list" items="${list}" varStatus="status">
                                                            <tr>
                                                                <td>
                                                                    <input type="hidden" id="refNo" value="${list[0]}"/>
                                                                    <c:if test="${list[8] != 'Service Manually'}">
                                                                        ${list[0]}
                                                                    </c:if>
                                                                    <c:if test="${list[8] == 'Service Manually'}">
                                                                        ${list[0]}
                                                                    </c:if>

                                                                </td>
                                                                <td>${list[2]}</td>
                                                                <td>${list[5]}</td>
                                                                <td>${list[6]}</td>
                                                                <td>${list[7]} Part</td>
                                                                <td>
<!--                                                                    <a href="#" onclick="window.open('vendor.htm?act=tenderVendorCommunication&tender_no=${list[0]}', '', 'left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1');
                                                                       ">Tender Communication</a>-->
                                                                      
                                                                <a href="#" data-toggle="modal" data-target="#vendorQueryUpload"  onclick="requestDocvendorQueryTab('${list[0]}')">
                                                               Tender Communication
                                                                 </a>         
                                                                       
                                                                       
                                                                       
                                                                       
                                                                </td> 

                                                                <td>
                                                                    <c:set var = "i2" value="0"/>
                                                                    <c:forEach var="tenderRegret" items="${tenderRegret}" varStatus="status2">
                                                                        <c:if test="${list[0] == tenderRegret.refNo && tenderRegret.flag == '1'}">
                                                                            <c:set var = "i2" value="1"/>
                                                                        </c:if>
                                                                    </c:forEach>
                                                                    <c:set var = "i1" value="0"/>
                                                                    <c:if test="${i2 == '0'}">

                                                                        <c:forEach var="list3" items="${list3}" varStatus="status1">
                                                                            <c:if test="${list[0] == list3[0]}">
                                                                                <c:set var = "i1" value="1"/>
                                                                            </c:if>
                                                                        </c:forEach>
                                                                        <c:if test="${i1 == '0'}">
                                                                            <c:if test="${list[7] == '1'}">
                                                                                <a href="vendor.htm?act=bidTenderForOffer&refNo=${list[0]}">Participate Bid</a>
                                                                            </c:if>
                                                                            <c:if test="${list[7] == '2'}">
                                                                                <a href="vendor.htm?act=bidTenderFortTechnical&refNo=${list[0]}">Participate Bid</a>
                                                                            </c:if>
                                                                            <c:if test="${list[7] == '3'}">
                                                                                <a href="vendor.htm?act=bidTenderForPreQualification&refNo=${list[0]}">Participate Bid</a>
                                                                            </c:if>
                                                                        </c:if>
                                                                        <c:if test="${i1 != '0'}">
                                                                            <c:if test="${list[7] == '1'}">
                                                                                <a href="vendor.htm?act=bidTenderForOffer&refNo=${list[0]}">Revise Bid</a>
                                                                            </c:if>
                                                                            <c:if test="${list[7] == '2'}">
                                                                                <a href="vendor.htm?act=bidTenderFortTechnical&refNo=${list[0]}">Revise Bid</a>
                                                                            </c:if>
                                                                            <c:if test="${list[7] == '3'}">
                                                                                <a href="vendor.htm?act=bidTenderForPreQualification&refNo=${list[0]}">Revise Bid</a>
                                                                            </c:if>
                                                                        </c:if>
                                                                    </c:if>
                                                                </td>
                                                                <td>
                                                                    <c:if test="${i1 == '0'}">

                                                                        <c:if test="${i2 == '0'}">
                                                                            <a href=""  data-toggle="modal" data-target="#Regret"> REGRET</a>
                                                                        </c:if>
                                                                        <c:if test="${i2 == '1'}">
                                                                            <a href=""  data-toggle="modal" data-target="#Bid">BID</a>
                                                                        </c:if>

                                                                    </c:if>   
                                                                    <c:if test="${i1 != '0'}">

                                                                        <c:if test="${list[7] == '3'}">
                                                                            <a  href="tenderMaster.htm?act=preBidPrint&refNo=${list[0]}&vendorCode=${username}">Pre Bid Print</a><br>
                                                                        </c:if>
                                                                        <c:if test="${list[7] != '1'}">
                                                                            <a  href="tenderMaster.htm?act=techBidVendorPrint&refNo=${list[0]}&vendorCode=${username}">Tech Bid Print</a><br>    
                                                                        </c:if>

                                                                        <c:if test="${list[7] == '1'}">
                                                                            <c:if test="${list[8] == 'Service Manually'}">
                                                                                <a  href="vendor.htm?act=priceBidServiceVendnorSidePrint&refNo=${list[0]}&vendorCode=${username}">Price Bid Print</a>
                                                                            </c:if>
                                                                            
                                                                                <c:if test="${list[8] != 'Service Manually'}">
                                                                                    <a  href="vendor.htm?act=priceBidVendorSidePrint&refNo=${list[0]}&vendorCode=${username}">Price Bid Print</a>
                                                                                </c:if>                                                                                
                                                                            
                                                                        </c:if>
                                                                    </c:if>

                                                                </td>
                                                            </tr>
                                                        </c:forEach>



                                                        <c:forEach var="list" items="${list11}" varStatus="status">
                                                            <tr>
                                                                <input type="hidden" id="refNo" value="${list[0]}"/>
                                                                <td>${list[0]}</td>
                                                                <td>${list[2]}</td>
                                                                <td>${list[5]}</td>
                                                                <td>${list[6]}</td>
                                                                <td>${list[7]} Part</td>
                                                                <td><a href="#" data-toggle="modal" data-target="#vendorQueryUpload"  onclick="requestDocvendorQueryTab('${list[0]}')">Tender Communication</a></td>
                                                                <td>
                                                                    <c:set var = "i2" value="0"/>
                                                                    <c:forEach var="tenderRegret" items="${tenderRegret}" varStatus="status2">
                                                                        <c:if test="${list[0] == tenderRegret.refNo && tenderRegret.flag == '1'}">
                                                                            <c:set var = "i2" value="1"/>
                                                                        </c:if>
                                                                    </c:forEach>
                                                                    <c:set var = "i1" value="0"/>
                                                                    <c:if test="${i2 == '0'}">

                                                                        <c:forEach var="list3" items="${list3}" varStatus="status1">
                                                                            <c:if test="${list[0] == list3[0]}">
                                                                                <c:set var = "i1" value="1"/>

                                                                            </c:if>
                                                                        </c:forEach>

                                                                        <c:if test="${i1 == '0'}">
                                                                            <c:if test="${list[7] == '1'}">
                                                                                <a href="vendor.htm?act=bidTenderForOffer&refNo=${list[0]}">Participate Bid</a>
                                                                            </c:if>
                                                                            <c:if test="${list[7] == '2'}">
                                                                                <a href="vendor.htm?act=bidTenderForOffer&refNo=${list[0]}">Participate Bid</a>
                                                                            </c:if>
                                                                            <c:if test="${list[7] == '3'}">
                                                                                <a href="vendor.htm?act=bidTenderForPreQualification&refNo=${list[0]}">Participate Bid</a>
                                                                            </c:if>
                                                                        </c:if>
                                                                        <c:if test="${i1 != '0'}">
                                                                            <c:if test="${list[7] == '1'}">
                                                                                <a href="vendor.htm?act=bidTenderForOffer&refNo=${list[0]}">Revise Bid</a>
                                                                            </c:if>
                                                                            <c:if test="${list[7] == '2'}">
                                                                                <a href="vendor.htm?act=bidTenderForOffer&refNo=${list[0]}">Revise Bid</a>
                                                                            </c:if>
                                                                            <c:if test="${list[7] == '3'}">
                                                                                <a href="vendor.htm?act=bidTenderForPreQualification&refNo=${list[0]}">Revise Bid</a>
                                                                            </c:if>
                                                                        </c:if>
                                                                    </c:if>

                                                                </td>
                                                                <td>

                                                                    <c:if test="${i1 == '0'}">




                                                                        <c:if test="${i2 == '0'}">
                                                                          <a href=""  data-toggle="modal"  data-target="#Regret"> REGRET</a>
                                                                        </c:if>
                                                                        <c:if test="${i2 == '1'}">
                                                                           <a href=""  data-toggle="modal" data-target="#Bid"> BID</a>
                                    
                                                                            
                                                                        </c:if>

                                                                    </c:if>   
                                                                    <c:if test="${i1 != '0'}">

                                                                        <c:if test="${list[7] == '3'}">
                                                                            <a  href="tenderMaster.htm?act=preBidPrint&refNo=${list[0]}&vendorCode=${username}">Pre Bid Print</a><br>
                                                                        </c:if>
                                                                        <c:if test="${list[7] != '1'}">
                                                                            <a  href="tenderMaster.htm?act=techBidVendorPrint&refNo=${list[0]}&vendorCode=${username}">Tech Bid Print</a><br>    
                                                                        </c:if>

                                                                        <c:if test="${list[8] == 'Service Manually'}">
                                                                            <a  href="vendor.htm?act=priceBidServiceVendnorSidePrint&refNo=${list[0]}&vendorCode=${username}">Price Bid Print</a>
                                                                        </c:if>
                                                                        <c:if test="${list[8] != 'Service Manually'}">
                                                                            <a  href="vendor.htm?act=priceBidVendorSidePrint&refNo=${list[0]}&vendorCode=${username}">Price Bid Print</a>
                                                                        </c:if>
                                                                    </c:if>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>

                                                </c:otherwise>
                                            </c:choose>
                                        </table>
                                    <h5 class="fw-600">Tender Revise Bid</h5>                                              
                                    <table id="commonDocTable1" class="table table-striped bg-white dt-scroll" style="min-width: 100%" align="Center"  >
                                        <c:choose>
                                            <c:when test="${empty list4}">

                                            </c:when>
                                            <c:otherwise>
                                                <thead>
                                                    <tr>
                                                        <th>Tender Ref No.</th>
                                                        <th>Project Name</th>
                                                        <th>Fee </th>
                                                        <th>Tender Date </th>
                                                        <th>Tender Due Date </th>
                                                        <th>Tender Type </th>
                                                        <th>EMD</th>
                                                        <th>Bid</th>
                                                        <th>Print</th>
                                                    </tr>
                                                </thead>
                                                <c:set var="count" value="0" scope="page" />
                                                <tbody>
                                                    <c:forEach var="list" items="${list4}" varStatus="status">
                                                        <tr>
                                                            <td>
                                                                <input type="hidden" id="refNo" value="${list[0]}"/>
                                                                ${list[0]}
                                                            </td>
                                                            <td>${list[1]}</td>
                                                            <td>${list[2]}</td>
                                                            <td>${list[4]}</td>
                                                            <td>${list[5]}</td>
                                                            <td>${list[6]} Part</td>
                                                            <td>${list[3]}</td>
                                                            <td>
                                                     <!--   <a href="vendor.htm?act=bidTenderForTwoPartFinancial&refNo=${list[0]}">Revise Bid</a> -->
                                                        <c:if test="${list[8] == '0'}">
                                                            <a href="vendor.htm?act=bidTenderFortTechnical&refNo=${list[0]}">Revise Bid</a>
                                                        </c:if>
                                                        <c:if test="${list[8] == '1'}">
                                                            <a href="vendor.htm?act=bidTenderForReviseBid&refNo=${list[0]}">Revise Bid</a>
                                                        </c:if>
                                                    </td>
                                                    <td>
                                                        <c:if test="${list[7] == 'Service Manually'}">
                                                            <a  href="vendor.htm?act=priceBidServiceVendnorSidePrint&refNo=${list[0]}&vendorCode=${username}">Price Bid Print</a>
                                                        </c:if>
                                                        <c:if test="${list[7] != 'Service Manually'}">
                                                            <a  href="vendor.htm?act=priceBidVendorSidePrint&refNo=${list[0]}&vendorCode=${username}">Revise Price Bid Print</a>
                                                        </c:if>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </c:otherwise>
                                </c:choose>
                            </table>
                        <c:choose>
                            <c:when test="${list5.size() == 0}">
                            </c:when>
                            <c:otherwise>
                                <br>
                                <h5 class="fw-600">Technical Revise Bid</h5>

                            <table id="commonDocTable2" class="table table-striped bg-white dt-scroll" style="min-width: 100%" align="Center"  >
                                <thead>
                                    <tr>
                                        <th>Tender Ref No.</th>
                                        <th>Project Name</th>
                                        <th>Tender Date </th>
                                        <th>Tender Due Date </th>
                                        <th>Tender Type </th>
                                        <th>Tender Communication</th> 
                                        <th>Bid</th>

                                    </tr>
                                </thead>
                                <c:set var="count" value="0" scope="page" />
                                <tbody>
                                    <c:forEach var="list" items="${list5}" varStatus="status">
                                        <tr>
                                            <td>
                                                <input type="hidden" id="refNo" value="${list[0]}"/>
                                                ${list[0]}</td>
                                            <td>${list[1]}</td>
                                            <td>${list[4]}</td>
                                            <td>${list[5]}</td>
                                            <td>${list[6]} Part</td>
                                            <td>
<!--                                                <a href="#" onclick="window.open('vendor.htm?act=tenderVendorCommunication&tender_no=${list[0]}', '', 'left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1');
                                                   ">Tender Communication</a>-->
                                                   
                                         <a href="#" data-toggle="modal" data-target="#vendorQueryUpload"  onclick="requestDocvendorQueryTab('${list[0]}')">
                                                               Tender Communication
                                                                 </a>             
                                                   
                                                   
                                                   
                                            </td> 
                                            <td>
                                                <a href="vendor.htm?act=bidTenderForTechnicalReviseBid&refNo=${list[0]}">Revise Bid</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </c:otherwise>
                    </c:choose>                                    
                </form:form>
            </section>
           
                 
                 
                 
                 
                 
                 <div class="modal fade" id="vendorQueryUpload" data-backdrop="static" data-keyboard="false"
                         tabindex="-1" aria-labelledby="vendorQueryUploadLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">

                                <div class="modal-header align-items-center">
                                    <h5 class="modal-title" id="vendorQueryUploadLabel">Vendor Communication
                                    </h5>
                                    <div class="cta-btn d-flex align-items-center">
                                        <button type="button" class="btn theme-btn light-btn mr-3" onclick=""
                                                data-dismiss="modal">Close</button>
                                        <button class="btn theme-btn flex ml-3" onclick="openVendorCreateModal()">
                                            <img src="StorageYard/assets/images/plus.svg" class="mr-2 icon">
                                            Add New
                                        </button>
                                        
                                    </div>
                                </div>
                                        <div class="modal-body">
                                        <div class="bg-white" id="vendorQueryDivs"></div>
                                    </div>
                            </div>
                        </div>  
                        </div> 
                 <script type="text/javascript">

    function setupImportVendorQueryTable() {
    if (jQuery('#vendorQueryTable').length) {
        initTable('#vendorQueryTable');
    }
}

    function requestDocvendorQueryTab(tenderNo) {

        if (!tenderNo) {
            console.error("Tender number missing");
            return;
        }

        const xhr = new XMLHttpRequest();

        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {

                const resultDiv = document.getElementById("vendorQueryDivs");

                if (resultDiv) {
                    resultDiv.innerHTML = xhr.responseText;
                    initResultContent();
                } else {
                    console.error("Element with ID 'vendorQueryDivs' not found.");
                }
            }
        };

        xhr.open(
            "GET",
            "vendor.htm?act=tenderVendorCommunication&tender_no=" + tenderNo,
            true
        );

        xhr.send();
    }

    function initResultContent() {
        setupImportVendorQueryTable();
    }

</script>

                                    <div class="modal fade" id="vendorQueryCreate" tabindex="-1">
                                    <div class="modal-dialog modal-lg">
                                        <div class="modal-content">
                                            <div class="modal-header align-items-center">
                                                <h5 class="modal-title">Vendor Communication Create</h5>
                                                <div class="cta-btn d-flex align-items-center">
                                                    <button type="button" class="btn theme-btn light-btn mr-3" data-dismiss="modal">
                                                        Close
                                                    </button>
                                                    <button type="button" class="btn theme-btn" id="vendorCommunicationSubmit">
                                                        Submit
                                                    </button>
                                                </div>
                                            </div>

                                            <div class="modal-body">
                                             <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                                                    <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                                                    <div>
                                                         <strong>Note:</strong> Ensure your file size is within <strong>5MB</strong> for a smooth upload. <br>
                                                        <span style="font-weight: bold;" >*</span> Fields marked with an asterisk are mandatory.
                                                    </div>
                                                </div>
                                                <br>
                                               
                                                <input type="hidden" id="create_tender_no" name="tender_no">

                                                <div class="row mb-3">
                                                    <div class="col-lg-4 col-md-6">
                                                        <label>Subject <span class="fw-600"style="color: red"> *</span></label>
                                                        <input type="text" class="input-field" id="subject">
                                                    </div>

                                                    <div class="col-lg-4 col-md-6">
                                                        <label>Message<span class="fw-600"style="color: red"> *</span></label>
                                                        <input type="text" class="input-field" id="msg">
                                                    </div>
                                                </div>

                                            
                                            <input type="hidden" id="policyCount" value="1" />

                                <div class="row title-row">
                                    <!--<div class="col-md-3 pr-2 pt-1 pb-2 fs-13 fw-600">Title</div>-->
                                    <div class="col-md-11 px-3 pt-1 pb-2 fs-13">Attachment</div>
                                    <div class="col-md-1 pl-2 pt-1 pb-2 fs-13 text-center">Action</div>
                                </div>

                                <div class="target-block">
                                    <div class="row main-row m-0 mb-2" id="addmoreFile1">

                                        <div class="col-md-11 p-0">
                                            <input type="file" id="techDocsInput" name="generalfile" class="input-field py-2 fs-12i" >
                                        </div>
                                        <div class="col-md-1 pl-2 text-center">
                                            <div class="clone-action clone-new-field mx-auto" title="Add">
                                                <img src="StorageYard/assets/images/clone-btn.svg" onload="SVGInject(this)" alt="Add">
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="clone d-none">
                                    <div class="row file-row m-0 mb-2">

                                        <div class="col-md-11 p-0">
                                            <input type="file" name="" class="input-field py-2 fs-12i" required>
                                        </div>
                                        <div class="col-md-1 pl-2 text-center">
                                            <div class="clone-action delete-parent-field mx-auto" title="Remove">
                                                <img src="StorageYard/assets/images/clone-delete-btn.svg"
                                                    onload="SVGInject(this)" alt="Remove">
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>







<script>
    
                    function openVendorCreateModal() {
                    var tenderNo = document.getElementById("tender_no").value;

                    if (!tenderNo) {
                        alert("Tender No missing");
                        return;
                    }

                    document.getElementById("create_tender_no").value = tenderNo;
                    $('#vendorQueryCreate').modal('show');
                }

                    let tempCount30 = 1;
                    const bootoast = window.Bootoast;

                    document.querySelector('.target-block').addEventListener('click', function (e) {
                        if (e.target.closest('.clone-new-field')) {
                            tempCount30++;

                            const clone = document.querySelector('.clone .file-row').cloneNode(true);
                            clone.classList.remove('d-none');

                            clone.querySelector('input[type="file"]').setAttribute('name', 'generalfile' + tempCount30);
                            clone.setAttribute('id', 'addmoreFile' + tempCount30);

                            document.querySelector('.target-block').appendChild(clone);
                            document.getElementById('policyCount').value = tempCount30;
                        }
                    });

                    document.querySelector('.target-block').addEventListener('click', function (e) {
                        if (e.target.closest('.delete-parent-field')) {
                            e.target.closest('.row').remove();
                            const rows = document.querySelectorAll('.target-block .row');
                            document.getElementById('policyCount').value = rows.length;
                            tempCount30 = rows.length;
                        }
                    });

                    document.getElementById('vendorCommunicationSubmit').addEventListener('click', function () {
                        
                        var tenderNo = document.getElementById("create_tender_no").value;
                        var subject  = document.getElementById("subject").value.trim();
                        var msg      = document.getElementById("msg").value.trim();

                        if (!tenderNo || !subject || !msg) {
                            Swal.fire({
                            icon: 'warning',
                            title: 'Missing Fields',
                            text: 'subject & Message  fields required'
                        });
                            return;
                        }
                        
                        const formData = new FormData();
                        const rows = document.querySelectorAll('.target-block .row');
                        const uploadedFileNames = [];
                        rows.forEach((row, index) => {
                            const fileInput = row.querySelector('input[type="file"]');

                            if (fileInput && fileInput.files.length > 0) {
                                const file = fileInput.files[0];
                                formData.append('vendorCreateAttachment', file);
                            }
                        });

                        formData.append('policyCount', rows.length);
                        formData.append("tender_no", tenderNo);
                        formData.append("subject", subject);
                        formData.append("msg", msg);

                        const xhr = new XMLHttpRequest();
                        xhr.open('POST', 'vendor.htm?act=tenderVendorCommunicationCreateSubmit', true);

                        
                        xhr.onload = function () {
                            
                            if (xhr.status === 200) {
                                document.querySelectorAll('.target-block input[type="file"]').forEach(input => {
                                    input.value = '';
                                });
                                document.querySelectorAll('.target-block .file-row').forEach(row => row.remove());
                                tempCount30 = 1;
                                document.getElementById('policyCount').value = 1;

                                Swal.fire({
                                    icon: 'success',
                                    title: 'Success',
                                    text: 'Saved successfully',
                                    confirmButtonText: 'OK'
                                }).then(() => {
                                    document.getElementById("subject").value = "";
                                    document.getElementById("msg").value = "";
                                    $('#vendorQueryCreate').modal('hide');
                                });
                            } else {
                                bootoast.toast({
                                    message: 'Upload failed: ' + xhr.statusText,
                                    type: 'danger',
                                    position: 'top-center',
                                    timeout: 4000
                                });
                            }
                        };

                        xhr.onerror = function () {
                            bootoast.toast({
                                message: 'Network error while uploading file.',
                                type: 'danger',
                                position: 'top-center',
                                timeout: 4000
                            });
                        };

                        xhr.send(formData);
                    });
                </script>


<script>
  
    


</script>






         <script>
       
            function validateFileSize(input) {
                const file = input.files[0];
                const maxSize = 5 * 1024 * 1024; // 5MB

                if (file && file.size > maxSize) {
                    document.getElementById('fileError').style.display = 'block';
                    input.value = ''; // Clear the file input
                } else {
                    document.getElementById('fileError').style.display = 'none';
                }
            }

            var tempCount3 = 1;
            $(document).on("click", "#policyCloneid", function () {
                    tempCount3++;

                    var clone = "<tr id='addmoreFile" + tempCount3 + "' style='clear:both;'>"
                        + "<td><input type=\"file\" class=\"input-field\" placeholder=\"action\" name=\"generalfile1\" id=\"vendorReplyAttachment" + tempCount3 + "\">\n\
                            <span id='fileError" + tempCount3 + "' style='display:none; color:red; font-size:12px;'>* File should not exceed 5MB</span></td>"
//                        + "<td><input type =\"text\" class=\"input-field\" placeholder=\"Description\" name=\"descriptions" + "" + "\" id=\"description" + tempCount3 + "\"></td>"
                        + "<td style='text-align: center'>"
                        + "<span style='margin-top: 5px;'>"
                        + "  &nbsp;&nbsp;&nbsp;"
                        + "<div class='clone-action delete-parent-field' title='Remove' style='cursor: pointer; display:inline-block;' onclick=\"removePolicy('addmoreFile" + tempCount3 + "');\">"
                        + "<img src='StorageYard/assets/images/clone-delete-btn.svg' onload='SVGInject(this)' alt='Remove'>"
                        + "</div>"
                        + "</span>"
                        + "</td>"
                        + "</tr>";

                    $("#policyTable").append(clone);
                    document.getElementById('policyCount').value = tempCount3;
                });
//            });

            function removePolicy(policyDiv) {
                try {
                    var element1 = document.getElementById(policyDiv);
                    element1.parentNode.removeChild(element1);
                    updateSerialNumbers();
                    var policyCount = document.getElementById('policyTable').rows.length - 1;
                    document.getElementById('policyCount').value = policyCount;
                } catch (e) {
                    console.log(e);
                }
            }

            function updateSerialNumbers() {
                var table = document.getElementById('policyTable');
                var rowCount = table.rows.length;
                var srNo = 1;
                for (var i = 1; i < rowCount; i++) {
                    if (table.rows[i].id !== '') {
                        table.rows[i].cells[0].getElementsByTagName('input')[0].value = srNo++;
                    }
                }
            }
    </script>        
             
    <div class="modal fade" id="vendorQueryUploadReply" tabindex="-1">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">

                <div class="modal-header align-items-center">
                    <h5 class="modal-title" id="vendorQueryUploadLabel">Vendor Communication Reply
                    </h5>
                    <div class="cta-btn d-flex align-items-center">
                        <button type="button" class="btn theme-btn light-btn" onclick=""
                                data-dismiss="modal">Close</button>
                        <button type="button" class="btn theme-btn ml-3"
                                id="replySubmitVendorQuery">Reply</button>
                    </div>
                </div>   

                <div class="modal-body">
                    <div id="vendorQueryReplyDivs"></div>
                </div>

            </div>
        </div>
    </div>
    
    <script type="text/javascript">
function openVendorModalReply(id, tenderNo) {

    // Show modal (Bootstrap 4/5 safe)
    const modalEl = document.getElementById('vendorQueryUploadReply');
    if (modalEl) {
        const modal = new bootstrap.Modal(modalEl);
        modal.show();
    }

    const targetDiv = document.getElementById("vendorQueryReplyDivs");
    if (!targetDiv) {
        console.error("vendorQueryReplyDivs not found");
        return;
    }

    // Loading text
    targetDiv.innerHTML = "<p>Loading...</p>";

    const xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                targetDiv.innerHTML = xhr.responseText;
//                initReplyContent();
            setupAjaxReplyContantTable();
            } else {
                targetDiv.innerHTML = "<p>Error loading data</p>";
            }
        }
    };

    xhr.open(
        "GET",
        "vendor.htm?act=tenderVendorCommunicationView&id=" + encodeURIComponent(id) +
        "&tender_no=" + encodeURIComponent(tenderNo),
        true
    );

    xhr.send();
    
}


</script>
    
     <script>
    function setupAjaxReplyContantTable() {
        if ($('#vendorQueryReply').length) {
            initTable('#vendorQueryReply');
        }
    }
    document.getElementById('replySubmitVendorQuery').addEventListener('click', function () {
        var form = document.getElementById('myform1');
        var formData = new FormData(form);

        var xhr = new XMLHttpRequest();
        xhr.open('POST', 'vendor.htm?act=tenderVendorCommunicationReply', true);
                 xhr.onreadystatechange = function () {
                if (xhr.readyState === 4) {
                    if (xhr.status === 200) {
                        document.getElementById("vendorQueryReplyFinalDivs").innerHTML = xhr.responseText;
                        setTimeout(() => {
//                            setupImportVendorTable();
                            if ($('#vendorQueryReplyFinalDivs').length) {
                                const table1 = initTable('#vendorQueryReplyFinal');
                            }
                            $('#vendorQueryUploadReply').modal('hide');          // close current modal (if any)
                            $('#vendorQueryUploadReplyNext').modal('show');      // open new modal

                            
                            $('#vendorQueryReplyDivs').removeClass('d-none');                     
                         }, 100);
                       
                    } else {
                        Swal.fire({
                            title: 'An error occurred while submitting data.',
                            icon: 'error',
                            timer: 2000,
                            showConfirmButton: false
                        });
                    }
                }
            };
        
        
        
        

        xhr.onerror = function () {
            console.error("Request failed.");
        };

        xhr.send(formData);
    });
    </script>
    
    <div class="modal fade" id="vendorQueryUploadReplyNext" tabindex="-1">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">

                <div class="modal-header align-items-center">
                    <h5 class="modal-title" id="vendorQueryUploadReply">Vendor Communication Reply Attachment
                    </h5>
                    <div class="cta-btn d-flex align-items-center">
                        <button type="button" class="btn theme-btn light-btn" onclick=""
                                data-dismiss="modal">Close</button>
                        <button type="button" class="btn theme-btn ml-3"
                                id="vendorQueryReplyAttachmentSubmit">Submit</button>
                    </div>
                </div>   

                <div class="modal-body">
                    <div id="vendorQueryReplyFinalDivs"></div>
                </div>

            </div>
        </div>
    </div> 
    
    
    <script>
    
    document.getElementById('vendorQueryReplyAttachmentSubmit').addEventListener('click', function () {
        var form = document.getElementById('myform2');
        var formData = new FormData(form);

        var xhr = new XMLHttpRequest();
        xhr.open('POST', 'vendor.htm?act=tenderVendorCommunicationSubmit', true);

                 xhr.onreadystatechange = function () {
                if (xhr.readyState === 4) {
                    if (xhr.status === 200) {
                        document.getElementById("vendorQueryReplyFinalDivs").innerHTML = xhr.responseText;
                        setTimeout(() => {
                            $('#vendorQueryUploadReplyNext').modal('hide');          // close current modal (if any)
                            $('#vendorQueryUploadReply').modal('hide');          // close current modal (if any)
                            $('#vendorQueryUploadReplyNext').modal('show');      // open new modal
                            
                            $('#vendorQueryReplyFinalDivs').removeClass('d-none');                     
                         }, 100);
                       
                    } else {
                        Swal.fire({
                            title: 'An error occurred while submitting data.',
                            icon: 'error',
                            timer: 2000,
                            showConfirmButton: false
                        });
                    }
                }
            };
        
        
        
        

        xhr.onerror = function () {
            console.error("Request failed.");
        };

        xhr.send(formData);
    });
    
    
    
    
    
</script>
    
    
    <script>
/* ===== BOOTSTRAP MULTI-MODAL STATE FIX ===== */

(function () {

    // When ANY modal is shown
    $(document).on('show.bs.modal', '.modal', function () {
        const openModals = $('.modal.show').length;
        const zIndex = 1040 + (10 * openModals);

        $(this).css('z-index', zIndex);

        setTimeout(function () {
            $('.modal-backdrop').not('.stacked')
                .css('z-index', zIndex - 1)
                .addClass('stacked');
        });
    });

    // When ANY modal is closed
    $(document).on('hidden.bs.modal', '.modal', function () {
        if ($('.modal.show').length > 0) {
            $('body').addClass('modal-open');
        } else {
            $('body').removeClass('modal-open');
        }
    });

})();
</script>

    
        </main> 
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
                           <script>
//                                    jQuery.noConflict();
//                                    jQuery(document).ready(function () {
//
//                                        jQuery("#employeeName").tokenInput(${list}, {
//                                            preventDuplicates: true,
//                                            noResultsText: "No Result",
//                                            tokenLimit: "1",
//                                            searchingText: "Searching ... .. ."
//                                        });
//                                    });

                                </script>
                                    <script>
                                        var slideIndex = 1;
                                        showSlides(slideIndex);

                                        function plusSlides(n) {
                                            showSlides(slideIndex += n);
                                        }
                                        function currentSlide(n) {
                                            showSlides(slideIndex = n);
                                        }

                                        function showSlides(n) {
                                            var i;
                                            var j;
                                            var imgsize = 1;

                                            var slides = document.getElementsByClassName("mySlides");


                                            if (n > slides.length) {
                                                slideIndex = 1;
                                            }
                                            if (n < 1) {
                                                slideIndex = slides.length;
                                            }
                                            if (n === 1 && slides.length === 0) {
                                                slides.length = 1;

                                            }

                                            for (i = 0; i < slides.length; i++) {
                                                slides[i].style.display = "none";
                                            }

                                            slides[slideIndex - 1].style.display = "block";


                                        }


                                    </script>

                        <script>
                            showSlides();
                            var slideIndex = 0;

                            function showSlides() {
                                var slides = document.getElementsByClassName("mySlides");
                                var n;

                                for (n = 0; n < slides.length; n++) {
                                    slides[n].style.display = "none";
                                }
                                slideIndex++;
                                if (slideIndex > slides.length) {
                                    slideIndex = 1;
                                }

                                slides[slideIndex - 1].style.display = "block";

                                setTimeout(showSlides, 5000); 
                            }
                        </script>



                            <script>
                                var rrslideIndex = 1;
                                rrshowSlides(rrslideIndex);

                                function rrplusSlides(n) {
                                    rrshowSlides(rrslideIndex += n);
                                }
                                function rrcurrentSlide(n) {
                                    rrshowSlides(rrslideIndex = n);
                                }

                                function rrshowSlides(n) {
                                    var i;
                                    var j;
                                    var imgsize = 1;

                                    var rrslides = document.getElementsByClassName("rrmySlides");


                                    if (n > rrslides.length) {
                                        rrslideIndex = 1;
                                    }
                                    if (n < 1) {
                                        rrslideIndex = rrslides.length;
                                    }
                                    if (n === 1 && rrslides.length === 0) {
                                        rrslides.length = 1;

                                    }

                                    for (i = 0; i < rrslides.length; i++) {
                                        rrslides[i].style.display = "none";
                                    }
                                    rrslides[rrslideIndex - 1].style.display = "block";
                                }

                            </script>
                            <script>
                        rrshowSlides();
                        var rrslideIndex = 0;

                        function rrshowSlides() {
                            var rrslides = document.getElementsByClassName("rrmySlides");
                            var n;

                            for (n = 0; n < rrslides.length; n++) {
                                rrslides[n].style.display = "none";
                            }
                            rrslideIndex++;
                            if (rrslideIndex > rrslides.length) {
                                rrslideIndex = 1;
                            }

                            rrslides[rrslideIndex - 1].style.display = "block";

                            setTimeout(rrshowSlides, 5000); 
                        }
                        </script>
                        
<form:form id="myForm" enctype="multipart/form-data" commandName="tenderMaster" name="form" class="form-horizontal"
               role="form">
        <div class="modal fade" id="Regret" data-backdrop="static" data-keyboard="false" tabindex="-1"
             aria-labelledby="RegretLabel" aria-hidden="true">
            <div class="modal-dialog modal-md">
                <div class="modal-content">

                    <div class="modal-header align-items-center">
                        <h5 class="modal-title" id="closeprLabel">Regrate RFQ :</h5>
                        <div class="cta-btn d-flex align-items-center">
                            <button type="button" class="btn theme-btn light-btn" data-dismiss="modal">Close</button>
                            <button type="button" class="btn theme-btn ml-3" id="regretBtn" title="">Regrate</button>

                        </div>
                    </div>

                    <div class="modal-body">
                        <label>Remarks</label>
                        <textarea class="textarea-field" id="remark" name="remark" required></textarea>

                    </div>

                    <script>
                                document.getElementById('regretBtn').addEventListener('click', async function () {
                                var form = document.getElementById('myForm');
                                var refNo = document.getElementById('refNo').value.trim();
                                        var remark = document.getElementById("remark").value.trim();
                                        if (remark === "") {
                                await Swal.fire({
                                icon: 'warning',
                                        title: 'Please fill in all * marked fields',
                                        text: 'Remark is required.',
                                        confirmButtonText: 'OK',
                                        customClass: {
                                        confirmButton: 'btn theme-btn mr-3'
                                        },
                                        buttonsStyling: false
                                });
                                        document.getElementById("remark").focus();
                                        return;
                                }

                                const result = await Swal.fire({
                                title: 'Are you sure to Regrate ?',
                                        icon: 'question',
                                        showCancelButton: true,
                                        confirmButtonText: 'Yes, Regrate',
                                        cancelButtonText: 'No',
                                        customClass: {
                                        confirmButton: 'btn theme-btn mr-3',
                                                cancelButton: 'btn theme-btn light-btn'
                                        },
                                        buttonsStyling: false
                                });
                                        if (!result.isConfirmed) {
                                return;
                                }

                                var formData = new FormData(form);
                                        var xhr = new XMLHttpRequest();
                                        xhr.open('POST', 'vendor.htm?act=regretTenderSubmit&tender_no=' + refNo, true);
                                        xhr.onload = async function () {
                                        if (xhr.status === 200) {
                                        //            document.getElementById('resultDiv').innerHTML = xhr.responseText;
                                        console.log("form", formData);
                                                initResultContents();
                                                await Swal.fire({
                                                icon: 'success',
                                                        title: 'You successfully Regrate the Tender',
                                                        showConfirmButton: false,
                                                        timer: 2000,
                                                        timerProgressBar: true,
                                                        customClass: {
                                                        popup: 'shadow-lg'
                                                        }
                                                });
                                                window.location.href = 'vendor.htm?act=liveTender';
                                        } else {
                                        console.error("Error occurred: " + xhr.statusText);
                                        }
                                        };
                                        xhr.onerror = function () {
                                        console.error("Request failed.");
                                        };
                                        xhr.send(formData);
                                });
                                        function initResultContents() {
                                        }
                    </script>

                </div>

            </div>
        </div>
        <div class="modal fade" id="Bid" data-backdrop="static" data-keyboard="false" tabindex="-1"
             aria-labelledby="BidLabel" aria-hidden="true">
            <div class="modal-dialog modal-md">
                <div class="modal-content">

                    <div class="modal-header align-items-center">
                        <h5 class="modal-title" id="closeprLabel">Regrate RFQ :</h5>
                        <div class="cta-btn d-flex align-items-center">
                            <button type="button" class="btn theme-btn light-btn" data-dismiss="modal">Close</button>
                            <button type="button" class="btn theme-btn ml-3" id="BidBtn" title="">Bid</button>
                        </div>
                    </div>

                    <div class="modal-body">
                        <label>Remarks</label>
                        <textarea class="textarea-field" id="remarks" name="remarks" required></textarea>

                    </div>

                    <script>
                                document.getElementById('BidBtn').addEventListener('click', async function () {
                                var form = document.getElementById('myForm');
                                var refNo = document.getElementById('refNo').value.trim();
                                        var remark = document.getElementById("remarks").value.trim();
                                        if (remark === "") {
                                await Swal.fire({
                                icon: 'warning',
                                        title: 'Please fill in all * marked fields',
                                        text: 'Remark is required.',
                                        confirmButtonText: 'OK',
                                        customClass: {
                                        confirmButton: 'btn theme-btn mr-3'
                                        },
                                        buttonsStyling: false
                                });
                                        document.getElementById("remarks").focus();
                                        return;
                                }

                                const result = await Swal.fire({
                                title: 'Are you sure to Bid ?',
                                        icon: 'question',
                                        showCancelButton: true,
                                        confirmButtonText: 'Yes, Bid',
                                        cancelButtonText: 'No',
                                        customClass: {
                                        confirmButton: 'btn theme-btn mr-3',
                                                cancelButton: 'btn theme-btn light-btn'
                                        },
                                        buttonsStyling: false
                                });
                                        if (!result.isConfirmed) {
                                return;
                                }

                                var formData = new FormData(form);
                                        var xhr = new XMLHttpRequest();
                                        xhr.open('POST', 'vendor.htm?act=bidTenderSubmit&tender_no='+ refNo , true);
                                        xhr.onload = async function () {
                                        if (xhr.status === 200) {
                                        console.log("form", formData);
                                                initResultContents();
                                                await Swal.fire({
                                                icon: 'success',
                                                        title: 'You successfully Participated in Bid',
                                                        showConfirmButton: false,
                                                        timer: 2000,
                                                        timerProgressBar: true,
                                                        customClass: {
                                                        popup: 'shadow-lg'
                                                        }
                                                });
                                                window.location.href = 'vendor.htm?act=liveTender';
                                        } else {
                                        console.error("Error occurred: " + xhr.statusText);
                                        }
                                        };
                                        xhr.onerror = function () {
                                        console.error("Request failed.");
                                        };
                                        xhr.send(formData);
                                });
                                        function initResultContents() {
                                        }
                    </script>

              



                </div>

            </div>
        </div>
    </div>
</form:form>

                        
</html>


