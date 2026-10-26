/<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Approved Technical Bid</title>
    </head>
    <body>
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="tenderMaster.htm?act=approvedTechnicalBidListSubmit" method="post" commandName="employeeMaster"
                           name='form1'  class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">Approved Technical Bid History</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>
                            <button type="submit" class="btn theme-btn">Search</button>
                        </div>
                    </div>
                    <hr>
                    <br>
                    <div class="row rounded-4 mt-6">
                        <!-- Tender No -->
                        <div class="col-lg-4 col-md-6">
                            <div class="form-group">
                                <label class="label">Tender No:</label>
                                <input type="text" name="tenderNo" value="" class="input-field" maxlength="30" />
                            </div>
                        </div>
                    </div>
                    <br>
                    <c:if test="${!empty list1}">
                    <%@include file="/WEB-INF/jsp/Common/TablePageNew.jsp"%>
                    </c:if>
                    <table id="commonTable" class="table  table-striped bg-white" style="width: 100%" align="center">
                       <c:choose>
                            <c:when test="${empty list1}"></c:when>
                            <c:otherwise>
                                <thead>
                                    <tr>
                                        <th>Tender No.</th>
                                        <th>Project Name</th>
                                        <th>Tender Date</th>
                                        <th>Tender Due Date</th>
                                        <th>Created By</th>
                                        <th>Tender Type</th>
                                        <th>Bid Sent To No. Of Vendor</th>
                                        <!--<th>Bid Received/Regret From No. Of Vendor</th>-->
                                        <th>Bid Status</th>
                                        <!--   <th>Send To Committee Member</th>    -->
                                    </tr>
                                </thead>
                                <c:set var="count" value="0" scope="page" />
                                <tbody>
                                    <tr>
                                        <td>${refNo}</td>

                                        <td>${title}</td>
                                        <td>${announceDate}</td>
                                        <td>${submitLastdate}</td>
                                        <td>${contactPerson}</td>
                                        <td>${tenderPhase} Part</td>
                                        <td>
                                                <a href="" onclick="loadBitSentVendor('${refNo}')" data-toggle="modal" data-target="#Bitsntvendor">${totalVendor}</a>
 
<!--                                            <a href="#" onclick="window.open('tenderMaster.htm?act=tenderVendorTotal&tender_no=${refNo}', '', 'left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1');
                                               ">${totalVendor}</a>-->
                                        </td>
                                        <td>
                                            <a href="tenderMaster.htm?act=techBidOpenHistorySearchView&id=${id}">
                                                Tech. bid open view<br><br>
                                            </a>
                                        </td>
                                    </tr>
                                </tbody>
                            </c:otherwise>
                            </c:choose>
                    </table>  
                </section>
            </form:form>
            <form:form id="myForm" enctype="multipart/form-data" commandName="prMaster" name="form" class="form-horizontal" role="form">
        <div class="modal fade" id="Bitsntvendor" data-backdrop="static" data-keyboard="false" tabindex="-1"
             aria-labelledby="BitsntvendorLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">

                    <div class="modal-header align-items-center">
                        <h5 class="modal-title" id="BitsntvendorLabel">Vendor Information</h5>
                        <div class="cta-btn d-flex align-items-center">
                            <button type="button" class="btn theme-btn light-btn" data-dismiss="modal" onclick="event.preventDefault();">Close</button>
                        </div>
                    </div>

                    <div class="modal-body">
                        <input type="hidden" id="tender_no" name="tender_no" />
                    </div>

                    <div id="resultDiv" class="bg-white">
                        <script>
                                    function loadBitSentVendor(tenderNo) {
                                    console.log("Vendor No received:", tenderNo);
                                            document.getElementById("tender_no").value = tenderNo;
                                            $.ajax({
                                            url: 'tenderMaster.htm?act=tenderVendorTotal',
                                                    type: 'GET',
                                                    data: {
                                                    tender_no: tenderNo
                                                    },
                                                    success: function(response) {
                                                    document.getElementById("resultDiv").innerHTML = response;
                                                            $('#Bitsntvendor').modal('show');
                                                            if ($('#commonTable1').length){
                                                    const table1 = initTable('#commonTable1', {
                                                    columnDefs: [
                                                    { targets: [], orderable: false }
                                                    ],
                                                            order: [[1, 'asc']]
                                                    });
                                                    }
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
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
