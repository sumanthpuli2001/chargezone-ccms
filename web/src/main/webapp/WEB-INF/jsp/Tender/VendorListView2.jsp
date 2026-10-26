
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tender Bid Information</title>
    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="tenderMaster.htm?act=vendorReviseBid" method="post" commandName="employeeMaster"
                           name='form1'  class="form-horizontal" role="form">

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Tender Bid Information</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                        </div>
                    </div>

                    <hr>
                    <input type="hidden" name="refNo" value="${refNo}">
                    <input type="hidden" name="id" value="${id}">           
                    <table id="commonTable" class="table table-striped bg-white" style="width: 100%" align="Center"  >

                        <thead>
                            <tr>
                                <th>Tender Ref No.</th>
                                <th style="min-width: 193px;">Vendor Id</th>
                                <th style="min-width: 193px;">Vendor Name</th>
                                <th style="min-width: 193px;">Vendor Email Id</th>
                                <th style="min-width: 233px;">Vendor Location</th>
                                <th data-dt-order="disable">View All Attachment</th>
                                <th data-dt-order="disable" style="min-width: 193px;">View</th>
                                <th data-dt-order="disable" style="min-width: 193px;">Print</th>
                            </tr>
                        </thead>
                        <c:set var="count" value="0" scope="page" />
                        <tbody>
                            <c:forEach var="list1" items="${list1}" varStatus="status">
                                <tr>
                                    <td>${list1[0]}</td>
                                    <td>${list1[1]}</td>
                                    <td>${list1[2]}</td>
                                    <td>${list1[5]}</td>
                                    <td>${list1[3]}</td>

                                    <td>
                                         <a href="#" onclick="loadAllvendorattach('${list1[0]}', '${list1[1]}')" data-toggle="modal" data-target="#vendorAttach">View</a>
<!--                                        <a href="#" onclick="window.open('tenderMaster.htm?act=vendorAllAttachView1&refNo=${list1[0]}&vendorCode=${list1[1]}', '', 'left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1');
                                           ">View</a>-->

                                    </td>
                                    <td>
                                        <c:if test="${tenderPhase == '3'}">
                                            <a href="tenderMaster.htm?act=preBidView&refNo=${list1[0]}&vendorCode=${list1[1]}">Pre Bid View</a><br>
                                        </c:if>
                                        <c:if test="${tenderPhase != '1'}">
                                            <a href="tenderMaster.htm?act=techBidView&refNo=${list1[0]}&vendorCode=${list1[1]}">Tech Bid View</a><br>    
                                        </c:if>


                                        <c:if test="${tender_type == 'Service Manually'}">
                                            <a href="tenderMaster.htm?act=priceBidServiceView&refNo=${list1[0]}&vendorCode=${list1[1]}">Price Bid View</a>
                                        </c:if>
                                        <c:if test="${tender_type != 'Service Manually'}">
                                            <a href="tenderMaster.htm?act=priceBidView&refNo=${list1[0]}&vendorCode=${list1[1]}">Price Bid View</a>
                                            <c:if test="${list1[6] == '1'}">
                                                <br><a href="tenderMaster.htm?act=priceBidReviseView&refNo=${list1[0]}&vendorCode=${list1[1]}">Revise Price Bid View</a>
                                            </c:if>
                                            <br><a  href="tenderMaster.htm?act=priceBidSummaryReport&refNo=${list1[0]}&vendorCode=${list1[1]}">Technical Commercial Report</a>    

                                        </c:if>


                                    </td>


                                    <td>
                                        <c:if test="${tenderPhase == '3'}">
                                            <a  href="tenderMaster.htm?act=preBidPrint&refNo=${list1[0]}&vendorCode=${list1[1]}">Pre Bid Print</a><br>
                                        </c:if>
                                        <c:if test="${tenderPhase != '1'}">
                                            <a  href="tenderMaster.htm?act=techBidPrint&refNo=${list1[0]}&vendorCode=${list1[1]}">Tech Bid Print</a><br>    
                                        </c:if>
                                        <c:if test="${tender_type == 'Service Manually'}">
                                            <a href="tenderMaster.htm?act=priceBidServicePrint&refNo=${list1[0]}&vendorCode=${list1[1]}">Price Bid Print</a>
                                        </c:if>
                                        <c:if test="${tender_type != 'Service Manually'}">
                                            <a  href="tenderMaster.htm?act=priceBidPrint&refNo=${list1[0]}&vendorCode=${list1[1]}">Price Bid Print</a>
                                            <c:if test="${list1[6] == '1'}">
                                                <br><a  href="tenderMaster.htm?act=priceBidRevisePrint&refNo=${list1[0]}&vendorCode=${list1[1]}">Revise Price Bid Print</a>
                                            </c:if>
                                            <br><a href="tenderMaster.htm?act=priceBidSummaryReport&refNo=${list1[0]}&vendorCode=${list1[1]}">Technical Commercial Report</a>    

                                        </c:if>


                                    </td>

                                </tr>
                            </c:forEach>
                        </tbody>


                    </table>
                    <div class="row">

                        <div class="col-md-12 col-sm-12">

                            <c:if test="${tenderPhase == '3'}">
                                <a href="tenderMaster.htm?act=preBidComparisonView&refNo=${refNo}">Pre Qualification Comparison</a><br>
                            </c:if>
                            <c:if test="${tenderPhase != '1'}">
                                <label class="label" ><a href="tenderMaster.htm?act=techBidComparisonView&refNo=${refNo}">Technical Comparison</a></label><br><br>
                            </c:if> 
                            <div class="form-group" >
                                    <label class="label" ><a href="tenderMaster.htm?act=priceBidComparisonSummaryView&refNo=${refNo}">Price Bid Comparison Summary VIew </a></label>
                            </div>
                            <div class="form-group" >
                                    <label class="label" ><a href="tenderMaster.htm?act=priceBidComparisonView&refNo=${refNo}">Price Bid Comparison VIew </a></label>
                            </div>
                            <div class="form-group" >
                                    <label class="label" ><a href="tenderMaster.htm?act=priceBidComparisonWithReviseView&refNo=${refNo}">Price Bid Comparison With Revise VIew </a></label>
                            </div>  
                            <div class="form-group" >
                                    <label class="label" ><a href="tenderMaster.htm?act=priceBidComparisonData&refNo=${refNo}">Vendor Confirmation</a></label>
                            </div>      
                        </div>
                    </div>      

                    <br>
                    <h5 class="fw-600">Approval Details</h5>

                    
                <table id="commonDocTable" class="table table-striped bg-white dt-scroll" style="width: 100%" align="Center"  >
                            <thead>
                                <tr>
                                    <th>Comment</th>
                                    <th>Date Time</th>
                                    <th>Attachment</th>
                                    <th>View</th>
                                </tr>
                            </thead>
                            <c:set var="count" value="0" scope="page" />
                            <tbody>
                                <tr>
                                    <td>${tenderPriceApproval.approvalRemark}</td>
                                    <td>${tenderPriceApproval.dateTime}</td>
                                    <td><a class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=vendorListViewDownload&id=${tenderPriceApproval.id}&refNo=${refNo}">${tenderPriceApproval.attachment}</a></td>
                                    <td><a href="tenderMaster.htm?act=viewApproveUserList&id=${tenderPriceApproval.id}">View</a></td>
                                </tr>
                            </tbody>


                        </table>
                    <h5 class="fw-600">Approval Comments</h5>
                   
                    <table id="commonTable1" class="table table-striped bg-white" style="width: 100%" align="Center"  >
                        <thead>
                            <tr>
                                <th style="min-width: 180px;">User Id</th>
                                <th style="min-width: 230px;">Comment</th>
                                <th style="min-width: 180px;">Date Time</th>

                            </tr>
                        </thead>
                        <c:set var="count" value="0" scope="page" />
                        <tbody>
                            <c:forEach var="list2" items="${list21}" varStatus="status">
                                <tr>

                                    <td>${list2.userId}</td>
                                    <td>${list2.approvalComment}</td>
                                    <td>${list2.dateTime}</td>

                                </tr>
                            </c:forEach>
                            <c:forEach var="list2" items="${list2}" varStatus="status">
                                <tr>

                                    <td>${list2.userId}</td>
                                    <td>${list2.approvalComment}</td>
                                    <td>${list2.dateTime}</td>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                        <div class="col-12 p-0">
                            <div class="form-group comment-box">
                                <label class="control-label">Comments </label>
                                <textarea type="text" maxlength="250" class="textarea-field comments" id="comments" name="comments"  readonly="true">${tenderMaster.comments}</textarea>
                            </div>
                        </div> 

                    



                </form:form>
                    <form:form id="myForm" enctype="multipart/form-data" commandName="prMaster" name="form" class="form-horizontal" role="form"> 
    <div class="modal fade" id="vendorAttach" data-backdrop="static" data-keyboard="false" tabindex="-1"
                         aria-labelledby="vendorAttachLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">

                                <div class="modal-header align-items-center">
                                    <h5 class="modal-title" id="vendorAttachLabel">Vendor All Attachment</h5>
                                    <div class="cta-btn d-flex align-items-center">
                                        <button type="button" class="btn theme-btn light-btn" data-dismiss="modal" onclick="event.preventDefault();">Close</button>

                                    </div>
                                </div>

                                <div class="modal-body">
                                    <input type="hidden" id="tender_no" name="tender_no" />
                                    <input type="hidden" id="vendorCode" name="vendorCode" />
                                    <input type="hidden" id="refNo" name="refNo" />
                                </div>

                                <div id="resultDiv" class="bg-white">
                                    <script>

                                                function loadAllvendorattach(refNo, vendorCode) {
                                                // Set input values
                                                document.getElementById("tender_no").value = refNo;
                                                        document.getElementById("vendorCode").value = vendorCode;
                                                        document.getElementById("refNo").value = refNo;
                                                        // AJAX request
                                                        $.ajax({
                                                        url: 'tenderMaster.htm?act=vendorAllAttachView1',
                                                                type: 'GET',
                                                                data: {
                                                                refNo: refNo,
                                                                        vendorCode: vendorCode
                                                                },
                                                                success: function(response) {
                                                                document.getElementById("resultDiv").innerHTML = response;
                                                                        $('#vendorAttach').modal('show');
                                                                        setTimeout(function () {
                                                                        if ($('#VendorCommercialAttachment').length) {
                                                                        const table1 = initTable('#VendorCommercialAttachment');
                                                                        }
                                                                        if ($('#technicalSpecificationTable').length) {
                                                                        const table2 = initTable('#technicalSpecificationTable');
                                                                        }
                                                                        if ($('#priceSpecificationTable').length) {
                                                                        const table3 = initTable('#priceSpecificationTable');
                                                                        }
                                                                        if ($('#reviseSpecificationTable').length) {
                                                                        const table4 = initTable('#reviseSpecificationTable');
                                                                        }
                                                                        if ($('#revisePriceSpecificationTable').length) {
                                                                        const table5 = initTable('#revisePriceSpecificationTable');
                                                                        }
                                                                        }, 100);
//                                                                        
                                                                },
                                                                error: function(xhr, status, error) {
                                                                console.error("AJAX Error:", error);
                                                                }
                                                        });
                                                        return false;
                                                }



                                    </script>
                                </div>
                            </div>
                        </div>
                    </div>
                                  
                                  
                </form:form> 
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
