
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Deliverable View List</title>
    </head>
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
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="oapForm.htm?act=AllDeliverableViewOapAttchment" method="post" commandName="oapForm"
                           class="form-horizontal" role="form">           
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">All Deliverable View List</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                            <a style="width:180px!important; " class="btn theme-btn mr-3"  href="oapForm.htm?act=BomSheet&id=${id}" title="Export data to Excel">
                                <i class="fa fa-file-excel-o"></i>&nbsp;&nbsp;BOM Excel
                            </a>
                            <!--<button type="submit" class="btn theme-btn">Submit</button>-->
                        </div>
                    </div>

                    <hr>
                    <input type="hidden" id="id" name="id" value="${id}">
                    <input type="hidden" id="size" name="size" value="${size}">

                    <h6>OAP Form</h6>
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
                    <hr>
                    <c:if test="${size!='0'}">   
                        <table  id="commonTable" class="table table-striped bg-white" style="max-width: 100%; "> <!-- Set maximum width and border -->
                            <thead>
                                <tr>
                                    <th>Sr. No.</th>
                                    <th>Description</th>
                                    <th>Username</th>
                                    <th data-dt-order="disable">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="DelivableCreate" items="${DelivableCreate}" varStatus="status">
                                    <tr>
                                        <td>${status.count}</td> <!-- Serial Number -->
                                        <td>${DelivableCreate.description}</td> <!-- User ID -->
                                        <td>${DelivableCreate.designCoordinator}</td> <!-- User ID -->
                                        <td>
                                            <div class="btn-group" style="display: flex; gap: 12px;"> 
                                                <a href="oapForm.htm?act=DesigncordinatorApprovedView&id=${DelivableCreate.id}" class="btn theme-btn light-btn"> View</a>
                                                <a data-id="${DelivableCreate.id}" data-toggle="modal" class="btn theme-btn light-btn" data-target="#closeDeliverable" onclick="requestTechbidTab(this)">Close</a>
<!--                                                <a href="oapForm.htm?act=id=${DelivableCreate.id}" class="btn theme-btn light-btn" style="margin-left: 10px;" onclick="openPopup(event, ${status.count}, '${DelivableCreate.id}')">
                                                    Close
                                                </a>-->
                                            </div>
                                            <!-- Hidden Popup -->
                                            

                                        </td> <!-- User ID -->
                                    </tr>
                                </c:forEach>
                            </tbody>


                        </table>
                       

                        <br>
                        <table id="policyTable" class="table dt-scroll" style="max-width: 100%" align="center">
                            <tr>
                                <th>Description</th>
                                <th>Design Co-ordinator</th>
                                <th>Add New</th>
                                <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                            </tr>
                            <tr id="policyRow1">
                                <td>
                                    <input id="description1" name="descriptions" placeholder="Description" class="input-field" type="text" >
                                </td>  
                                <td>
                                    <select class="select-input" id="attachment1" name="attach" style=" font-size: 12px; padding: 5px;"  >
                                        <option value="">--SELECT--</option>
                                        <c:forEach var="list23" items="${list23}">
                                            <option value="${list23[1]}">${list23[0]}</option>
                                        </c:forEach>
                                    </select>
                                </td> 
                                <td style="text-align: center" class="d-flex justify-content-center align-items-center">
                                    <div class="clone-action clone-new-field mb-2" id="policyCloneid" style="cursor:pointer;">
                                        <img src="StorageYard/assets/images/clone-btn.svg" onload="SVGInject(this)" alt="Clone Btn" />
                                    </div>
                                </td>
                            </tr>
                        </table>
                        <br>
                        <div class="form-group">
                            <div style="display: flex;  justify-content: center;">
<button type="submit" class="btn theme-btn" style="width: 180px !important;" title="" value="SUBMIT">SUBMIT</button>
                            </div>
                        </div>
                    </c:if>
                    <script>
                        var tempCount3 = 1;
                        $(function () {
                            $("#policyCloneid").on("click", function () {
                                tempCount3++;
                                var clone = "<tr id='addmoreFile" + tempCount3 + "' style='clear:both;'>"
                                + "<td><input type =\"text\" class=\"input-field\" placeholder=\"Description\" name=\"descriptions" + "" + "\" id=\"description" + tempCount3 + "\"></td>"
                                + "<td id=\"addmoreFile" + tempCount3 + "\"  style=\"text-align: center\"><div>\n\
                                    <select id='attachment" + tempCount3 + "' name='attach" + "' class=\"select-input\">"
                                + "<option value=''>--Select--</option>"
                                + "<c:forEach var='list23' items='${list23}'>"
                                + "<option value='${list23[1]}'>${list23[0]}</option>"
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

                </form:form>
                
                <div class="modal fade" id="closeDeliverable" data-backdrop="static" data-keyboard="false"
                    tabindex="-1" aria-labelledby="closeDeliverableLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">

                            <div class="modal-header align-items-center">
                                <h5 class="modal-title" id="closeDeliverableLabel">Close Deliverable</h5>
                                <div class="cta-btn d-flex align-items-center">
                                    <button type="button" class="btn theme-btn light-btn" data-dismiss="modal" >Close</button>
                                    <button type="button" class="btn theme-btn ml-3" id="closeDeliverableBtn">Submit</button>
                                </div>
                            </div>

                            <div class="modal-body">
                                <input type="hidden" id="hiddenId" />
                                <div class="row col-12">
                                    <div class="form-group col-4">
                                        <label>Date & Time:<span class="text-danger">*</span></label>
                                        <input id="fromdateTime" name="fromdateTime" type="text" placeholder="DD-MM-YYYY MM:SS" class="input-field form_datetime" maxlength="30" />
                                    </div>
                                    <div class="form-group col-8">
                                        <label>Comments:<span class="text-danger">*</span></label>
                                        <textarea id="comments" name="comment" class="textarea-field" style="width: 100%; height: 60px;" ></textarea>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
    <script>
        function requestTechbidTab(element) {
            var hiddenId = element.getAttribute('data-id');
            document.getElementById('hiddenId').value = hiddenId;
        }
        
        if (!document.getElementById("fromdateTime")._flatpickr) {
            flatpickr("#fromdateTime", {
                dateFormat: "d-m-Y H:i",
                enableTime: true,
                allowInput: true,
                onOpen: function(selectedDates, dateStr, instance) {
                    if (!instance.input.value) {
                        instance.setDate(new Date());
                    }
                }
            });
        }

        document.getElementById('closeDeliverableBtn').addEventListener('click', function () {
            const fromdateTime = $('#fromdateTime').val();
            const comments = $('#comments').val();
            const id1 = $('#id').val();
            const id = $('#hiddenId').val();

            if (comments && fromdateTime) {
                $.ajax({
                    url: 'oapForm.htm?act=AllDeliverablepopupsubmitOap' ,
                    type: "post",
                    data: { 
                        fromdateTime: fromdateTime,
                        com: comments,
                        id: id,
                        id1: id1 
                    },
                    success: function (response) {
                        Swal.fire({
                            icon: 'Success',
                            title: 'Submitted',
                            text: 'Data Submitted Successfully'
                        });
                    },
                    error: function (err) {
                        console.error(err);
                    }
                });

            } else{
                Swal.fire({
                    icon: 'warning',
                    title: 'Close Deliverable',
                    text: 'Please Fill the * Fields Data .'
                });
            }
        });

    </script>
    <script>
                    requestajaxPrApprovalDetails();
                    $("#userList1").on("change", function () {
                        requestajaxPrApprovalDetails();          
                    });
                    function requestajaxPrApprovalDetails() {
                        let userValue = $("#userList1").val();
                        $.ajax({
                            url: 'prMaster.htm?act=ajaxPrApprovalDetails' ,
                            type: "post",
                            data: { userId: userValue },
                            success: function (response) {
                                $("#ajaxPrApprovalDetails").html(response);
                                if ($('#tenderApprovalTab').length) {
                                    const table1 = initTable('#tenderApprovalTab');
                                }
                            },
                            error: function (err) {
                                console.error(err);
                            }
                        });
                    }
                </script>
    <!--oapForm.htm?act=AllDeliverablepopupsubmitOap-->
    
<!--    + "&com=" + encodeURIComponent(comment)
            + "&fromdateTime=" + encodeURIComponent(fromDateTime)
            + "&id1=" + encodeURIComponent(id1)
            + "&id=" + encodeURIComponent(id);-->
    
</html>
