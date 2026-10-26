<%-- 
    Document   : ApproveOneVendor
    Created on : 13 Oct, 2025, 03:59:00 PM
    Author     : fnp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>Buyer Approval List</title>
    </head>

    <body>
        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

            <section class="main-content">
                <form:form action="" method="post" commandName="rightMaster"
                           name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
                    <div class="card-box rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)" alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)" alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Buyer Approval List</h5>
                        </div>
                        <div class="cta d-flex align-items-center">                            
                            <a onclick="window.location = 'vendorInvitation.htm?act=addVendorInvitation'" class="btn theme-btn flex ml-3">
                                <img src="StorageYard/assets/images/plus.svg" onload="SVGInject(this)" class="mr-2 icon" alt="Plus Icon">
                                Invite Vendor
                            </a>
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
                    <div class="card-box rounded-3 mt-3 py-2 px-3  top-0 sticky-model1">
                        <ul class="list-unstyled mb-0 d-flex align-items-center overflow-auto">
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.allVendor=='1'}">
                                    <a href="vendorInformation.htm?act=allVendor" class="tab-link transition-0">All Vendors</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.venderInvite=='1'}">
                                    <a href="vendorInformation.htm?act=newVendor" class="tab-link transition-0">Invited Vendor</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.venderRequest=='1'}">
                                    <a href="vendorInformation.htm?act=inprogressVendor" class="tab-link transition-0">In Progress</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.buyerApproval=='1'}">
                                    <a href="vendorInformation.htm?act=firstLevelnApprove" class="tab-link active transition-0">Buyer</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.procurementHead=='1'}">
                                    <a href="vendorInformation.htm?act=procurementHeadApproval" class="tab-link transition-0">Procurement Head Approval</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.financialApproval=='1'}">
                                    <a href="vendorInformation.htm?act=finacialApproval" class="tab-link transition-0">Financial Approval</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.technicalApproval=='1'}">
                                    <a href="vendorInformation.htm?act=technicalApproval" class="tab-link transition-0">Technical Approval</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.hrApproval=='1'}">
                                    <a href="vendorInformation.htm?act=hrApproval" class="tab-link transition-0">HR Approval</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.safetyApproval=='1'}">
                                    <a href="vendorInformation.htm?act=safetyApproval" class="tab-link transition-0">Safety Approval</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.itApproval=='1'}">
                                    <a href="vendorInformation.htm?act=itApproval" class="tab-link transition-0">IT Approval</a>
                                </c:if>
                            </li>
                        </ul>
                    </div>
                    
                    

                    <%@include file="/WEB-INF/jsp/Common/TablePageNew.jsp"%>
                    <table id="CommonTable" class="table table-striped bg-white" style="min-width: 100%;" align="Center"  >
                        <c:choose>
                            <c:when test="${empty vendorInformation1}"></c:when>
                            <c:otherwise>
                                <thead>
                                    <tr>                                        
                                        <th>Sr.No.</th>
                                        <th>Company Name</th>
                                        <th>Email Id</th>
                                        <th>Status</th>
                                        <th data-dt-order="disable">Action</th>                                   
                                    </tr>
                                </thead>
                                <c:set var="count" value="0" scope="page" />
                                <tbody>
                                    <c:forEach var="list" items="${vendorInformation1}" varStatus="status">
                                        <tr>
                                            <td> ${status.count}</td>
                                            <td>${list[1]}</td>
                                            <td>${list[2]}</td>
                                            <td>
                                                <c:if test="${list[3]==2}">
                                                    &nbsp;Approve
                                                </c:if>
                                                <c:if test="${list[3]==1}">
                                                    &nbsp;Pending
                                                </c:if>
                                                <c:if test="${list[3]==8}">
                                                    &nbsp;Active Vender <br><span style="color: red;">Ask For Account Change</span>
                                                </c:if>
                                                <c:if test="${list[3]==9}">
                                                    &nbsp;Active Vender <br><span style="color: red;">Rejected Account Changes</span>
                                                </c:if>
                                                <c:if test="${list[3]==11}">
                                                    &nbsp;Active Vender <br><span style="color: red;">Accept Account Changes</span>
                                                </c:if>
                                                <c:if test="${list[3]==3}">
                                                    &nbsp;Recycle From Buyer
                                                </c:if>
                                                <c:if test="${list[3]==6}">
                                                    &nbsp;Reject From Buyer
                                                </c:if>
                                                <c:if test="${list[3]==10 && list[5]==1}">
                                                    &nbsp;Active Vender
                                                </c:if>
                                                <c:if test="${list[3]==100}">
                                                    &nbsp;Sent To Auditor
                                                </c:if>
                                                <c:if test="${list[3]==101}">
                                                    &nbsp;Sent To Procurement Head
                                                </c:if>
                                                <c:if test="${list[3]==102}">
                                                    &nbsp;Procurement Head Approved
                                                </c:if>
                                                <c:if test="${list[3]==5}">
                                                    &nbsp;Recycle By Procurement Head                                                   
                                                </c:if>
                                                <c:if test="${list[3]==7}">
                                                    &nbsp;Rejected By Procurement Head                                                    
                                                </c:if>
                                                <c:if test="${list[3]==500}">
                                                    &nbsp;Sent To Compliance Officer
                                                </c:if>                                                    
                                                <c:if test="${list[3]==501}">
                                                    &nbsp;Reject From Compliance Officer
                                                </c:if>
                                                <c:if test="${list[3]==502}">
                                                    &nbsp;Recycle From Compliance Officer
                                                </c:if>
                                                <c:if test="${list[3]==4}">
                                                    &nbsp;Recycle From Auditor
                                                </c:if>
                                                <c:if test="${list[5]==5}">
                                                    &nbsp; <span style="color: red">Vendor Financial Information Update Request</span>
                                                </c:if>
                                                <c:if test="${list[5]==6}">
                                                    &nbsp; Vendor Financial  Request Updated
                                                </c:if>
                                                <c:if test="${list[5]==7||list[5]==8}">
                                                   &nbsp;Active Vender
                                                </c:if>
                                            </td>
                                            
                                            <td>
                                                <c:if test="${list[3]==102}">                                                   
                                                    <a href="vendorInformation.htm?act=approveoneviewClick&id=${list[0]}" class="btn theme-btn">Send To Acceptance</a>
                                                </c:if>
                                                <c:if test="${list[3]==502}">                                                   
                                                    <a href="vendorInformation.htm?act=selectAuditor&id=${list[0]}" class="btn theme-btn">Send To Acceptance</a>
                                                </c:if>
                                                <c:if test="${list[3]==1}">
                                                    <a href="vendorInformation.htm?act=selectAuditor&id=${list[0]}" class="btn theme-btn">Send To Auditor Acceptance</a>                                                    
                                                </c:if>
                                                <c:if test="${list[3]==0 || list[3]==6 || list[3]==5 || list[3]==7 || list[3]==4   || list[3]==8 || list[3]==9 || list[3]==11 || list[3]==101 || list[3]==100 || list[3]==3}">
                                                    <a href="vendorInformation.htm?act=approveoneviewClickview&id=${list[0]}" class="btn theme-btn light-btn">View</a>                                                    
                                                </c:if>
                                                    <c:if test="${(list[3] == 10 || list[3] == 2 || list[3] == 500 || list[3] == 501 || list[5] == 6 || list[5] == 7) && list[5] != 5}">
                                                        <a href="vendorInformation.htm?act=approveoneviewClickTwo&id=${list[0]}" class="btn theme-btn light-btn">Views</a>
                                                    </c:if>
                                                        <c:if test="${list[5] == 5}">
                                                            <div class="cta d-flex align-items-center justify-content-center" style="gap:15px;">
                                                                <button type="button" class="btn theme-btn" id="submit2" title="submit2"
                                                                        onclick="openApprovalModal('${list[0]}', '${list[1]}', '${list[2]}', '${list[6]}')">Approve/Reject</button>
                                                            </div>
                                                        </c:if>   

                                            </td> 
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </c:otherwise>
                        </c:choose>
                    </table>


                </form:form>
                    <!-- Financial Approval Modal -->
<div class="modal fade" id="approvalModal" data-backdrop="static" data-keyboard="false" tabindex="-1"
     aria-labelledby="approvalModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header align-items-center">
                <h5 class="modal-title" id="approvalModalLabel">Buyer Approval :</h5>
                <div class="cta-btn d-flex align-items-center">
                    <button type="button" class="btn theme-btn light-btn" data-dismiss="modal"
                            onclick="window.location.href='vendorInformation.htm?act=firstLevelnApprove';">Close</button>
                    <button type="button" class="btn theme-btn ml-3" id="approveButton" data-status="Approve">
                        <span class="btn-spinner" id="approveBtnSpinner"></span>
                        <span id="approveBtnText" style="color: white;">Approve</span>
                    </button>
                    <button type="button" class="btn theme-btn ml-2" id="rejectButton" data-status="Reject" style="background:#D8000C;">
                        <span class="btn-spinner" id="rejectBtnSpinner"></span>
                        <span id="rejectBtnText" style="color: white;">Reject</span>
                    </button>
                </div>
            </div>
            <div class="modal-body">
                <div id="approvalResultDiv" class="bg-white">

                    <div class="approval-loading-overlay" id="approvalLoadingOverlay">
                        <div class="spinner-border text-danger" role="status"></div>
                        <span>Processing, please wait...</span>
                    </div>

                    <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.
                            <div style="font-weight: bold;" id="approvalErrorMsg" class="text-danger" style="display:none; font-size:12px;"></div>
                        </div>
                    </div>
                    <br>

                    <form id="approvalForm" action="vendorInformation.htm" method="post">

                        <input type="hidden" name="act" value="FinancialApprovalProcess">
                        <input type="hidden" name="id" id="approvalVendorId">
                        <input type="hidden" name="approvalStatus" id="approvalStatus">
                        <div class="col-12 p-0">
                            <div class="form-group d-flex" style="gap:8px;">
                                <label class="control-label mb-0" style="width:200px; flex-shrink:0;">Company Name :</label>
                                <span id="approvalCompanyName" style="font-weight: bold;"></span>
                            </div>

                            <div class="form-group d-flex" style="gap:8px;">
                                <label class="control-label mb-0" style="width:200px; flex-shrink:0;">Email Id :</label>
                                <span id="approvalEmailId" style="font-weight: bold;"></span>
                            </div>

                            <div class="form-group d-flex" style="gap:8px;">
                                <label class="control-label mb-0" style="width:200px; flex-shrink:0;">Vendor Comments For Buyer :</label>
                                <span id="approvalVendorComments" style="font-weight: bold;"></span>
                            </div>

                            <div class="form-group comment-box">
                                <label class="control-label">Comments :<span class="text-danger">*</span></label>
                                <textarea type="text" maxlength="250" class="textarea-field remark" id="approvalRemark" name="remark" required="true"></textarea>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<style>
    #approvalResultDiv {
        position: relative;
    }
    .approval-loading-overlay {
        display: none;
        position: absolute;
        top: 0; left: 0; right: 0; bottom: 0;
        background: rgba(255, 255, 255, 0.75);
        z-index: 10;
        align-items: center;
        justify-content: center;
        flex-direction: column;
        border-radius: 8px;
    }
    .approval-loading-overlay .spinner-border {
        width: 2rem;
        height: 2rem;
    }
    .approval-loading-overlay span {
        margin-top: 8px;
        font-size: 13px;
        font-weight: bold;
        color: #333;
    }
    #approveButton .btn-spinner,
    #rejectButton .btn-spinner {
        display: none;
        width: 14px;
        height: 14px;
        border: 2px solid rgba(255,255,255,0.5);
        border-top-color: #fff;
        border-radius: 50%;
        margin-right: 6px;
        animation: approval-spin 0.7s linear infinite;
        vertical-align: middle;
    }
    @keyframes approval-spin {
        to { transform: rotate(360deg); }
    }
</style>
<script>
  function openApprovalModal(id, companyName, emailId, vendorComments) {
    $('#approvalErrorMsg').hide().text('');
    $('#approvalVendorId').val(id);
    $('#approvalCompanyName').text(companyName);
    $('#approvalEmailId').text(emailId);
    $('#approvalVendorComments').text(vendorComments);
    $('#approvalRemark').val('');
    $('#approvalStatus').val('');

    resetApprovalButtons();

    $('#approvalModal').modal('show');
}

    function showApprovalError(message) {
        var $errorMsg = $('#approvalErrorMsg');
        clearTimeout($errorMsg.data('timeout'));

        $errorMsg.stop(true, true)
                 .removeClass('text-success')
                 .addClass('text-danger')
                 .text(message)
                 .show();

        var timeout = setTimeout(function () {
            $errorMsg.fadeOut(function () {
                $(this).text('');
            });
        }, 3000);

        $errorMsg.data('timeout', timeout);
    }

    function resetApprovalButtons() {
        $('#approveButton, #rejectButton').prop('disabled', false);
        $('#approveBtnSpinner, #rejectBtnSpinner').hide();
        $('#approveBtnText').text('Approve');
        $('#rejectBtnText').text('Reject');
        $('#approvalLoadingOverlay').hide();
    }

    function setApprovalLoading(clickedBtnId, isLoading) {
        if (isLoading) {
            $('#approvalLoadingOverlay').css('display', 'flex');
            $('#approveButton, #rejectButton').prop('disabled', true);

            if (clickedBtnId === 'approveButton') {
                $('#approveBtnSpinner').show();
                $('#approveBtnText').text('Processing...');
            } else {
                $('#rejectBtnSpinner').show();
                $('#rejectBtnText').text('Processing...');
            }
        } else {
            $('#approvalLoadingOverlay').hide();
            $('#approveBtnSpinner, #rejectBtnSpinner').hide();

            if (!$('#approveButton').prop('disabled')) {
                $('#approveBtnText').text('Approve');
                $('#rejectBtnText').text('Reject');
            }
        }
    }

    $(document).on('click', '#approveButton, #rejectButton', function (e) {
        e.preventDefault();

        var clickedBtnId = $(this).attr('id');
        var status = $(this).data('status');
        var remark = $('#approvalRemark').val().trim();

        if (!remark) {
            showApprovalError('Remark is mandatory');
            return;
        }

        $('#approvalStatus').val(status);

        var formData = new FormData($('#approvalForm')[0]);

        setApprovalLoading(clickedBtnId, true);

        $.ajax({
            url: $('#approvalForm').attr('action'),
            type: 'POST',
            data: formData,
            processData: false,
            contentType: false,

            success: function (response) {

                $('#approvalErrorMsg')
                    .removeClass('text-danger')
                    .addClass('text-success')
                    .text('Vendor Financial Change Request ' + status + 'd Sucessfully ')
                    .show();

                $('#approvalRemark').val('');

                $('#approvalLoadingOverlay').hide();
                $('#approveBtnSpinner, #rejectBtnSpinner').hide();

                $('#approveButton, #rejectButton').prop('disabled', true);
                if (clickedBtnId === 'approveButton') {
                    $('#approveBtnText').text('Approved');
                } else {
                    $('#rejectBtnText').text('Rejected');
                }
            },

            error: function () {
                setApprovalLoading(clickedBtnId, false);
                showApprovalError('Something went wrong.');
            },

            complete: function () {
                if (!$('#approveButton').prop('disabled')) {
                    setApprovalLoading(clickedBtnId, false);
                }
            }
        });
    });
</script>
            </section>
        </main> 
    </body>

    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
    <script>        
        if ($('#CommonTable').length) {
            const table = initTable('#CommonTable')
            $(function () {
                table.page.len($('#entriesPerPage').val()).draw();
            });
            // Entries Per Page Control
            $('#entriesPerPage').on('change', function () {
                table.page.len($(this).val()).draw();
            });
            // Global Search Box
            $('#searchBox').on('keyup', function () {
                table.search(this.value).draw();
            });
            // Select All Checkbox
            $('#select_all').on('change', function () {
                $('.rowCheckbox').prop('checked', this.checked).trigger('change');
            });
            // Individual Row Checkbox
            $('#CommonTable tbody').on('change', '.rowCheckbox', function () {
                if ($('.rowCheckbox:checked').length > 0) {
                    $('#deleteSelected').removeClass('d-none').addClass('d-flex');
                } else {
                    $('#deleteSelected').addClass('d-none').removeClass('d-flex');
                }

                if ($('.rowCheckbox:checked').length === $('.rowCheckbox').length) {
                    $('#select_all').prop('checked', true);
                } else {
                    $('#select_all').prop('checked', false);
                }
            });
            // Delete Multiple Records
            $('#deleteSelected').on('click', function () {
                var selectedIds = [];
                $('.rowCheckbox:checked').each(function () {
                    var selectedId = $(this).val(); // Get the value from the checkbox
                    selectedIds.push(selectedId);
                });
                if (selectedIds.length === 0) {
                    Swal.fire({
                        icon: 'warning',
                        title: 'No Selection',
                        text: 'Please select at least one row to delete.'
                    });
                    return;
                }
            });
        }
        ;
    </script>
</html>
