
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TENDER BID INFORMATION</title>
    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="tenderMaster.htm?act=vendorReviseBid" method="post" commandName="employeeMaster"
                           name='form1' onsubmit='return deleteChecked11();' id="form1" class="form-horizontal" role="form">

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">TENDER BID INFORMATION</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                        </div>
                    </div>

                    <hr>
                    <c:if test="${!empty failureMessage}">
                        <div class="fadeOutEffect alert alert-danger mt-2 mb-2" style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                            <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                            <div>
                                <strong>Note:</strong> <strong class="text-danger fs-13">${failureMessage} </strong><br>                            
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${!empty successMessage}">
                        <div class="fadeOutEffect alert alert-info mt-2 mb-2" style="display: flex; align-items: center; gap: 12px; background: #F0FFF4; color: #0F5132; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #198754; box-shadow: 2px 2px 10px rgba(25, 135, 84, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">                        
                            <div style="background: #198754; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px; ">✓</div>  
                            <div>                             
                                <strong>Note:</strong> <strong class="text-success fs-13">${successMessage} </strong><br>                            
                            </div>
                        </div>
                    </c:if>

                    <input type="hidden" name="refNo" value="${refNo}">
                    <input type="hidden" name="tender_no" value="${refNo}">
                    <input type="hidden" name="id" value="${id}">    


                    <table id="commonTable" class="table table-striped bg-white" style="width: 100%;" align="center">   
                        <thead>
                            <tr>
                                <th data-dt-order="disable">Check</th>
                                <th style="min-width: 230px;">Tender Ref No.</th>
                                <th style="min-width: 230px;">Vendor Id</th>
                                <th style="min-width: 230px;">Vendor Name</th>
                                <th style="min-width: 230px;">Vendor Email Id</th>
                                <th style="min-width: 230px;">Vendor Location</th>
                                <th data-dt-order="disable">View All Attachment</th>
                                <th data-dt-order="disable" style="min-width: 230px;">View</th>

                                <th data-dt-order="disable" style="min-width: 180px;">Print</th>

                            </tr>
                        </thead>
                        <c:set var="count" value="0" scope="page" />
                        <tbody>
                            <c:forEach var="list1" items="${list1}" varStatus="status">
                                <tr>
                                    <td><input type="checkbox" value="${list1[1]}" name="checkedId" ></td>
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
                                                <br><a href="tenderMaster.htm?act=revisePriceBidReviseView&refNo=${list1[0]}&vendorCode=${list1[1]}">Revise Price Bid View</a>
                                            </c:if>
                                            <br><br>

                                            <a  href="tenderMaster.htm?act=priceBidSummaryReport&refNo=${list1[0]}&vendorCode=${list1[1]}">Technical Commercial Report</a>    
                                        </c:if>


                                    </td>


                                    <td>
                                        <c:if test="${tenderPhase == '3'}">
                                            <a " href="tenderMaster.htm?act=preBidPrint&refNo=${list1[0]}&vendorCode=${list1[1]}">Pre Bid Print</a><br>
                                        </c:if>
                                        <c:if test="${tenderPhase != '1'}">
                                            <a  href="tenderMaster.htm?act=techBidPrint&refNo=${list1[0]}&vendorCode=${list1[1]}">Tech Bid Print</a><br>    
                                        </c:if>
                                        <c:if test="${tender_type == 'Service Manually'}">
                                            <a  href="tenderMaster.htm?act=priceBidServicePrint&refNo=${list1[0]}&vendorCode=${list1[1]}">Price Bid Print</a>
                                        </c:if>
                                        <c:if test="${tender_type != 'Service Manually'}">

                                            <a  href="tenderMaster.htm?act=priceBidPrint&refNo=${list1[0]}&vendorCode=${list1[1]}">Price Bid Print</a>
                                            <c:if test="${list1[6] == '1'}">
                                                <br><a  href="tenderMaster.htm?act=revisePriceBidRevisePrint&refNo=${list1[0]}&vendorCode=${list1[1]}">Revise Price Bid Print</a>
                                            </c:if>
                                        </c:if>


                                    </td>

                                </tr>
                            </c:forEach>
                        </tbody>


                    </table>       
                    <div class="col-md-12 mb-4 pt-4 pb-2">
                        <div class="form-group">
                            <c:if test="${tenderPhase == '3'}">
                                <label class="label"><a href="tenderMaster.htm?act=preBidComparisonView&refNo=${list1[0]}&vendorCode=${list1[1]}">Pre Qualification Comparison</a></label>
                            </c:if>
                        </div>
                        <div class="form-group">
                            <c:if test="${tenderPhase != '1'}">
                                <label class="label"><a href="tenderMaster.htm?act=techBidComparisonView&refNo=${refNo}">Technical Comparison</a></label>
                            </c:if> 
                        </div>
                        <div class="form-group">
                            <label class="label"><a href="tenderMaster.htm?act=priceBidComparisonSummaryView&refNo=${refNo}">Price Bid Comparison Summary View </a></label>
                        </div>
                        <div class="form-group">
                            <label class=label"><a href="tenderMaster.htm?act=priceBidComparisonView&refNo=${refNo}">Price Bid Comparison View </a></label>
                        </div>
                        <label class="label"><a href="tenderMaster.htm?act=priceBidComparisonWithReviseView&refNo=${refNo}">Price Bid Comparison With Revise View </a></label>
                    </div>  


                    <h5 class="fw-600">Vendor Revise Bid List</h5>
                    <table id="commonTable1" class="table table-striped bg-white" style="width: 100%" align="Center"  >
                        <thead>
                            <tr>
                                <th>Tender Ref No.</th>
                                <th>Vendor Id</th>
                                <th>Revise Date Time</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <c:set var="count" value="0" scope="page" />
                        <tbody>
                            <c:forEach var="reviseList" items="${reviseList}" varStatus="status">
                                <tr>
                                    <td>${reviseList.refNo}</td>
                                    <td>${reviseList.vendorCode}</td>
                                    <td>${reviseList.reviseDateTime}</td>
                                    <td><c:if test="${reviseList.reviseStatus == 0}">
                                            Not Submited
                                        </c:if>
                                        <c:if test="${reviseList.reviseStatus == 1}">
                                            Submited
                                        </c:if>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                    <div class="col-12 p-0">
                        <div class="form-group comment-box">
                            <label class="control-label">Remark  :<span class="text-danger">*</span></label>
                            <textarea type="text" maxlength="250" class="textarea-field remark" id="remark" name="remark"  required="true"></textarea>
                            <small id="charCount_remark" style="font-size: 12px; color: green;">250 characters remaining</small>
                            <script type="text/javascript">
                                document.addEventListener("DOMContentLoaded", function () {
                                    var textarea = document.getElementById("remark");
                                    var counter = document.getElementById("charCount_remark");
                                    var maxChars = 250;

                                    function updateCounter() {
                                        var count = textarea.value.length;
                                        var remaining = maxChars - count;
                                        counter.textContent = remaining + " characters remaining";

                                        if (remaining <= 20) {
                                            counter.style.color = "red";
                                        } else {
                                            counter.style.color = "green";
                                        }
                                    }

                                    updateCounter();
                                    textarea.addEventListener("input", updateCounter);
                                });
                            </script>
                        </div>
                    </div> 
                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label">Tender Revise Due Date<span class="text-danger">*</span></label>
                                    <input type="text"id="submitLastdate"name="submitLastdate" class="input-field form_datetime"value="${submitLastdate}" placeholder="dd-mm-yyyy HH:mm:ss" />                                </div>
                            </div>
                        </div>
                    </div>
                    <script>
                        const picker = flatpickr("#submitLastdate", {
                            enableTime: true,
                            enableSeconds: true,
                            dateFormat: "d-m-Y H:i:S",
                            allowInput: true
                        });

                        document.getElementById("submitLastdate").addEventListener("focus", function () {
                            if (!this.value) {
                                picker.setDate(new Date(), true);
                            }
                        });
                    </script>

                    <div class="form-group" >
                        <div style="display: flex;  justify-content: center;">
                            <button type="submit" class="btn theme-btn"   >Revise Bid</button>
                        </div>
                    </div>

                    <h5 class="fw-600">Select Approval Work Flow -  <a href="tenderMaster.htm?act=approvalWorkFlowSelect&refNo=${refNo}&&id=${id}">Select</a> </h5>
                    <br>


                    <c:if test="${tenderPriceApproval.id != ''}">

                        <h5 class="fw-600">User Approval List</h5>

                        <table id="commonTable2" class="table table-striped bg-white" style="width: 100%" align="Center"  >
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
                    </c:if>

                    <c:if test="${tenderPriceApproval1.id != '' && tenderPriceApproval.id == ''}">
                        <h5 class="fw-600">User Approval List</h5>
                       
                        <table id="commonTable3" class="table table-striped bg-white" style="width: 100%" align="Center"  >
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
                                    <td>${tenderPriceApproval1.approvalRemark}</td>
                                    <td>${tenderPriceApproval1.dateTime}</td>
                                    <td><a class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=vendorListViewDownload&id=${tenderPriceApproval.id}&refNo=${refNo}">${tenderPriceApproval.attachment}</a></td>
                                    <td><a href="tenderMaster.htm?act=viewApproveUserList&id=${tenderPriceApproval1.id}">View</a></td>
                                </tr>
                            </tbody>
                        </table>
                    </c:if>
                    <c:if test="${tenderPriceApproval.id != '' || tenderPriceApproval1.id != ''}">
                        <h5 class="fw-600">Approval Comments</h5>
                        <table id="commonTable4" class="table table-striped bg-white" style="width: 100%" align="Center"  >
                            <thead>
                                <tr>
                                    <th>User Id</th>
                                    <th>Comment</th>
                                    <th>Attachment</th>
                                    <th>Date Time</th>
                                </tr>
                            </thead>
                            <c:set var="count" value="0" scope="page" />
                            <tbody>
                                <c:forEach var="list2" items="${list21}" varStatus="status">
                                    <tr>
                                        <td>${list2.userId}</td>
                                        <td>${list2.approvalComment}</td>
                                        <td><a class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=vendorListViewDownload&id=${tenderPriceApproval.id}&refNo=${refNo}">${tenderPriceApproval.attachment}</a></td>
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
    <script>
        function deleteChecked11() {

    var checkboxes = document.getElementsByName("checkedId");
    var submitLastdate = document.getElementById("submitLastdate");
    var checked = false;

    for (var i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked) {
            checked = true;
            break;
        }
    }

    if (!submitLastdate || submitLastdate.value.trim() === "") {
        Swal.fire({
            icon: "warning",
            title: "No selection",
            text: "Please select date and time."
        });
        return false;
    }

    if (!checked) {
        Swal.fire({
            icon: "warning",
            title: "No selection",
            text: "Please select one or more Vendor records."
        });
        return false;
    }

    return true;
}
    </script>
</html>
