
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tendor Approve Technical Price Bid View</title>
    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                  <form:form action="tenderMaster.htm?act=approveTechnicalBid" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                                           class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Tendor Approve Technical Price Bid View</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                            <button type="submit" class="btn theme-btn mr-3"  onclick="approve();" >Approve</button>
                            <button type="submit" class="btn theme-btn mr-3"  formaction="tenderMaster.htm?act=technicalReworkBid"   > Rework</button>
                            <button type="submit" class="btn theme-btn "  formaction="tenderMaster.htm?act=technicalReworkBidToBuyer"   > Rework To Technical Reviewer</button>                        </div>
                    </div>

                    <hr>
                    <input type="hidden" name="policyCount" id="policyCount" value="1"/>           
                    <input type="hidden" name="id" value="${id}">


                    <table id="commonTable" class="table table-striped bg-white" style="width: 100%" align="Center"  >
                        <thead>
                            <tr>
                                <th>Tender Ref No.</th>
                                <th>Vendor Id</th>
                                <th>Vendor Name</th>
                                <th>Vendor Email Id</th>
                                <th>Vendor Location</th>
                                <th data-dt-order="disable">View All Attachment</th>
                                <th data-dt-order="disable">View</th>
                                <th data-dt-order="disable">Print</th>
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

<!--                                        <a href="#" onclick="window.open('tenderMaster.htm?act=vendorAllAttachView&refNo=${list1[0]}&vendorCode=${list1[1]}', '', 'left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1');
   ">View</a>-->
                                    </td>
                                    <td><a href="tenderMaster.htm?act=techBidView&refNo=${list1[0]}&vendorCode=${list1[1]}">View</a></td>
                                    <td><a href="tenderMaster.htm?act=techBidPrint&refNo=${list1[0]}&vendorCode=${list1[1]}">Print</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>


                    <h5 class="fw-600"><a href="tenderMaster.htm?act=techBidComparisonView&refNo=${refNo}">Technical Comparison</a></h5><br>


                    <h5 class="fw-600">User Approval List</h5>

                    <table id="commonDocTable" class="table table-striped bg-white dt-scroll" style="width: 100%" align="Center"  >
                        <thead>
                            <tr>
                                <th>Tender Ref No.</th>
                                <th>Comment</th>
                                <th>View</th>
                            </tr>
                        </thead>
                        <c:set var="count" value="0" scope="page" />
                        <tbody>
                            <tr>
                                <td>${tenderPriceApproval.tenderNo}</td>
                                <td>${tenderPriceApproval.approvalRemark}</td>
                                <td><a href="tenderMaster.htm?act=viewApproveTechnicalUserList&id=${tenderPriceApproval.id}">View</a></td>
                            </tr>
                        </tbody>
                    </table>
                    <br>

                    <h5 class="fw-600">Approval Comments</h5>
                    <table id="commonTable1" class="table table-striped bg-white" style="width: 100%" align="Center"  >
                        <thead>
                            <tr>
                                <th>User Id</th>
                                <th>Comment</th>
                                <th>Date Time</th>

                            </tr>
                        </thead>
                        <c:set var="count" value="0" scope="page" />
                        <tbody>
                            <c:forEach var="list2" items="${list3}" varStatus="status">
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
                            <label class="control-label">Comment :<span class="text-danger">*</span></label>
                            <textarea type="text" maxlength="250" class="textarea-field comment" id="comment" name="comment"  required="true"></textarea>
                        </div>
                    </div>        





                    <div class="form-group">
                        <div style="display: flex;  justify-content: center;">

                            <button type="submit" class="btn theme-btn mr-3"  onclick="approve();" >Approve</button>
                            <button type="submit" class="btn theme-btn mr-3"  formaction="tenderMaster.htm?act=technicalReworkBid"   > Rework</button>
                            <button type="submit" class="btn theme-btn "  formaction="tenderMaster.htm?act=technicalReworkBidToBuyer"   > Rework To Technical Reviewer</button>
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
                                                url: 'tenderMaster.htm?act=vendorAllAttachView',
                                                type: 'GET',
                                                data: {
                                                    refNo: refNo,
                                                    vendorCode: vendorCode
                                                },
                                                success: function (response) {
                                                    document.getElementById("resultDiv").innerHTML = response;
                                                    $('#vendorAttach').modal('show');
                                                    setTimeout(function () {
                                                        if ($('#VendorCommercialAttachment').length) {
                                                            const table1 = initTable('#VendorCommercialAttachment');
                                                        }
                                                    }, 100);
//                                                                        
                                                },
                                                error: function (xhr, status, error) {
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
