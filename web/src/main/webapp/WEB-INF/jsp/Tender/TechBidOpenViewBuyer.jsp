
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TENDER TECHNICAL BID INFORMATION</title>
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

                            <h5 class="fw-600 mb-0">TENDER TECHNICAL BID INFORMATION</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                          <!--<button type="submit" class="btn theme-btn"   title="" onclick='return deleteCheck11();' >Open</button>-->

                        </div>
                    </div>

                    <hr>
                    <c:if test="${!empty successMessage}">
                        <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                    </c:if>
                    <c:if test="${!empty failureMessage}">
                        <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                    </c:if>

                    <input type="hidden" name="refNo" value="${refNo}">
                    <input type="hidden" name="id" value="${id}"> 


                    <table id="commonTable" class="table table-striped bg-white dt-scroll" style="min-width:100%;" align="center">                                                 

                        <thead>
                            <tr>
                                <th data-dt-order="disable">Select</th>
                                <th>Tender Ref No.</th>
                                <th>Vendor Id</th>
                                <th>Vendor Name</th>
                                <th>Vendor Email Id</th>
                                <th>Vendor Location</th>
                                <th>Percentage</th>
                                <th>Approve</th>
                                <th>View All Attachment</th>
                                <th>View</th>
                                <th data-dt-order="disable">Print</th>
                                <th data-dt-order="disable">History</th>
                            </tr>
                        </thead>
                        <c:set var="count" value="0" scope="page" />
                        <tbody>
                            <c:forEach var="list1" items="${list1}" varStatus="status">
                                <tr>
                                    <c:set var="i" value="0"/>
                                    <c:forEach var="list4" items="${list4}">
                                        <c:if test="${list4.vendorCode == list1[1]}">
                                            <c:if test="${list4.techOpenFlag == 1}">
                                                <c:set var="i" value="1"/>
                                            </c:if>
                                        </c:if>
                                    </c:forEach> 
                                    <td>
                                        <c:if test="${i == 0}">
                                            <input type="checkbox" value="${list1[1]}"  name="checkedId">
                                        </c:if>
                                        <c:if test="${i == 1}">
                                            <input type="checkbox" value="${list1[1]}" checked="checked"  name="checkedId">
                                        </c:if>

                                    </td>
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
                        <c:otherwise>
                            <br>
                            <h6 class="fw-600"> <a href="tenderMaster.htm?act=techBidComparisonView&refNo=${refNo}">Technical Comparison</a></h6>
                            <br>
                            <h6 class="fw-600">  <a href="tenderMaster.htm?act=changeItemDetails&refNo=${refNo}">Change Item Details</a></h6>

                           

                            
                 <div class="col-12 p-0">
                    <div class="form-group comment-box">
                        <label class="control-label">Remark :<span class="text-danger">*</span></label>
                        <textarea type="text" maxlength="250" class="textarea-field remark" id="remark" name="remark"  required="true"></textarea>
                      <small id="charCount_remark" style="font-size: 12px; color: green;">
                                        250 characters remaining
                                    </small>

                                    <script type="text/javascript">
                                        document.addEventListener("DOMContentLoaded", function () {
                                            var input = document.getElementById("remark");
                                            var counter = document.getElementById("charCount_remark");
                                            var maxChars = 250;

                                            function updateCounter() {
                                                var count = input.value.length;
                                                var remaining = maxChars - count;
                                                counter.textContent = remaining + " characters remaining";

                                                if (remaining <= 20) {
                                                    counter.style.color = "red";
                                                } else {
                                                    counter.style.color = "green";
                                                }
                                            }

                                            updateCounter();
                                            input.addEventListener("input", updateCounter);
                                        });
                                    </script>
                    </div>
                </div> 
         
                            
                      <div class="rounded-4 mt-4">
                    <div class="row mb-3">
                        <div class="col-lg-4 col-md-6">
                            <div class="form-group">
                                <label for="department-name" class="label">Date Time <span
                                        class="text-danger">*</span></label>
                               
                        <input class="input-field form_datetime" placeholder="dd-mm-yyyy --:--" name="submitLastdate" id="submitLastdate" path="submitLastdate" />
                            </div>
                        </div>
                    </div>
                </div>          
                        <script>
                const picker = flatpickr("#submitLastdate", {
                    enableTime: true,
                    enableSeconds: true,
                    dateFormat: "d-m-Y H:i:S",
                    allowInput: true,
                     minDate: "today" 
                });

                document.getElementById("submitLastdate").addEventListener("focus", function () {
                    if (!this.value) {
                        picker.setDate(new Date(), true);
                    }
                });
                </script>



        
                            
                            




                            <div class="form-group">
                                        <div style="display: flex;  justify-content: center;">
                                            <button type="submit" class="btn theme-btn mr-3"  formaction="tenderMaster.htm?act=techBidAuthorize" onclick='return deleteChecked11();' >Authorize To Price Bid</button>
                                    <button type="submit" class="btn theme-btn"  formaction="tenderMaster.htm?act=reworkTechBidAuthorize">Rework Back To Techncial Bid</button>

                                </div>
                            </div>              
                        </c:otherwise>
                    </c:choose>
                    <br>
                    <h5 class="fw-600">Select Approval Work Flow -  <a href="tenderMaster.htm?act=approvalTechnicalWorkFlowSelect&refNo=${refNo}&&id=${id}">Select</a></h5>
                    <hr>
                    <c:if test="${tenderPriceApproval.id != ''}">

                        <h5 class="fw-600">User Approval List</h5>
                        
                        <table id="commonDocTable" class="table table-striped bg-white dt-scroll" style="min-width: 100%" align="Center"  >
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
                        <hr>
                        <table id="commonDocTable1" class="table table-striped bg-white dt-scroll" style="min-width: 100%" align="Center"  >

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
                        <table id="commonDocTable3" class="table table-striped bg-white dt-scroll" style="min-width: 100%" align="Center"  >
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
                 
                        <table id="commonDocTable4" class="table table-striped bg-white dt-scroll" style="min-width: 100%" align="Center"  >
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
                        
                        <h5 class="fw-600">Tender To Be Open For Technical Bid</h5>
                    <hr>

                    <table id="commonTable5" class="table table-striped bg-white" style="min-width: 100%" align="Center"  >
                        <c:choose>
                            <c:when test="${empty list}">
                               
                            </c:when>
                            <c:otherwise>
                                <thead>
                                    <tr>
                                        <th>Select</th>
                                        <th>Vendor Id</th>
                                        <th>Vendor Name</th>
                                        <th>Vendor Location</th>
                                        <th>Vendor Mobile Number</th>

                                    </tr>
                                </thead>
                                <c:set var="count" value="0" scope="page" />
                                <tbody>
                                    <c:forEach var="list" items="${list}" varStatus="status">
                                        <tr>
                                            <td><input type="checkbox" value="${list[1]}" name="checkId" checked="true" readonly="true"></td>
                                            <td>${list[1]}</td>
                                            <td>${list[2]}</td>
                                            <td>${list[3]}</td>
                                            <td>${list[4]}</td>

                                        </tr>
                                    </c:forEach>
                                </tbody>

                            </c:otherwise>
                        </c:choose>
                    </table>
                    <!--                                            </div>

                    <div class="form-group">
                       <div style="display: flex;  justify-content: center;">
                           <button type="submit" class="btn theme-btn"   title="" onclick='return deleteCheck11();' >Open</button>
                        </div>
                    </div>-->
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
                                                                success: function(response) {
                                                                document.getElementById("resultDiv").innerHTML = response;
                                                                        $('#vendorAttach').modal('show');
                                                                        setTimeout(function () {
                                                                        if ($('#VendorCommercialAttachment').length) {
                                                                        const table1 = initTable('#VendorCommercialAttachment');
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
<script>
function deleteChecked11() {
    var checkboxes = document.getElementsByName("checkedId");
    var submitLastdate = document.getElementById("submitLastdate");
    var checked = false;

    // Check if at least one checkbox is selected
    for (var i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked) {
            checked = true;
            break;
        }
    }

    // Check if date/time is selected
    if (!submitLastdate || submitLastdate.value === '') {
        Swal.fire({
            icon: 'warning',
            title: 'No selection',
            text: 'Please select date and time.'
        });
        return false;
    }

    // Check if any vendor is selected
    if (!checked) {
        Swal.fire({
            icon: 'warning',
            title: 'No selection',
            text: 'Please select one or more Vendor records.'
        });
        return false;
    }

    return true;
}
</script>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
