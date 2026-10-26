
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TENDER PRICE BID INFORMATION</title>
    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="tenderMaster.htm?act=priceBidOpenUserView" method="post" commandName="employeeMaster"
                           name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">TENDER PRICE BID INFORMATION</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn">Back</a>
                            
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
                    <input type="hidden" name="id" value="${id}">

                    <table id="commonTable" class="table table-striped bg-white" style="min-width: 100%" align="Center"  >

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
                                    <td>${list1[7]}</td>
                                    <td>
                                        <a href="#" onclick="loadAllvendorattach('${list1[0]}', '${list1[1]}')" data-toggle="modal" data-target="#vendorAttach">View</a>
                                    </td>
                                    <td>
                                        <c:if test="${tender_type == 'Service Manually'}">
                                            <a href="tenderMaster.htm?act=priceBidServiceView&refNo=${list1[0]}&vendorCode=${list1[1]}">View</a>
                                        </c:if>
                                        <c:if test="${tender_type != 'Service Manually'}">
                                            <a href="tenderMaster.htm?act=priceBidView&refNo=${list1[0]}&vendorCode=${list1[1]}">View</a>
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:if test="${tender_type == 'Service Manually'}">
                                            <a  href="tenderMaster.htm?act=priceBidServicePrint&refNo=${list1[0]}&vendorCode=${list1[1]}">Print</a>
                                        </c:if>
                                        <c:if test="${tender_type != 'Service Manually'}">
                                            <a  href="tenderMaster.htm?act=priceBidPrint&refNo=${list1[0]}&vendorCode=${list1[1]}">Print</a>
                                        </c:if>

                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                    <c:choose>
                        <c:when test="${empty list1}"></c:when>
                        <c:otherwise>
                            <div class="row">
                                <div class="col-md-12 col-sm-12">
                                    <div class="form-group" style="margin-bottom: 15px;">
                                        <div class="col-sm-3">
                                            <label class="control-label" style="padding-top: 0px;"><a href="tenderMaster.htm?act=priceBidComparisonSummaryView&refNo=${refNo}">Price Bid Comparison Summary VIew </a></label>
                                        </div>
                                    </div>
                                    <div class="form-group" style="margin-bottom: 15px;">
                                        <div class="col-sm-3">
                                            <label class="control-label" style="padding-top: 0px;"><a href="tenderMaster.htm?act=priceBidComparisonView&refNo=${refNo}">Price Bid Comparison VIew </a></label>
                                        </div>
                                    </div>
                                    <div class="form-group" style="margin-bottom: 15px;">
                                        <div class="col-sm-3">
                                            <label class="control-label" style="padding-top: 0px;"><a href="tenderMaster.htm?act=priceBidComparisonWithReviseView&refNo=${refNo}">Price Bid Comparison With Revise VIew </a></label>
                                        </div>
                                    </div>  
                                </div>
                            </div>
                        </c:otherwise>
                    </c:choose>        
                    <c:if test="${omsMaster != null}">
                        <div class="row">
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label">OMS Ticket No. : </label>
                                    <input type="text" name="ticketId" id="ticketId" class="input-field" value="${omsMaster.ticketId}" readonly="true"/>
                                    <input type="hidden" name="omsMasterId" id="omsMasterId" class="input-field" value="${omsMaster.id}" />
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">OMS Ticket Id : </label>
                                    <input type="text" class="input-field" value="${omsMaster.omsPrId}" readonly="true"/>
                                </div>
                            </div>
                        </div>
                    </c:if>

                    <h5 class="fw-600">Tender Committee Member</h5>
                    <hr>
                    <table id="commonTable1" class="table table-striped bg-white" style="min-width: 100%" align="Center"  >
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

                    <h5 class="fw-600">Tender To Be Open For Price Bid</h5>
                    <hr>

                    <table id="commonTable2" class="table table-striped bg-white" style="min-width: 100%" align="Center"  >
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
                                            <td><input type="checkbox" value="${list[1]}" name="checkId" checked="true"></td>
                                            <td>${list[1]}</td>
                                            <td>${list[2]}</td>
                                            <td>${list[3]}</td>
                                            <td>${list[4]}</td>

                                        </tr>
                                    </c:forEach>
                                </tbody>

                            </c:otherwise>
                        </c:choose>
                    </table><br>
                   <div class="form-group">
                       <div style="display: flex;  justify-content: center;">
                           <c:set var="i" value="0" />
                           <c:forEach var="tenderCommittee2" items="${tenderCommittee2}" varStatus="status">
                                <c:if test="${tenderCommittee2.bidOpenStatus != '1'}">
                                   <c:set var="i" value="1" />
                                </c:if>
                                
                                
                            </c:forEach>
                           <c:if test="${i==1}">
                                 <button type="submit" class="btn theme-btn" style="width: 100px;" onclick='return deleteCheck11();' >Open</button>
                            </c:if>
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
              <script>
        function deleteCheck11() {
    var checkboxes = document.getElementsByName("checkId");
    var checked = false;

    for (var i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked) {
            checked = true;
            break;
        }
    }

    if (!checked) {
        Swal.fire({
        icon: 'warning',
        title: 'No selection',
        text: 'Please select one or more records of Vendor.'
    });
        return false; // Prevent form submission
    }

    return true; // Allow form submission
}
    </script>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
