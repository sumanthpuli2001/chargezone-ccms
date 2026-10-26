<%-- 
    Document   : RejectedVendorDashboard
    Created on : 19 May, 2026, 10:53:16 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>Rejected Vendor Dashboard</title>
    </head>

    <body>
        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

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
                <form:form action="" method="post" commandName="rightMaster"
                           name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
                    <div class="card-box rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)" alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)" alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Rejected Vendor Dashboard</h5>
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
                                <a href="dashboard.htm?act=activeVendorDashboard" class="tab-link tab-link1 transition-0">Active Vendor
                                    <span class="count-badge">${activeVendorCount}</span>
                                </a>
                            </li>
                            
                            <li class="tab-item mr-2 ml-3 mt-3">
                                <a href="dashboard.htm?act=inprogressVendorList" class="tab-link tab-link1 transition-0">In Progress Vendor
                                    <span class="count-badge">${inprogressVendorCount}</span>
                                </a>
                            </li>                            
                            
                            <li class="tab-item mr-2 ml-3 mt-3">
                                <a href="dashboard.htm?act=invitedVendorList" class="tab-link tab-link1 transition-0">Invited Vendor
                                    <span class="count-badge">${invitedVendorCount}</span>
                                </a>
                            </li>                            
                            
                            <li class="tab-item mr-2 ml-3 mt-3">
                                <a href="dashboard.htm?act=rejectVendorList" class="tab-link tab-link1 transition-0 active">Rejected Vendor
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

                        <table id="rejectedVendorTable" class="table table-striped bg-white dt-scroll" style="width:100%">
                            <thead>
                                <tr>
                                    <th>Sr.No.</th>
                                    <th>Company Name</th>
                                    <th>Email Id</th>                                      
                                    <th>Rejected By</th>                                    
                                </tr>
                            </thead>
                        </table>
                    </div>
                                
                    <script>

                        var table;

                        $(document).ready(function () {

                            table = $('#rejectedVendorTable').DataTable({

                                processing: true,

                                serverSide: true,

                                stateSave: false,

                                ordering: true,

                                orderMulti: false,

                                aaSorting: [[0, 'asc']],
                                
                                scrollCollapse: true,
                                
                                scrollY: '80vh',
                                
                                columnDefs: [
                                    {
                                        targets: [3],
                                        orderable: false,
                                        searchable: false
                                    }
                                ],

                                ajax: {

                                    url: 'dashboard.htm?act=rejectVendorAjax',

                                    type: 'POST',

                                    cache: false
                                },

                                columns: [

                                    {
                                        data: 'srNo',
                                        orderable: true,
                                        searchable: false
                                    },

                                    { data: 'companyName' },
                                    { data: 'vendorEmailId' },                                    
                                    { data: 'status',
                                        orderable: true,
                                        searchable: false 
                                    }                                    
                                    
                                ],

                                pageLength: 10,

                                lengthChange: false,

                                searching: true,

                                info: true,

                                autoWidth: false,

                                responsive: true,

                                scrollX: false,

                                language: {

                                    info: "Showing _START_ to _END_ of _TOTAL_ filtered records",

                                    infoFiltered: "(filtered from _MAX_ total records)",

                                    zeroRecords: "No matching records found"
                                },

                                dom: 'rt<"table-bottom-info d-flex align-items-center justify-content-between pt-3"ip>'

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

                            var $bottomInfo = $('#rejectedVendorTable_wrapper > .table-bottom-info');
                            $('.table-responsive').after($bottomInfo);
                            
                        });
                        
                        
                //      For Export To Excel            
                        $('#exportExcelBtn').on('click', function () {

                            var params = {
                                searchValue: $('#searchBox').val()
                            };

                            var $form = $('<form>', {
                                method: 'POST',
                                action: 'dashboard.htm?act=rejectVendorReportExportExcel'
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

                    

                </form:form>
            </section>
        </main> 
    </body>

    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
    
</html>
