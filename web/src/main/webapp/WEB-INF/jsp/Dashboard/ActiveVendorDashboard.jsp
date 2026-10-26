<%-- 
    Document   : ActiveVendorDashboard.jsp
    Created on : 15 May, 2026, 4:27:49 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp" %>
    <%@include file="/WEB-INF/jsp/Common/countryjs.jsp"%>


    <head>
        <title>Active Vendor List</title>
    </head>      

    <body>
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp" %>

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
            
            <section class="main-content">
                <form:form action="" method="post" commandName="vendorInformation1" name='form1' 
                           onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
                    

                        <div class="card-box rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                            <div class="page-title d-flex align-items-center">
                                <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                    <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)" alt="Menu collapse">
                                    <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)" alt="Menu collapse">
                                </div>

                                <h5 class="fw-600 mb-0">Active Vendor Dashboard</h5>
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
                                    <a href="dashboard.htm?act=activeVendorDashboard" class="tab-link transition-0 active">Active Vendor
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
                                    <a href="dashboard.htm?act=rejectVendorList" class="tab-link transition-0">Rejected Vendor
                                        <span class="count-badge">${rejectedVendorCount}</span>
                                    </a>
                                </li>
                                <li class="tab-item mr-2 ml-3 mt-3">
                                    <a href="dashboard.htm?act=vendorBlockList" class="tab-link transition-0">Vendor Block
                                        <span class="count-badge">${vendorBlockCount}</span>
                                    </a>
                                </li>

                            </ul>
                        </div>
                                
                    
                    <div class="mt-3 table-responsive">

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

                        <table id="activeVendorTable" class="table table-striped bg-white" style="width:100%">
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
                                        <select id="groupNameFilter" class="select-input selectpicker dropup" data-container="body" data-dropup-auto="false">
                                            <option value="">Select Group</option>
                                        </select>
                                    </th>

                                    <th>
                                        <select id="groupCategoryFilter" class="select-input selectpicker dropup" data-container="body" data-dropup-auto="false">
                                            <option value="">Select Category</option>
                                        </select>
                                    </th>

                                    <th>
                                        <select id="groupSubCategoryFilter" class="select-input selectpicker dropup" data-container="body" data-dropup-auto="false">
                                            <option value="">Select Sub Category</option>
                                        </select>
                                    </th>

                                    <th>
                                        <select id="vendorCountryFilter" class="select-input selectpicker" data-container="body">
                                            <option value="">Select Country</option>
                                        </select>
                                    </th>

                                    <th>
                                        <select id="vendorStateFilter" class="select-input selectpicker" data-container="body">
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


                </form:form>
            </section>
        </main>
    </body>

    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
    
    <script>
        $(document).ready(function () {

            const groupHierarchy = ${groupHierarchyJson};

            const $group = $('#groupNameFilter');
            const $category = $('#groupCategoryFilter');
            const $subcategory = $('#groupSubCategoryFilter');

            const $country = $('#vendorCountryFilter');   // was $('#country')
            const $state = $('#vendorStateFilter');        // was $('#state')

            var countryStateMap = {};

            for (var i = 0; i < country_arr.length; i++) {

                var country = country_arr[i];

                var states = s_a[i + 1]
                        ? s_a[i + 1].split('|')
                        : [];

                countryStateMap[country] = states;
            }

            var table;

            // GROUP DROPDOWN
            Object.keys(groupHierarchy).forEach(function (group) {

                $group.append(
                        $('<option>', {
                            value: group,
                            text: group
                        })
                        );

            });
            $group.selectpicker('refresh');

            // COUNTRY DROPDOWN
            for (var i = 0; i < country_arr.length; i++) {

                $country.append(
                        $('<option>', {
                            value: country_arr[i],
                            text: country_arr[i]
                        })
                        );
            }

            // GROUP CHANGE
            function handleGroupChange() {

                var selectedGroup = $group.val();

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

                $category.selectpicker('refresh');
                $subcategory.selectpicker('refresh');
            }

            $group.on('change', function () {
                handleGroupChange();
                if (table) {
                    table.ajax.reload();
                }
            });

            // CATEGORY CHANGE
            function handleCategoryChange() {

                var selectedGroup = $group.val();
                var selectedCategory = $category.val();

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

                $subcategory.selectpicker('refresh');
            }

            $category.on('change', function () {
                handleCategoryChange();
                if (table) {
                    table.ajax.reload();
                }
            });

            // SUB CATEGORY CHANGE
            $subcategory.on('change', function () {
                if (table) {
                    table.ajax.reload();
                }
            });

            // COUNTRY CHANGE
            function handleCountryChange() {

                var selectedCountry = $country.val();

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

                $state.selectpicker('refresh');
            }

            $country.on('change', function () {
                handleCountryChange();
                if (table) {
                    table.ajax.reload();
                }
            });

            // STATE CHANGE
            $state.on('change', function () {
                if (table) {
                    table.ajax.reload();
                }
            });

            $country.val('India');
            handleCountryChange();
            $country.selectpicker('refresh');

            // DATATABLE
            table = $('#activeVendorTable').DataTable({

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

                    url: 'dashboard.htm?act=activeVendorDashBoardPagination',
                    type: 'POST',

                    data: function (d) {

                        d.sapCodeFilter = $('#sapCodeFilter').val();
                        d.companyNameFilter = $('#companyNameFilter').val();
                        d.vendorEmailIdFilter = $('#vendorEmailIdFilter').val();
                        d.contactNoFilter = $('#contactNoFilter').val();

                        d.groupNameFilter = $group.val();
                        d.groupCategoryFilter = $category.val();
                        d.groupSubCategoryFilter = $subcategory.val();

                        d.countryFilter = $country.val();
                        d.stateFilter = $state.val();
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
                ],

                initComplete: function () {
                    $('select.selectpicker').each(function () {
                        $(this).selectpicker({
                            container: 'body',
                            dropupAuto: $(this).is('#vendorCountryFilter, #vendorStateFilter')
                        });
                    });
                }
            });

            $('#sapCodeFilter,#companyNameFilter,#vendorEmailIdFilter,#contactNoFilter,#cityFilter,#gstNoFilter,#panNoFilter,#riskCategoryFilter,#vendorInviteSourceFilter,#invitedByFilter,#activatedDateFilter')
                    .on('keyup change', function () {

                        clearTimeout($.data(this, 'timer'));

                        var wait = setTimeout(function () {

                            table.ajax.reload();

                        }, 500);

                        $(this).data('timer', wait);
                    });

            $('#searchBox').on('keyup', function () {

                table.search(this.value).draw();

            });

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

                countryFilter: $('#vendorCountryFilter').val(),
                stateFilter: $('#vendorStateFilter').val(),
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
                action: 'dashboard.htm?act=activeVendorReportExportExcel'
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
        document.addEventListener('scroll', function (e) {
            if (e.target && e.target.closest && e.target.closest('.dropdown-menu')) {
                return;
            }
            $('.dropdown-toggle[aria-expanded="true"]').dropdown('hide');
        }, true);
    </script>
    
     <script>
        $(window).on('load', function () {
            setTimeout(function () {
                window.scrollBy(0, 1);
                window.scrollBy(0, -1);
                $('.selectpicker').selectpicker('refresh');
            }, 300);
        });
    </script>
    
</html>
