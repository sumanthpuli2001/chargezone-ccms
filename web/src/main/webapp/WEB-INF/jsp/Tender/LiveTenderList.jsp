
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LIVE TENDER LIST</title>
    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="tenderMaster.htm?act=liveTenderList" commandName="departmentMaster" method="post">

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">LIVE TENDER LIST</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
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
                    <hr>
                    
                
                    
                  
                    <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <strong>Note:</strong> <strong>Send Email is used for vendors who are informing us that they have not received a tender enquiry.</strong> 
                        </div>
                    </div>
                    <br>
                    
                 
                            <%@include file="/WEB-INF/jsp/Common/TablePageNew.jsp"%>
                  
                    
                    <div class="bg-white card-full-h">
                        <table id="commonTable1" class="table table-striped bg-white" style="width:100%">
                          
                                    <thead>
                                        <tr>
                                            <th>Close</th>
                                            <th>Tender No.</th>
                                            <th style="min-width: 230px;">Project Name</th>
                                            <th style="min-width: 230px;">Project ID</th>
                                            <!--<th>Project ID</th>-->
                                            <th style="min-width: 180px;">Tender Start Date</th>
                                            <th style="min-width: 180px;">Tender End Date</th>
                                            <th>Tender Type</th>
                                            <th style="min-width: 180px;">Send Email</th>
                                            <th>Corrigendum</th>
                                            <th>Print</th>    
                                        </tr>
                                    </thead>
                                    <c:set var="count" value="0" scope="page" />
                                    <tbody>


                                        <c:forEach var="list" items="${list2}" varStatus="status">
                                            <tr>
                                                <td>
                                             <a href="#" onclick="loadCloseTender('${list.refNo}')" data-toggle="modal" data-target="#closeTender"> close</a>
        
                                                    
                                                    
<!--                                                    <a href="#" onclick="window.open('tenderMaster.htm?act=closeTender&tender_no=${list.refNo}', '', 'left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1');
                                                       ">Close</a>-->
                                                </td>


                                                <td>${list.refNo}</td>

                                                <td>${list.title}</td>
                                                <td>${list.projectId}</td>
                                                <!--<td>${list.docCost}</td>-->
                                                <td>${list.announceDate}</td>
                                                <td>
                                               <a href="" id="extendDate_${list.refNo}" onclick="loadextenddate('${list.refNo}')" data-toggle="modal" data-target="#ExtendDateTender"> ${list.submitLastdate}</a>
                                                    
<!--                                                    <a href="#" onclick="window.open('tenderMaster.htm?act=extendDate&refNo=${list.refNo}', '', 'left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1');
                                                       ">${list.submitLastdate}</a>-->
                                                </td>
                                                <td>${list.tenderPhase} Part</td>
                                                <td></td>
                                                <td>
                                                    <c:if test="${list.tenderType == 'Service Manually'}">
                                                        <a href="tenderMaster.htm?act=recycleTenderView&id=${list.id}">Corrigendum</a>
                                                    </c:if>
                                                    <c:if test="${list.tenderType != 'Service Manually'}">
                                                        <a href="tenderMaster.htm?act=recycleTenderView&id=${list.id}">Corrigendum</a>
                                                    </c:if>

                                                </td>

                                                <td>
                                                    <c:if test="${list.tenderType == 'Service Manually'}">
                                                        <a  href="tenderMaster.htm?act=tenderPrint&id=${list.id}">Print</a>
                                                    </c:if>
                                                    <c:if test="${list.tenderType != 'Service Manually'}">
                                                        <a  href="tenderMaster.htm?act=tenderPrint&id=${list.id}">Print</a>
                                                    </c:if>

                                                </td>
                                            </tr>
                                        </c:forEach>




                                        <c:forEach var="list" items="${list}" varStatus="status">
                                            <tr>

                                                <td>
                                                <a href="#" onclick="loadCloseTender('${list.refNo}')" data-toggle="modal" data-target="#closeTender"> close</a>
   
<!--                                                    <a href="#" onclick="window.open('tenderMaster.htm?act=closeTender&tender_no=${list.refNo}', '', 'left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1');
                                                       ">Close</a>-->
                                                </td>

                                                <td>${list.refNo}</td>

                                                <td>${list.title}</td>
                                                <td>${list.projectId}</td>
                                                <!--<td>${list.docCost}</td>-->
                                                <td>${list.announceDate}</td>
                                                <td>
                                                    <c:if test="${authuser == '0'}">
                                                                            <a href="" id="extendDate_${list.refNo}" onclick="loadextenddate('${list.refNo}')" data-toggle="modal" data-target="#ExtendDateTender">${list.submitLastdate}</a>
                           
                                                        
                                                        
<!--                                                        <a href="#" onclick="window.open('tenderMaster.htm?act=extendDate&refNo=${list.refNo}', '', 'left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1');
                                                           ">${list.submitLastdate}</a>-->
                                                    </c:if>
                                                    <c:if test="${authuser == '1'}">
                                                        
                                                 <a href="" id="extendDate_${list.refNo}" onclick="loadextenddate('${list.refNo}')" data-toggle="modal" data-target="#ExtendDateTender">${list.submitLastdate}</a>
    
                                                        
<!--                                                        <a href="#" onclick="window.open('tenderMaster.htm?act=extendDate&refNo=${list.refNo}', '', 'left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1');
                                                           ">${list.submitLastdate}</a>-->
                                                    </c:if>

                                                </td>
                                                <td>${list.tenderPhase} Part</td>

                                                <td>
                                              <a href="#" onclick="loadSendmail('${list.refNo}')" data-toggle="modal" data-target="#Sendmail">Send Email</a>

<!--                                                    <a href="#" onclick="window.open('tenderMaster.htm?act=sendEmail&refNo=${list.refNo}', '', 'left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1');
                                                       ">Send Email</a>-->
                                                </td>
                                                <td>
                                                    <c:if test="${list.tenderType == 'Service Manually'}">
                                                        <a href="tenderMaster.htm?act=recycleTenderView&id=${list.id}">Corrigendum</a>
                                                    </c:if>
                                                    <c:if test="${list.tenderType != 'Service Manually'}">
                                                        <a href="tenderMaster.htm?act=recycleTenderView&id=${list.id}">Corrigendum</a>
                                                    </c:if>


                                                </td>

                                                <td>
                                                    <c:if test="${list.tenderType == 'Service Manually'}">
                                                        <a  href="tenderMaster.htm?act=tenderPrint&id=${list.id}">Print</a>
                                                    </c:if>
                                                    <c:if test="${list.tenderType != 'Service Manually'}">
                                                        <a  href="tenderMaster.htm?act=tenderPrint&id=${list.id}">Print</a>
                                                    </c:if>

                                                </td>
                                            </tr>
                                        </c:forEach>


                                        <c:forEach var="list" items="${list3}" varStatus="status">
                                            <tr>

                                                <td>
                                              <a href="#" onclick="loadCloseTender('${list.refNo}')" data-toggle="modal" data-target="#closeTender"> close</a>
                                                </td>

                                                <td>${list.refNo}</td>

                                                <td>${list.title}</td>
                                                <td>${list.projectId}</td>
                                                <!--<td>${list.docCost}</td>-->
                                                <td>${list.announceDate}</td>
                                                <td>
                                                    <c:if test="${authuser == '0'}">
                                                              <a href="" id="extendDate_${list.refNo}" onclick="loadextenddate1('${list.refNo}')" data-toggle="modal" data-target="#ExtendDateTender1">${list.collectionLastdate}</a>

                                                    </c:if>
                                                    <c:if test="${authuser == '1'}">
                                                      <a href="" id="extendDate_${list.refNo}" onclick="loadextenddate1('${list.refNo}')" data-toggle="modal" data-target="#ExtendDateTender1"> ${list.collectionLastdate}</a>

                                                    </c:if>

                                                </td>
                                                <td>${list.tenderPhase} Part</td>

                                                <td>
                                              <a href="#" onclick="loadSendmail('${list.refNo}')" data-toggle="modal" data-target="#Sendmail">Send Email</a>
     
                                                    
                                                    
<!--                                                    <a href="#" onclick="window.open('tenderMaster.htm?act=sendEmail&refNo=${list.refNo}', '', 'left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1');
                                                       ">Send Email</a>-->
                                                
                                                </td>
                                                <td>
                                                    <c:if test="${list.tenderType == 'Service Manually'}">
                                                        <a href="tenderMaster.htm?act=recycleTenderView&id=${list.id}">Corrigendum</a>
                                                    </c:if>
                                                    <c:if test="${list.tenderType != 'Service Manually'}">
                                                        <a href="tenderMaster.htm?act=recycleTenderView&id=${list.id}">Corrigendum</a>
                                                    </c:if>


                                                </td>

                                                <td>
                                                    <c:if test="${list.tenderType == 'Service Manually'}">
                                                        <a  href="tenderMaster.htm?act=tenderPrint&id=${list.id}">Print</a>
                                                    </c:if>
                                                    <c:if test="${list.tenderType != 'Service Manually'}">
                                                        <a  href="tenderMaster.htm?act=tenderPrint&id=${list.id}">Print</a>
                                                    </c:if>

                                                </td>
                                            </tr>
                                        </c:forEach>

                                        <c:forEach var="list1" items="${list1}" varStatus="status">
                                            <tr>
                                                <td>
                                                 <a href="#" onclick="loadCloseTender('${list1.refNo}')" data-toggle="modal" data-target="#closeTender"> close</a>

<!--                                                    <a href="#" onclick="window.open('tenderMaster.htm?act=closeTender&tender_no=${list1.refNo}', '', 'left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1');
                                                       ">Close</a>-->
                                                </td>

                                                <td>${list1.refNo}</td>

                                                <td>${list1.title}</td>
                                                <td>${list1.projectId}</td>
                                                <!--<td>${list1.docCost}</td>-->
                                                <td>${list1.announceDate}</td>
                                                <td>
                                               <a href="" id="extendDate_${list1.refNo}" onclick="loadextenddate('${list1.refNo}')" data-toggle="modal" data-target="#ExtendDateTender"> ${list1.submitLastdate}</a>

<!--                                                    <a href="#" onclick="window.open('tenderMaster.htm?act=extendDate&refNo=${list1.refNo}', '', 'left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1');
                                                       ">${list1.submitLastdate}</a>-->

                                                </td>
                                                <td>${list1.tenderPhase} Part</td>

                                                <td></td>
                                                <td>

                                                </td>

                                                <td>
                                                    <c:if test="${list1.tenderType == 'Service Manually'}">
                                                        <a  href="tenderMaster.htm?act=tenderPrint&id=${list1.id}">Print</a>
                                                    </c:if>
                                                    <c:if test="${list1.tenderType != 'Service Manually'}">
                                                        <a  href="tenderMaster.htm?act=tenderPrint&id=${list1.id}">Print</a>
                                                    </c:if>

                                                </td>
                                            </tr>
                                        </c:forEach>

                                        <c:forEach var="list1" items="${list4}" varStatus="status">
                                            <tr>
                                                <td>
                                               <a href="#" onclick="loadCloseTender('${list1.refNo}')" data-toggle="modal" data-target="#closeTender"> close</a>

<!--                                                    <a href="#" onclick="window.open('tenderMaster.htm?act=closeTender&tender_no=${list1.refNo}', '', 'left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1');
                                                       ">Close</a>-->
                                                </td>

                                                <td>${list1.refNo}</td>

                                                <td>${list1.title}</td>
                                                <td>${list1.projectId}</td>
                                                <!--<td>${list1.docCost}</td>-->
                                                <td>${list1.announceDate}</td>
                                                <td>

                                                  <a href="" id="extendDate_${list1.refNo}" onclick="loadextenddate1('${list1.refNo}')" data-toggle="modal" data-target="#ExtendDateTender1">${list1.collectionLastdate}</a>


                                                </td>
                                                <td>${list1.tenderPhase} Part</td>

                                                <td></td>
                                                <td>

                                                </td>

                                                <td>
                                                    <c:if test="${list1.tenderType == 'Service Manually'}">
                                                        <a  href="tenderMaster.htm?act=tenderPrint&id=${list1.id}">Print</a>
                                                    </c:if>
                                                    <c:if test="${list1.tenderType != 'Service Manually'}">
                                                        <a  href="tenderMaster.htm?act=tenderPrint&id=${list1.id}">Print</a>
                                                    </c:if>

                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                               
                               

                        </table>
                    </div> 



                </form:form>
                    
             <form:form id="myForm" enctype="multipart/form-data" commandName="prMaster" name="form" class="form-horizontal" role="form"> 
                                   <div class="modal fade" id="closeTender" data-backdrop="static" data-keyboard="false" tabindex="-1"
                        aria-labelledby="closeTenderLabel" aria-hidden="true">
                        <div class="modal-dialog modal-sm">
                            <div class="modal-content">

                                <div class="modal-header align-items-center">
                                    <h5 class="modal-title" id="closeTenderLabel">Close Tender By Force :</h5>
                                    <div class="cta-btn d-flex align-items-center">
                                        <button type="button" class="btn theme-btn light-btn" data-dismiss="modal"
                                            onclick="event.preventDefault();">Close</button>
                                        <button type="button" class="btn theme-btn ml-3" id="closetenderButton" title="">Submit</button>

                                    </div>
                                </div>

                                <div class="modal-body">
                                    <input type="hidden" name="refNo" class="input-field" id="refNo" value="${List.refNo}">
                                </div>

                                <div id="resultDiv" class="bg-white">

                                    <script>
                                        function loadCloseTender(tenderNo) {
                                            console.log("Tender No received:", tenderNo);
                                            document.getElementById("refNo").value = tenderNo;
                                            $.ajax({
                                                url: 'tenderMaster.htm?act=closeTender',
                                                type: 'GET',
                                                data: {
                                                    tender_no: tenderNo
                                                },
                                                success: function (response) {
                                                    document.getElementById("resultDiv").innerHTML = response;
                                                },
                                                error: function (xhr, status, error) {
                                                    console.error("Error:", error);
                                                }
                                            });
                                            return false;
                                        }
                                    </script>

                              <script>
                                document.getElementById('closetenderButton').addEventListener('click', function () {
                                    var form = document.getElementById('myForm');
                                    var remark = document.getElementById("remark").value.trim();
                                    var Tenderno = document.getElementById("tender_no").value.trim();

                                    // Validation
                                    if (remark === "") {
                                        Swal.fire({
                                            title: 'Required Field',
                                            text: 'Please fill in all * marked fields (Remark is required).',
                                            icon: 'warning',
                                            confirmButtonText: 'OK'
                                        }).then(() => {
                                            document.getElementById("remark").focus();
                                        });
                                        return;
                                    }

                                    // SweetAlert Confirmation
                                    Swal.fire({
                                        title: "Are you sure?",
                                        text: "Do you really want to close this tender?",
                                        icon: "warning",
                                        showCancelButton: true,
                                        confirmButtonText: "Yes, Close It",
                                        cancelButtonText: "No, Cancel"
                                    }).then((result) => {
                                        if (result.isConfirmed) {

                                            var formData = new FormData(form);
                                            var xhr = new XMLHttpRequest();
                                            xhr.open('POST', 'tenderMaster.htm?act=closeTenderSubmit', true);

                                            xhr.onload = function () {
                                                if (xhr.status === 200) {
                                                    document.getElementById('resultDiv').innerHTML = xhr.responseText;

                                                  Swal.fire({
                                                        icon: 'success',
                                                        title: 'Tender Closed Successfully',
                                                        text: 'The tender ' + Tenderno + ' has been closed.',
                                                        confirmButtonText: 'OK'
                                                    }).then(() => {
                                                        location.reload();  
                                                    });
                                                } else {
                                                    console.error("Error occurred: " + xhr.statusText);
                                                }
                                            };

                                            xhr.onerror = function () {
                                                console.error("Request failed.");
                                            };

                                            xhr.send(formData);
                                        }
                                        // If cancelled, do nothing
                                    });
                                });
                                </script>


                                </div>

                            </div>
                        </div>
                    </div> 
                                
                      <div class="modal fade" id="ExtendDateTender" data-backdrop="static" data-keyboard="false"
                        tabindex="-1" aria-labelledby="ExtendDateTenderLabel" aria-hidden="true">
                        <div class="modal-dialog " style="max-width: 700px; ">
                            <div class="modal-content">

                                <div class="modal-header align-items-center">
                                    <h5 class="modal-title" id="ExtendDateTenderLabel">Extend Date:</h5>
                                    <div class="cta-btn d-flex align-items-center">
                                        <button type="button" class="btn theme-btn light-btn" data-dismiss="modal" onclick="event.preventDefault();">Close</button>
                                        <button type="button" class="btn theme-btn ml-3" id="extendtenderButton" title="">Submit</button>
                                    </div>
                                </div>

                                <div class="modal-body">
                                    <input type="hidden" name="refNo" id="refNo" value="${List.refNo}">

                                    <div id="resultDiv1" class="bg-white">

                                        <script>
                                            function loadextenddate(tenderNo) {
    //                                            console.log("Tender No received:", tenderNo);

                                                document.getElementById("refNo").value = tenderNo;
                                                $.ajax({
                                                    url: 'tenderMaster.htm?act=extendDate',
                                                    type: 'GET',
                                                    data: {
                                                        refNo: tenderNo
                                                    },
                                                    success: function (response) {
                                                        document.getElementById("resultDiv1").innerHTML = response;

                                                        flatpickr(".form_datetime", {
                                                            enableTime: true,
                                                            dateFormat: "d-m-Y H:i:S",
                                                            minDate: new Date(),
                                                            time_24hr: true, 
                                                            onChange: function(selectedDates, dateStr, instance) {
                                                                if (selectedDates.length > 0 && !instance._timeSetByUser) {
                                                                    var now = new Date();
                                                                    var selectedDate = selectedDates[0];

                                                                    selectedDate.setHours(now.getHours(), now.getMinutes(), now.getSeconds());

                                                                    instance.setDate(selectedDate, false);
                                                                }
                                                            },
                                                            onOpen: function(selectedDates, dateStr, instance) {
                                                                instance._timeSetByUser = false;
                                                            },
                                                            onValueUpdate: function() {
                                                                this._timeSetByUser = true;
                                                            }
                                                        });

//                                                        requestExtDateAttachment();
                                                    },
                                                    error: function (xhr, status, error) {
                                                        console.error("AJAX Error:", error);
                                                    }
                                                });

                                                return false;
                                            }
                                        </script>

                                       <script>
                                            document.getElementById('extendtenderButton').addEventListener('click', function () {

                                                var form = document.getElementById('myForm');
                                                var submitLastdate = document.getElementById("submitLastdate").value.trim();
                                                var refNo = document.getElementById("refNo").value.trim();

                                                /* Validation using SweetAlert */
                                                
                                                /* SweetAlert Confirmation */
                                                Swal.fire({
                                                    title: 'Are you sure?',
                                                    text: 'Do you want to extend the tender?',
                                                    icon: 'question',
                                                    showCancelButton: true,
                                                    confirmButtonText: 'Yes, Extend',
                                                    cancelButtonText: 'Cancel'
                                                }).then((result) => {

                                                    if (!result.isConfirmed) {
                                                        return;
                                                    }

                                                    var formData = new FormData(form);
                                                    var xhr = new XMLHttpRequest();
                                                    xhr.open('POST', 'tenderMaster.htm?act=extendDateSubmit', true);

                                              xhr.onload = function () {

                                            if (xhr.status == 200) {

                                                var result = xhr.responseText;

                                                if (result.startsWith("SUCCESS:")) {

                                                    Swal.fire({
                                                        icon: "success",
                                                        title: "Success",
                                                        text: result.replace("SUCCESS:", "")
                                                    }).then(function () {
                                                        window.location.href = "tenderMaster.htm?act=liveTenderList";
                                                    });

                                                } else if (result.startsWith("FAIL:")) {

                                                    Swal.fire({
                                                        icon: "warning",
                                                        title: "Warning",
                                                        text: result.replace("FAIL:", "")
                                                    });

                                                } else {

                                                    Swal.fire({
                                                        icon: "error",
                                                        title: "Error",
                                                        text: result.replace("ERROR:", "")
                                                    });

                                                }

                                            } else {

                                                Swal.fire({
                                                    icon: "error",
                                                    title: "Server Error",
                                                    text: "Something went wrong."
                                                });

                                            }

                                        };


                                                    xhr.onerror = function () {
                                                        Swal.fire({
                                                            icon: 'error',
                                                            title: 'Request Failed',
                                                            text: 'Unable to connect to the server.'
                                                        });
                                                    };

                                                    xhr.send(formData);
                                                });

                                            });
                                            </script>


                                    </div>
                                    <div id="extDateAttachmentDiv" ></div>
                                </div>

                            </div>
                        </div>
                    </div>  

                    <div class="modal fade" id="ExtendDateTender1" data-backdrop="static" data-keyboard="false"
                        tabindex="-1" aria-labelledby="ExtendDateTenderLabel1" aria-hidden="true">
                        <div class="modal-dialog " style="max-width: 700px; ">
                            <div class="modal-content">

                                <div class="modal-header align-items-center">
                                    <h5 class="modal-title" id="ExtendDateTenderLabel1">Extend Date:</h5>
                                    <div class="cta-btn d-flex align-items-center">
                                        <button type="button" class="btn theme-btn light-btn" data-dismiss="modal" onclick="event.preventDefault();">Close</button>
                                        <button type="button" class="btn theme-btn ml-3" id="extendtenderButton1" title="">Submit</button>
                                    </div>
                                </div>

                                <div class="modal-body">
                                    <input type="hidden" name="refNo" id="refNo" value="${List.refNo}">

                                    <div id="resultDiv2" class="bg-white">

                                        <script>
                                            function loadextenddate1(tenderNo) {
    //                                            console.log("Tender No received:", tenderNo);

                                                document.getElementById("refNo").value = tenderNo;
                                                $.ajax({
                                                    url: 'tenderMaster.htm?act=extendDate1',
                                                    type: 'GET',
                                                    data: {
                                                        refNo: tenderNo
                                                    },
                                                    success: function (response) {
                                                        document.getElementById("resultDiv2").innerHTML = response;

                                                        flatpickr(".form_datetime", {
                                                            enableTime: true,
                                                            dateFormat: "d-m-Y H:i:S",
                                                            minDate: new Date(),
                                                            time_24hr: true, 
                                                            onChange: function(selectedDates, dateStr, instance) {
                                                                if (selectedDates.length > 0 && !instance._timeSetByUser) {
                                                                    var now = new Date();
                                                                    var selectedDate = selectedDates[0];

                                                                    selectedDate.setHours(now.getHours(), now.getMinutes(), now.getSeconds());

                                                                    instance.setDate(selectedDate, false);
                                                                }
                                                            },
                                                            onOpen: function(selectedDates, dateStr, instance) {
                                                                instance._timeSetByUser = false;
                                                            },
                                                            onValueUpdate: function() {
                                                                this._timeSetByUser = true;
                                                            }
                                                        });

//                                                        requestExtDateAttachment();
                                                    },
                                                    error: function (xhr, status, error) {
                                                        console.error("AJAX Error:", error);
                                                    }
                                                });

                                                return false;
                                            }
                                        </script>

                                       <script>
                                            document.getElementById('extendtenderButton1').addEventListener('click', function () {

                                                var form = document.getElementById('myForm');
                                                var submitLastdate = document.getElementById("submitLastdate").value.trim();
                                                var refNo = document.getElementById("refNo").value.trim();

                                                /* Validation using SweetAlert */
                                                
                                                /* SweetAlert Confirmation */
                                                Swal.fire({
                                                    title: 'Are you sure?',
                                                    text: 'Do you want to extend the tender?',
                                                    icon: 'question',
                                                    showCancelButton: true,
                                                    confirmButtonText: 'Yes, Extend',
                                                    cancelButtonText: 'Cancel'
                                                }).then((result) => {

                                                    if (!result.isConfirmed) {
                                                        return;
                                                    }

                                                    var formData = new FormData(form);
                                                    var xhr = new XMLHttpRequest();
                                                    xhr.open('POST', 'tenderMaster.htm?act=extendDate1Submit', true);

                                                   xhr.onload = function () {
                                                        if (xhr.status === 200) {

                                                            document.getElementById('resultDiv2').innerHTML = xhr.responseText;

                                                            Swal.fire({
                                                                icon: 'success',
                                                                title: 'Extended Successfully',
                                                                text: 'The tender last date has been extended.',
                                                                confirmButtonText: 'OK'
                                                            }).then((result) => {
                                                                if (result.isConfirmed) {
                                                                    window.location.href = 'tenderMaster.htm?act=liveTenderList';
                                                                }
                                                            });

                                                            document.getElementById("extendDate_" + refNo).innerText = submitLastdate;

                                                        } else {
                                                            Swal.fire({
                                                                icon: 'error',
                                                                title: 'Error',
                                                                text: 'Something went wrong. Please try again.'
                                                            });
                                                        }
                                                    };


                                                    xhr.onerror = function () {
                                                        Swal.fire({
                                                            icon: 'error',
                                                            title: 'Request Failed',
                                                            text: 'Unable to connect to the server.'
                                                        });
                                                    };

                                                    xhr.send(formData);
                                                });

                                            });
                                            </script>


                                    </div>
                                    <div id="extDateAttachmentDiv" ></div>
                                </div>

                            </div>
                        </div>
                    </div>  
                    
                                    
        <div class="modal fade" id="Sendmail" data-backdrop="static" data-keyboard="false" tabindex="-1"
                        aria-labelledby="SendmailLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">

                                <div class="modal-header align-items-center">
                                    <h5 class="modal-title" id="SendmailLabel">Send Email To Vendor</h5>
                                    <div class="cta-btn d-flex align-items-center">
                                        <button type="button" class="btn theme-btn light-btn" data-dismiss="modal"
                                            onclick="event.preventDefault();">Close</button>
                                        <button type="button" class="btn theme-btn ml-3" style="width: 100px;"
                                            id="sendmailButton" title="">Submit</button>
                                    </div>
                                </div>

                                <div class="modal-body">
                                </div>

                                <div id="emailDiv" class="bg-white">

                                    <script>
                                        function loadSendmail(tenderNo) {
                                            console.log("Tender No received:", tenderNo);
                                            document.getElementById("refNo").value = tenderNo;
                                            $.ajax({
                                                url: 'tenderMaster.htm?act=sendEmail',
                                                type: 'GET',
                                                data: {
                                                    refNo: tenderNo
                                                },
                                                success: function (response) {
                                                    document.getElementById("emailDiv").innerHTML = response;
                                                    $('#Sendmail').modal('show');
                                                    if ($('#commonTable').length) {
                                                        const table1 = initTable('#commonTable',
                                                            {
                                                                columnDefs: [
                                                                    { targets: [0], orderable: false }
                                                                ], order: [[1, 'asc']]
                                                            });
                                                    }
                                                }
                                            });
                                            return false;
                                        }
                                    </script>

                                   <script>
                                        document.getElementById('sendmailButton').addEventListener('click', function () {

                                            var form = document.getElementById('myForm');
                                            var refNo = document.getElementById("refNo").value.trim();

                                            var checkedBoxes = document.querySelectorAll('input[name="checkId"]:checked');

                                            /* Validation using SweetAlert */
                                            if (checkedBoxes.length === 0) {
                                                Swal.fire({
                                                    title: 'Selection Required',
                                                    text: 'Please tick at least one checkbox.',
                                                    icon: 'warning',
                                                    confirmButtonText: 'OK'
                                                });
                                                return;
                                            }

                                            /* SweetAlert Confirmation */
                                            Swal.fire({
                                                title: 'Are you sure?',
                                                text: 'Do you want to send email to the selected vendor(s)?',
                                                icon: 'question',
                                                showCancelButton: true,
                                                confirmButtonText: 'Yes, Send',
                                                cancelButtonText: 'Cancel'
                                            }).then((result) => {

                                                if (!result.isConfirmed) {
                                                    return;
                                                }

                                                var formData = new FormData(form);
                                                var xhr = new XMLHttpRequest();
                                                xhr.open('POST', 'tenderMaster.htm?act=sendEmailSubmit', true);

                                                xhr.onload = function () {
                                                    if (xhr.status === 200) {

                                                        document.getElementById('emailDiv').innerHTML = xhr.responseText;

                                                        Swal.fire({
                                                            icon: 'success',
                                                            title: 'Email Sent',
                                                            text: 'Email sent to vendor(s) successfully.',
                                                            confirmButtonText: 'OK'
                                                        });
                                                        if ($('#commonTable').length) {
                                                            const table1 = initTable('#commonTable',
                                                                {
                                                                    columnDefs: [
                                                                        { targets: [0], orderable: false }
                                                                    ], order: [[1, 'asc']]
                                                                });
                                                        }
                                                    } else {
                                                        Swal.fire({
                                                            icon: 'error',
                                                            title: 'Error',
                                                            text: 'Failed to send email. Please try again.'
                                                        });
                                                    }
                                                };

                                                xhr.onerror = function () {
                                                    Swal.fire({
                                                        icon: 'error',
                                                        title: 'Request Failed',
                                                        text: 'Server not responding. Please try later.'
                                                    });
                                                };

                                                xhr.send(formData);
                                            });

                                        });
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
