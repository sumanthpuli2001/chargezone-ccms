<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Send Confirmation Mail To Vendor</title>
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

                  <form:form action="tenderMaster.htm?act=sendmailtoVendor" method="post" commandName="employeeMaster"
                   name='form1'  class="form-horizontal" role="form">

                    <!-- PAGE HEADER -->
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)" alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)" alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">Send Confirmation Mail To Vendor</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                        </div>
                    </div>
                    <hr>
                    <c:if test="${!empty successMessage}">
                        <div id="successMsg" class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                    </c:if>

                    <c:if test="${!empty failureMessage}">
                        <div id="failureMsg" class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                    </c:if>
                    <input type="hidden" name="refNo" value="${refNo}">
                    <input type="hidden" name="omsMasterId" value="${omsMaster.id}" />

                   

                        <h5 class="fw-600">Tender information</h5>   
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

                    <table id="commonTable" class="table table-striped bg-white" style="width: 100%" align="Center"  >
                        <thead>
                        <tr>
                            <th data-dt-order="disable">Select</th>
                            <th style="min-width: 180px;">Vendor Code</th>
                            <th style="min-width: 180px;">Contact Person</th>
                            <th style="min-width: 180px;">Contact Email Id</th>
                            <th>Contact No.</th>
                            <th>Quotation No.</th>
                            <th style="min-width: 180px;">Grand Total</th>
                            <th>Rank</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="list1" items="${list1}" varStatus="status">
                            <tr>
                                <td>
                                    <c:if test="${list1.approveFlag == 1}">
                                        <input type="checkbox" name="checkedId" id="checkedId" checked="true" value="${list1.vendorCode}">
                                    </c:if>
                                    <c:if test="${list1.approveFlag == 0}">
                                        <input type="checkbox" name="checkedId" id="checkedId" value="${list1.vendorCode}">
                                    </c:if>

                                </td>
                                <td>${list1.vendorCode}</td>
                                <td>${list1.contactPerson}</td>
                                <td>${list1.conactEmail}</td>
                                <td>${list1.contactNo}</td>
                                <td>${list1.offerNo}</td>
                                <td>${list1.finalTotal}</td>
                                <td>${status.count}</td>
                            </tr>
                        </c:forEach>
                             </tbody>
                    </table>
                                    
                                    
         <div class="col-12 p-0">
                    <div class="form-group comment-box">
                        <label class="control-label">Remark :<span class="text-danger">*</span></label>
                        <textarea type="text" maxlength="250" class="textarea-field remark" id="remark" name="remark"  required="true"></textarea>
                      <small id="charCount_remark" style="font-size: 12px; color: green;">
                                250 characters remaining
                            </small>
                    </div>
             
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
                 

                    <div class="form-group">
                         <div style="display: flex;  justify-content: center;">
                             <button type="submit" class="btn theme-btn mr-3"  formaction="tenderMaster.htm?act=selectVendor" title="" value="" >Select Vendor</button>
                            <button type="submit" class="btn theme-btn mr-3"  formaction="tenderMaster.htm?act=sendmailtoVendor1" title="" value="" >Send Mail To Selected Vendor</button>
                            <button type="submit" class="btn theme-btn mr-3"   title="" value=" " >Send Mail To Non Selected Vendor</button>
                            <button type="submit" class="btn theme-btn mr-3"  formaction="tenderMaster.htm?act=finallyCloseTender" title="" value="" >Finally Close Tender</button>
                        </div>
                    </div>
                </form:form>

                <hr style="border-top:1px solid #2ecc71;margin:30px 0;">
                <h5 class="fw-600">PO Details</h5>


                <table id="commonTable1" class="table table-striped bg-white" style="width: 100%" align="Center"  >
                    <thead>
                    <tr>
                        <th>Pr Number</th>
                        <th>Tender Number</th>
                        <th>PO Number</th>
                        <th style="min-width: 190px;">PO Date</th>
                        <th>PO Value</th>
                        <th style="min-width: 190px;">Vendor Code</th>
                        <th style="min-width: 190px;">Vendor Name</th>
                        <th style="min-width: 220px;">No. of Document Attached</th>
                        <th>Status</th>
                       
                        <th data-dt-order="disable">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="list" items="${list5}" varStatus="status">
                        <tr>
                             
                            <td>${list.prNo}</td>
                            <td>${list.tenderNo}</td>
                            <td>${list.poNo}</td>
                            <td>${list.poDate}</td>
                            <td>${list.poValue}</td>
                            <td>${list.vendorCode}</td>
                            <td>${list.vendorName}</td>
                            <td>${list.noDocumentAttached}</td>
                            <td>
                                <c:if test="${list.status==0}">
                                    Document Pending
                                </c:if>
                                <c:if test="${list.status==1}">
                                    Document Uploaded
                                </c:if>
                            </td>
                            <td>
                                <c:if test="${list.status==0}">
                                <a href="tenderMaster.htm?act=deletePoDetails&id=${list.id}&refNo=${list.tenderNo}" class="d-flex justify-content-center align-items-center text-danger p-1 mx-1"data-toggle="tooltip"data-placement="left"title="Delete"><img src="StorageYard/assets/images/delete-icon.svg" onload="SVGInject(this)"alt="Delete Icon" style="width: 22px; height: 22px;"></a>
                                </c:if>
                                <c:if test="${list.status==1}">
                                <a href="poDetails.htm?act=viewPoDocuments&id=${list.id}&vendorCode=${list.vendorCode}" class="btn theme-btn light-btn">View</a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                        </tbody>
                </table>

                <br>
                <form:form action="tenderMaster.htm?act=submitPoDetails" method="post" commandName="employeeMaster"
                           name='form1'  class="form-horizontal" role="form"> 
                    <input value="${tenderMaster.refNo}" name="refNo" type="hidden">
                        <input value="${tenderMaster.prNo}" name="prNo" type="hidden">
                 <table id="policyTable" class="table dt-scroll" style="max-width: 100%" align="center">
                        <thead>
                        <tr>
                        <th >PO Number</th>
                        <th >PO Date</th>
                        <th >PO Value</th>
                        <th >Vendor Code</th>
                        <th >Add New</th>
                        <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                        </tr>
                        </thead>
                        <tr id="addmoreFile1">
                            <td><input type="text" id="poNumber1" name="poNumber1" placeholder="PO Number" class="input-field" /></td>
                            <td><input type="text" name="poDate1" id="poDate1" class="input-field poDate" placeholder="DD-MM-YYYY" /></td>
                            <td><input type="number" name="poValue1" id="poValue1" placeholder="PO Value" class="input-field" /></td>

                            <td id="policyId1">
                                <div>
                                    <select id="userList1" name="userList1" class="select-input">
                                        <option value="">--SELECT--</option>
                                        <c:forEach var="list" items="${list1}" varStatus="status">
                                            <option  value="${list.vendorCode}">${list.vendorCode}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <span id="policyError1" style="color: red;"></span>
                            </td>
                         <td style="text-align: center" class="d-flex justify-content-center align-items-center">
                                    <div class="clone-action clone-new-field mb-2" id="policyCloneid" style="cursor:pointer;">
                                        <img src="StorageYard/assets/images/clone-btn.svg" onload="SVGInject(this)" alt="Clone Btn" />
                                    </div>
                                </td>   
                        </tr>
                    </table>
              <script type="text/javascript">
    flatpickr("#poDate1", {
        dateFormat: "d-m-Y",
        allowInput: true
    });
</script>

<script>
                                    var tempCount3 = 1;

                                    $(function () {
                                    $("#policyCloneid").on("click", function () {
                                    tempCount3++;

                                    var clone = "<tr id='addmoreFile" + tempCount3 + "' style='clear:both;'>"
                                    + "<td><input type='text' name='poNumber1' id='poNumber1" + tempCount3 + "' placeholder='PO Number' class='input-field' /></td>"
                                    + "<td><input type='text' name='poDate1' id='poDate1" + tempCount3 + "' class='input-field' placeholder='DD-MM-YYYY' /></td>"
                                    + "<td><input type='text' name='poValue1' id='poValue1" + tempCount3 + "' placeholder='PO Value' class='input-field' /></td>"
                                    + "<td id=\"addmoreFile" + tempCount3 + "\"  style=\"text-align: center\"><div>\n\
                                        <select id='userList1" + tempCount3 + "' name='userList1' class=\"select-input\">"
                                    + "<option value=''>--Select--</option>"
                                    + "<c:forEach var='list' items='${list1}'>"
                                    + "<option value='${list.vendorCode}'>${list.vendorCode}</option>"
                                    + "</c:forEach>"
                                    + "</select>"
                                    + "</div></td>"
                                    + "<td class=\"d-flex justify-content-center align-items-center\">"
                                    + "<span style='margin-top: 5px;'>"
                                    + "<div class='clone-action delete-parent-field' title='Remove' style='cursor: pointer; display:inline-block;' onclick=\"removePolicy('addmoreFile" + tempCount3 + "');\">"
                                    + "<img src='StorageYard/assets/images/clone-delete-btn.svg' onload='SVGInject(this)' alt='Remove'>"
                                    + "</div>"
                                    + "</span>"
                                    + "</td>"
                                    + "</tr>";

                                            $("#policyTable").append(clone);

                                            /* 🔥 REQUIRED LINE — THIS FIXES YOUR ISSUE */
                                            flatpickr("#poDate1" + tempCount3, {
                                            dateFormat: "d-m-Y",
                                            allowInput: true
                                            });

                                            document.getElementById('policyCount').value = tempCount3;
                                            $('.select-input').selectpicker("refresh");
                                            addBPolicy(tempCount3);
                                            });
                                            });

                                            $("#policyTable").on("click", ".delete-parent-field", function () {
                                            var row = $(this).closest("tr");
                                            row.remove();
                                            var policyCount = document.getElementById('policyTable').rows.length - 1;
                                            document.getElementById('policyCount').value = policyCount;
                                            });
</script>

                                <div class="form-group">
                                    <div style="display: flex;  justify-content: center;">
                                        <button type="submit" value="" class="btn theme-btn" >Submit</button>
                                    </div>
                                </div>
                </form:form>
            </section>
        </main>

        <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>

    </body>






</html>
