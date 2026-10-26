<%-- 
    Document   : vendorBlockListDashboard
    Created on : Jul 17, 2026, 11:39:08 AM
    Author     : Sumanth
--%>



<!-- <%@page contentType="text/html" pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp" %>
    <%@include file="/WEB-INF/jsp/Common/countryjs.jsp"%>


    <head>
        <title>Block Vendor Dashboard</title>
    </head>
  <style>
                .tab-item {
                    position: relative;
                    display: inline-block;
                    margin-right: 10px;
                    list-style: none;
                }

                .tab-link {
                    position: relative;
                    display: inline-block;
                    padding: 10px 18px;
                    border-radius: 8px;
                    /*background: #f5f5f5;*/
                    text-decoration: none;
                    color: #333;
                    font-weight: 600;
                    transition: 0.3s;
                }

                .count-badge {
                    position: absolute;
                    top: -8px;
                    right: -8px;
                    min-width: 22px;
                    height: 22px;
                    padding: 0 6px;
                    border-radius: 50px;
                    background: #007BFF;
                    color: #fff;
                    font-size: 12px;
                    font-weight: bold;
                    display: flex;
                    align-items: center;
                    justify-content: center;
                    box-shadow: 0 2px 6px rgba(0,0,0,0.2);
                }
            </style>
    
    <body>
        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp" %>

            <section class="main-content">
                <form:form action="" method="post" commandName="vendorInformation1" name='form1' 
                           onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
                    <div class="card-box rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)" alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)" alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Block Vendor Dashboard</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>
                            <a href="javascript:void(0)" id="exportExcelBtn" class="btn theme-btn">Export To Excel</a>
                        </div>
                    </div>                    
                    <div class="card-box rounded-3 mt-2 py-2 px-3 top-0 sticky-model1">
                        <ul class="list-unstyled mb-0 d-flex align-items-center overflow-auto">
                            <li class="tab-item mr-2">
                                <a href="dashboard.htm?act=tenderDashboard" class="tab-link transition-0 ">Dashboard</a>
                            </li>
                            <li class="tab-item mr-2">
                                <a href="oapForm.htm?act=oapAndAocDashboard" class="tab-link transition-0">OAP & AOC DashBoard</a>
                            </li>
                            <li class="tab-item mr-2">
                                <a href="dashboard.htm?act=report" class="tab-link transition-0">PR Register</a>
                            </li>
                            <li class="tab-item mr-2">
                                <a href="dashboard.htm?act=activeVendorDashboard" class="tab-link transition-0 active">Active Vendor</a>
                            </li>
                            <li class="tab-item mr-2">
                                <a href="dashboard.htm?act=oapTracker" class="tab-link transition-0">OAP Tracker</a>
                            </li>
                            <li class="tab-item mr-2">
                                <a href="dashboard.htm?act=aocTracker" class="tab-link transition-0">AOC Tracker</a>
                            </li>

                        </ul>
                    </div>
                    <div class="card-box rounded-3 mt-2 py-2 px-3 mb-3 top-0 sticky-model2">
                        <ul class="list-unstyled mb-0 d-flex align-items-center overflow-auto">

                            <li class="tab-item mr-2 mt-3">
                                <a href="dashboard.htm?act=activeVendorDashboard" class="tab-link transition-0">Active Vendor
                                    <span class="count-badge">${activeVendorCount}</span>
                                </a>
                            </li>
                            
                            <li class="tab-item mr-2 ml-3 mt-3">
                                <a href="dashboard.htm?act=inprogressVendorList" class="tab-link transition-0">In Progress Vendor
                                    <span class="count-badge">${inprogressVendorCount}</span>
                                </a>
                            </li>                            
                            
                            <li class="tab-item mr-2 ml-3 mt-3">
                                <a href="dashboard.htm?act=invitedVendorList" class="tab-link transition-0 ">Invited Vendor
                                    <span class="count-badge">${invitedVendorCount}</span>
                                </a>
                            </li>                            
                            
                            <li class="tab-item mr-2 ml-3 mt-3">
                                <a href="dashboard.htm?act=rejectVendorList" class="tab-link transition-0 ">Rejected Vendor
                                    <span class="count-badge">${rejectedVendorCount}</span>
                                </a>
                            </li>

                            <li class="tab-item mr-2 ml-3 mt-3">
                                <a href="dashboard.htm?act=vendorBlockList" class="tab-link transition-0 active">Vendor Block
                                    <span class="count-badge">${vendorBlockCount}</span>
                                </a>
                            </li>
                        </ul>
                    </div>                    
                    
                    <div class="table-responsive">

                        <div class="d-flex align-items-center justify-content-between mb-3">

                            <div>
                                <select id="entriesPerPage" class="select-input">
                                    <option value="10">10</option>
                                    <option value="20">20</option>
                                    <option value="50">50</option>
                                    <option value="100">100</option>
                                    <option value="-1">ALL</option>
                                </select>
                            </div>

                            <div>
                                <input type="text" id="searchBox" class="input-field" placeholder="Search here...">
                            </div>

                        </div>

                        <table id="activeVendorTable" class="table table-striped bg-white dt-scroll" style="width:100%">
                            <thead>
                                <tr>
                                    <th>Sr.No.</th>
                                    <th style="min-width: 190px;">SAP Code</th>
                                    <th style="min-width: 250px;">Company Name</th>
                                    <th>Email Id</th>
                                    <th style="min-width: 180px;">Contact No</th>
                                    <th>Group Name</th>
                                    <th>Group Category</th>
                                    <th>Group Sub Category</th>
                                    <th>Country</th>
                                    <th>State</th>
                                    <th>City</th>
                                    <th>GST No.</th>
                                    <th>PAN No.</th>
                                    <th>Risk Category</th>
                                    <th style="min-width: 180px;">Vendor Invite Source</th>
                                    <th>Invited By</th>
                                    <th>Activated Date</th>
                                    <th>View</th>
                                </tr>        

                                <tr id="thead_1" data-dt-order="disable">

                                    <th></th>

                                    <th>
                                        <input type="text" id="sapCodeFilter" class="input-field" placeholder="Search SAP">
                                    </th>

                                    <th>
                                        <input type="text" id="companyNameFilter" class="input-field" placeholder="Search Company">
                                    </th>

                                    <th>
                                        <input type="text" id="vendorEmailIdFilter" class="input-field" placeholder="Search Email">
                                    </th>

                                    <th>
                                        <input type="text" id="contactNoFilter" class="input-field" placeholder="Search Contact">
                                    </th>

                                    <th>
                                        <select id="groupNameFilter" class="select-input selectpicker">
                                            <option value="">Select Group</option>
                                        </select>
                                    </th>

                                    <th>
                                        <select id="groupCategoryFilter" class="select-input selectpicker">
                                            <option value="">Select Category</option>
                                        </select>
                                    </th>

                                    <th>
                                        <select id="groupSubCategoryFilter" class="select-input selectpicker">
                                            <option value="">Select Sub Category</option>
                                        </select>
                                    </th>

                                    <th>
                                        <select id="country" class="select-input selectpicker">
                                            <option value="">Select Country</option>
                                        </select>
                                    </th>

                                    <th>
                                        <select id="state" class="select-input selectpicker">
                                            <option value="">Select State</option>
                                        </select>
                                    </th>

                                    <th>
                                        <input type="text" id="cityFilter" class="input-field" placeholder="Search City">
                                    </th>

                                    <th>
                                        <input type="text" id="gstNoFilter" class="input-field" placeholder="Search GST">
                                    </th>

                                    <th>
                                        <input type="text" id="panNoFilter" class="input-field" placeholder="Search PAN">
                                    </th>

                                    <th>
                                        <input type="text" id="riskCategoryFilter" class="input-field" placeholder="Search Risk">
                                    </th>

                                    <th>
                                        <input type="text" id="vendorInviteSourceFilter" class="input-field" placeholder="Search Source">
                                    </th>

                                    <th>
                                        <input type="text" id="invitedByFilter" class="input-field" placeholder="Search Invited By">
                                    </th>

                                    <th>
                                        <input type="text" id="activatedDateFilter" class="input-field" placeholder="Search Date">
                                    </th>

                                    <th></th>

                                </tr>

                            </thead>

                            <tbody></tbody>

                        </table>

                    </div>
                        
                    <div id="sapPopup" style="display:none; position: fixed; top: 0; left: 0; width: 100%; height: 100%; background: rgba(0,0,0,0.5); z-index:9999;">

                        <div style="background: #fff; width: 500px; padding: 30px; margin: 10% auto; border-radius: 8px; text-align: center;">

                            <input type="hidden" id="sapIdText">
                            <input type="hidden" id="sapIdCode">
                            <div id="sapPopupMsg" class="custom-alert"></div>

                            <div style="display: flex; align-items: center; margin-bottom: 15px;">
                                <h5 style="margin: 0; width: 120px;">Company Name:</h5>
                                <span><b id="popupCompanyName"></b></span>
                            </div>

                            <div style="display: flex; align-items: center; margin-bottom: 15px;">
                                <h5 style="margin: 0; width: 120px;">Add SAP Code:</h5>
                                <input type="text" id="sapCodeInput" class="input-field" placeholder="Enter SAP Code" required="true" style="flex:1;">
                            </div>

                            <div style="display: flex; justify-content: center; gap: 15px;">
                                <button type="button" class="btn theme-btn" onclick="SapCodeSubmit()">Submit</button>
                                <button type="button" class="btn theme-btn light-btn" onclick="closeSapPopup()">Close</button>
                            </div>

                        </div>
                    </div>

                   
                </form:form>
            </section>
        </main>
    </body>
 <!-- Block List Modal -->
<div class="modal fade" id="blockListModal" data-backdrop="static" data-keyboard="false" tabindex="-1"
     aria-labelledby="blockListModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header align-items-center">
                <h5 class="modal-title" id="blockListModalLabel">UnBlock Vendor :</h5>
                <div class="cta-btn d-flex align-items-center">
                    <button type="button" class="btn theme-btn light-btn" data-dismiss="modal"
                            onclick="window.location.href='dashboard.htm?act=vendorBlockList';">Close</button>
                    <button type="button" class="btn theme-btn ml-3" id="blockListSubmitButton">
                        <span class="btn-spinner" id="blockListBtnSpinner"></span>
                        <span id="blockListBtnText"  style="color: white;">Submit</span>
                    </button>
                </div>
            </div>
            <div class="modal-body">
                <div id="blockListResultDiv" class="bg-white">

                    <div class="block-list-loading-overlay" id="blockListLoadingOverlay">
                        <div class="loading-content">
                            <div class="enterprise-spinner"></div>
                            <div class="loading-title">Processing Request</div>
                            <div class="loading-subtitle">Please wait while your request is being processed.</div>
                        </div>
                    </div>
                    <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.<br>
                            <small class="text-muted">
                                    <span class="text-danger" style="font-weight: bold;">Attachment: PDF, JPG, PNG, DOC (max 5MB)</span>
                                </small>
                            <div style="font-weight: bold;" id="blockListErrorMsg" class="text-danger" style="display:none; font-size:12px;"></div>
                        </div>
                    </div>
                    <br>

                    <form id="blockListForm" action="vendorInformation.htm" method="post" enctype="multipart/form-data">

                        <input type="hidden" name="act" value="vendorUnBlock">
                        <input type="hidden" name="id" id="blockVendorId">

                        <div class="col-12 p-0">
                            <div class="form-group">
                                <label class="control-label">Company Name :</label>
                                <span id="blockCompanyName" style="font-weight: bold;"></span>
                            </div>

                            <div class="form-group">
                                <label class="control-label">Attachment :<span class="text-danger">*</span></label>
                                <input class="input-field" type="file" id="blockAttachment" name="attachment"
                                       accept=".pdf,.jpg,.jpeg,.png,.doc,.docx" required>
                                <small class="text-muted">Allowed: PDF, JPG, PNG, DOC (max 5MB)</small>
                            </div>

                            <div class="form-group comment-box">
                                <label class="control-label">Comments :<span class="text-danger">*</span></label>
                                <textarea type="text" maxlength="250" class="textarea-field remark" id="blockRemark" name="remark" required="true"></textarea>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<style>
   #blockListResultDiv {
    position: relative;
}

/* Professional Transparent Loading Overlay */
.block-list-loading-overlay {
    display: none;
    position: absolute;
    inset: 0;
    z-index: 9999;

    justify-content: center;
    align-items: center;

    background: transparent; /* No background color */
    pointer-events: all;      /* Prevent clicking */
}

/* Center Content */
.loading-content {
    display: flex;
    flex-direction: column;
    align-items: center;
    text-align: center;
    user-select: none;
}

/* Enterprise Spinner */
.enterprise-spinner {
    width: 46px;
    height: 46px;
    border: 4px solid #d9d9d9;
    border-top: 4px solid #0d6efd;
    border-radius: 50%;
    animation: enterpriseSpin .8s linear infinite;
}

/* Title */
.loading-title {
    margin-top: 14px;
    font-size: 15px;
    font-weight: 600;
    color: #2f3542;
    font-family: "Segoe UI", Arial, sans-serif;
}

/* Subtitle */
.loading-subtitle {
    margin-top: 5px;
    font-size: 12px;
    color: #6c757d;
    font-family: "Segoe UI", Arial, sans-serif;
}

@keyframes enterpriseSpin {
    to {
        transform: rotate(360deg);
    }
}

/* Submit Button Spinner */
#blockListSubmitButton .btn-spinner {
    display: none;
    width: 14px;
    height: 14px;
    border: 2px solid rgba(255,255,255,.4);
    border-top-color: #fff;
    border-radius: 50%;
    margin-right: 6px;
    animation: block-list-spin .8s linear infinite;
    vertical-align: middle;
}

@keyframes block-list-spin {
    to {
        transform: rotate(360deg);
    }
}
</style>
<script>
    function openBlockListModal(id, companyName) {
        $('#blockListErrorMsg')
            .removeClass('text-success')
            .addClass('text-danger')
            .hide()
            .text('');

        $('#blockVendorId').val(id);
        $('#blockCompanyName').text(companyName);
        $('#blockAttachment').val('');
        $('#blockRemark').val('');

        // Reset loading
        setBlockListLoading(false);

        // Enable submit button when opening modal
        $('#blockListSubmitButton').prop('disabled', false);
        $('#blockListBtnSpinner').hide();
        $('#blockListBtnText').text('Submit');

        $('#blockListModal').modal('show');
    }

    function showError(message) {
        var $errorMsg = $('#blockListErrorMsg');

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

    function setBlockListLoading(isLoading) {

        if (isLoading) {

            $('#blockListLoadingOverlay').css('display', 'flex');

            $('#blockListSubmitButton').prop('disabled', true);

            $('#blockListBtnSpinner').show();
            $('#blockListBtnText').text('Processing...');

        } else {

            $('#blockListLoadingOverlay').hide();

            $('#blockListBtnSpinner').hide();

            // Only reset text if button isn't disabled after success
            if (!$('#blockListSubmitButton').prop('disabled')) {
                $('#blockListBtnText').text('Submit');
            }
        }
    }

    $(document).on('click', '#blockListSubmitButton', function (e) {

        e.preventDefault();

        var fileInput = $('#blockAttachment')[0];
        var remark = $('#blockRemark').val().trim();

        if (!fileInput.files.length) {
            showError('Attachment is mandatory');
            return;
        }

        if (!remark) {
            showError('Remark is mandatory');
            return;
        }

        var fileSizeMB = fileInput.files[0].size / (1024 * 1024);

        if (fileSizeMB > 5) {
            showError('File size must be under 5 MB');
            return;
        }

        var formData = new FormData($('#blockListForm')[0]);

        setBlockListLoading(true);

        $.ajax({
            url: $('#blockListForm').attr('action'),
            type: 'POST',
            data: formData,
            processData: false,
            contentType: false,

            success: function (response) {

                $('#blockListErrorMsg')
                    .removeClass('text-danger')
                    .addClass('text-success')
                    .text('Vendor UnBlocked successfully')
                    .show();

                // Keep modal open
                $('#blockAttachment').val('');
                $('#blockRemark').val('');

                // Stop loading
                $('#blockListLoadingOverlay').hide();
                $('#blockListBtnSpinner').hide();

                // Disable submit button after success
                $('#blockListSubmitButton').prop('disabled', true);
                $('#blockListBtnText').text('Submitted');
            },

            error: function () {

                setBlockListLoading(false);
                showError('Something went wrong.');
            },

            complete: function () {

                // Don't reset button after successful submit
                if (!$('#blockListSubmitButton').prop('disabled')) {
                    setBlockListLoading(false);
                }
            }
        });
    });
</script>
            
                    
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
    
    <script>
        $(document).ready(function () {

            //====================================================
            // GROUP & COUNTRY DATA
            //====================================================

            const groupHierarchy = ${groupHierarchyJson};

            const $group = $('#groupNameFilter');
            const $category = $('#groupCategoryFilter');
            const $subcategory = $('#groupSubCategoryFilter');

            const $country = $('#country');
            const $state = $('#state');

            var countryStateMap = {};

            for (var i = 0; i < country_arr.length; i++) {

                var country = country_arr[i];

                var states = s_a[i + 1]
                        ? s_a[i + 1].split('|')
                        : [];

                countryStateMap[country] = states;
            }

            //====================================================
            // GROUP DROPDOWN
            //====================================================

            Object.keys(groupHierarchy).forEach(function (group) {

                $group.append(
                        $('<option>', {
                            value: group,
                            text: group
                        })
                        );

            });

            //====================================================
            // COUNTRY DROPDOWN
            //====================================================

            for (var i = 0; i < country_arr.length; i++) {

                $country.append(
                        $('<option>', {
                            value: country_arr[i],
                            text: country_arr[i]
                        })
                        );
            }
            $country.val('India').trigger('change');
            $('.select-input').selectpicker('refresh');

            //====================================================
            // DATATABLE
            //====================================================

            var table = $('#activeVendorTable').DataTable({

                processing: true,
                serverSide: true,
                searching: true,
                ordering: true,
                destroy: true,
                autoWidth: false,
                scrollX: false,
                pageLength: 10,
                lengthChange: false,
                scrollCollapse: true,
                scrollY: '80vh',                                

                dom: 't<"table-bottom-info d-flex align-items-center justify-content-between pt-3"ip>',

                ajax: {

                    url: 'dashboard.htm?act=vendorBlockListPagination',
                    type: 'POST',

                    data: function (d) {

                        d.sapCodeFilter = $('#sapCodeFilter').val();
                        d.companyNameFilter = $('#companyNameFilter').val();
                        d.vendorEmailIdFilter = $('#vendorEmailIdFilter').val();
                        d.contactNoFilter = $('#contactNoFilter').val();

                        d.groupNameFilter = $('#groupNameFilter').val();
                        d.groupCategoryFilter = $('#groupCategoryFilter').val();
                        d.groupSubCategoryFilter = $('#groupSubCategoryFilter').val();

                        d.countryFilter = $('#country').val();
                        d.stateFilter = $('#state').val();

                        d.cityFilter = $('#cityFilter').val();
                        d.gstNoFilter = $('#gstNoFilter').val();
                        d.panNoFilter = $('#panNoFilter').val();

                        d.riskCategoryFilter = $('#riskCategoryFilter').val();
                        d.vendorInviteSourceFilter = $('#vendorInviteSourceFilter').val();
                        d.invitedByFilter = $('#invitedByFilter').val();

                        d.activatedDateFilter = $('#activatedDateFilter').val();
                    }
                },

                columns: [

                    {data: 'srNo'},

                    {
                        data: 'sapCodeButton',
                        orderable: true
                    },

                    {data: 'companyName'},
                    {data: 'vendorEmailId'},
                    {data: 'contactNo'},

                    {data: 'groupName'},
                    {data: 'groupCategoryName'},
                    {data: 'groupSubCategoryName'},

                    {data: 'countryName'},
                    {data: 'stateName'},
                    {data: 'cityName'},

                    {data: 'gstinNo'},
                    {data: 'panNo'},

                    {data: 'riskCategory'},
                    {data: 'vendorInviteSource'},
                    {data: 'invitedBy'},
                    {data: 'vendorActivatedDate'},

                    {
                        data: 'view',
                        orderable: false
                    }
                ],

                columnDefs: [
                    {
                        targets: [1, 17],
                        render: function (data) {
                            return data;
                        }
                    }
                ]
            });

            //====================================================
            // GROUP CHANGE
            //====================================================

            $group.on('change', function () {

                var selectedGroup = $(this).val();

                $category.empty()
                        .append('<option value="">Select Category</option>');

                $subcategory.empty()
                        .append('<option value="">Select Sub Category</option>')
                        .prop('disabled', true);

                if (selectedGroup && groupHierarchy[selectedGroup]) {

                    Object.keys(groupHierarchy[selectedGroup]).forEach(function (category) {

                        $category.append(
                                $('<option>', {
                                    value: category,
                                    text: category
                                })
                                );
                    });

                    $category.prop('disabled', false);
                }

                $('.select-input').selectpicker('refresh');

                table.ajax.reload();
            });

            //====================================================
            // CATEGORY CHANGE
            //====================================================

            $category.on('change', function () {

                var selectedGroup = $group.val();
                var selectedCategory = $(this).val();

                $subcategory.empty()
                        .append('<option value="">Select Sub Category</option>')
                        .prop('disabled', true);

                if (selectedGroup
                        && selectedCategory
                        && groupHierarchy[selectedGroup]
                        && groupHierarchy[selectedGroup][selectedCategory]) {

                    groupHierarchy[selectedGroup][selectedCategory].forEach(function (sub) {

                        $subcategory.append(
                                $('<option>', {
                                    value: sub,
                                    text: sub
                                })
                                );
                    });

                    $subcategory.prop('disabled', false);
                }

                $('.select-input').selectpicker('refresh');

                table.ajax.reload();
            });

            //====================================================
            // SUB CATEGORY CHANGE
            //====================================================

            $subcategory.on('change', function () {

                table.ajax.reload();

            });

            //====================================================
            // COUNTRY CHANGE
            //====================================================

            $country.on('change', function () {

                var selectedCountry = $(this).val();

                $state.empty()
                        .append('<option value="">Select State</option>')
                        .prop('disabled', true);

                if (countryStateMap[selectedCountry]
                        && countryStateMap[selectedCountry].length > 0) {

                    countryStateMap[selectedCountry].forEach(function (stateName) {

                        $state.append(
                                $('<option>', {
                                    value: stateName,
                                    text: stateName
                                })
                                );
                    });

                    $state.prop('disabled', false);
                }

                $('.select-input').selectpicker('refresh');

                table.ajax.reload();
            });

            //====================================================
            // STATE CHANGE
            //====================================================

            $state.on('change', function () {

                table.ajax.reload();

            });

            //====================================================
            // COLUMN FILTERS
            //====================================================

            $('#sapCodeFilter,#companyNameFilter,#vendorEmailIdFilter,#contactNoFilter,#cityFilter,#gstNoFilter,#panNoFilter,#riskCategoryFilter,#vendorInviteSourceFilter,#invitedByFilter,#activatedDateFilter')
                    .on('keyup change', function () {

                        clearTimeout($.data(this, 'timer'));

                        var wait = setTimeout(function () {

                            table.ajax.reload();

                        }, 500);

                        $(this).data('timer', wait);
                    });

            //====================================================
            // GLOBAL SEARCH
            //====================================================

            $('#searchBox').on('keyup', function () {

                table.search(this.value).draw();

            });

            //====================================================
            // PAGE SIZE
            //====================================================

            $('#entriesPerPage').on('change', function () {
                var val = $(this).val();

                if (val === "" || val === "-1") {
                    var total = table.page.info().recordsTotal;
                    table.page.len(total > 0 ? total : 1).draw();
                } else {
                    table.page.len(parseInt(val, 10)).draw();
                }
            });

            var $bottomInfo = $('#activeVendorTable_wrapper > .table-bottom-info');
            $('.table-responsive').after($bottomInfo);
            
        });
        
        
//      For Export To Excel            
        $('#exportExcelBtn').on('click', function () {

            var params = {
                searchValue: $('#searchBox').val(),

                sapCodeFilter: $('#sapCodeFilter').val(),
                companyNameFilter: $('#companyNameFilter').val(),
                vendorEmailIdFilter: $('#vendorEmailIdFilter').val(),
                contactNoFilter: $('#contactNoFilter').val(),

                groupNameFilter: $('#groupNameFilter').val(),
                groupCategoryFilter: $('#groupCategoryFilter').val(),
                groupSubCategoryFilter: $('#groupSubCategoryFilter').val(),

                countryFilter: $('#country').val(),
                stateFilter: $('#state').val(),
                cityFilter: $('#cityFilter').val(),

                gstNoFilter: $('#gstNoFilter').val(),
                panNoFilter: $('#panNoFilter').val(),

                riskCategoryFilter: $('#riskCategoryFilter').val(),
                vendorInviteSourceFilter: $('#vendorInviteSourceFilter').val(),
                invitedByFilter: $('#invitedByFilter').val(),
                activatedDateFilter: $('#activatedDateFilter').val()
            };

            var $form = $('<form>', {
                method: 'POST',
                action: 'dashboard.htm?act=vendorBlockReportExportExcel'
            });

            $.each(params, function (key, value) {
                $form.append($('<input>', {
                    type: 'hidden',
                    name: key,
                    value: value || ''
                }));
            });

            $form.appendTo('body').submit().remove();
        });
    </script>
    <script>
        function showPopupMessage(msg, type) {
            var popupMsg = document.getElementById("sapPopupMsg");
            if (!popupMsg) return;

            popupMsg.classList.remove("custom-alert-danger", "custom-alert-success", "hide", "show");

            if (type === 'success') {
                popupMsg.classList.add("custom-alert-success");
            } else {
                popupMsg.classList.add("custom-alert-danger");
            }

            popupMsg.innerText = msg;
            popupMsg.classList.add("show");
            popupMsg.style.display = "block";
        }

        function hidePopupMessage() {
            var popupMsg = document.getElementById("sapPopupMsg");
            if (!popupMsg) return;

            popupMsg.classList.remove("show");
            popupMsg.classList.add("hide");

            setTimeout(() => {
                popupMsg.style.display = "none";
                popupMsg.innerText = "";
                popupMsg.classList.remove("custom-alert-danger", "custom-alert-success", "hide");
            }, 100);
        }

        function openSapPopup(id, companyName, msg) {
            document.getElementById("sapPopup").style.display = "block";
            document.getElementById("sapIdText").value = id;
            document.getElementById("popupCompanyName").innerText = companyName;
            document.getElementById("sapPopupMsg").innerText = msg ? msg : "";
        }

        function closeSapPopup() {
            document.getElementById("sapPopup").style.display = "none";
            hidePopupMessage();
        }

        function SapCodeSubmit() {
            var id = document.getElementById("sapIdText").value;
            var sapCode = document.getElementById("sapCodeInput").value;

            hidePopupMessage();

            if (sapCode.trim() === "") {
                alert("Please enter SAP Code");
                return;
            }

            var xhr = new XMLHttpRequest();
            xhr.open("POST", "vendorInformation.htm", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4) {
                    if (xhr.status === 200) {
                        try {
                            var data = JSON.parse(xhr.responseText);

                            if (data.success) {
                                closeSapPopup();
                                window.location.href = "vendorInformation.htm?act=activeVendor";
                            } else {
                                showPopupMessage(data.message || "Something went wrong", "error");
                            }
                        } catch (e) {
                            console.error("Invalid JSON response:", xhr.responseText);
                            showPopupMessage("Server returned invalid response", "error");
                        }
                    } else {
                        showPopupMessage("Server error: " + xhr.status, "error");
                    }
                }
            };

            xhr.send(
                "act=SapCodeSubmit&id=" + encodeURIComponent(id) +
                "&sapCode=" + encodeURIComponent(sapCode)
            );
        }
    </script>

    
</html>
