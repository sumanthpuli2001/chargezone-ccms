
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

    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="tenderMaster.htm?act=submitTenderMaster" method="post" enctype="multipart/form-data" commandName="tenderMaster" name="form" class="form-horizontal" role="form" onsubmit="return checkdata()" >

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600">CREATE TENDER- ${tenderPhase}  Part Tender Information</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="window.location = 'tenderMaster.htm?act=selectTypeTender'" class="btn theme-btn light-btn mr-3">Back</a>
                            <button type="submit" class="btn theme-btn">Submit</button>
                        </div>
                    </div>

                    <hr>
                    <input type="hidden" name="tenderPhase" id="tenderPhase" value="${tenderPhase}">
                    <input type="hidden" name="tender_no" id="tender_no" value="${ref_no}">

                    <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label"> Tender Type <span class="text-danger">*</span></label>

                                    <input path="type"  class="input-field" value="Procurement"   readonly="true"  required="required"/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label"> Tender Reference No</label>

                                    <input path="refNo" id="refNo"  class="input-field" maxlength="30" pattern="[0-9]+" readonly="true"   />
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label"> Title <span class="text-danger">*</span></label>

                                    <form:textarea path="title" class="textarea-field comment"   placeholder="Enter Title " required="required" ></form:textarea>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6">
                                    <div class="form-group">
                                        <label class="label"> Tender Value  </label>

                                    <form:input path="value" class="input-field" value="0" pattern="[0-9]+" onkeypress="return (event.charCode !=8 && event.charCode ==0 || (event.charCode >= 48 && event.charCode <= 57))"  maxlength="30" required="required"/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label"> Tender classification   </label>

                                    <form:input path="categoryId" class="input-field"   maxlength="30" />                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label"> Tender Fee  </label>

                                    <form:input path="docCost" class="input-field"  value="0" pattern="[0-9]+" onkeypress="return (event.charCode !=8 && event.charCode ==0 || (event.charCode >= 48 && event.charCode <= 57))" maxlength="30" required="required"/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label"> Tender EMD </label>

                                    <form:input path="emd" class="input-field" value="0" pattern="[0-9]+" onkeypress="return (event.charCode !=8 && event.charCode ==0 || (event.charCode >= 48 && event.charCode <= 57))"  maxlength="30" required="required"/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">  Tender Location  <span class="text-danger">*</span></label>

                                    <form:input path="location" class="input-field" value="${location}"  maxlength="30" readonly="true"/>
                                </div>
                            </div>   
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">Tender Date<span class="text-danger">*</span></label>

                                    <form:input path="announceDate" class="input-field" value="${formattedDate}"  maxlength="30" required="required" readonly="true"/>
                                </div>
                            </div>   
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">Tender Due Date<span class="text-danger">*</span></label>

                                    <div class='input-group date' id='datetimepicker1'>
                                        <input type="text" class="input-field form_datetime" path="submitLastdate" name="submitLastdate" value="${submitLastdate}" placeholder="dd-mm-yyyy --:--"  />

                                    </div>
                                    <script type="text/javascript">
                                        flatpickr("#datetimepicker1", {
                                            enableTime: true,
                                            enableSeconds: true,
                                            dateFormat: "d-m-Y H:i:S",
                                            minDate: "today",
                                            allowInput: true
                                        });
                                    </script>




                                </div>
                            </div>   

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label"> PR No</label>

                                    <form:input path="prNo" class="input-field"  value="" />                                </div>
                            </div>                  
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label"> PR Item No</label>

                                    <form:input path="prItemNo" class="input-field" value="" />
                                </div>                  

                            </div>
                        </div>
                        </div>
                                
                                
                        <div class="col-12 p-0">
                            <div class="form-group comment-box">
                                <label class="control-label"> Tender Subject Description<span class="text-danger">*</span></label>
                                <form:textarea path="workDesc" class="textarea-field comment"   maxlength="200" required="required"></form:textarea>
                                </div>
                            </div>  

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
                                        <label  class="label"> End User Name </label>

                                        <form:input path="endUserName" class="input-field" value=""  maxlength="130" />
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6">
                                    <div class="form-group">
                                        <label  class="label"> End User Contact No</label>

                                        <form:input path="endUserNumber" class="input-field" value=""  maxlength="30" />
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
                                        <label  class="label"> Plant </label>

                                        <input type="hidden" name="plant_name" value="">
                                        <select name="plant" class="select-input" onchange="changeplant()" required="true">
                                            <option value="">Select</option>
                                            <c:forEach var="plantMaster" items="${plantMaster}" varStatus="status1">
                                                <option value="${plantMaster.plantName}::${plantMaster.location}">${plantMaster.plantName}</option>
                                            </c:forEach>


                                        </select>                                  
                                    </div>
                                </div> 
                                <div class="col-lg-4 col-md-6">
                                    <div class="form-group">
                                        <label  class="label"> Delivery Location</label>

                                        <form:input path="deliveryLocation" class="input-field"   maxlength="200" required="required"/>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6">
                                    <div class="form-group">
                                        <label  class="label"> Delivery Period</label>

                                        <form:input path="deliveryPeriod" class="input-field"   maxlength="200" required="required"/>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6">
                                    <div class="form-group">
                                        <label  class="label"> Terms Of Payment </label>
                                            <select name="termsOfPayment" class="select-input">
                                                <c:forEach var="locationMaster" items="${locationMaster}" varStatus="status1">
                                                    <option value="${locationMaster.locationName}">${locationMaster.locationName}</option>
                                                </c:forEach>


                                            </select>
                                        
                                        </div>                                   
                                </div>
                                <div class="col-lg-4 col-md-6">
                                    <div class="form-group">
                                        <label  class="label">  Mode Of Transport </label>
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
                                        <label  class="label">Inco Terms</label>
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

                            

                                    <h5 class="fw-600" >Tender Attachment</h5>
                                    <hr>       
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
                                    
                 <div class="form-group">
                        <div class="content-top mb-3 d-flex align-items-center justify-content-between">
                            <div class="d-flex align-items-center">
                                <h6 class="fw-600">Tender Additional Document </h6>
                            </div>

                           
                            
                            <button type="button" class="btn theme-btn d-flex align-items-center" data-toggle="modal"
                                data-target="#tenderAdditionalUpload" onclick="requestDocTenderAddTab();">
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
                        function showuser6(str) {
                            str = document.getElementById("tender_no").value;
                            //alert("");
                            str7 = str;
                            //if(win && win.closed){
                            var xreq, ID;
                            if (str == "") {
                                document.getElementById("showtext6").innerHTML = "";
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
                                    document.getElementById("showtext6").innerHTML = xreq.responseText;

                                    setTimeout(() => {
                                        if ($('#tenderAddTable').length) {
                                            const table1 = initTable('#tenderAddTable');
                                        }
                                    }, 100);
                                }
                            }

                          xreq.open("Get", "tenderMaster.htm?act=agaxTenderAdditionalFileDetails&bid_type=1&q=" + str7, true);
                            xreq.send();
                            //}
                            window.clearInterval(ID);
                        }

                        var ID = window.setInterval(showuser6(str7), 1000);
                    </script>
                     
              
                <div id="showtext6" class="bg-white"></div>
                                    
                   </div>       
                                    
                  
                     <div class="form-group">
                        <div class="content-top mb-3 d-flex align-items-center justify-content-between">
                            <div class="d-flex align-items-center">
                                <h6 class="fw-600"> Tender Technical Document  </h6>
                            </div>
                            
                            <button type="button" class="btn theme-btn d-flex align-items-center" data-toggle="modal"
                                data-target="#tenderTechnicalUpload" onclick="requestDocTenderTechnicalTab();">
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
                        function showuser7(str) {
                            str = document.getElementById("tender_no").value;
                            //alert("");
                            str7 = str;
                            //if(win && win.closed){
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
                            //}
                            window.clearInterval(ID);
                        }

                        var ID = window.setInterval(showuser7(str7), 1000);
                    </script>
                     
                     
              
                                            <div id="showtext7" class="bg-white"></div>

                                    
                   </div>                
                                    
                                    <hr>    
                 <div class="col-12 p-0">
                    <div class="form-group comment-box">
                        <label class="control-label">Tender Remark </label>
                        <textarea type="text" maxlength="250" class="textarea-field comment" id="remark" name="remark"  ></textarea>
                    </div>
                </div>  
                   
                                    
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
                                            //alert("");
                                            strV = str;
                                            //if(win && win.closed){
                                            var xreq, ID;
                                            if (str == "") {
                                    document.getElementById("showtext111").innerHTML = "";
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
                                    document.getElementById("showtext111").innerHTML = xreq.responseText;
                                            setTimeout(() => {
                                            if ($('#VendorDetailsTable').length) {
                                            const table1 = initTable('#VendorDetailsTable');
//                                                                         $('#prVedorDetailsTab').DataTable().columns.adjust().draw(false);
                                            }

                                            }, 100);
                                            $('.select-input').selectpicker('refresh');
                                    }
                                    }

                                    xreq.open("get", "tenderMaster.htm?act=agaxTenderVendorDetails&q=" + str11, true);
                                            xreq.send();
                                            //}
                                            window.clearInterval(ID);
                                    }

                            var ID = window.setInterval(showuser11(str11), 1000);</script>

                        <div id="showtext111"></div>                      
                  
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
                                    
                                    
                                         
                                    
                                    
                                    
                                    
   

                                    

                                    
                                    
                                    
                                    
                                    <br>
                                    <br>
                                    <div class="form-group">
                                        <div style="display: flex;  justify-content: center;">

                                            <button type="submit" class="btn theme-btn mr-3" style="width: 180px;"  >SUBMIT</button>
                                        </div>
                                    </div>



                    </form:form>
                                    
                 <form:form id="myForm" enctype="multipart/form-data" commandName="prMaster" name="form"
                            class="form-horizontal" role="form">
                      <input type="hidden" id="ref_no" name="ref_no1" value="${ref_no}" />
                    <input type="hidden" id="ref_no" name="ref_no1" value="${ref_no}" />
                    
                    
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


                                    <table id="commonDocTable" class="table table-striped bg-white dt-scroll" style="min-width: 100%" align="center">
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
                    
            <!--Tender Additional Document-->        
                    
                    
             <div class="modal fade" id="tenderAdditionalUpload" data-backdrop="static" data-keyboard="false"
                         tabindex="-1" aria-labelledby="tenderAdditionalUploadLabel" aria-hidden="true">
                        <div class="modal-dialog modal-sm">
                            <div class="modal-content">

                                <div class="modal-header align-items-center">
                                    <h5 class="modal-title" id="tenderAdditionalUploadLabel">Attach Document
                                    </h5>
                                    <div class="cta-btn d-flex align-items-center">
                                        <button type="button" class="btn theme-btn light-btn" onclick="showuser6(id);"
                                                data-dismiss="modal">Close</button>
                                        <button type="button" class="btn theme-btn ml-3"
                                                id="tenderAddSubmitBtn">Submit</button>
                                    </div>
                                </div>

                                <div class="modal-body">


                                    <table id="commonDocTable1" class="table table-striped bg-white dt-scroll" style="min-width: 100%" align="center">
                                        <thead>
                                            <tr>
                                                <th>Vendor Attachment</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>
                                                    <div class="col-md-12">
                                                        <input type="file" name="generalfiles" id="generalfiles" class="input-field py-2 fs-12i">
                                                    </div>
                                                </td>

                                            </tr>
                                        </tbody>
                                    </table>
                                    <div id="AjaxTenderAddDiv" class="p-1"></div>    
                                </div>
                            </div>
                        </div>  
                 
                 
                        </div>       
                    
                    <script type="text/javascript">
                  
             const bootoast1 = window.Bootoast1;
        // Submit file with FormData
        document.getElementById('tenderAddSubmitBtn').addEventListener('click', function () {
            const fileInputs = document.getElementById("generalfiles");
           
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
            formData.append('generalfiles', fileInputs.files[0]);
            formData.append('policyCount', 1);
//            console.log(refNoValue);
//            if (refNoValue) {
//                formData.append('ref_no', refNoValue);
//            }

            const xhr = new XMLHttpRequest();
            xhr.open('POST', 'tenderMaster.htm?act=addTenderAdditionalFileDetailsSubmit', true);

            xhr.onload = function () {
                if (xhr.status === 200) {
                    const uploadedFileNames = fileInputs.files[0].name;
                    Swal.fire({
                        icon: 'success',
                        title: 'Added Attachment Tender Additional Document Successfully.',
                        timer: 3000,
                        showConfirmButton: false,
                        position: 'top'
                    });
                    requestDocTenderAddTab();
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
            setupImportTenderAddDocument();
        });
//            function initResultContent() {
//          }
        </script> 
               <script type="text/javascript">
             
                var str7 = document.getElementById("ref_no").value;
                function requestDocTenderAddTab(str) {
                      
                    str = document.getElementById("ref_no").value;
                    str7 = str;
                 
                    var xreq, ID;
                    if (str == "") {
                        document.getElementById("AjaxTenderAddDiv").innerHTML = "";
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
                            document.getElementById("AjaxTenderAddDiv").innerHTML = xreq.responseText;
                            setTimeout(() => {
                                if ($('#AjaxAjaxTenderAddTab').length) {
                                    const table1 = initDocTable('#AjaxAjaxTenderAddTab');
                                }
                            }, 100);
                        }
                    }

                    xreq.open("Get", "tenderMaster.htm?act=addTenderAdditionalFileDetails&ref_no1=" + str7, true);
                    xreq.send();
                    window.clearInterval(ID);
                }

                var ID = window.setInterval(requestDocTenderAddTab(str7), 1000);
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
                        url: 'tenderMaster.htm?act=tenderAdditionalFileDetailsDelete',
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
                            $('#AjaxAjaxTenderAddTab')
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
                                            <input type="hidden" name="ref_no" id="ref_no" value="${ref_no}">
                                            <input type="hidden" name="bid_type" id="bid_type" value="1">
                                            <select id="userList1" name="userList1" class="select-input">
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
                                        document.getElementById('uploadSubmitBtn0').addEventListener('click', function () {
                                            var form = document.getElementById('myForm');
                                            var formData = new FormData(form);
                                            var ref_no = document.getElementById("ref_no").value;
                                            var bid_type = document.getElementById("bid_type").value;
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
                     
                        xhr.open("GET", "tenderMaster.htm?act=searchVendorToAddInTender&ref_no=${ref_no}", true);
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
            xhr.open("POST", "tenderMaster.htm?act=addVendorForTender", true);
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
        
        
                 </form:form>                    
                                    
                                    
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
    
    
    
    
    
    
    
  <script language="javascript" type="text/javascript">
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

            function checkdata()
            {

                if (document.form.vendor_code111.length == null)
                {
                    alert("Please add vendor");
                    return false;
                }

            }
        </script>  
    
</html>
