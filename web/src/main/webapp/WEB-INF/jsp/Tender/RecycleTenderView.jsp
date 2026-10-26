
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TENDER INFORMATION</title>
        <style>
            .modal-body {
    max-height: calc(100vh - 180px);
    overflow-y: auto;
     overflow-x: hidden !important;
}

        </style>
    </head>
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
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
               <form:form action="tenderMaster.htm?act=submitRecycleView" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                          class="form-horizontal" role="form">         
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600">TENDER INFORMATION- ${tenderPhase}  Part Tender Information</h5>

                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                        </div>
                    </div>

                    <hr>
                    <input type="hidden" name="tenderPhase" id="tenderPhase" value="${tenderPhase}">
                    <input type="hidden" name="tender_no" id="tender_no" value="${refNo}">
                    <input type="hidden" name="refNo" id="refNo" value="${refNo}">
                    
                    <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.
                        </div>
                    </div>


                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label"> Tender Type :</label>

                                    <input path="type"  class="input-field" value="Procurement"   readonly="true"  required="required"/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label"> Tender Reference No :</label>

                                    <input path="refNo" id="refNo" value="${refNo}"  class="input-field" maxlength="30" pattern="[0-9]+" readonly="true"   />
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label"> Project Name : <span class="text-danger">*</span></label>
                                    <form:input path="title" class="textarea-field comment"   placeholder="Enter Title " required="required" ></form:input>

                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label"> Tender classification  : </label>
                                    <form:input path="categoryId" class="input-field"   maxlength="30" />                         
                                </div>
                            </div>
                                
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label"> Estimate Cost With GST : </label>
                                    <input type="text" name="value" class="input-field" value="${tenderMaster.value}" pattern="[0-9]+" onkeypress="return (event.charCode != 8 && event.charCode == 0 || (event.charCode >= 48 && event.charCode <= 57))"  maxlength="30" required="required"/>
                                </div>
                            </div>
                                
                            <input type="hidden" name="docCost" value="0" class="form-control"   pattern="[0-9]+" onkeypress="return (event.charCode != 8 && event.charCode == 0 || (event.charCode >= 48 && event.charCode <= 57))" maxlength="30" required="required" readonly="true"/>
                            <input type="hidden" name="emd" value="0" class="form-control"  pattern="[0-9]+" onkeypress="return (event.charCode != 8 && event.charCode == 0 || (event.charCode >= 48 && event.charCode <= 57))"  maxlength="30" required="required" readonly="true"/>
                            
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label"> Business Type : </label>
                                    <input type="text" name="business_type" class="input-field"  value="${tenderMaster.businessType}" readonly="true" />
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">Project Type :</label>
                                    <input type="text" name="project_type" class="input-field" value="${tenderMaster.projectType}" readonly="true"/>
                                </div>
                            </div>
                                
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">Tender Date : <span class="text-danger">*</span></label>
                                    <form:input path="announceDate" class="input-field" value="${formattedDate}"  maxlength="30" required="required" readonly="true"/>
                                </div>
                            </div>
                                
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">Tender Due Date : <span class="text-danger">*</span></label>
                                    <input type="text" class="input-field" readonly name="submitLastdate" name="submitLastdate" value="${submitLastdate}" />
                                </div>
                            </div>   
                             
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label"> PR No :</label>
                                    <form:input path="prNo" class="input-field"  value="" readonly="true"/>                              
                                </div>
                            </div>

                            <input type="hidden" name="prItemNo" value="" class="input-field" readonly="true" />

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">Tender Subject Description : </label>
                                    <form:input path="workDesc" class="input-field"   maxlength="200" readonly="true"/>
                                </div>
                            </div>
                                
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label"> Minimum Quotes Required : </label>
                                    <input type="text" name="quotes" id="quotes" value="${tenderMaster.quotes}" class="input-field"   maxlength="200" readonly="true"/>
                                </div>
                            </div>
                                
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">Billing Location : </label>
                                    <input type="text" name="location" id="location" value="${tenderMaster.location}" class="input-field"   maxlength="200" readonly="true"/>
                                </div>
                            </div>
                                
                        </div>
                    </div>           
                    
                    <h5 class="fw-600">Site Address</h5>
                    <hr>

                    <table id="commonTable" class="table  table-striped bg-white" style="min-width: 100%" align="Center"  >

                        <thead>
                            <tr>
                                <th>Sr. No.</th>
                                <th>Address1</th>
                                <th>Address2</th>
                                <th>City</th>
                                <th>State</th>
                                <th>PIN Code</th>
                                <th>Remarks</th>

                            </tr>
                        </thead>
                        <c:set var="count" value="0" scope="page" />
                        <tbody>
                            <c:forEach var="list6" items="${multiadd}" varStatus="status">
                                <tr>
                                    <td style="text-align: center;">${status.count}</td>
                                    <td style="text-align: center;">${list6.address1}</td>
                                    <td style="text-align: center;">${list6.address2}</td>
                                    <td style="text-align: center;">${list6.city}</td>
                                    <td style="text-align: center;">${list6.state}</td>
                                    <td style="text-align: center;">${list6.pincode}</td>
                                    <td style="text-align: center;">${list6.remark}</td>


                                </tr>
                            </c:forEach>
                        </tbody>
                    </table> 
                    <br>
                    <h5 class="fw-600">Tender Contact Person</h5>
                    <hr>

                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label">Created By : </label>
                                    <form:input path="contactPerson" class="input-field" value="${employee_name}"  maxlength="30" readonly="true"/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label">Contact Number : </label>
                                    <form:input path="tenderAdminContactNumber" class="input-field"   maxlength="30" readonly="true"/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label">User Name : </label>
                                    <form:input path="endUserName" class="input-field" value=""  maxlength="130" readonly="true"/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label">User Contact No : </label>
                                    <form:input path="endUserNumber" class="input-field" value=""  maxlength="30" readonly="true"/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label">Technical Person Contact Name : </label>
                                    <form:input path="technicalContactName" class="input-field" value=""  maxlength="130" readonly="true"/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label">Technical Person Contact No : </label>
                                    <form:input path="technicalContactNo" class="input-field" value=""  maxlength="30" readonly="true"/>
                                </div>
                            </div>
                        </div>        
                    </div>        

                    <h5 class="fw-600">Tender Terms & Condition</h5>
                    <hr>
                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label"> Delivery Period : </label>
                                    <form:input path="deliveryPeriod" class="input-field"   maxlength="200" required="required" readonly="true"/>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label"> Terms Of Payment : </label>
                                    <form:input path="termsOfPayment" class="input-field"   maxlength="200" required="required" readonly="true"/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label">Mode Of Transport : </label>
                                    <form:input path="modeOfTransport" class="input-field"   maxlength="200" required="required" readonly="true"/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label">Inco Terms : </label>
                                    <form:input path="incoTerms" class="input-field"   maxlength="200" required="required" readonly="true"/>
                                </div>
                            </div>

                        </div>
                    </div>
                                
                    <h5 class="fw-600">Item Details</h5>
                    <hr>
                    <table id="commonNoPageTable" class="table table-striped bg-white" style="min-width: 100px;" align="center">   
                        <thead>
                            <tr>
                                <th>Sr. No.</th>
                                <th style="min-width: 190px;"> Item Code</th>
                                <th style="min-width: 530px;"> Item Description</th>
                                <th style="min-width: 190px;"> Purpose</th>
                                <th> Make   </th>
                                <th> UoM  </th>
                                <th> Quantity  </th>
                                <th> HSN /SAC Code  </th>
                                <th > GST  </th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach var="tenderItemMaster" items="${tenderItemMaster}" varStatus="status">
                                <tr>
                                    <td> ${status.count}</td>
                                    <td>${tenderItemMaster.itemCode}</td>
                                    <td>${tenderItemMaster.itemDescription}</td>
                                    <td>${tenderItemMaster.deliveryScheduleQty}</td>
                                    <td>${tenderItemMaster.deliveryScheduleDate}</td>
                                    <td>${tenderItemMaster.uom}</td>
                                    <td><input type="text" class="input-field" name="qty" value="${tenderItemMaster.qty}" readonly="true"></td>
                                    <td>${tenderItemMaster.hsnNo}</td>
                                    <td>${tenderItemMaster.gst}</td>
                                </tr>
                            </c:forEach>

                        </tbody>

                    </table>
                    
                    <c:if test="${tenderMaster.type == 'Contract' || tenderMaster.type == 'Contract Civil' || tenderMaster.type == 'Contract Electrical'}">
                        <br>
                        <h5 class="fw-600"> Items Details For Service</h5>
                        <hr>

                        <table id="commonNoPageTable0" class="table table-striped bg-white" style=" width: 100%;" align="center">
                            <thead>
                                <tr>
                                    <th>Sr. No.</th>
                                    <th style="min-width: 190px;"> Item Code</th>
                                    <th style="min-width: 530px;"> Item Description</th>
                                    <th style="min-width: 190px;"> Purpose</th>
                                    <th> Make   </th>
                                    <th> UoM  </th>
                                    <th> Quantity  </th>
                                    <th> HSN /SAC Code  </th>
                                    <th > GST  </th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach var="tenderItemMaster" items="${tenderItemMaster1}" varStatus="status">
                                    <tr>
                                        <td> ${status.count}</td>
                                        <td>${tenderItemMaster.itemCode}</td>
                                        <td>${tenderItemMaster.itemDescription}</td>
                                        <td>
                                            ${tenderItemMaster.deliveryScheduleQty}

                                        </td>
                                        <td>${tenderItemMaster.deliveryScheduleDate}</td>
                                        <td>${tenderItemMaster.uom}</td>
                                        <td><input type="text" class="input-field" name="qty" value="${tenderItemMaster.qty}" readonly="true"></td>
                                        <td>${tenderItemMaster.hsnNo}</td>
                                        <td>${tenderItemMaster.gst}</td>
                                    </tr>
                                </c:forEach>

                            </tbody>


                        </table>

                    </c:if>

                    <br>
                    <h5 class="fw-600">Tender Attachment</h5>
                    <hr>

                    <h6 class="fw-600">PR Document</h6>
                    
                    <table id="commonDocTable" class="table  table-striped bg-white dt-scroll" style="width: 100%" align="Center"  >

                        <thead>
                            <tr>
                                <th>Sr. No.</th>
                                <th>Name</th>
                                <th>Document</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:set var="count" value="0" scope="page" />
                            <c:forEach var="prDoc" items="${prDoc}" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${prDoc.docTitle}</td>
                                    <td><a class="fw-600 text-break gradient-text" href="prMaster.htm?act=downloadPrFile&amp;fileName=${prDoc.docName}&RefNo=${prDoc.refNo}">${prDoc.docName}</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <br>
                    <div class="form-group">
                        <div class="content-top mb-3 d-flex align-items-center justify-content-between">
                            <div class="d-flex align-items-center">
                                <h6 class="fw-600">General Terms & Conditions</h6>
                            </div>

                            <button type="button" class="btn theme-btn d-flex align-items-center" data-toggle="modal"
                                    data-target="#generalTermsUpload" onclick="requestDocTechTab();">
                                <img src="StorageYard/assets/images/attachment.svg" class="attachment mr-1 d-inline"
                                     onload="SVGInject(this)" alt="User Image">
                                Attachment
                            </button>

                        </div>
                        <div id="showtext5" class="bg-white"></div>

                    </div>
                            
                    <script type="text/javascript">                       

                        var str7 = document.getElementById("tender_no").value;
                        function showuser5(str) {
                            str = document.getElementById("tender_no").value;
                            str7 = str;
                            var xreq, ID;
                            if (str == "") {
                                document.getElementById("showtext5").innerHTML = "";
                                return;
                            }
                            if (window.XMLHttpRequest) {
                                xreq = new XMLHttpRequest();
                            }
                            else {
                                xreq = new ActiveXObject("Microsoft.XMLHTTP");
                            }
                            xreq.onreadystatechange = function () {
                                if ((xreq.readyState == 4) && (xreq.status == 200)) {
                                    document.getElementById("showtext5").innerHTML = xreq.responseText;

                                    setTimeout(() => {
                                        if ($('#generalTermsTable').length) {
                                            const table1 = initTable('#generalTermsTable');
                                        }
                                    }, 100);
                                }
                            }

                        xreq.open("Get", "tenderMaster.htm?act=agaxTenderGeneralFileDetails&bid_type=1&q=" + str7, true);
                            xreq.send();
                            window.clearInterval(ID);
                        }

                        var ID = window.setInterval(showuser5(str7), 1000);
                    </script>
                    <br>
                    <div class="form-group">
                        <div class="content-top mb-3 d-flex align-items-center justify-content-between">
                            <div class="d-flex align-items-center">
                                <h6 class="fw-600"> Tender Technical Document </h6>
                            </div>

                            <button type="button" class="btn theme-btn d-flex align-items-center" data-toggle="modal"
                                    data-target="#tenderTechnicalUpload" onclick="requestDocTenderTechnicalTab();">
                                <img src="StorageYard/assets/images/attachment.svg" class="attachment mr-1 d-inline"
                                     onload="SVGInject(this)" alt="User Image">
                                Attachment
                            </button>  

                        </div>
                        <div id="showtext7" class="bg-white"></div>
                    </div>   
                    <script type="text/javascript">                        

                        var str7 = document.getElementById("tender_no").value;
                        function showuser7(str) {
                            str = document.getElementById("tender_no").value;
                            str7 = str;
                            var xreq, ID;
                            if (str == "") {
                                document.getElementById("showtext7").innerHTML = "";
                                return;
                            }
                            if (window.XMLHttpRequest) {
                                xreq = new XMLHttpRequest();
                            }
                            else {
                                xreq = new ActiveXObject("Microsoft.XMLHTTP");
                            }
                            xreq.onreadystatechange = function () {
                                if ((xreq.readyState == 4) && (xreq.status == 200)) {
                                    document.getElementById("showtext7").innerHTML = xreq.responseText;

                                    setTimeout(() => {
                                        if ($('#tenderTechnicalTable').length) {
                                            const table1 = initTable('#tenderTechnicalTable');
                                        }
                                    }, 100);
                                }
                            }

                            xreq.open("Get", "tenderMaster.htm?act=agaxTenderTechnicalFileDetails&bid_type=1&q=" + str7, true);
                            xreq.send();
                            window.clearInterval(ID);
                        }

                        var ID = window.setInterval(showuser7(str7), 1000);
                    </script>
                     
                    <c:if test="${tenderPhase != '1'}">
                        <h5 class="fw-600">Technical Detail / Specification</h5>
                        <hr>

                        <div class="form-group tech-detail">
                            <c:if test="${tenderTechnicalDoc == 'Yes'}">
                                <input type="checkbox" name="technicalDoc" class="input-field" checked disabled>
                            </c:if>
                            <c:if test="${tenderTechnicalDoc != 'Yes'}">
                                <input type="checkbox" name="technicalDoc" class="input-field" disabled="true">
                            </c:if>
                            <label for="technicalDoc">Technical Detail Required From Vendor</label>
                        </div>
                        <style>
                            .tech-detail {
                                display: flex;
                                align-items: center;
                                gap: 15px; /* space between text and checkbox */
                            }

                            .tech-detail input[type="checkbox"] {
                                width: 22px;
                                height: 22px;
                                cursor: pointer;
                            }

                        </style>                               


                    </c:if>                             
                     
                    <div class="form-group">
                        <div class="content-top mb-3 d-flex align-items-center justify-content-between">
                            <div class="d-flex align-items-center">
                                <h5 class="fw-600"> Vendor Query</h5>
                            </div>

                            <button type="button" class="btn theme-btn d-flex align-items-center" data-toggle="modal"
                                    data-target="#vendorQueryUpload" onclick="requestDocvendorQueryTab();">
                                <img src="StorageYard/assets/images/attachment.svg" class="attachment mr-1 d-inline"
                                     onload="SVGInject(this)" alt="User Image">
                                View
                            </button>  

                        </div>

                    </div>            
                    <br>
                    
                    <h5 class="fw-600">Tender Remark</h5>
                    <hr>   
                    <div class="col-12 p-0">
                        <div class="form-group comment-box">
                            <label class="control-label">Remark :</label>
                            <textarea type="text" maxlength="250" class="textarea-field comment" id="remark" name="remark"  >${tenderMaster.tenderRemark}</textarea>
                        </div>
                    </div>                           
           
                    <div class="form-group">
                        <div class="content-top mb-3 d-flex align-items-center justify-content-between">
                            <div class="d-flex align-items-center">
                                <h5 class="fw-600">Add Vendor</h5>
                            </div>

                            <button type="button" onclick="searchAddVendor()"
                                    class="btn theme-btn d-flex align-items-center"
                                    data-toggle="modal" data-target="#iteamDocsUploadkg11">
                                <i class="fa fa-search " style="color: white;"></i>&nbsp;
                                Search
                            </button>
                        </div>
                        <hr>
                        <div id="showtext111"></div>             
                    </div>
                        
                    <script type="text/javascript">
                        var str11 = document.getElementById("tender_no").value;
                        function showuser11(str) {
                            str = document.getElementById("tender_no").value;
                            strV = str;
                            var xreq, ID;
                            
                            if (str == "") {
                                document.getElementById("showtext111").innerHTML = "";
                                return;
                            }
                            
                            if (window.XMLHttpRequest) {
                                xreq = new XMLHttpRequest();
                            } else {
                                xreq = new ActiveXObject("Microsoft.XMLHTTP");
                            }
                            
                            xreq.onreadystatechange = function () {
                                if ((xreq.readyState == 4) && (xreq.status == 200)) {
                                    document.getElementById("showtext111").innerHTML = xreq.responseText;
                                    setTimeout(() => {
                                        if ($('#VendorDetailsTable').length) {
                                            const table1 = initTable('#VendorDetailsTable');
                                        }                                        
                                    }, 100);
                                    $('.select-input').selectpicker('refresh');
                                }
                            }
    
                            xreq.open("get", "tenderMaster.htm?act=agaxTenderVendorDetails1&q=" + str11, true);
                            xreq.send();
                            window.clearInterval(ID);
                        }
                        var ID = window.setInterval(showuser11(str11), 1000);

                    </script>
               
                    <c:if test="${tenderPhase != '1'}">
                        <br>                     
                        <div class="form-group">
                            <div class="content-top mb-3 d-flex align-items-center justify-content-between">
                                <h6 class="fw-600 mr-4 mb-0"> Technical Committee Member </h6>
                                <button type="button" class="btn theme-btn d-flex align-items-center" data-toggle="modal" data-target="#technicalCommitteeUpload">
                                    <i class="fa fa-search " style="color: white;"></i>&nbsp;
                                      Search
                                </button>
                            </div>
                            <hr>
                            <div id="showtext3"></div> 
                        </div>        
                        
                        <script type="text/javascript">
                            var str7 = document.getElementById("tender_no").value;
                            function showuser3(str) {
                                str = document.getElementById("tender_no").value;
                                str7 = str;
                                var xreq, ID;

                                if (str == ""){
                                    document.getElementById("showtext3").innerHTML = "";
                                    return;
                                }
                                
                                if (window.XMLHttpRequest){
                                    xreq = new XMLHttpRequest();
                                } else {
                                    xreq = new ActiveXObject("Microsoft.XMLHTTP");
                                }
                                
                                xreq.onreadystatechange = function () {
                                    if ((xreq.readyState == 4) && (xreq.status == 200)){
                                        document.getElementById("showtext3").innerHTML = xreq.responseText;
                                        setTimeout(() => {
                                            if ($('#TechCommitteeTable').length) {
                                                const table1 = initTable('#TechCommitteeTable');
                                            }
                                        }, 100);
                                    }
                                }

                                xreq.open("Get", "tenderMaster.htm?act=agaxTenderCommitteeDetails&bid_type=2&q=" + str7, true);
                                xreq.send();
                                window.clearInterval(ID);
                            }
                            var ID = window.setInterval(showuser3(str7), 1000);
                        </script>
                    </c:if>                   
                    <br>
                    <div class="form-group">
                        <div class="content-top mb-3 d-flex align-items-center justify-content-between">
                            <h6 class="fw-600 mr-4 mb-0"> Price Committee Member </h6>
                            <button type="button" class="btn theme-btn d-flex align-items-center" data-toggle="modal"
                                    data-target="#PriceDocsUpload">
                                <i class="fa fa-search " style="color: white;"></i>&nbsp;
                                Search
                            </button>
                        </div>
                        <hr>
                        <div id="showtext4" class="bg-white"></div>
                    </div>

                    <script type="text/javascript">
                        var str7 = document.getElementById("tender_no").value;
                        function showuser4(str) {
                            str = document.getElementById("tender_no").value;
                            str7 = str;
                            var xreq, ID;
                            
                            if (str == "") {
                                document.getElementById("showtext4").innerHTML = "";
                                return;
                            }
                            
                            if (window.XMLHttpRequest) {
                                xreq = new XMLHttpRequest();
                            } else {
                                xreq = new ActiveXObject("Microsoft.XMLHTTP");
                            }
                            
                            xreq.onreadystatechange = function () {
                                if ((xreq.readyState == 4) && (xreq.status == 200)) {
                                    document.getElementById("showtext4").innerHTML = xreq.responseText;
                                    setTimeout(() => {
                                        if ($('#PriceCommitteeTable').length) {
                                            const table1 = initTable('#PriceCommitteeTable');
                                        }
                                    }, 100);
                                }
                            }

                            xreq.open("get", "tenderMaster.htm?act=agaxTenderCommitteeDetails&bid_type=1&q=" + str7, true);
                            xreq.send();
                            window.clearInterval(ID);
                        }
                        var ID = window.setInterval(showuser4(str7), 1000);
                    </script>                   
                        
                    <div class="form-group">
                        <div style="display: flex;  justify-content: center;">
                            <button type="submit" class="btn theme-btn" style="width: 150px !important;" >Submit</button>
                        </div>
                    </div>                        
                        
                </form:form>
         <form:form id="myForm" enctype="multipart/form-data" commandName="prMaster" name="form"
                            class="form-horizontal" role="form">
                      <input type="hidden" id="ref_no" name="ref_no1" value="${ref_no}" />
                    <input type="hidden" id="ref_no" name="ref_no1" value="${ref_no}" />
                      <input type="hidden" name="bid_type" id="bid_type">
                    <input type="hidden" name="userList1" id="committee_user_id">
                    
                    <!--General Terms & Conditions-->
                    
                    <div class="modal fade" id="generalTermsUpload" data-backdrop="static" data-keyboard="false"
                         tabindex="-1" aria-labelledby="generalTermsUploadLabel" aria-hidden="true">
                        <div class="modal-dialog modal-sm">
                            <div class="modal-content">

                                <div class="modal-header align-items-center">
                                    <h5 class="modal-title" id="generalTermsUploadLabel">Attach Document
                                    </h5>
                                    <div class="cta-btn d-flex align-items-center">
                                        <button type="button" class="btn theme-btn light-btn" onclick="showuser5(id);"
                                                data-dismiss="modal">Close</button>
                                        <button type="button" class="btn theme-btn ml-3"
                                                id="uploadSubmitBtn">Submit</button>
                                    </div>
                                </div>

                                <div class="modal-body">


                                    <table id="commonDocTable3" class="table table-striped bg-white dt-scroll" style="min-width: 100%" align="center">
                                        <thead>
                                            <tr>
                                                <th>Vendor Attachment</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>
                                                    <div class="col-md-12">
                                                        <input type="file" name="generalfile" id="generalfile" class="input-field py-2 fs-12i">
                                                    </div>
                                                </td>

                                            </tr>
                                        </tbody>
                                    </table>
                                    <div id="AjaxTechDiv" class="p-1"></div>    
                                </div>
                            </div>
                        </div>
                    
                     
                     <script type="text/javascript">
                  
             const bootoast = window.Bootoast;
        // Submit file with FormData
        document.getElementById('uploadSubmitBtn').addEventListener('click', function () {
            const fileInput = document.getElementById("generalfile");
           
            const refNoValue = document.getElementById('tender_no')?.value;
            if (!fileInput || fileInput.files.length === 0) {
            
                Swal.fire({
                    icon: 'warning',
                    title: 'Please select a file to upload.',
                    timer: 3000,
                    showConfirmButton: false,
                    position: 'top'
                });
                return;
            }

            var form = document.getElementById('myForm');
            var formData = new FormData(form);
            formData.append('generalfile', fileInput.files[0]);
            formData.append('policyCount', 1);
//            console.log(refNoValue);
//            if (refNoValue) {
//                formData.append('ref_no', refNoValue);
//            }

            const xhr = new XMLHttpRequest();
            xhr.open('POST', 'tenderMaster.htm?act=addTenderGeneralFileDetailsSubmit', true);
            xhr.onload = function () {
                if (xhr.status === 200) {
                    const uploadedFileName = fileInput.files[0].name;
                    Swal.fire({
                        icon: 'success',
                        title: 'Added Attachment General Terms & Conditions Document Successfully.',
                        timer: 3000,
                        showConfirmButton: false,
                        position: 'top'
                    });
                    requestDocTechTab();
                    // Hide modal
                    // $('#techDocsUpload').modal('hide');
                    // Reset file input
                    fileInput.value = '';
                } else {
                    Swal.fire({
                        icon: 'error',
                        title: 'Upload failed: ' + xhr.statusText,
                        timer: 4000,
                        showConfirmButton: false,
                        position: 'top'
                    });
                }
            };
            xhr.onerror = function () {
                console.error('Network error.');
                Swal.fire({
                    icon: 'error',
                    title: 'Network error occurred.',
                    timer: 4000,
                    showConfirmButton: false,
                    position: 'top'
                });
            };
            xhr.send(formData);
            setupImportTechnicalDocument();
        });
//            function initResultContent() {
//          }
        </script> 
        
        <script type="text/javascript">
             
                var str7 = document.getElementById("ref_no").value;
                function requestDocTechTab(str) {
                      
                    str = document.getElementById("ref_no").value;
                    str7 = str;
                 
                    var xreq, ID;
                    if (str == "") {
                        document.getElementById("AjaxTechDiv").innerHTML = "";
                        return;
                    }
                    if (window.XMLHttpRequest) {
                        xreq = new XMLHttpRequest();
                    }
                    else {
                        xreq = new ActiveXObject("Microsoft.XMLHTTP");
                    }
                    xreq.onreadystatechange = function () {
                        if ((xreq.readyState == 4) && (xreq.status == 200)) {
                            document.getElementById("AjaxTechDiv").innerHTML = xreq.responseText;
                            setTimeout(() => {
                                if ($('#AjaxTechTab').length) {
                                    const table1 = initDocTable('#AjaxTechTab');
                                }
                            }, 100);
                        }
                    }

                    xreq.open("Get", "tenderMaster.htm?act=addTenderGeneralFileDetails&ref_no1=" + str7, true);
                    xreq.send();
                    window.clearInterval(ID);
                }

                var ID = window.setInterval(requestDocTechTab(str7), 1000);
            </script>
        </div> 
                    
          <script>
        $(document).on('click', '.delete-doc-row', function (e) {
            e.preventDefault();

            var $row = $(this).closest('tr');
            var id = $(this).data('id');

            var fieldOne = $('#pr_no').val();

            Swal.fire({
                title: 'Are you sure you want to delete this?',
                text: 'You will not be able to recover this record!',
                icon: 'warning',
                showCancelButton: true,
                confirmButtonText: 'Yes, delete it!',
                cancelButtonText: 'No, cancel',
                reverseButtons: true,
                customClass: {
                    confirmButton: 'confirm-delete',
                    cancelButton: 'theme-btn light-btn'
                }
            }).then((result) => {
                if (result.isConfirmed) {
                    $.ajax({
                        url: 'tenderMaster.htm?act=tenderGeneralFileDetailsDelete',
                        type: 'POST',
                        data: {
                            id: id,
                            ref_no: fieldOne,
                        },
//                        contentType: 'application/json',
                        success: function (response) {
                            Swal.fire({
                                icon: 'success',
                                title: 'Deleted!',
                                text: response.message || 'Record has been deleted.'
                            });
                            $('#AjaxTechTab')
                                .DataTable()
                                .row($row)
                                .remove()
                                .draw();
                        },
                        error: function (xhr) {
                            Swal.fire({
                                icon: 'error',
                                title: 'Error!',
                                text: 'Error deleting record: ' + xhr.responseText
                            });
                        }
                    });
                }
            });
        });
    </script>     
    
      <!--Tender Technical Document-->
    <div class="modal fade" id="tenderTechnicalUpload" data-backdrop="static" data-keyboard="false"
                         tabindex="-1" aria-labelledby="tenderTechnicalUploadLabel" aria-hidden="true">
                        <div class="modal-dialog modal-sm">
                            <div class="modal-content">

                                <div class="modal-header align-items-center">
                                    <h5 class="modal-title" id="tenderTechnicalUploadLabel">Attach Document
                                    </h5>
                                    <div class="cta-btn d-flex align-items-center">
                                        <button type="button" class="btn theme-btn light-btn" onclick="showuser7(id);"
                                                data-dismiss="modal">Close</button>
                                        <button type="button" class="btn theme-btn ml-3"
                                                id="tenderTechnicalSubmitBtn">Submit</button>
                                    </div>
                                </div>

                                <div class="modal-body">


                                    <table id="commonDocTable2" class="table table-striped bg-white dt-scroll" style="min-width: 100%" align="center">
                                        <thead>
                                            <tr>
                                                <th>Vendor Attachment</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>
                                                    <div class="col-md-12">
                                                        <input type="file" name="generalsfiles" id="generalsfiles" class="input-field py-2 fs-12i">
                                                    </div>
                                                </td>

                                            </tr>
                                        </tbody>
                                    </table>
                                    <div id="AjaxtenderTechnicalDiv" class="p-1"></div>    
                                </div>
                            </div>
                        </div>  
                 
                 
                        </div>  
        
    <script type="text/javascript">
                  
             const bootoast2 = window.Bootoast2;
        // Submit file with FormData
        document.getElementById('tenderTechnicalSubmitBtn').addEventListener('click', function () {
            const fileInputs = document.getElementById("generalsfiles");
           
            const refNoValue = document.getElementById('tender_no')?.value;
            if (!fileInputs || fileInputs.files.length === 0) {
            
                Swal.fire({
                    icon: 'warning',
                    title: 'Please select a file to upload.',
                    timer: 3000,
                    showConfirmButton: false,
                    position: 'top'
                });
                return;
            }

            var form = document.getElementById('myForm');
            var formData = new FormData(form);
            formData.append('generalsfiles', fileInputs.files[0]);
            formData.append('policyCount', 1);
//            console.log(refNoValue);
//            if (refNoValue) {
//                formData.append('ref_no', refNoValue);
//            }

            const xhr = new XMLHttpRequest();
            xhr.open('POST', 'tenderMaster.htm?act=addTenderTechnicalFileDetailsSubmit', true);

            xhr.onload = function () {
                if (xhr.status === 200) {
                    const uploadedFileNames = fileInputs.files[0].name;
                    Swal.fire({
                        icon: 'success',
                        title: 'Added Attachment Tender Technical Document Successfully.',
                        timer: 3000,
                        showConfirmButton: false,
                        position: 'top'
                    });
                    requestDocTenderTechnicalTab();
                    // Hide modal
                    // $('#techDocsUpload').modal('hide');
                    // Reset file input
                    fileInputs.value = '';
                } else {
                    Swal.fire({
                        icon: 'error',
                        title: 'Upload failed: ' + xhr.statusText,
                        timer: 4000,
                        showConfirmButton: false,
                        position: 'top'
                    });
                }
            };
            xhr.onerror = function () {
                console.error('Network error.');
                Swal.fire({
                    icon: 'error',
                    title: 'Network error occurred.',
                    timer: 4000,
                    showConfirmButton: false,
                    position: 'top'
                });
            };
            xhr.send(formData);
            setupImportTenderTechnicalDocument();
        });
//            function initResultContent() {
//          }
        </script> 
    
            
     <script type="text/javascript">
             
                var str7 = document.getElementById("ref_no").value;
                function requestDocTenderTechnicalTab(str) {
                      
                    str = document.getElementById("ref_no").value;
                    str7 = str;
                 
                    var xreq, ID;
                    if (str == "") {
                        document.getElementById("AjaxtenderTechnicalDiv").innerHTML = "";
                        return;
                    }
                    if (window.XMLHttpRequest) {
                        xreq = new XMLHttpRequest();
                    }
                    else {
                        xreq = new ActiveXObject("Microsoft.XMLHTTP");
                    }
                    xreq.onreadystatechange = function () {
                        if ((xreq.readyState == 4) && (xreq.status == 200)) {
                            document.getElementById("AjaxtenderTechnicalDiv").innerHTML = xreq.responseText;
                            setTimeout(() => {
                                if ($('#AjaxtenderTechnicalTab').length) {
                                    const table1 = initDocTable('#AjaxtenderTechnicalTab');
                                }
                            }, 100);
                        }
                    }

                    xreq.open("Get", "tenderMaster.htm?act=addTenderTechnicalFileDetails&ref_no1=" + str7, true);
                    xreq.send();
                    window.clearInterval(ID);
                }

                var ID = window.setInterval(requestDocTenderTechnicalTab(str7), 1000);
            </script>    
        
        
        <script>
        $(document).on('click', '.delete-doc-row', function (e) {
            e.preventDefault();

            var $row = $(this).closest('tr');
            var id = $(this).data('id');

            var fieldOne = $('#pr_no').val();

            Swal.fire({
                title: 'Are you sure you want to delete this?',
                text: 'You will not be able to recover this record!',
                icon: 'warning',
                showCancelButton: true,
                confirmButtonText: 'Yes, delete it!',
                cancelButtonText: 'No, cancel',
                reverseButtons: true,
                customClass: {
                    confirmButton: 'confirm-delete',
                    cancelButton: 'theme-btn light-btn'
                }
            }).then((result) => {
                if (result.isConfirmed) {
                    $.ajax({
                        url: 'tenderMaster.htm?act=tenderTechnicalFileDetailsDelete',
                        type: 'POST',
                        data: {
                            id: id,
                            ref_no: fieldOne,
                        },
//                        contentType: 'application/json',
                        success: function (response) {
                            Swal.fire({
                                icon: 'success',
                                title: 'Deleted!',
                                text: response.message || 'Record has been deleted.'
                            });
                            $('#AjaxtenderTechnicalTab')
                                .DataTable()
                                .row($row)
                                .remove()
                                .draw();
                        },
                        error: function (xhr) {
                            Swal.fire({
                                icon: 'error',
                                title: 'Error!',
                                text: 'Error deleting record: ' + xhr.responseText
                            });
                        }
                    });
                }
            });
        });
    </script> 
        
    <div class="modal fade" id="iteamDocsUploadkg11" data-backdrop="static"
                             data-keyboard="false" tabindex="-1" aria-labelledby="iteamDocsUploadkg11Label"
                             aria-hidden="true">
                            <div class="modal-dialog modal-xl">
                                <div class="modal-content">

                                    <div class="modal-header align-items-center">
                                        <h5 class="modal-title" id="iteamDocsUploadkg11Label">Vendor Details :</h5>
                                        <div class="cta-btn d-flex align-items-center"> 
                                            <button type="button" class="btn theme-btn light-btn" onclick="showuser11(id);" data-dismiss="modal">Close</button>
                                            <button type="button" class="btn theme-btn ml-3" onclick="submitCheckedVendorkg11()" title="">Search</button>
                                            <button type="button" class="btn theme-btn ml-3"  onclick="submitCheckedVendor11()" title="">Add</button>                                            
                                        </div>
                                    </div>
                                    <div class="modal-body">
                                        <div class="bg-white" id="IteamDetailsDivV">
                                        </div>
                                    </div>
                                </div>
                            </div>
            
                        </div>
						
						<script type="text/javascript">
                function searchAddVendor() {
                const formData = new FormData();                        
                        const queryParams = new URLSearchParams(formData).toString();
                        const xhr = new XMLHttpRequest();
                        xhr.onreadystatechange = function () {
                        if (xhr.readyState === 4 && xhr.status === 200) {
                        const resultDiv = document.getElementById("IteamDetailsDivV");
                                if (resultDiv) {
                        resultDiv.innerHTML = xhr.responseText;
                                initResultContent();
                                setTimeout(() => {
                                    
                                }, 100);
                        } else {
                        console.error("Element with ID 'IteamDetailsDivV' not found.");
                        }
                        }
                        };
                     
                        xhr.open("GET", "tenderMaster.htm?act=searchVendorForManualTender1&ref_no=${ref_no}", true);
                        xhr.send();
                        function initResultContent() {
                        setupImportVendorTable();
                        }
                }
    </script>
    <script>
        function toggleAllCheckboxes11() {
        //               var ref_no = document.getElementById("prNo").value;
            var materialCheck = document.getElementById("vendorId");
            var checkboxes = document.getElementsByName("checkedId");
            for (var i = 0; i < checkboxes.length; i++) {
                checkboxes[i].checked = materialCheck.checked;
            }
        }

        function submitCheckedVendor11() {
            
            var checkboxes = document.getElementsByName("checkedId");
            var ref_no = document.getElementById("tender_no").value;
            var atLeastOneChecked = false;
            for (var i = 0; i < checkboxes.length; i++) {
                if (checkboxes[i].checked) {
                    atLeastOneChecked = true;
                    break;
                }
            }

            if (!atLeastOneChecked) {
//        alert("Select at least one item.");
                Swal.fire({
                    title: 'Select at least one Vendor.',
                    icon: 'warning',
                    timer: 2000,
                    showConfirmButton: false
                });
                return false;
            }

            var form = document.getElementById("myForm");
            var formData = new FormData(form);
            formData.append("ref_no", ref_no);
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "tenderMaster.htm?act=addVendorForManualTender1", true);
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4) {
                    if (xhr.status === 200) {
                        document.getElementById("IteamDetailsDivV").innerHTML = xhr.responseText;
//                        document.getElementById("IteamDetailsDivV").innerHTML = xhr.responseText;

                        Swal.fire({
                            title: 'Vendor Added Successfully',
                            icon: 'success',
                            timer: 2000,
                            showConfirmButton: false
                        });
                        searchAddVendor();
                        setupImportVendorTable();

                    } else {
                        Swal.fire({
                            title: 'An error occurred while adding items.',
                            icon: 'error',
                            timer: 2000,
                            showConfirmButton: false
                        });
                    }
                }
            };
            xhr.send(formData);
        }
    </script>
    <script>
        function submitCheckedVendorkg11() {
            var vendor_code = document.getElementById("vendor_code").value;
            var vendor_name = document.getElementById("vendor_name").value;
            var vendor_remark = document.getElementById("vendor_remark").value;
            var ref_no = document.getElementById("ref_no").value;
            var form = document.getElementById("myForm");
            var formData = new FormData();
            formData.append("vendor_code", vendor_code);
            formData.append("vendor_name", vendor_name);
            formData.append("vendor_remark", vendor_remark);
            formData.append("ref_no", ref_no);
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "tenderMaster.htm?act=searchVendorForTenderSubmit", true);
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4) {
                    if (xhr.status === 200) {
                        document.getElementById("IteamDetailsDivV").innerHTML = xhr.responseText;
                        setTimeout(() => {
                        setupImportVendorTable();
                            if ($('#AjaxVendorAddTable').length) {
                                const table1 = initTable('#AjaxVendorAddTable');
                            }
//                            searchAddVendor();
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
            xhr.send(formData);
        }
    </script>
    
     <script>
                        function setupImportVendorTable() {
                        if ($('#AjaxVendorTable').length) {
                        initTable('#AjaxVendorTable');
                                $('#select_all').on('change', function () {
                        $('.rowCheckbox').prop('checked', this.checked).trigger('change');
                        });
                                $('#AjaxVendorTable tbody').on('change', '.rowCheckbox', function () {
                        const anyChecked = $('.rowCheckbox:checked').length > 0;
                                $('#deleteSelectedVendor').toggleClass('d-none', !anyChecked).toggleClass('', anyChecked);
                                $('#select_all').prop('checked', $('.rowCheckbox:checked').length === $('.rowCheckbox').length);
                        });
                                $('#deleteSelectedVendor').on('click', function () {
                        var selectedIds = [];
                                $('.rowCheckbox:checked').each(function () {

                        var selectedId = $(this).val();
                                //           alert(selectedId);
                                selectedIds.push(selectedId);
                        });
                                if (selectedIds.length === 0) {
                        return Swal.fire({
                        icon: 'warning',
                                title: 'No Selection',
                                text: 'Please select at least one row to delete.'
                        });
                        }

                        const msg = selectedIds.length === 1
                                ? 'Are you sure you want to remove selected vendor?'
                                : `Are you sure you want to delete these ${selectedIds.length} Vendors?`;
                                const confirmText = selectedIds.length === 1
                                ? 'Yes, delete it!'
                                : 'Yes, delete them!';
                                Swal.fire({
                                title: msg,
                                        text: 'You will not be able to recover these records!',
                                        icon: 'warning',
                                        showCancelButton: true,
                                        confirmButtonText: confirmText,
                                        cancelButtonText: 'No, cancel',
                                        reverseButtons: true,
                                        customClass: {
                                        confirmButton: 'confirm-delete',
                                                cancelButton: 'theme-btn light-btn'
                                        },
                                }).then((result) => {
                        if (result.isConfirmed) {
                        $.ajax({
                        url: 'tenderMaster.htm?act=deleteVendorForTender&ref_no=${ref_no}&Ids=' + selectedIds.join(','),
                                type: 'POST',
                                data: JSON.stringify({ ids: selectedIds }),
                                contentType: 'application/json',
                                success: function (response) {
                                Swal.fire({
                                icon: 'success',
                                        title: 'Deleted!',
                                        text: response.message
                                });
                                $('#deleteSelectedVendor').addClass('d-none');
                                
                                        $('#AjaxVendorTable')
                                        .DataTable()
                                        .rows(function (idx, data, node) {
                                        return $(node).find('.rowCheckbox').is(':checked');
                                        })
                                        .remove()
                                        .draw();
                                        loadAddServiceDocument();
                                },
                                error: function (xhr) {
                                Swal.fire({
                                icon: 'error',
                                        title: 'Error!',
                                        text: 'Error deleting records: ' + xhr.responseText
                                });
                                }
                        });
                        }
                        });
                        });
                        }
                        }
    </script> 
    
    <div class="modal fade" id="technicalCommitteeUpload" data-backdrop="static" data-keyboard="false"
                        tabindex="-1" aria-labelledby="technicalCommitteeUploadLabel" aria-hidden="true">
                        <div class="modal-dialog modal-sm">
                            <div class="modal-content">

                                <div class="modal-header align-items-center">
                                    <h5 class="modal-title" id="technicalCommitteeUploadLabel">Technical Committee Member :</h5>
                                    <div class="cta-btn d-flex align-items-center">
                                        <button type="button" class="btn theme-btn light-btn" onclick="showuser3(id);"
                                            data-dismiss="modal">Close</button>
                                        <button type="button" class="btn theme-btn ml-3"
                                            id="SubmitTechnicalCommBtn">Add</button>
                                    </div>
                                </div>
                                <div class="modal-body pb-1">
                                    <input type="hidden" id="policyCount" value="1" />
                                    <div class="row title-row">
                                        <div class="col-md-12 px-3 pt-1 pb-2 fs-13">Technical Committee Member</div>
                                    </div>
                                    <div class="target-block1 px-3">
                                        <div class="row main-row" id="addmoreFile13">
                                            <select id="techUserSelect" class="select-input">
                                                <option value="">--SELECT--</option>
                                                <c:forEach var="list" items="${list}" varStatus="status">
                                                    <option value="${list.id}">${list.approvalName}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                            <br id="brs">
                                </div>
                                <div id="techCommDiv" class="bg-white ">
 <script>
                                        $('#technicalCommitteeUpload').on('show.bs.modal', function () {
                                            document.getElementById('bid_type').value = 2;
                                        });

                                        document.getElementById('SubmitTechnicalCommBtn').addEventListener('click', function () {
                                            var form = document.getElementById('myForm');
                                            document.getElementById('committee_user_id').value = document.getElementById('techUserSelect').value;
                                            var formData = new FormData(form);
                                            var ref_no = document.getElementById("ref_no").value;
                                            var tenderPhase = document.getElementById("tenderPhase").value;
                                            var xhr = new XMLHttpRequest();
                                            xhr.open('POST', 'tenderMaster.htm?act=searchUserForCommitteeList', true);
                                            xhr.onload = function () {
                                                if (xhr.status === 200) {
                                                    document.getElementById('techCommDiv').innerHTML = xhr.responseText;
                                                    console.log("form", formData);
                                                    Swal.fire({
                                                        icon: 'success',
                                                        title: 'Technical Committee  Member Added Successfully',
                                                        timer: 2000,
                                                        showConfirmButton: false
                                                    });
                                                    initResultContentTech();
                                                    $('#brs').addClass('d-none');
                                                } else {
                                                    console.error("Error occurred: " + xhr.statusText);
                                                }
                                            };
                                            xhr.onerror = function () {
                                                console.error("Request failed.");
                                            };
                                            xhr.send(formData);
                                        });

                                        function initResultContentTech() {
                                            setupAjaxTechComitteTable();
                                        }
                                    </script>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
        
         <script>
            function setupAjaxTechComitteTable() {
                if ($('#AjaxTechComitteTable').length) {
                    initTable('#AjaxTechComitteTable');
                }
            }
        </script>
                             </form:form>
                      
          <div class="modal fade" id="PriceDocsUpload" data-backdrop="static" data-keyboard="false"
                        tabindex="-1" aria-labelledby="PriceDocsUploadLabel" aria-hidden="true">
                        <div class="modal-dialog modal-sm">
                            <div class="modal-content">

                                <div class="modal-header align-items-center">
                                    <h5 class="modal-title" id="PriceDocsUploadLabel">Add Price Committee Member :</h5>
                                    <div class="cta-btn d-flex align-items-center">
                                        <button type="button" class="btn theme-btn light-btn" onclick="showuser4(id);"
                                            data-dismiss="modal">Close</button>
                                        <button type="button" class="btn theme-btn ml-3"
                                            id="uploadSubmitBtn0">Add</button>
                                    </div>
                                </div>
                                <div class="modal-body pb-1">
                                    <input type="hidden" id="policyCount" value="1" />
                                    <div class="row title-row">
                                        <div class="col-md-12 px-3 pt-1 pb-2 fs-13">Price Committee Member</div>
                                    </div>
                                    <div class="target-block1 px-3">
                                        <div class="row main-row" id="addmoreFile12">
                                            <select id="priceUserSelect" class="select-input">
                                                <option value="">--SELECT--</option>
                                                <c:forEach var="list" items="${list}" varStatus="status">
                                                    <option value="${list.id}">${list.approvalName}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                            <br id="br">
                                </div>
                                <div id="resultDiv" class="bg-white ">

                                    <script>
                                         $('#PriceDocsUpload').on('show.bs.modal', function () {
                                            document.getElementById('bid_type').value = 1;
                                        });
                                        document.getElementById('uploadSubmitBtn0').addEventListener('click', function () {
                                            var form = document.getElementById('myForm');
                                            document.getElementById('committee_user_id').value = document.getElementById('priceUserSelect').value;
                                            var formData = new FormData(form);
                                            var ref_no = document.getElementById("ref_no").value;
                                            var tenderPhase = document.getElementById("tenderPhase").value;
                                            var xhr = new XMLHttpRequest();
                                            xhr.open('POST', 'tenderMaster.htm?act=searchUserForCommitteeList', true);
                                            xhr.onload = function () {
                                                if (xhr.status === 200) {
                                                    document.getElementById('resultDiv').innerHTML = xhr.responseText;
                                                    console.log("form", formData);
                                                    Swal.fire({
                                                        icon: 'success',
                                                        title: 'Price Committee Member Added Successfully',
                                                        timer: 2000,
                                                        showConfirmButton: false
                                                    });
                                                    initResultContent();
                                                    $('#br').addClass('d-none');
                                                } else {
                                                    console.error("Error occurred: " + xhr.statusText);
                                                }
                                            };
                                            xhr.onerror = function () {
                                                console.error("Request failed.");
                                            };
                                            xhr.send(formData);
                                        });

                                        function initResultContent() {
                                            setupAjaxPriceComitteTable();
                                        }                                      

                                    </script>
                                </div>
                            </div>
                        </div>
                    </div>
 <script>
            function setupAjaxPriceComitteTable() {
                if ($('#AjaxPriceComitteTable').length) {
                    initTable('#AjaxPriceComitteTable');
                }
            }
        </script>  
        
        
        <div class="modal fade" id="vendorQueryUpload" data-backdrop="static" data-keyboard="false"
                         tabindex="-1" aria-labelledby="vendorQueryUploadLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">

                                <div class="modal-header align-items-center">
                                    <h5 class="modal-title" id="vendorQueryUploadLabel">Vendor Communication
                                    </h5>
                                    <div class="cta-btn d-flex align-items-center">
                                        <button type="button" class="btn theme-btn light-btn" onclick=""
                                                data-dismiss="modal">Close</button>
                                        
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
                if ($('#vendorQueryTable').length) {
                    initTable('#vendorQueryTable');
                }
            }
            
                function requestDocvendorQueryTab() {
                const formData = new FormData();                        
                        const queryParams = new URLSearchParams(formData).toString();
                        const xhr = new XMLHttpRequest();
                        xhr.onreadystatechange = function () {
                        if (xhr.readyState === 4 && xhr.status === 200) {
                        const resultDiv = document.getElementById("vendorQueryDivs");
                                if (resultDiv) {
                        resultDiv.innerHTML = xhr.responseText;
                                initResultContent();
                                setTimeout(() => {
                                    
                                }, 100);
                        } else {
                        console.error("Element with ID 'vendorQueryDivs' not found.");
                        }
                        }
                        };
                     
                        xhr.open("GET", "vendor.htm?act=tenderAdminCommunication&tender_no=${refNo}", true);
                        xhr.send();
                        function initResultContent() {
                        setupImportVendorQueryTable();
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
        "vendor.htm?act=tenderAdminCommunicationView&id=" + encodeURIComponent(id) +
        "&tender_no=" + encodeURIComponent(tenderNo),
        true
    );

    xhr.send();
    
}


</script>

    <script>
        //                                        if ($("#policyTable").length) {
        //                                            const table1 = initDocTable("#policyTable");
        //                                        }
//        window.onload = function () {
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
//        }
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
        xhr.open('POST', 'vendor.htm?act=tenderAdminCommunicationReply', true);




                 xhr.onreadystatechange = function () {
                if (xhr.readyState === 4) {
                    if (xhr.status === 200) {
                        document.getElementById("vendorQueryReplyFinalDivs").innerHTML = xhr.responseText;
                        setTimeout(() => {
                            setupImportVendorTable();
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
        xhr.open('POST', 'vendor.htm?act=tenderAdminCommunicationSubmit', true);

                 xhr.onreadystatechange = function () {
                if (xhr.readyState === 4) {
                    if (xhr.status === 200) {
                        document.getElementById("vendorQueryReplyFinalDivs").innerHTML = xhr.responseText;
                        setTimeout(() => {
//                            setupImportVendorTable();
                             
                            $('#vendorQueryUploadReplyNext').modal('hide');          // close current modal (if any)
                            $('#vendorQueryUploadReply').modal('hide');          // close current modal (if any)
                            $('#vendorQueryUpload').modal('show');      // open new modal
//                               if ($('#vendorQueryTable').length) {
//                                 initTable('#vendorQueryTable');
//                              }
                            
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
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
