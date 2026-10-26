
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TENDER TECHNICAL BID OPEN</title>
    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="tenderMaster.htm?act=techBidOpenUserView" method="post" commandName="employeeMaster"
                           enctype="multipart/form-data" name='form1'  class="form-horizontal" role="form">

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">TENDER TECHNICAL BID OPEN</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                        </div>
                    </div>
                    <hr>
                    <input type="hidden" name="refNo" value="${refNo}">
                    <input type="hidden" name="id" value="${id}"> 

                    <table id="commonTable" class="table table-striped bg-white  " style="min-width: 100%;" align="center">    
                        <thead>
                            <tr>
                                <th>Tender Ref No.</th>
                                <th style="min-width: 180px;">Vendor Id</th>
                                <th style="min-width: 180px;">Vendor Name</th>
                                <th>Vendor Email Id</th>
                                <th>Vendor Location</th>
                                <th>Percentage</th>
                                <th>Approve</th>
                                <th style="min-width: 180px;" data-dt-order="disable">View All Attachment</th>
                                <th  data-dt-order="disable">View</th>
                                <th data-dt-order="disable">Print</th>
                                <th  data-dt-order="disable">History</th>
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
                                    <td>${list1[6]}</td>
                                    <td>
                                        <c:if test="${list1[7] == '0'}">Send for Revision</c:if>
                                        <c:if test="${list1[7] == '2'}">Approved</c:if>
                                        </td>
                                        <td>
                                            <a href="#" onclick="loadAllvendorattach('${list1[0]}', '${list1[1]}')" data-toggle="modal" data-target="#vendorAttach">View</a>


<!--                                            <a href="#" onclick="window.open('tenderMaster.htm?act=vendorAllAttachView&refNo=${list1[0]}&vendorCode=${list1[1]}', '', 'left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1');
">View</a>-->

                                    </td>
                                    <td><a href="tenderMaster.htm?act=techBidView&refNo=${list1[0]}&vendorCode=${list1[1]}">View</a></td>

                                    <td><a href="tenderMaster.htm?act=techBidPrint&refNo=${list1[0]}&vendorCode=${list1[1]}">Print</a></td>
                                    <td><a href="tenderMaster.htm?act=techBidHistory&refNo=${list1[0]}&vendorCode=${list1[1]}">History</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                    <c:choose>
                        <c:when test="${empty list1}">
                        </c:when>
                        <c:otherwise><br>
                            <h5 class="fw-600"><a href="tenderMaster.htm?act=techBidComparisonView&refNo=${refNo}">Technical Comparison</a><br></h5>

                            </c:otherwise>
                        </c:choose>
                        <br>

                        <c:if test="${tenderPriceApproval.id != ''}">
                            <h5 class="fw-600">User Approval List</h5>
                            
                            <table id="commonDocTable" class="table table-striped bg-white dt-scroll" style="width: 100%" align="Center"  >
                                <thead>
                                    <tr>
                                        <th>Comment</th>
                                        <th>Date Time</th>
                                        <th>View</th>

                                    </tr>
                                </thead>
                                <c:set var="count" value="0" scope="page" />
                                <tbody>
                                    <tr>
                                        <td>${tenderPriceApproval.approvalRemark}</td>
                                        <td>${tenderPriceApproval.dateTime}</td>
                                        <td><a href="tenderMaster.htm?act=viewTechnicalApproveUserList&id=${tenderPriceApproval.id}">View</a></td>
                                    </tr>
                                </tbody>
                            </table>
                        </c:if>
                        <c:if test="${tenderPriceApproval1.id != '' && tenderPriceApproval.id == ''}">
                            <h5 class="fw-600">User Approval List</h5>
                           
                            <table id="commonDocTable1" class="table table-striped bg-white dt-scroll" style="width: 100%" align="Center"  >
                                <thead>
                                    <tr>
                                        <th>Comment</th>
                                        <th>Date Time</th>
                                        <th>View</th>
                                    </tr>
                                </thead>
                                <c:set var="count" value="0" scope="page" />
                                <tbody>
                                    <tr>
                                        <td>${tenderPriceApproval1.approvalRemark}</td>
                                        <td>${tenderPriceApproval1.dateTime}</td>
                                        <td><a href="tenderMaster.htm?act=viewApproveUserList&id=${tenderPriceApproval1.id}">View</a></td>
                                    </tr>
                                </tbody>
                            </table>
                        </c:if>
                            
                        <c:if test="${tenderPriceApproval.id != '' || tenderPriceApproval1.id != ''}">
                            <h5 class="fw-600">Approval Comments</h5>
                            
                            <table id="commonDocTable2" class="table table-striped bg-white dt-scroll" style="width: 100%" align="Center"  >
                                <thead>
                                    <tr>
                                        <th>User Id</th>
                                        <th>Comment</th>
                                        <th>Date Time</th>
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
                        </c:if>
                            <h5 class="fw-600">Tender Committee Member</h5>
                        <hr>
                        <table id="commonTable1" class="table table-striped bg-white" style="width: 100%" align="Center"  >
                            <c:choose>
                                <c:when test="${empty tenderCommittee2}">
                                    
                                </c:when>
                                <c:otherwise>
                                    <thead>
                                        <tr>
                                            <th>User Id</th>
                                            <th>Bid Open Status</th>
                                            <th>Bid Open Date Time</th>
                                        </tr>
                                    </thead>
                                    <c:set var="count" value="0" scope="page" />
                                    <tbody>
                                        <c:forEach var="tenderCommittee2" items="${tenderCommittee2}" varStatus="status">
                                            <tr>
                                                <td>${tenderCommittee2.userId}</td>
                                                <td>
                                                    <c:if test="${tenderCommittee2.bidOpenStatus == '1'}">
                                                        Bid Open
                                                    </c:if>
                                                    <c:if test="${tenderCommittee2.bidOpenStatus != '1'}">
                                                        Bid Not Open
                                                    </c:if>

                                                </td>
                                                <td>${tenderCommittee2.bidOpenDate}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>

                                </c:otherwise>
                            </c:choose>
                        </table> 
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
