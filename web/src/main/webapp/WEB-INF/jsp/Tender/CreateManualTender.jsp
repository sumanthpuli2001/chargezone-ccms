
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CREATE TENDER</title>
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
            function initResultContentTech(selector, obj = {}) {
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
<!--    <body>-->

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="tenderMaster.htm?act=submitServiceManualTenderMaster" id="tenderForm"  method="post" enctype="multipart/form-data" commandName="tenderMaster"
                           name="form"   class="form-horizontal" role="form">           
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0"> CREATE TENDER- ${tenderPhase} Part Tender Information  </h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                            <!--<button type="submit" class="btn theme-btn" onclick="return handleSubmit(event)">Submit</button>-->
                        </div>
                    </div>
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
                    <input type="hidden" name="tenderPhase" id="tenderPhase" value="${tenderPhase}">
                    <input type="hidden" name="tender_no" id="tender_no" value="${ref_no}">
                    <hr>
                    <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <strong>Note:</strong> Ensure your file size is within <strong>5MB</strong> for a smooth upload. <br>
                            <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.
                        </div>
                    </div>

                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label"> Item Category <span class="text-danger">*</span></label>
                                    <input type="text" name="type" id="type" class="input-field" value="${pr_type}" onchange="changeType()" readonly>                                                                   
                                </div>
                            </div>
                                
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label">Tender Reference No</label>

                                    <form:input path="refNo" id="refNo" class="input-field" value="${refNo}" pattern="[0-9]+" onkeypress="return (event.charCode !=8 && event.charCode ==0 || (event.charCode >= 48 && event.charCode <= 57))"  maxlength="30" readonly="true"/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label"> Project Name<span
                                            class="text-danger">*</span></label>
                                    <form:input path="title" class="input-field" value="${prMaster.title}" readonly="true" maxlength="240" required="required"/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label"> Project ID<span
                                            class="text-danger">*</span></label>
                                    <form:input path="projectId" class="input-field" value="${prMaster.projectId}" readonly="true" maxlength="240" required="required"/>
                                </div>
                            </div>
                            <c:if test="${omsMaster != null}">
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
                            </c:if>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label"> Tender classification</label>

                                    <form:input path="categoryId" class="input-field"  value="${prMaster.categoryId}" readonly="true"  maxlength="30" />
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label">Estimate Cost With GST</label>

                                    <input type="text" name="value" class="input-field" value="${prMaster.value}" pattern="[0-9]+" onkeypress="return (event.charCode != 8 && event.charCode == 0 || (event.charCode >= 48 && event.charCode <= 57))"  maxlength="30" readonly="true"/>
                                </div>
                            </div>
                            <input type="hidden" name="docCost" class="input-field"  value="0" pattern="[0-9]+" onkeypress="return (event.charCode != 8 && event.charCode == 0 || (event.charCode >= 48 && event.charCode <= 57))" maxlength="30" required="required"/>
                            <input type="hidden" name="emd" class="input-field" value="0" pattern="[0-9]+" onkeypress="return (event.charCode != 8 && event.charCode == 0 || (event.charCode >= 48 && event.charCode <= 57))"  maxlength="30" required="required"/>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label">Business Type </label>

                                    <input type="text" name="business_type" class="input-field"  value="${prMaster.businessType}" readonly="true" />
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label">Project Type </label>

                                    <input type="text" name="project_type" class="input-field" value="${prMaster.projectType}" readonly="true"/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label">Tender Date  </label>

                                    <form:input path="announceDate" class="input-field" value="${formattedDate}"  maxlength="30" required="required" readonly="true"/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label">Tender Due Date<span class="text-danger">*</span>  </label>

                                    <div class='input-group date' id='datetimepicker1'>
                                        <input type="text"  id="submitLastdate"class="input-field form_datetime" name="submitLastdate"value="${submitLastdate}" placeholder="dd-mm-yyyy --:--"required/>
                                    </div>


                                    <input type="hidden" name="quotes" id="quotes" value="${prMaster.quotes}" class="input-field" maxlength="200" readonly="true" />

                                    <script>
                                        $(document).ready(function () {

                                            flatpickr("#submitLastdate", {
                                                enableTime: true,
                                                enableSeconds: true,
                                                dateFormat: "d-m-Y H:i:S",
                                                minDate: "today",
                                                allowInput: true
                                            });

                                            $('#tenderForm').submit(function (event) {

                                                var quotesValue = parseInt($('#quotes').val(), 10);

                                                if (quotesValue >= 3) {

                                                    var dateValue = $('#submitLastdate').val();

                                                    if (!dateValue) {
                                                        alert("Please select Tender Due Date.");
                                                        event.preventDefault();
                                                        return;
                                                    }

                                                }

                                            });

                                        });
                                        </script>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label">  PR No </label>

                                    <form:input path="prNo" class="input-field"  value="${pr_no}" readonly="true" required="required"/>
                                </div>
                            </div>
                            <input type="hidden" name="prItemNo" class="input-field" value="" />
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label"> Minimum Quotes Required </label>

                                    <input type="text" name="quotes" id="quotes" value="${prMaster.quotes}" class="input-field"   maxlength="200" readonly="true"/>
                                </div>
                            </div>
                            <div class="col-lg-12 col-md-6">
                                <div class="form-group comment-box">
                                    <label class="control-label"> Tender Subject Description</label>
                                    <textarea class="textarea-field comment" name="workDesc" readonly="readonly"maxlength="200"><c:out value="${prMaster.workDesc}" /></textarea>
                                </div>
                            </div>  

                        </div>
                    </div>
                    <c:if test="${prMaster.singleQuoteFlag== 1}">
                        <h5 class="fw-600">Single Quote Attachment </h5>
                        <table id="commonDocTable" class="table table-striped bg-white dt-scroll" style="min-width: 100%" align="center">
                            <thead>
                                <tr>
                                    <th>Attachment:</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <a class="fw-600 text-break gradient-text" href="prMaster.htm?act=downloadPrSingleQuoteAttachment&prNo=${prMaster.prNo}&id=${prMaster.id}&page=viewapprovePR">
                                            ${prMaster.singleQuoteAttachment}
                                        </a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </c:if>


                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label">Terms Condition<span
                                            class="text-danger">*</span></label>

                                    <select class="select-input" id="termsCondition" name="termsCondition" required="true">
                                        <option value="">--select--</option>
                                        <c:forEach var="termsCondition" items="${termsCondition}">
                                            <option value="${termsCondition.name}">${termsCondition.name}</option>
                                        </c:forEach>
                                    </select>                            </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label">Billing Location<span
                                            class="text-danger">*</span></label>

                                    <input type="text" name="location" id="location" value="${prMaster.billingLocation}" class="input-field"  readonly="true" maxlength="200" required="required"/>
                                </div>
                            </div>
                        </div>
                    </div>          

                    <div class="form-group">
                        <div class="col-sm-3">
                            <input type="hidden" name="gst" id="gst" value="${prMaster.plant}" class="input-field"   maxlength="200" readonly="true"/>
                        </div> 
                        <div class="col-sm-3">
                            <input type="hidden" name="gst" id="gst" value="${prMaster.locationName}" class="input-field"   maxlength="200" readonly="true"/>
                        </div> 

                    </div> 
                    <h5 class="fw-600">Site Address</h5>


                    <table id="commonTable3" class="table  table-striped bg-white" style="min-width: 100%" align="Center"  >

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
                            <c:forEach var="list6" items="${list6}" varStatus="status">
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

                    <h5 class="fw-600">Tender Contact Person</h5>

                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label"> Created By </label>

                                    <form:input path="contactPerson" class="input-field" value="${employee_name}"  maxlength="30" readonly="true"/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label"> Contact Number  </label>

                                    <form:input path="tenderAdminContactNumber" class="input-field" value="${ph_no}"  maxlength="30" readonly="true"/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label"> User Name </label>

                                    <form:input path="endUserName" value="${prMaster.prAdmin}" class="input-field" readonly="true"  maxlength="130" />
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label"> User Contact No.</label>

                                    <form:input path="endUserNumber" value="${prMaster.prAdminContactNumber}" readonly="true" class="input-field"  maxlength="30" />
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label">Technical Person Name</label>

                                    <input type="text" name="technical_contact_name" value="${prMaster.technicalContactName}" readonly="true" id="contactPerson" class="input-field"  />
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label">Technical Person Contact Number</label>

                                    <input type="text" name="technical_contact_no" value="${prMaster.technicalContactNo}" readonly="true" id="contactPersonNumber" class="input-field" />
                                </div>
                            </div>
                                <div class="col-lg-4 col-md-6">
                                    <div class="form-group">
                                        <label  class="label">Name of Location Partner</label>

                                        <input type="text" name="nameofLocationPartner" id="nameofLocationPartner" class="input-field" readonly="true" value="${prMaster.nameofLocationPartner}"  maxlength="30" />
                                    </div>
                                </div>
                                    <div class="col-lg-4 col-md-6">
                                    <div class="form-group">
                                        <label  class="label">Mobile No Location Partner</label>

                                        <input type="text" name="mobileNoLocationPartner" id="mobileNoLocationPartner" class="input-field" readonly="true" value="${prMaster.mobileNoLocationPartner}"  maxlength="30" />
                                    </div>
                                </div>


                        </div>
                    </div>


                    <h5 class="fw-600">Tender Terms & Condition</h5>          
                    <script>
                        function changeplant()
                        {
                            var plant_location = document.form.plant.value;
                            const myArray = plant_location.split("::");
                            // alert("");
                            document.form.deliveryLocation.value = myArray[1];
                            document.form.plant_name.value = myArray[0];
                        }
                    </script>         

                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label"> Delivery Period</label>

                                    <form:input path="deliveryPeriod" class="input-field"  value="${prMaster.deliveryPeriod}" readonly="true" maxlength="200" required="required"/>
                                </div>
                            </div>         
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label"> Terms Of Payment</label>

                                    <select name="termsOfPayment" class="select-input">
                                        <c:forEach var="locationMaster" items="${locationMaster}" varStatus="status1">
                                            <option value="${locationMaster.locationName}">${locationMaster.locationName}</option>
                                        </c:forEach>


                                    </select>                               
                                </div>
                            </div>         
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label"> Mode Of Transport</label>

                                    <select name="modeOfTransport" class="select-input">
                                        <option value="Road">Road</option>
                                        <option value="Rail">Rail</option>
                                        <option value="Air">Air</option>
                                        <option value="Sea">Sea</option>
                                    </select>                              
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label"> Mode Of Transport</label>

                                    <select name="incoTerms" class="select-input">
                                        <option value="FOR">FOR</option>
                                        <option value="CIF">CIF</option>
                                        <option value="ExWork">ExWork</option>
                                        <option value="FOB">FOB</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                                
                                
                                
                        <div>
                                        <c:if test="${pr_type == 'Contract Civil'}">
                                            <h5 class="fw-600">Civil Details</h5>
                                        </c:if>
                                        <c:if test="${pr_type != 'Contract Civil'}">
                                            <c:if test="${pr_type == 'Service'}">
                                                <h5 class="fw-600">Items Details For Service </h5>
                                            </c:if>
                                            <c:if test="${pr_type != 'Service'}">
                                                 <h5 class="fw-600">Item Details</h5>
                                            </c:if>
                                        </c:if>

                                    </div> 


                                    <script type="text/javascript">
                                            //document.getElementById("contracts").style.display = "none";

                                            //  var win2 = window.open("tenderMaster.htm?act=addServiceDocument");
                                            //  win2.close();
                                            var str5 = document.getElementById("tender_no").value;
                                            var ID1;
                                            function showuser1(str1)
                                            {
                                                str1 = document.getElementById("tender_no").value;
                                                //var str5=str1;
                                                //  alert(str1);
                                                //if(win2 && win2.closed ){
                                                var xreq1;
                                                if (str1 === "")
                                                {
                                                    document.getElementById("showtext1").innerHTML = "";
                                                    return;
                                                }

                                                try {
                                                    xreq1 = new XMLHttpRequest();// Firefox, Opera 8.0+, Safari
                                                } catch (e) {
                                                    try {
                                                        xreq1 = new ActiveXObject("Msxml2.XMLHTTP"); // Internet Explorer
                                                    } catch (e) {
                                                        try {
                                                            xreq1 = new ActiveXObject("Microsoft.XMLHTTP");
                                                        } catch (e) {
                                                            alert("No AJAX!?");
                                                            return false;
                                                        }
                                                    }
                                                }

                                                xreq1.onreadystatechange = function ()
                                                {
                                                    if (xreq1.readyState == 4 && xreq1.status == 200)
                                                    {

                                                        document.getElementById("showtext1").innerHTML = xreq1.responseText;
                                                        setTimeout(() => {
                                                        if ($('#IteamTable').length) {
                                                        const table1 = initNoPageTable('#IteamTable');
                                                       }
                                                     }, 100);
                                                    }
                                                }

                                                xreq1.open("get", "tenderMaster.htm?act=agaxTenderItemDetails&q=" + str5, true);
                                                xreq1.send();

                                                //}
                                                window.clearInterval(ID1);
                                            }
                                            ID1 = window.setInterval(showuser1(str5), 1000);
                                    </script>


                                    <div id="showtext1"></div>
                                    
                                    



                                    <div id="contracts" style="display: none;">


                                       
                                            <c:if test="${pr_type == 'Contract' || pr_type == 'Contract Civil' || pr_type == 'Contract Electrical'}">

                                                <c:if test="${pr_type == 'Contract Civil'}">
                                                    <h5 class="fw-600">Steel Details</h5>
                                                </c:if>
                                                <c:if test="${pr_type != 'Contract Civil'}"> 
                                                    <h5 class="fw-600">Item Details For Service</h5> 
                                                </c:if>
                                                        
                                                <hr>



                                        <script type="text/javascript">


                                            //  var win2 = window.open("tenderMaster.htm?act=addServiceDocument");
                                            //  win2.close();
                                            var str5 = document.getElementById("tender_no").value;
                                            var ID1;
                                            function showuser11(str1)
                                            {
                                                str1 = document.getElementById("tender_no").value;
                                                //var str5=str1;
                                                //  alert(str1);
                                                //if(win2 && win2.closed ){
                                                var xreq1;
                                                if (str1 === "")
                                                {
                                                    document.getElementById("showtext1").innerHTML = "";
                                                    return;
                                                }

                                                try {
                                                    xreq1 = new XMLHttpRequest();// Firefox, Opera 8.0+, Safari
                                                } catch (e) {
                                                    try {
                                                        xreq1 = new ActiveXObject("Msxml2.XMLHTTP"); // Internet Explorer
                                                    } catch (e) {
                                                        try {
                                                            xreq1 = new ActiveXObject("Microsoft.XMLHTTP");
                                                        } catch (e) {
                                                            alert("No AJAX!?");
                                                            return false;
                                                        }
                                                    }
                                                }

                                                xreq1.onreadystatechange = function ()
                                                {
                                                    if (xreq1.readyState == 4 && xreq1.status == 200)
                                                    {

                                                        document.getElementById("showtext11").innerHTML = xreq1.responseText;
                                                        setTimeout(() => {
                                                        if ($('#IteamsTables').length) {
                                                        const table1 = initNoPageTable('#IteamsTables');
                                                       }
                                                     }, 100);
                                                    }
                                                }

                                                xreq1.open("Get", "tenderMaster.htm?act=agaxTenderItemDetails1&q=" + str5, true);
                                                xreq1.send();

                                                //}
                                                window.clearInterval(ID1);
                                            }
                                            ID1 = window.setInterval(showuser11(str5), 1000);
                                        </script>


                                        <div id="showtext11"></div>                                    

                                   
                                      </c:if>                                
                                          </div> 
                                    <br>
                                    <script type="text/javascript">
                                        changeType();

                                        function changeType()
                                        {
                                            var tender_type = document.getElementById("type").value;
//                                            alert(tender_type)

                                            if (tender_type == 'Contract' || tender_type == 'Contract Civil' || tender_type == 'Contract Electrical')
                                            {
                                                document.getElementById("contracts").style.display = "block";
                                            }
                                            else
                                            {
                                                document.getElementById("contracts").style.display = "none";
                                            }
                                        }
                                    </script>
                          
                                    <h5 class="fw-600">  Tender Attachment </h5>
                                    <hr>

                                    <h6 class="fw-600">PR Document</h6>
                                    <table id="commonTable" class="table  table-striped bg-white" style="width: 100%" align="Center"  >

                                        <thead>
                                            <tr>
                                                <th>Sr. No.</th>
                                                <th>Title</th>
                                                <th>Document</th>

                                            </tr>
                                        </thead>
                                        <c:set var="count" value="0" scope="page" />
                                        <tbody>

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
                                <h6 class="fw-600">Commercial Terms & Conditions</h6>
                            </div>

                            <button type="button" class="btn theme-btn d-flex align-items-center" data-toggle="modal"
                                data-target="#generalTermsUpload" onclick="requestDocTechTab();">
                                <img src="StorageYard/assets/images/attachment.svg" class="attachment mr-1 d-inline"
                                    onload="SVGInject(this)" alt="User Image">
                                Attachment
                            </button>
                            
                        </div>
    <script type="text/javascript">
                        //    var win = window.open("tenderMaster.htm?act=searchVendorForManualTender");
                        //    win.close();
                        //win.onunload =showuser;

                        var str7 = document.getElementById("tender_no").value;
                        function showuser5(str) {
                            str = document.getElementById("tender_no").value;
                            //alert("");
                            str7 = str;
                            //if(win && win.closed){
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
                            //}
                            window.clearInterval(ID);
                        }

                        var ID = window.setInterval(showuser5(str7), 1000);
                    </script>
                   
                <div id="showtext5" class="bg-white"></div>
                                    
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
                                        
                                        
                                        <c:if test="${tenderPhase != '1'}">
                                            <h5 class="fw-600">Technical Detail / Specification</h5>
                                            <hr>
                                            <div class="form-group tech-detail">
                                                <label for="technicalDoc">Technical Detail Required From Vendor</label>
                                                <input type="checkbox" id="technicalDoc" name="technicalDoc">
                                            </div>


                                        </c:if>                                                       
                                                                          

                       
              
                          <div class="col-12 p-0">
                    <div class="form-group comment-box">
                        <label class="control-label">Tender Remark </label>
                        <textarea type="text"  class="textarea-field comment" id="remark" name="remark"  >${prMaster.remarks}</textarea>
                      <small id="charCount_remark" style="font-size: 12px; color: green;">250 characters remaining</small>

                    </div>
                </div>      

                                            
                       
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

                                                    updateCounter(); // For pre-filled remarks in edit mode
                                                    textarea.addEventListener("input", updateCounter);
                                                });
                                            </script>
                       
                       
                    <div class="form-group">
                        <div class="content-top mb-3 d-flex align-items-center justify-content-between">
                            <h6 class="fw-600 mr-4 mb-0"> Price Committee Member </h6>
                            <button type="button" class="btn theme-btn d-flex align-items-center" data-toggle="modal"
                                data-target="#PriceDocsUpload">
                                <i class="fa fa-search " style="color: white;"></i>&nbsp;
                                Search
                            </button>
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
                                }
                                else {
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
                                //}
                                window.clearInterval(ID);
                            }

                            var ID = window.setInterval(showuser4(str7), 1000);</script>
                        <div id="showtext4" class="bg-white"></div>
                    </div>     
                       
                       
           <c:if test="${tenderPhase != '1'}">
               
             <div class="form-group">
                        <div class="content-top mb-3 d-flex align-items-center justify-content-between">
                            <h6 class="fw-600 mr-4 mb-0"> Technical Committee Member </h6>
                            <button type="button" class="btn theme-btn d-flex align-items-center" data-toggle="modal"
                                data-target="#technicalCommitteeUpload">
                                <i class="fa fa-search " style="color: white;"></i>&nbsp;
                                Search
                            </button>
                        </div>

                        <script type="text/javascript">

                                            //    var win = window.open("tenderMaster.htm?act=searchVendorForManualTender");
                                            //    win.close();
                                            //win.onunload =showuser;

                                            var str7 = document.getElementById("tender_no").value;
                                            function showuser3(str)
                                            {
                                                str = document.getElementById("tender_no").value;
                                                //alert("");
                                                str7 = str;

                                                //if(win && win.closed){
                                                var xreq, ID;

                                                if (str == "")
                                                {
                                                    document.getElementById("showtext3").innerHTML = "";
                                                    return;
                                                }
                                                if (window.XMLHttpRequest)
                                                {
                                                    xreq = new XMLHttpRequest();
                                                }
                                                else
                                                {
                                                    xreq = new ActiveXObject("Microsoft.XMLHTTP");
                                                }
                                                xreq.onreadystatechange = function ()
                                                {
                                                    if ((xreq.readyState == 4) && (xreq.status == 200))
                                                    {
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

                                                //}
                                                window.clearInterval(ID);
                                            }

                                            var ID = window.setInterval(showuser3(str7), 1000);

                                        </script>

                                        <div id="showtext3"></div> 
                    </div>                            
                                    </c:if>
                                            
                                            
                                            
                        <div class="content-top mb-3 d-flex align-items-center justify-content-between">
                            <div class="form-group">
                                <h6 class="fw-600">Add Vendor</h6>
                            </div>

                            <button type="button" onclick="searchAddVendor()"
                                    class="btn theme-btn d-flex align-items-center"
                                    data-toggle="modal" data-target="#iteamDocsUploadkg11">
                                <i class="fa fa-search " style="color: white;"></i>&nbsp;
                                Search
                            </button>

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
                                xreq.open("get", "tenderMaster.htm?act=agaxTenderVendorDetails&q=" + str11, true);
                                xreq.send();
                                window.clearInterval(ID);
                            }

                            var ID = window.setInterval(showuser11(str11), 1000);
                        </script>

                        <div id="showtext111"></div>                            
                                            
                        <div class="form-group">
                            <div style="display: flex;  justify-content: center;">
                                <button type="submit" class="btn theme-btn" style="width: 180px!important;" id="alertButton" onclick="return handleSubmit(event)"  title="" value="">SUBMIT</button>
                            </div>
                        </div>                       
                </form:form>
                <form:form id="myForm" enctype="multipart/form-data" commandName="prMaster" name="form" class="form-horizontal" role="form">
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
      
                <div class="modal fade" id="iteamDocsUploadkg11" data-backdrop="static"
                     data-keyboard="false" tabindex="-1" aria-labelledby="iteamDocsUploadkg11Label"
                     aria-hidden="true">
                    <div class="modal-dialog modal-xl">
                        <div class="modal-content">

                            <div class="modal-header align-items-center sticky-model">
                                <h5 class="modal-title" id="iteamDocsUploadkg11Label">Vendor Details :</h5>
                                <div class="cta-btn d-flex align-items-center"> 
                                    <button type="button" class="btn theme-btn light-btn" onclick="showuser11(id);" data-dismiss="modal">Close</button>
                                    <button type="button" class="btn theme-btn ml-3" onclick="submitCheckedVendorkg11()" title="">Search</button>
                                    <button type="button" class="btn theme-btn ml-3" onclick="submitCheckedVendor11()" title="">Add</button>                                            
                                </div>
                            </div>
                            <div class="modal-body">
                                <div class="bg-white" id="IteamDetailsDivV">
                                    <!-- Dynamic AJAX vendor search block will load here -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <script type="text/javascript">
                    // Handles cascading changes on Category and Sub Category filters dynamically
                    function initializeVendorFilters() {
                        if (typeof groupHierarchy === 'undefined') {
                            console.error("groupHierarchy is not defined");
                            return;
                        }

                        $('#groupNameFilter').off('change').on('change', function () {
                            var groupName = $(this).val();
                            var categorySelect = $('#groupCategoryFilter');
                            var subCategorySelect = $('#groupSubCategoryFilter');

                            categorySelect.empty().append('<option value="">Select Category</option>');
                            subCategorySelect.empty().append('<option value="">Select Sub Category</option>');

                            if (groupName && groupHierarchy[groupName]) {
                                $.each(groupHierarchy[groupName], function (categoryName) {
                                    categorySelect.append($('<option>', {
                                        value: categoryName,
                                        text: categoryName
                                    }));
                                });
                            }
                        });

                        $('#groupCategoryFilter').off('change').on('change', function () {
                            var groupName = $('#groupNameFilter').val();
                            var categoryName = $(this).val();
                            var subCategorySelect = $('#groupSubCategoryFilter');

                            subCategorySelect.empty().append('<option value="">Select Sub Category</option>');

                            if (groupName && categoryName && groupHierarchy[groupName] && groupHierarchy[groupName][categoryName]) {
                                $.each(groupHierarchy[groupName][categoryName], function (index, subCategoryName) {
                                    subCategorySelect.append($('<option>', {
                                        value: subCategoryName,
                                        text: subCategoryName
                                    }));
                                });
                            }
                        });
                    }

                    function searchAddVendor() {
                        const xhr = new XMLHttpRequest();
                        xhr.onreadystatechange = function () {
                            if (xhr.readyState === 4 && xhr.status === 200) {
                                const resultDiv = document.getElementById("IteamDetailsDivV");
                                if (resultDiv) {
                                    resultDiv.innerHTML = xhr.responseText;
                                    setTimeout(function () {
                                        initializeVendorFilters();
                                        initializeAjaxVendorAddTable();
                                        setupImportVendorTable();
                                    }, 500);
                                }
                            }
                        };
                        xhr.open("GET", "tenderMaster.htm?act=searchVendorToAddInTender&ref_no=${ref_no}", true);
                        xhr.send();
                    }

                    function initializeAjaxVendorAddTable() {
                        console.log("initializeAjaxVendorAddTable Started");

                        if ($("#AjaxVendorAddTable").length === 0) {
                            console.log("AjaxVendorAddTable not found");
                            return;
                        }

                        if ($.fn.DataTable.isDataTable("#AjaxVendorAddTable")) {
                            $("#AjaxVendorAddTable").DataTable().destroy();
                        }

                        var table = $("#AjaxVendorAddTable").DataTable({
                            processing: true,
                            serverSide: true,
                            searching: true,
                            ordering: true,
                            destroy: true,
                            autoWidth: false,
                            scrollX: false,
                            pageLength: 10,
                            lengthChange: false,
                            dom: 't<"table-bottom-info d-flex align-items-center justify-content-between pt-3"ip>',
                            ajax: {
                                url: "vendorInformation.htm?act=activeVendorAjax",
                                type: "POST",
                                data: function (d) {
                                    d.sapCodeFilter = $("#sapCodeFilter").val();
                                    d.companyNameFilter = $("#companyNameFilter").val();
                                    d.vendorEmailIdFilter = $("#vendorEmailIdFilter").val();
                                    d.contactNoFilter = $("#contactNoFilter").val();
                                    d.groupNameFilter = $("#groupNameFilter").val();
                                    d.groupCategoryFilter = $("#groupCategoryFilter").val();
                                    d.groupSubCategoryFilter = $("#groupSubCategoryFilter").val();
                                    d.countryFilter = $("#country").val();
                                    d.stateFilter = $("#state").val();
                                    d.cityFilter = $("#cityFilter").val();
                                    d.gstNoFilter = $("#gstNoFilter").val();
                                    d.panNoFilter = $("#panNoFilter").val();
                                    d.riskCategoryFilter = $("#riskCategoryFilter").val();
                                    d.vendorInviteSourceFilter = $("#vendorInviteSourceFilter").val();
                                    d.invitedByFilter = $("#invitedByFilter").val();
                                    d.activatedDateFilter = $("#activatedDateFilter").val();
                                },
                                error: function (xhr, status, error) {
                                    console.log("datatable error", error);
                                }
                            },
                            columns: [
                                {
                                    data: "vendorEmailId",
                                    orderable: false,
                                    searchable: false,
                                    render: function (data) {
                                        return '<input type="checkbox" name="checkedId" class="vendorCheckbox" value="' + data + '">';
                                    }
                                },
                                {data: "sapCodeButton"},
                                {data: "companyName"},
                                {data: "vendorEmailId"},
                                {data: "contactNo"},
                                {data: "groupName"},
                                {data: "groupCategoryName"},
                                {data: "groupSubCategoryName"},
                                {data: "countryName"},
                                {data: "stateName"},
                                {data: "cityName"},
                                {data: "gstinNo"},
                                {data: "panNo"},
                                {data: "riskCategory"},
                                {data: "vendorInviteSource"},
                                {data: "invitedBy"},
                                {data: "vendorActivatedDate"}
                            ]
                        });                        

                        $("#sapCodeFilter,#companyNameFilter,#vendorEmailIdFilter,#contactNoFilter,#groupNameFilter,#groupCategoryFilter,#groupSubCategoryFilter,#country,#state,#cityFilter,#gstNoFilter,#panNoFilter,#riskCategoryFilter,#vendorInviteSourceFilter,#invitedByFilter,#activatedDateFilter")
                            .off("keyup change")
                            .on("keyup change", function () {
                                table.ajax.reload();
                        });                        

                        $(document).off("change", "#selectAllVendor");
                        $(document).on("change", "#selectAllVendor", function () {
                            $(".vendorCheckbox").prop("checked", this.checked);
                        });
                        var $bottomInfo = $('#AjaxVendorAddTable_wrapper > .table-bottom-info');
                        $('.table-responsive').after($bottomInfo);
                    }

                    function submitCheckedVendorkg11() {
                        var vendor_code = document.getElementById("vendor_code").value;
                        var vendor_name = document.getElementById("vendor_name").value;
                        var vendor_remark = document.getElementById("vendor_remark").value;
                        var ref_no = document.getElementById("ref_no").value;

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
                                    setTimeout(function () {
                                        initializeVendorFilters();
                                        initializeAjaxVendorAddTable();
                                        setupImportVendorTable();
                                    }, 500);
                                }
                            }
                        };
                        xhr.send(formData);
                    }
                </script>

                <script>
                    function toggleAllCheckboxes11() {
                        var materialCheck = document.getElementById("vendorId");
                        var checkboxes = document.getElementsByName("checkedId");
                        for (var i = 0; i < checkboxes.length; i++) {
                            checkboxes[i].checked = materialCheck.checked;
                        }
                    }

                    function submitCheckedVendor11() {
                        var ref_no = document.getElementById("tender_no").value;
                        var selectedVendors = [];

                        $(".vendorCheckbox:checked").each(function () {
                            selectedVendors.push($(this).val());
                        });

                        console.log("Selected Vendors =", selectedVendors);

                        if (selectedVendors.length === 0) {
                            Swal.fire({
                                title: 'Select at least one Vendor.',
                                icon: 'warning',
                                timer: 2000,
                                showConfirmButton: false
                            });
                            return false;
                        }

                        var formData = new FormData();
                        formData.append("ref_no", ref_no);
                        $.each(selectedVendors, function (index, value) {
                            formData.append("checkedId", value);
                        });

                        var xhr = new XMLHttpRequest();
                        xhr.open("POST", "tenderMaster.htm?act=addVendorForTender", true);
                        xhr.onreadystatechange = function () {
                            if (xhr.readyState === 4) {
                                if (xhr.status === 200) {
                                    document.getElementById("IteamDetailsDivV").innerHTML = xhr.responseText;
                                    Swal.fire({
                                        title: 'Vendor Added Successfully',
                                        icon: 'success',
                                        timer: 2000,
                                        showConfirmButton: false
                                    });
                                    setTimeout(function () {
                                        searchAddVendor();
                                    }, 300);
                                } else {
                                    Swal.fire({
                                        title: 'An error occurred while adding vendors.',
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
                            initTable('#SearchVendorTable');
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
                                    selectedIds.push(selectedId);
                                });
                                if (selectedIds.length === 0) {
                                    return Swal.fire({
                                        icon: 'warning',
                                        title: 'No Selection',
                                        text: 'Please select at least one row to delete.'
                                    });
                                }

                                // Fixed trailing extra quote and JSP expression parser clash
                                const msg = selectedIds.length === 1 
                                    ? 'Are you sure you want to remove selected vendor?' 
                                    : 'Are you sure you want to delete these ' + selectedIds.length + ' Vendors?';

                                const confirmText = selectedIds.length === 1 ? 'Yes, delete it!' : 'Yes, delete them!';
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


   
        
          </form:form>                           
                 
            </section>
        </main>
    <!--</body>-->
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
    <tbody onload="changeType()">
        
    </tbody>
      <script language="javascript" type="text/javascript">

//alert("");

            function gettender()
            {

                var t = document.getElementById("refNo").value;
                var tenderPhase = document.getElementById("tenderPhase").value;
                window.location = 'tenderMaster.htm?act=getTender&refNo=' + t + '&tenderPhase=' + tenderPhase;
            }

            var tempCount3 = 1;
            function Policy()
            {

                tempCount3++;
                var clone = "<tr id='addmoreFile" + tempCount3 + "' style='clear:both;'>"
                        + ""
                        + "<td style=\"text-align: center\"><input type=\"file\" name='generalfile" + tempCount3 + "' id='generalfile" + tempCount3 + "'</td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\"value=\"-\"  onclick=\"removePolicy('addmoreFile" + tempCount3 + "');\"/>"
                        + "</span>"
                        + "</td>"
                        + "</tr>";
                $("#policyTable").append(clone);
                document.getElementById('policyCount').value = tempCount3;
                addAPolicy(tempCount3);
            }

            function removePolicy(policyDiv) {

                try {
                    var currentMinusName = policyDiv;
                    element1 = document.getElementById(policyDiv);
                    element1.parentNode.removeChild(element1);
                } catch (e) {

                }
            }


            var tempCount31 = 1;
            function Policy1()
            {

                tempCount31++;
                var clone = "<tr id='addmoreFile" + tempCount31 + "' style='clear:both;'>"
                        + ""
                        + "<td style=\"text-align: center\"><input type=\"file\" name='additionalfile" + tempCount31 + "' id='additionalfile" + tempCount31 + "'</td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\"value=\"-\"  onclick=\"removePolicy1('addmoreFile" + tempCount31 + "');\"/>"
                        + "</span>"
                        + "</td>"
                        + "</tr>";
                $("#policyTable1").append(clone);
                document.getElementById('policyCount1').value = tempCount31;
                addAPolicy(tempCount31);
            }

            function removePolicy1(policyDiv) {

                try {
                    var currentMinusName = policyDiv;
                    element1 = document.getElementById(policyDiv);
                    element1.parentNode.removeChild(element1);
                } catch (e) {

                }
            }

            var tempCount32 = 1;
            function Policy2()
            {

                tempCount32++;
                var clone = "<tr id='addmoreFile" + tempCount32 + "' style='clear:both;'>"
                        + ""
                        + "<td style=\"text-align: center\"><input type=\"file\" name='technicalfile" + tempCount32 + "' id='technicalfile" + tempCount32 + "'</td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\"value=\"-\"  onclick=\"removePolicy2('addmoreFile" + tempCount32 + "');\"/>"
                        + "</span>"
                        + "</td>"
                        + "</tr>";
                $("#policyTable2").append(clone);
                document.getElementById('policyCount2').value = tempCount32;
                addAPolicy(tempCount32);
            }

            function removePolicy2(policyDiv) {

                try {
                    var currentMinusName = policyDiv;
                    element1 = document.getElementById(policyDiv);
                    element1.parentNode.removeChild(element1);
                } catch (e) {

                }
            }

            function updatedata(str) {
                var ss = "";
                //var ss=form["vendor_em"].value;
                if (typeof XMLHttpRequest != "undefined") {
                    xmlHttp = new XMLHttpRequest();
                }
                else if (window.ActiveXObject) {
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
                if (xmlHttp == null) {
                    alert("Browser does not support XMLHTTP Request")
                    return;
                }

                var url = "tenderMaster.htm?act=updateVendor";
                url += "&tender_no=" + str + "&str1=" + ss;
                alert(str);
                xmlHttp.onreadystatechange = stateChange2;
                alert(str);
                xmlHttp.open("GET", url, true);
                alert(str);
                xmlHttp.send(null);
                alert(str);
                //stateChange1();
            }

            function stateChange2()
            {
                if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete")
                {
                    var a = xmlHttp.responseText;

                    var c = a.split("*");
                    var b = c[0].split("$");
                    var d = c[1].split("$");

                    if (b.length == 2)
                    {
                        form["vendor_email_id"].value = b[0];
                    }
                    else
                    {
                        for (var i = 0; i < b.length - 1; i++)
                        {
                            form["vendor_email_id"][i].value = b[i];
                        }
                    }

                    if (d.length == 2)
                    {
                        form["vendor_mob_no"].value = d[0];
                    }
                    else
                    {
                        for (var i = 0; i < d.length - 1; i++)
                        {
                            form["vendor_mob_no"][i].value = d[i];
                        }
                    }
                }
            }


        </script>
        
        <script>
function handleSubmit(event) {
  
    let tenderVendorcount = document.getElementById("tenderVendorcount").value.trim();
//    alert(tenderVendorcount)
    let tenderCommitteecount = document.getElementById("tenderCommitteecount").value.trim();
// alert(tenderCommitteecount)
    if (tenderVendorcount === "" || Number(tenderVendorcount) === 0) {
        Swal.fire({
            icon: 'warning',
            title: 'Missing Items',
            text: 'Please add Vendor Details'
        });
        return false;
    }
    
    var bid_type = parseInt("${tenderPhase}", 10);
// alert(bid_type)
    if (bid_type === 1 || bid_type === 2) {
        
        if (tenderCommitteecount === "" || Number(tenderCommitteecount) === 0) {
            Swal.fire({
                title: 'Missing Committee',
                text: 'Please add Committee Price Member',
                icon: 'warning'
            });
            return false;
        }
    }

    return true; 
}
</script>
</html>
