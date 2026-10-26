<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp" %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Design Engineer View</title>
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
                    ...obj,
                });
            }
        </script>
    </head>

    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="oapForm.htm?act=DesigncordinatorviewSubmit" method="post" enctype="multipart/form-data"  commandName="rightMaster"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)" alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)" alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">Design Engineer View</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                        </div>
                    </div>
                    <hr>
                    <input type="hidden" name="id" id="id" value="${id}">
                    <input type="hidden" name="id1" id="id1" value="${id}">
                    <input type="hidden" name="id8" id="id8" value=""> <!--count of the type -->
                    <input type="hidden" name="id9" id="id9" value=""> <!--count of the type-->

                    <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;"> !</div>
                        <div>
                            <p style="margin: 0;"><strong>Note:</strong> At least one <strong>TYPE</strong> of attachment file must be uploaded to proceed.</p>
                            <p style="margin: 0;">• Fields marked with * are mandatory.</p>
                        </div>
                    </div>
                    <br>
                    <c:if test="${deliverableMulti.aocId == 0}">
                        <h6 class="fw-600">OAP Form Details</h6>
                        <div class="rounded-4 mt-4">
                            <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                                <div class="row buyer-info">
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Document No</label>
                                            <p class="fw-600">${oapForm.documentNo}</p>

                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Pcs Name</label>
                                            <p class="fw-600">${oapForm.pcsName}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-8 pb-1">
                                        <div class="form-group">
                                            <label>Project Name</label>
                                            <p class="fw-600">${oapForm.projectName}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Pcs CoOrdinates</label>
                                            <p class="fw-600">${oapForm.pcsCoordinates}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Client Name</label>
                                            <p class="fw-600">${oapForm.mobileNo}</p>
                                        </div>
                                    </div>

                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Department</label>
                                            <p class="fw-600">${oapForm.department}</p>
                                        </div>
                                    </div>

                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Date</label>
                                            <p class="fw-600">${oapForm.createdDate}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <div class="rounded-4 mt-4">
                            <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                                <div class="row buyer-info">
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Document No</label>
                                            <p class="fw-600">${crcForm.documentNo}</p>

                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Pcs Name</label>
                                            <p class="fw-600">${crcForm.pcsName}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-8 pb-1">
                                        <div class="form-group">
                                            <label>PCS Drawing Number </label>
                                            <p class="fw-600">${crcForm.pcsDrawingNumber}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Prepared By</label>
                                            <p class="fw-600">${crcForm.preparedBy}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Scope Of Work</label>
                                            <p class="fw-600">${crcForm.scopeWork}</p>
                                        </div>
                                    </div>

                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Designation</label>
                                            <p class="fw-600">${crcForm.designation}</p>
                                        </div>
                                    </div>


                                </div>
                            </div>
                        </div>

                        <h6 class="fw-600">Site Survey Details</h6>
                        <table id="commonTable" class="table  table-striped  bg-white" style="  max-width: 100%;"
                            align="center">
                            <thead>
                                <tr>
                                    <th>Sr No</th>
                                    <th>Survey No</th>
                                    <th>Project Representative</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="oapSurveyAttch" items="${oapSurveyAttch}" varStatus="status">
                                    <tr>
                                        <td>${status.count}</td>
                                        <td><a class="fw-600 text-break gradient-text"
                                                href="oapForm.htm?act=siteSurveyView&id=${oapSurveyAttch.surveyNo}">${oapSurveyAttch.surveyNo}</a>
                                        </td>
                                        <td>${oapSurveyAttch.projectRepresentative}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:if>

                    <c:if test="${deliverableMulti.oapId == 0}">
                        <h6>AOC Form Details</h6>
                        <div class="rounded-4 mt-4">
                            <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                                <div class="row buyer-info">
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Document Number</label>
                                            <p class="fw-600">${aocForm.documentNo}</p>

                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Depo.Name</label>
                                            <p class="fw-600">${aocForm.hubDepoName}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-8 pb-1">
                                        <div class="form-group">
                                            <label>Project Name</label>
                                            <p class="fw-600">${aocForm.clientProjectName}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Created By</label>
                                            <p class="fw-600">${aocForm.userId}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Client Name</label>
                                            <p class="fw-600">${aocForm.mobileNo}</p>
                                        </div>
                                    </div>

                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Date</label>
                                            <p class="fw-600">${aocForm.createdDate}</p>
                                        </div>
                                    </div>


                                </div>
                            </div>
                        </div>

                        <h6>KICKOFF Form Details</h6>

                        <div class="rounded-4 mt-4">
                            <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                                <div class="row buyer-info">
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Document No</label>
                                            <p class="fw-600">${kickOffForm.documentNo}</p>

                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Hub Location</label>
                                            <p class="fw-600">${kickOffForm.hubLocation}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-8 pb-1">
                                        <div class="form-group">
                                            <label>Project Name</label>
                                            <p class="fw-600">${kickOffForm.projectName}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Designation</label>
                                            <p class="fw-600">${kickOffForm.designation}</p>
                                        </div>
                                    </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                        <div class="form-group">
                                            <label>Date & Time</label>
                                            <p class="fw-600">${kickOffForm.dateTime}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <h6 class="fw-600">Site Survey Details</h6>
                        <table id="commonTable1" class="table table-striped bg-white" style=" max-width: 100%;"
                            align="center">
                            <thead>
                                <tr>
                                    <th>Sr No</th>
                                    <th>Survey No</th>
                                    <th>Project Representative</th>
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach var="aocSurveyAttch" items="${aocSurveyAttch}" varStatus="status">
                                    <tr>
                                        <td>${status.count}</td>
                                        <td><a class="fw-600 text-break gradient-text" href="oapForm.htm?act=siteSurveyView&id=${aocSurveyAttch.surveyNo}">${aocSurveyAttch.surveyNo}</a>
                                        </td>
                                        <td>${aocSurveyAttch.projectRepresentative}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                    <hr>
                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-6 col-md-9">
                                <div class="form-group">
                                    <label class="label" for="approvalName">TYPE <span class="text-danger">*</span></label>
                                    <select class="select-input" id="type" name="type" required="required" onchange="toggleItemDetails(this.value)">
                                        <option value="">--SELECT--</option>
                                        <option value="Goods">Goods</option>
                                        <option value="Service">Service</option>
                                        <option value="10">Contract</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-12 col-md-12">
                                <div class="form-group">
                                    <div id="goodsServiceSection" style="display: none;">
                                        <div class="content-top mb-1 d-flex align-items-center justify-content-between">
                                            <h5 id="itemDetailsHeading" class="fw-600 mr-4 mb-0">Items Details</h5>
                                            <button type="button" class="btn theme-btn" id="attachmentLink" onclick="requestAjaxItemDetails()" data-toggle="modal" data-target="#itemDetailsImport1">
                                                <img src="StorageYard/assets/images/attachment.svg" class="attachment mr-1 d-inline" onload="SVGInject(this)" alt="User Image"> Attachment
                                            </button>
                                        </div>


                                        <br>
                                        <div id="showtext1"></div>
                                    </div>                                  
                                    <br>  
                             <div id="serviceSection" style="display: none;">
                                        <div class="content-top mb-1 d-flex align-items-center justify-content-between mt-1">
                                            <h5 id="" class="fw-600 mr-4 mb-0">Item Details For Service</h5>
                                            <button type="button" class="btn theme-btn" id="attachmentLinkElse" onclick="requestAjaxItemDetails1()" data-toggle="modal" data-target="#itemDetailsContract">
                                                <img src="StorageYard/assets/images/attachment.svg" class="attachment mr-1 d-inline" onload="SVGInject(this)" alt="User Image"> Attachment
                                            </button>
                                        </div>


                                        <br>
                                        <div id="showtext11"></div>
                                    </div>  
                                   
                                            
                                            
                                    <script>
                                        function toggleItemDetails(type) {

                                            var str1 = document.getElementById("id").value;
                                            var itemDetailsHeading = document.getElementById("itemDetailsHeading");

                                            if (type === "Goods") {
                                                //                  alert("ss");
                                                var sts = 0;
                                                document.getElementById("goodsServiceSection").style.display = "block";
                                                document.getElementById("serviceSection").style.display = "none";
                                                itemDetailsHeading.innerHTML = "<b>Item Details</b>"; // Keep original name
                                                showuser1(str1, 0);
                                            } else if (type === "Service") {
                                                document.getElementById("goodsServiceSection").style.display = "block";
                                                document.getElementById("serviceSection").style.display = "none";
                                                itemDetailsHeading.innerHTML = "<b>Service Details</b>"; // Change name to Service Details
                                                showuser1(str1, 3);
                                            } else if (type === "10") {
                                                document.getElementById("goodsServiceSection").style.display = "block";
                                                document.getElementById("serviceSection").style.display = "block";
                                                itemDetailsHeading.innerHTML = "<b>Item Details</b>"; // Keep default name
                                                showuser1(str1, 4);
                                            } else {
                                                document.getElementById("goodsServiceSection").style.display = "none";
                                                document.getElementById("serviceSection").style.display = "none";
                                            }
                                        }

                                        // Function to open the attachment window with type and id
                                        function openAttachmentWindow() {
                                            var type = document.getElementById("type").value;
                                            var id = new URLSearchParams(window.location.search).get("id");
                                            if (!id || !type) {
                                                console.warn("ID or type is missing");
                                                return;
                                            }

                                            // Use "Contract_Goods" instead of "Contract&Goods"
                                            var typeParam = (type === "Contract") ? "Contract_Goods" : type;
                                            var url = 'oapForm.htm?act=Designcordinatorviewpopup&id=' + encodeURIComponent(id) + '&type=' + encodeURIComponent(typeParam);
                                            window.open(url, '', 'left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1');
                                        }
                                    </script>
                                    <br>

                                    <script type="text/javascript">
                                        function showuser1(str1, sts, type) {
                                            var idElement = document.getElementById("id");
                                            var typeElement = document.getElementById("type");
                                            if (!idElement || !typeElement) {
                                                console.warn("ID or type element is missing");
                                                return;
                                            }

                                            var str1 = idElement.value;
                                            var type = typeElement.value;
                                            if (!str1 || !type) {
                                                console.warn("ID or type value is missing");
                                                return;
                                            }

                                            // Convert "Contract" to "Contract_Goods" if necessary
                                            var typeParam = (type === "10") ? "Contract_Goods" : type;
                                            // Debugging: Check if typeParam is correct
                                            console.log("Type Parameter Sent:", typeParam);
                                            var xreq1;
                                            try {
                                                xreq1 = new XMLHttpRequest();
                                            } catch (e) {
                                                try {
                                                    xreq1 = new ActiveXObject("Msxml2.XMLHTTP");
                                                } catch (e) {
                                                    try {
                                                        xreq1 = new ActiveXObject("Microsoft.XMLHTTP");
                                                    } catch (e) {
                                                        alert("No AJAX!?");
                                                        return false;
                                                    }
                                                }
                                            }

                                            var requestURL = "oapForm.htm?act=AgaxOapIteamDatailsAttachmentscreate&q=" + encodeURIComponent(str1) + "&sts=" + encodeURIComponent(sts) + "&type=" + encodeURIComponent(typeParam);
                                            console.log("Request URL:", requestURL);
                                            xreq1.onreadystatechange = function () {
                                                if (xreq1.readyState == 4 && xreq1.status == 200) {
                                                    document.getElementById("showtext1").innerHTML = xreq1.responseText;
                                                    var count1 = document.getElementById("countt").value;
                                                    var count2 = document.getElementById("id8").value = count1;
                                                    //                                                           alert(count1);

                                                    var subbtn = document.getElementById("subbtn");
                                                    var typeElement1 = document.getElementById("type").value;
                                                    if (typeElement1 == "Contract") {
                                                        //                                                                    alert(typeElement1);
                                                        var id9 = document.getElementById("id9").value;
                                                        if (id9 != 0 && count2 != 0) {
                                                            subbtn.removeAttribute("disabled");
                                                        } else {
                                                            subbtn.setAttribute("disabled", "true");
                                                        }

                                                    } else {
                                                        if (count2 != 0) {
                                                            //                                                        alert(count2);
                                                            subbtn.removeAttribute("disabled");
                                                        } else {
                                                            subbtn.setAttribute("disabled", "true");
                                                        }
                                                    }
                                                    if ($('#itemsDetailsTab').length) {
                                                        const table1 = initTable('#itemsDetailsTab');
                                                        $('#entriesPerPage').on('change', function () {
                                                            table1.page.len($(this).val()).draw();
                                                        });
                                                        $('#searchBox').on('keyup', function () {
                                                            table1.search(this.value).draw();
                                                        });
                                                    }
                                                }
                                            };
                                            xreq1.open("GET", requestURL, true);
                                            xreq1.send();
                                            window.clearInterval(ID1);
                                        }
                                    </script>

                                    <div id="showtext1"></div>

                                    <!--                                            <h4><b>Item Details For Service</b></h4> <a href="StorageYard/Sample_File.xlsx">Sample File Download</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="#" onclick="window.open('oapForm.htm?act=Designcordinatorviewpopup1&id1=${id}', '', 'left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1');
                                                                                                                                                                                       ">Attachment File</a>

                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a  onclick="showuser11(id);" style="cursor: pointer;">Refresh</a>-->

                                    <script type="text/javascript">
                                        //  var win2 = window.open("tenderMaster.htm?act=addServiceDocument");
                                        //  win2.close();
                                        var str5 = document.getElementById("id1").value;
                                        var ID1;
                                        function showuser11(str1) {
                                            str1 = document.getElementById("id1").value;
                                            //var str5=str1;
                                            //  alert(str1);
                                            //if(win2 && win2.closed ){
                                            var xreq1;
                                            if (str1 === "") {
                                                document.getElementById("showtext11").innerHTML = "";
                                                return;
                                            }

                                            try {
                                                xreq1 = new XMLHttpRequest(); // Firefox, Opera 8.0+, Safari
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

                                            xreq1.onreadystatechange = function () {
                                                if (xreq1.readyState == 4 && xreq1.status == 200) {

                                                    document.getElementById("showtext11").innerHTML = xreq1.responseText;
                                                    var count3 = document.getElementById("countt").value;
                                                    var count4 = document.getElementById("id9").value = count3;
                                                    //                                                       alert(count3);
                                                    var subbtn = document.getElementById("subbtn");
                                                    var id8 = document.getElementById("id8").value;
                                                   
                                                    if (count4 != 0 && id8 == 0) {
//                                                                                                                alert(count4);
                                                        subbtn.removeAttribute("disabled");
                                                    } else {
                                                        subbtn.setAttribute("disabled", "true");
                                                    }
                                                    
                                                if ($('#itemsDetailsContractTab').length) {
                                                        const table1 = initTable('#itemsDetailsContractTab');
                                                        $('#entriesPerPage').on('change', function () {
                                                            table1.page.len($(this).val()).draw();
                                                        });
                                                        $('#searchBox').on('keyup', function () {
                                                            table1.search(this.value).draw();
                                                        });
                                                    }    
                                                    
                                                }
                                                
                                            }

                                            xreq1.open("Get", "oapForm.htm?act=AgaxOapIteamDatailsAttachments1&q=" + str5, true);
                                            xreq1.send();
                                            //}
                                            window.clearInterval(ID1);
                                        }
                                        ID1 = window.setInterval(showuser11(str5), 1000);
                                                                            </script>


                                    <div id="showtext11"></div>


                                </div>
                            </div>
                        </div>
                    </div>

                    <hr>
                    <table id="policyTable" class="table  table-striped bg-white dt-scroll" style="max-width: 100%"
                        align="center">
                        <thead>
                            <tr>
                                <th>Attachment</th>
                                <th>Description</th>
                                <th>Add New</th>
                                <input type="hidden" name="policyCount" id="policyCount" value="1" />
                            </tr>
                        </thead>
                        <tbody>
                            <tr id="policyRow1">
                                <td>
                                    <input id="attachment1" name="attach" class="input-field" type="file"
                                        onchange="validateFileSize(this)">
                                    <span id="fileError" style="color: red; font-size: 11px; display: none;">* File
                                        should not exceed 5MB</span>
                                </td>
                                <td>
                                    <input id="description1" name="descriptions" placeholder="Description"
                                        class="input-field" type="text">
                                </td>

                                <td style="text-align: center" class="d-flex justify-content-center align-items-center">
                                    <div class="clone-action clone-new-field mb-2" id="policyCloneid"
                                        style="cursor:pointer;">
                                        <img src="StorageYard/assets/images/clone-btn.svg" onload="SVGInject(this)"
                                            alt="Clone Btn" />
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <script>
                        if ($("#policyTable").length) {
                            const table1 = initDocTable("#policyTable");
                        }
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
                        $(function () {
                            $("#policyCloneid").on("click", function () {
                                tempCount3++;

                                var clone = "<tr id='addmoreFile" + tempCount3 + "' style='clear:both;'>"
                                    + "<td><input type=\"file\" class=\"input-field\" placeholder=\"action\" name=\"attach\" id=\"attachment" + tempCount3 + "\">\n\
                    <span id='fileError" + tempCount3 + "' style='display:none; color:red; font-size:12px;'>* File should not exceed 5MB</span></td>"

                                    + "<td><input type =\"text\" class=\"input-field\" placeholder=\"Description\" name=\"descriptions" + "" + "\" id=\"description" + tempCount3 + "\"></td>"

                                    + "<td class=\"d-flex justify-content-center align-items-center\">"
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
                        });

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

                    </script>


                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-6 col-md-9">
                                <div class="form-group">
                                    <label class="label" for="approvalName">Approval Name: <span
                                            class="text-danger">*</span></label>
                                    <select class="select-input" id="approvalName" name="approvalName"
                                        style="width: 225px; font-size: 12px; padding: 5px;" required="true">
                                        <option value="">--SELECT--</option>
                                        <c:forEach var="list16" items="${list16}">
                                            <option value="${list16[1]}">${list16[0]}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                        </div>
                    </div>

                    <div class="d-flex justify-content-center">
                        <button type="submit" class="btn theme-btn" id="subbtn" disabled="true">Submit</button>
                    </div>

                    <script src="StorageYard/assets/js/TableScript/oapForms.js" type="text/javascript"></script>
                    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp" %>
                </form:form>
                    
                <form:form id="myForm" enctype="multipart/form-data" commandName="prMaster" name="form"
                           class="form-horizontal" role="form">
                    <div class="modal fade" id="itemDetailsImport1" data-backdrop="static" data-keyboard="false"
                         tabindex="-1" aria-labelledby="itemDetailsImportLabel" aria-hidden="true">
                        <div class="modal-dialog modal-xl">
                            <div class="modal-content">
                                <div class="modal-header align-items-center">
                                    <h5 class="modal-title" id="itemDetailsImportLabel">Items Details Attachments</h5>
                                    <div class="cta-btn d-flex align-items-center">
                                        <button type="button" class="btn theme-btn light-btn" data-dismiss="modal" onclick="showuser1();">Close</button>
                                        <button type="button" class="btn theme-btn ml-3 d-none" id="importSubmitBtn1">Submit</button>
                                    </div>
                                </div>
                                <div class="modal-body import-items px-lg-4 position-relative blank">
                                    <div class="file-upload-base file-upload-area d-flex flex-column align-items-center justify-content-center rounded-3"
                                         id="file-upload-area" style="min-height: 220px;">
                                        <div class="upload-icon pb-3">
                                            <img src="StorageYard/assets/images/upload-icon.svg" class="mx-auto" onload="SVGInject(this)" alt="Upload Icon">
                                        </div>
                                        <p class="fw-600 upload-text mb-2 fs-14">Drag & drop files or
                                            <span class="gradient-text underline-text browseFile" data-target="#fileInput1" id="browseFile">&nbsp;Browse&nbsp;</span>
                                        </p>
                                        <p class="fs-13">Supported formats:
                                            <a href="StorageYard/Sample_File.xlsx">.xlsx</a>
                                        </p>
                                        <input type="file" id="fileInput1" name="service_file" hidden accept=".xlsx" />
                                    </div>

                                    <div class="importedDataTable mt-4 pt-2">
                                        <div class="content-top mb-3 d-flex align-items-center justify-content-between">
                                            <h6 class="fw-600 mr-4 mb-0">Items Details</h6>
                                            <button type="button" id="deleteSelected" class="btn theme-btn delete-btn d-none">
                                                <img src="StorageYard/assets/images/delete-icon.svg" class="icon" onload="SVGInject(this)" alt="Delete Icon">
                                                Delete Selected
                                            </button>
                                        </div>
                                        <input type="hidden" id="hiddenType"  />
                                        <div id="resultDivGoodnService" class="bg-white d-none">

                                            <script>
                                                document.getElementById('importSubmitBtn1').addEventListener('click', function () {
                                                    $('#itemDetailsTitle').removeClass('d-none');
                                                    var form = document.getElementById('myForm');
                                                    let type = $("#hiddenType").val();
                                                    let id = $("#id").val();
                                                    
                                                    var formData = new FormData(form);
                                                    formData.append("type", type);
                                                    formData.append("id", id);
                                                    
                                                    var xhr = new XMLHttpRequest();
                                                    xhr.open('POST', 'oapForm.htm?act=Designcordinatorviewpopupsubmit', true);
                                                    document.getElementById('resultDivGoodnService').innerHTML = "";

                                                    xhr.onload = function () {
                                                        if (xhr.status === 200) {
//                                                            document.getElementById('resultDivGoodnService').innerHTML = xhr.responseText;

//                                                            Swal.fire({
//                                                                icon: 'success',
//                                                                title: 'Success',
//                                                                text: 'Items Details attachment added successfully',
//                                                                confirmButtonColor: '#3085d6',
//                                                                confirmButtonText: 'OK'
//                                                            });

                                                                var resultDiv = document.getElementById('resultDivGoodnService');
                                                                resultDiv.innerHTML = xhr.responseText;

                                                                var swalDiv = resultDiv.querySelector('#swalData');

                                                                if (swalDiv) {
                                                                    var message = swalDiv.getAttribute('data-message');
                                                                    var status  = swalDiv.getAttribute('data-status');

                                                                    console.log(message);
                                                                    console.log(status);

                                                                    Swal.fire({
                                                                        icon: status === 'success' ? 'success' : 'error',
                                                                        title: status === 'success' ? 'Success' : 'Failed',
                                                                        text: message,
                                                                        confirmButtonColor: '#3085d6',
                                                                        confirmButtonText: 'OK'
                                                                    });
                                                                }

                                                            if ($('#AjaxModelOapIteamDatailsTab').length) {
                                                                setupImportItemsTable();
                                                            }
                                                        } else {
                                                            console.error("Error occurred: " + xhr.statusText);
                                                            Swal.fire({
                                                                icon: 'error',
                                                                title: 'Oops...',
                                                                text: 'Something went wrong! Please try again.'
                                                            });
                                                        }
                                                    };

                                                    xhr.onerror = function () {
                                                        console.error("Request failed.");
                                                        Swal.fire({
                                                            icon: 'error',
                                                            title: 'Network Error',
                                                            text: 'Unable to connect to the server. Please check your connection.'
                                                        });
                                                    };

                                                    xhr.send(formData);
                                                });
                                            </script>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                      
                <!--Item Details For Service-->
    
                    
                  <div class="modal fade" id="itemDetailsContract" data-backdrop="static" data-keyboard="false"
                         tabindex="-1" aria-labelledby="itemDetailsContractLabel" aria-hidden="true">
                        <div class="modal-dialog modal-xl">
                            <div class="modal-content">
                                <div class="modal-header align-items-center">
                                    <h5 class="modal-title" id="itemDetailsContractLabel">Items Details Attachments</h5>
                                    <div class="cta-btn d-flex align-items-center">
                                        <button type="button" class="btn theme-btn light-btn" data-dismiss="modal" onclick="showuser11();">Close</button>
                                        <button type="button" class="btn theme-btn ml-3 d-none" id="contractSubmitBtn">Submit</button>
                                    </div>
                                </div>
                                <div class="modal-body import-items px-lg-4 position-relative blank">
                                    <div class="file-upload-base file-upload-area d-flex flex-column align-items-center justify-content-center rounded-3"
                                         id="file-upload-area" style="min-height: 220px;">
                                        <div class="upload-icon pb-3">
                                            <img src="StorageYard/assets/images/upload-icon.svg" class="mx-auto" onload="SVGInject(this)" alt="Upload Icon">
                                        </div>
                                        <p class="fw-600 upload-text mb-2 fs-14">Drag & drop files or
                                            <span class="gradient-text underline-text browseFile" data-target="#fileInput" id="browseFile1">&nbsp;Browse&nbsp;</span>
                                        </p>
                                        <p class="fs-13">Supported formats:
                                            <a href="StorageYard/Sample_File.xlsx">.xlsx</a>
                                        </p>
                                        <input type="file" id="fileInput" name="service_file1" hidden accept=".xlsx" />
                                    </div>

                                    <div class="importedDataTable mt-4 pt-2">
                                        <div class="content-top mb-3 d-flex align-items-center justify-content-between">
                                            <h6 class="fw-600 mr-4 mb-0">Items Details</h6>
                                            <button type="button" id="deleteSelectedContract" class="btn theme-btn delete-btn d-none">
                                                <img src="StorageYard/assets/images/delete-icon.svg" class="icon" onload="SVGInject(this)" alt="Delete Icon">
                                                Delete Selected
                                            </button>
                                        </div>
                                        <input type="hidden" id="hiddenType"  />
                                        <script>
                                                document.getElementById('contractSubmitBtn').addEventListener('click', function () {
                                                    $('#itemDetailsTitleContract').removeClass('d-none');
                                                    var form = document.getElementById('myForm');
                                                    let type = $("#hiddenType").val();
                                                    let id = $("#id").val();
                                                    
                                                    var formData = new FormData(form);
                                                    formData.append("type", "Contract");
                                                    formData.append("id1", id);
                                                    
                                                    var xhr = new XMLHttpRequest();
                                                    xhr.open('POST', 'oapForm.htm?act=Designcordinatorviewpopupsubmit1', true);
                                                    document.getElementById('resultDivContract').innerHTML = "";

                                                    xhr.onload = function () {
                                                        if (xhr.status === 200) {
//                                                            document.getElementById('resultDivContract').innerHTML = xhr.responseText;
//
//                                                            Swal.fire({
//                                                                icon: 'success',
//                                                                title: 'Success',
//                                                                text: 'Items Details attachment added successfully',
//                                                                confirmButtonColor: '#3085d6',
//                                                                confirmButtonText: 'OK'
//                                                            });
                                                            
                                                      var resultDiv = document.getElementById('resultDivContract');
                                                                resultDiv.innerHTML = xhr.responseText;

                                                                var swalDiv = resultDiv.querySelector('#swalData');

                                                                if (swalDiv) {
                                                                    var message = swalDiv.getAttribute('data-message');
                                                                    var status  = swalDiv.getAttribute('data-status');

                                                                    console.log(message);
                                                                    console.log(status);

                                                                    Swal.fire({
                                                                        icon: status === 'success' ? 'success' : 'error',
                                                                        title: status === 'success' ? 'Success' : 'Failed',
                                                                        text: message,
                                                                        confirmButtonColor: '#3085d6',
                                                                        confirmButtonText: 'OK'
                                                                    });
                                                                }      
                                                            
                                                            
                                                            if ($('#AjaxOapIteamDetailsContractTab').length) {
                                                                setupImportItemsContractTable();
                                                            }
                                                        } else {
                                                            console.error("Error occurred: " + xhr.statusText);
                                                            Swal.fire({
                                                                icon: 'error',
                                                                title: 'Oops...',
                                                                text: 'Something went wrong! Please try again.'
                                                            });
                                                        }
                                                    };

                                                    xhr.onerror = function () {
                                                        console.error("Request failed.");
                                                        Swal.fire({
                                                            icon: 'error',
                                                            title: 'Network Error',
                                                            text: 'Unable to connect to the server. Please check your connection.'
                                                        });
                                                    };

                                                    xhr.send(formData);
                                                });
                                            </script>
                                           
                                            <div id="resultDivContract" class="bg-white d-none">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                </form:form>
                
            </section>
        </main>
    </body>
    <script>
        function requestAjaxItemDetails() {
            let type = $("#type").val();
            let id = $("#id").val();
            $("#hiddenType").val(type);
            $.ajax({
                url: 'oapForm.htm?act=Designcordinatorviewpopup' ,
                type: "post",
                data: {
                    id: id,
                    type: type,
                },
                success: function (response) {
//                    $("#ajaxPrApprovalDetails").html("");
                    $('#resultDivGoodnService').removeClass('d-none');
                    
                    $("#resultDivGoodnService").html(response);
                    if ($('#AjaxModelOapIteamDatailsTab').length) {
                        setupImportItemsTable();
                    }
                },
                error: function (err) {
                    console.error(err);
                }
            });
        }
        
    </script>

    <script>
        function setupImportItemsTable() {
            if ($('#AjaxModelOapIteamDatailsTab').length) {
                initTable('#AjaxModelOapIteamDatailsTab');

                $('#select_all').on('change', function () {
                    $('.rowCheckbox').prop('checked', this.checked).trigger('change');
                });

                $('#AjaxModelOapIteamDatailsTab tbody').on('change', '.rowCheckbox', function () {
                    const anyChecked = $('.rowCheckbox:checked').length > 0;
                    $('#deleteSelected').toggleClass('d-none', !anyChecked).toggleClass('', anyChecked);
                    $('#select_all').prop('checked', $('.rowCheckbox:checked').length === $('.rowCheckbox').length);
                });

                $('#deleteSelected').on('click', function () {
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

                    const msg = selectedIds.length === 1
                        ? 'Are you sure you want to delete this Item?'
                        : `Are you sure you want to delete these ${selectedIds.length} Items?`;

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
                            var formData = new FormData();

                            formData.append("id", document.getElementById("id").value);
                            formData.append("type", document.getElementById("hiddenType").value);
                            console.log(formData);
                            
                            formData.append("Ids", selectedIds.join(','));
                            $.ajax({
                                url: 'oapForm.htm?act=deleteDesigncordinatorviewpopup',
                                type: 'POST',
                                data: formData,
                                contentType: false,
                                processData: false, 
                                success: function (response) {
                                    Swal.fire({
                                        icon: 'success',
                                        title: 'Deleted!',
                                        text: response.message
                                    });
                                    console.log(selectedIds);
                                    $('#AjaxModelOapIteamDatailsTab')
                                        .DataTable()
                                        .rows(function (idx, data, node) {
                                            return $(node).find('.rowCheckbox').is(':checked');
                                        })
                                        .remove()
                                        .draw();
                                    $('#deleteSelected').addClass('d-none');
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
    
   <!--Item Details For Contract-->
 
    
    <script>
        function requestAjaxItemDetails1() {
//            let type = $("#type").val();
            let id = $("#id").val();
            $("#hiddenType").val(type);
            $.ajax({
                url: 'oapForm.htm?act=Designcordinatorviewpopup1' ,
                type: "post",
                data: {
                    id1: id,
                    type: "Contract",
                },
                success: function (response) {
                    $('#resultDivContract').removeClass('d-none');
                    
                    $("#resultDivContract").html(response);
                    if ($('#AjaxOapIteamDetailsContractTab').length) {
                        setupImportItemsContractTable();
                    }
                },
                error: function (err) {
                    console.error(err);
                }
            });
        }
        
    </script>
    <script>
        function setupImportItemsContractTable() {
            if ($('#AjaxOapIteamDetailsContractTab').length) {
                initTable('#AjaxOapIteamDetailsContractTab');

                $('#select_all').on('change', function () {
                    $('.rowCheckbox').prop('checked', this.checked).trigger('change');
                });

                $('#AjaxOapIteamDetailsContractTab tbody').on('change', '.rowCheckbox', function () {
                    const anyChecked = $('.rowCheckbox:checked').length > 0;
                    $('#deleteSelectedContract').toggleClass('d-none', !anyChecked).toggleClass('', anyChecked);
                    $('#select_all').prop('checked', $('.rowCheckbox:checked').length === $('.rowCheckbox').length);
                });

                $('#deleteSelectedContract').on('click', function () {
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

                    const msg = selectedIds.length === 1
                        ? 'Are you sure you want to delete this Item?'
                        : `Are you sure you want to delete these ${selectedIds.length} Items?`;

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
                            var formData = new FormData();
                            
                            formData.append("id", document.getElementById("id").value);
                            formData.append("type", document.getElementById("hiddenType").value);
                            console.log(formData);
                            
                            formData.append("Ids", selectedIds.join(','));
                            $.ajax({
                                url: 'oapForm.htm?act=deleteDesigncordinatorviewpopup1',
                                type: 'POST',
                                data: formData,
                                contentType: false,
                                processData: false, 
                                success: function (response) {
                                    Swal.fire({
                                        icon: 'success',
                                        title: 'Deleted!',
                                        text: response.message
                                    });
                                    console.log(selectedIds);
                                    $('#AjaxOapIteamDetailsContractTab')
                                        .DataTable()
                                        .rows(function (idx, data, node) {
                                            return $(node).find('.rowCheckbox').is(':checked');
                                        })
                                        .remove()
                                        .draw();
                                    $('#deleteSelectedContract').addClass('d-none');
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
    
    
</html>