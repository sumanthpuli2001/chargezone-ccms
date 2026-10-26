<%-- 
    Document   : oapAndAocDashboard
    Created on : Mar 27, 2026, 12:29:05 PM
    Author     : Sumanth
--%>




<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

    <head>
        <title>OAP And AOC Dashboard</title>
        <style>
            
           

            .card-box {
                background-color: #fef9e7;
                border-top: 3px solid #f39c12;
                /*height: 110px;*/
                padding: 10px;
            }

            .content {
                display: flex;
                flex-direction: column;
                justify-content: center;
                height: 100%;
            }

            .icon {
                color: #f39c12;
                font-size: 25px;
            }

            .label {
                font-size: 12px;
                line-height: 1.2;

                display: -webkit-box;
                -webkit-line-clamp: 2;
                -webkit-box-orient: vertical;
                overflow: hidden;
            }
            .box-card .pt-2 {
                position: relative;
                height: 320px; /* controls chart height */
            }

            .box-card canvas {
                width: 100% !important;
                height: 100% !important;
            }
        </style>
    </head>

    <body>
        

        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content dashboard">
                <form:form action="oapForm.htm?act=oapAndAocDashboard" method="post" commandName=""
                           name='form1'  class="form-horizontal" role="form">
                    <div class="card-box rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars"
                                     onload="SVGInject(this)" alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort"
                                     onload="SVGInject(this)" alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">OAP And AOC Dashboard</h5>
                        </div>                    
                        <div class="cta d-flex align-items-center" style="gap: 10px;">
                            <li class="search-container" style="margin-left: auto; display: flex; align-items: center;">
                                <a onclick="history.back();" class="btn theme-btn light-btn mr-3 no-print">Back</a>
                                <button type="button" style="background-color: #00bcd4; color: white;" class="btn theme-btn" data-toggle="modal" data-target="#searchModal">
                                     Filter
                                </button>
                            </li>
                        </div>
                    </div>
                    
                    <div class="card-box rounded-3 mt-3 py-2 px-3 top-0 sticky-model1">
                        <ul class="list-unstyled mb-0 d-flex align-items-center overflow-auto">
                            <li class="tab-item mr-2">
                                <a href="dashboard.htm?act=tenderDashboard" class="tab-link transition-0 ">Dashboard</a>
                            </li>
                            <li class="tab-item mr-2">
                                <a href="oapForm.htm?act=oapAndAocDashboard" class="tab-link transition-0 active">OAP & AOC DashBoard</a>
                            </li>
                            <li class="tab-item mr-2">
                                <a href="dashboard.htm?act=report" class="tab-link transition-0">PR Register</a>
                            </li>
                            <li class="tab-item mr-2">
                                <a href="dashboard.htm?act=activeVendorDashboard" class="tab-link transition-0">Active Vendor</a>
                            </li>
                            <li class="tab-item mr-2">
                                <a href="dashboard.htm?act=oapTracker" class="tab-link transition-0">OAP Tracker</a>
                            </li>
                            <li class="tab-item mr-2">
                                <a href="dashboard.htm?act=aocTracker" class="tab-link transition-0">AOC Tracker</a>
                            </li>

                        </ul>
                    </div>
                    <div id="searchModal" class="modal fade" tabindex="-1" role="dialog">
                        <div class="modal-dialog modal-sm" role="document">
                            <div class="modal-content">
                                <div class="modal-header d-flex justify-content-between align-items-center">
                                    <h5 class="modal-title">Search</h5>
                                    <div class="ml-auto d-flex align-items-center">
                                        <button type="submit" class="btn theme-btn mr-2" name="applyFilter" id="applyFilter" value="1">
                                            Apply
                                        </button>
                                        <a class="btn theme-btn light-btn mr-2" data-dismiss="modal">
                                            Close
                                        </a>
                                    </div>
                                </div>

                                <div class="modal-body">
                                    <div class="form-horizontal">
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">From Date :</label>
                                            <div class="col-sm-9">
                                                <input type="text" autocomplete="off" name="fromDate" placeholder="DD-MM-YYYY" id="fromDate" class="input-field " >
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">To Date :</label>
                                            <div class="col-sm-9">
                                                <input type="text" autocomplete="off" name="toDate"  placeholder="DD-MM-YYYY" id="toDate" class="input-field">
                                            </div>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label" for="date-filter">Filter By :</label>
                                            <div class="col-sm-9">
                                                <select id="date-filter" name="Filter" class="select-input">
                                                    <option value="--select--">--SELECT--</option>
                                                    <option value="last-week">Last-1-Week</option>
                                                    <option value="last-month">Last-1-Month</option>
                                                    <option value="last-6-month">Last-6-Month</option>
                                                    <option value="last-year">Last-1-Year</option>
                                                </select>
                                            </div>
                                        </div>
                                        
                                    </div>
                                </div>
                                <script type="text/javascript">
                                    $(function () {
                                        flatpickr("#fromDate", {
                                            enableTime: false,
                                            dateFormat: "d/m/Y",
                                            allowInput: true
                                        });
                                        flatpickr("#toDate", {
                                            enableTime: false,
                                            dateFormat: "d/m/Y",
                                            allowInput: true
                                        });
                                    });    
                                </script>
                            </div>
                        </div>
                    </div>
                    
                        
                    <script>
                        var cardTargetUrl = 'oapForm.htm';
                        
                        $(document).ready(function () {
                            window.currentFilter = { fromDate: '', toDate: '', filter: '' };
                            $('.card-link').off('click').on('click', function (e) {
                                e.preventDefault();

                                var act = $(this).data('act');

                                $('#cardLinkForm').attr('action', cardTargetUrl);
                                $('#cardLinkAct').val(act);
                                $('#cardLinkFromdate').val(window.currentFilter.fromDate);
                                $('#cardLinkTodate').val(window.currentFilter.toDate);
                                $('#cardLinkFilter').val(window.currentFilter.filter);

                                $('#cardLinkForm').submit();
                            });

                            $('#applyFilter').off('click').on('click', function (e) {
                                e.preventDefault();
                                applyDashboardFilter($('#fromDate').val(), $('#toDate').val(), $('#date-filter').val());
                                $('#searchModal').modal('hide');
                            });
                        });

                        function applyDashboardFilter(fromDate, toDate, filterVal) {
                            window.currentFilter = { fromDate: fromDate, toDate: toDate, filter: filterVal };

                            $.ajax({
                                url: 'oapAocDashboard.htm',
                                method: 'GET',
                                data: { act: 'oapAndAocDashboardData', Fromdate: fromDate, Todate: toDate, Filter: filterVal },
                                dataType: 'json',
                                success: function (data) {
                                    updateCounters(data);
                                    window.currentFilter = {
                                        fromDate: data.appliedFilter.Fromdate,
                                        toDate: data.appliedFilter.Todate,
                                        filter: data.appliedFilter.Filter
                                    };
                                    if (typeof rebuildAllCharts === 'function') {
                                        rebuildAllCharts(data);
                                    }
                                },
                                error: function (xhr) { console.error('Filter update failed', xhr.status, xhr.responseText); }
                            });
                        }

                        $('#applyFilter').off('click').on('click', function (e) {
                            e.preventDefault();
                            applyDashboardFilter($('#fromDate').val(), $('#toDate').val(), $('#date-filter').val());
                            $('#searchModal').modal('hide');
                        });    
                        
                        function updateCounters(data) {
                            $('#totalOapCount').text(data.totalOap);
                            $('#approvedOapCount').text(data.approvedOap);
                            $('#pendingOapCount').text(data.pendingOap);
                            $('#rejctedOapCount').text(data.rejctedOap);
                            $('#unfieldCRCCount').text(data.unfieldCRC);
                            
                            $('#totalCrcCount').text(data.totalCrc);
                            $('#approvedCrcCount').text(data.approvedCrc);
                            $('#pendingCrcCount').text(data.pendingCrc);
                            $('#revisionCrcCount').text(data.revisionCrc);
                            $('#partiallyApprovedCrcCount').text(data.partiallyApprovedCrc);
                            $('#rejectedCrcCount').text(data.rejectedCrc);
                            
                            $('#totalAocCount').text(data.totalAoc);
                            $('#approvedAocCount').text(data.approvedAoc);
                            $('#pendingAocCount').text(data.pendingAoc);
                            $('#rejectedAocCount').text(data.rejectedAoc);
                            $('#unfieldKOMCount').text(data.unfieldKOM);
                            
                            $('#totalKomCount').text(data.totalKom);
                            $('#approvedKomCount').text(data.approvedKom);
                            $('#pendingKomCount').text(data.pendingKom);
                            $('#rejectedKomCount').text(data.rejectedKom);
                        }                             
                        
                    </script>

         
                    <div class="statistics mt-4 py-2">
                        <div class="row g-3 row-cols-auto flex-nowrap ">
                            <div class="col">
                                <a class="card-link" href="javascript:void(0);" data-act="totalOapDashboad" style="text-decoration: none; color: inherit;">
                                    <div class="card-box rounded-3  d-flex align-items-center justify-content-center text-center px-3 py-3" style="background-color: #e0edf9; border-top: 3px solid #3498db;">
                                        <div class="content">
                                            <i class="fas fa-users-cog" style="color: #3498db; font-size:25px;"></i>
                                            <h5 id="totalOapCount" class="mb-1 fw-bold ">${totalOap}</h5>
                                            <p class="mb-0 small">Total OAP</p>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <div class="col">
                                <a class="card-link" href="javascript:void(0);" data-act="approvedOapDashboad" style="text-decoration: none; color: inherit;">
                                    <div class="card-box rounded-3  d-flex align-items-center justify-content-center text-center px-3 py-3" style="background-color: #bdeec0; border-top: 3px solid #2ecc71;">
                                        <div class="content">
                                            <i class="fas fa-check-circle" style="color: #2ecc71; font-size:25px;"></i>
                                            <h5 id="approvedOapCount" class="mb-1 fw-bold">${approvedOap}</h5>
                                            <p class="mb-0 small">Approved OAP</p>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <div class="col">
                                <a class="card-link" href="javascript:void(0);" data-act="pendingOapDashboad" style="text-decoration: none; color: inherit;">
                                    <div class="card-box rounded-3  d-flex align-items-center justify-content-center text-center px-3 py-3" style="background-color:#f3e8ff; border-top: 3px solid #f00;">
                                        <div class="content">
                                            <i class="fas fa-hourglass-half" style="color: #f39c12; font-size:25px;"></i>
                                            <h5 id="pendingOapCount" class="mb-1 fw-bold">${pendingOap}</h5>
                                            <p class="mb-0 small" style="white-space: normal; word-wrap: break-word; overflow-wrap: break-word;">Pending OAP</p>
                                        </div>
                                    </div>
                                </a>
                            </div>

                            <div class="col">
                                <a class="card-link" href="javascript:void(0);" data-act="rejectedOapDashboad" style="text-decoration: none; color: inherit;">
                                    <div class="card-box rounded-3 d-flex align-items-center justify-content-center text-center px-3 py-3"style="background-color:#eafaf1; border-top:3px solid #58b368; ">
                                        <div class="content">
                                            <i class="fas fa-user-times"style="color:#58b368; font-size:28px;"></i>
                                            <h5 id="rejctedOapCount" class="mb-1 fw-bold">${rejctedOap}</h5>
                                            <p class="mb-0 small">Rejected OAP</p>
                                        </div>
                                    </div>
                                </a>
                            </div>                   
                            <div class="col">
                                <a class="card-link" href="javascript:void(0);" data-act="unfieldCRCDashboad" style="text-decoration: none; color: inherit;">
                                    <div class="card-box rounded-3 d-flex align-items-center justify-content-center text-center px-3 py-3"style="background-color:#eef8e6; border-top:3px solid #7cb342; ">
                                        <div class="content">
                                            <i class="fas fa-file-circle-xmark"style="color:#7cb342; font-size:28px;"></i>
                                            <h5 id="unfieldCRCCount" class="mb-1 fw-bold">${unfieldCRC}</h5>
                                            <p class="mb-0 small">Unfield CRC</p>
                                        </div>
                                    </div>
                                </a>
                            </div>                                  

                            <div class="col">
                                <a class="card-link" href="javascript:void(0);" data-act="totalCrcDashboad" style="text-decoration: none; color: inherit;">
                                    <div class="card-box rounded-3  d-flex align-items-center justify-content-center text-center px-3 py-3" style="background-color: #bbe6ec; border-top: 3px solid #1abc9c;">
                                        <div class="content">
                                            <i class="fas fa-database" style="color: #1abc9c; font-size:25px;"></i>
                                            <h5 id="totalCrcCount" class="mb-1 fw-bold">${totalCrc}</h5>
                                            <p class="mb-0 small">Total CRC</p>
                                        </div>
                                    </div>
                                </a>
                            </div>  

                            <div class="col">
                                <a class="card-link" href="javascript:void(0);" data-act="approvedCrcDashboad" style="text-decoration: none; color: inherit;">
                                    <div class="card-box rounded-3  d-flex align-items-center justify-content-center text-center px-3 py-3" style="background-color: #ffdea9; border-top: 3px solid #e67e22;">
                                        <div class="content">
                                            <i class="fas fa-check-double" style="color: #e67e22; font-size:25px;"></i>
                                            <h5 id="approvedCrcCount" class="mb-1 fw-bold">${approvedCrc}</h5>
                                            <p class="mb-0 small" >Approved CRC</p>
                                        </div>
                                    </div>
                                </a>
                            </div>                




                        </div>   
                    </div>   
                    <div class="statistics mt-2 py-2">
                        <div class="row g-3 row-cols-auto flex-nowrap ">
                            <div class="col">
                                <a class="card-link" href="javascript:void(0);" data-act="pendingCrcDashboad" style="text-decoration: none; color: inherit;">
                                    <div class="card-box rounded-3 d-flex align-items-center justify-content-center text-center px-3 py-3" style="background-color:#eaf4ff; border-top: 3px solid #3498db;">
                                        <div class="content">
                                            <i class="fas fa-hourglass-half" style="color: #3498db; font-size:25px;"></i>
                                            <h5 id="pendingCrcCount" class="mb-1 fw-bold">${pendingCrc}</h5>
                                            <p class="mb-0 small" style="white-space: normal; word-wrap: break-word; overflow-wrap: break-word;">Pending CRC</p>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <div class="col">
                                <a class="card-link" href="javascript:void(0);" data-act="revisionCrcDashboad" style="text-decoration: none; color: inherit;">
                                    <div class="card-box rounded-3 d-flex align-items-center justify-content-center text-center px-3 py-3"
                                         style="background-color: #bdeec0; border-top: 3px solid #2ecc71;">
                                        <div class="content">
                                            <i class="fas fa-edit" style="color: #e74c3c; font-size:25px;"></i>
                                            <h5 id="revisionCrcCount" class="mb-1 fw-bold">${revisionCrc}</h5>
                                            <p class="mb-0 small">Revision CRC</p>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <div class="col">
                                <a class="card-link" href="javascript:void(0);" data-act="partiallyApprovedCrcDashboad" style="text-decoration: none; color: inherit;">
                                    <div class="card-box rounded-3  d-flex align-items-center justify-content-center text-center px-3 py-3" style="background-color: #e3f2fd; border-top: 3px solid #2980b9;">
                                        <div class="content">
                                            <i class="fas fa-users" style="color: #2980b9; font-size:15px;"></i>
                                            <h5 id="partiallyApprovedCrcCount" class="mb-1 fw-bold">${partiallyApprovedCrc}</h5>
                                            <p class="mb-0 small"  style="white-space: normal; word-wrap: break-word; overflow-wrap: break-word;">
                                                Partially Approved CRC
                                            </p>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <div class="col">
                                <a class="card-link" href="javascript:void(0);" data-act="rejectedCrcDashboad" style="text-decoration: none; color: inherit;">
                                    <div class="card-box rounded-3  d-flex align-items-center justify-content-center text-center px-3 py-3" style="background-color: #fef9e7; border-top: 3px solid #f39c12;">
                                        <div class="content">
                                            <i class="fas fa-hourglass-half" style="color: #f39c12; font-size:25px;"></i>
                                            <h5 id="rejectedCrcCount" class="mb-1 fw-bold">${rejectedCrc}</h5>
                                            <p class="mb-0 small" style="white-space: normal; word-wrap: break-word; overflow-wrap: break-word;">
                                                Rejected OAP through CRC
                                            </p>
                                        </div>
                                    </div>
                                </a>
                            </div>

                            <div class="col">
                                <a class="card-link" href="javascript:void(0);" data-act="totalAocDashboad" style="text-decoration: none; color: inherit;">
                                    <div class="card-box rounded-3  d-flex align-items-center justify-content-center text-center px-3 py-3"  style="background-color: #fde8e9; border-top: 3px solid #e74c3c;">
                                        <div class="content">
                                            <i class="fas fa-users-cog" style="color: #e74c3c; font-size:25px;"></i>
                                            <h5 id="totalAocCount" class="mb-1 fw-bold">${totalAoc}</h5>
                                            <p class="mb-0 small">Total AOC</p>
                                        </div>
                                    </div>
                                </a>
                            </div>

                            <div class="col">
                                <a class="card-link" href="javascript:void(0);" data-act="approvedAocDashboad" style="text-decoration: none; color: inherit;">
                                    <div class="card-box rounded-3  d-flex align-items-center justify-content-center text-center px-3 py-3" style="background-color: #f0d9ff; border-top: 3px solid #9b59b6;">
                                        <div class="content">
                                            <i class="fas fa-thumbs-up" style="color: #9b59b6; font-size:25px;"></i>
                                            <h5 id="approvedAocCount" class="mb-1 fw-bold">${approvedAoc}</h5>
                                            <p class="mb-0 small">Approved AOC</p>
                                        </div>
                                    </div>
                                </a>
                            </div>                    
                            <div class="col">
                                <a class="card-link" href="javascript:void(0);" data-act="pendingAocDashboad" style="text-decoration: none; color: inherit;">
                                    <div class="card-box rounded-3 text-center px-3 py-3" style="background-color:#eef7f7; border-top: 3px solid #16a085;">
                                        <i class="fas fa-user-tie" style="color:#16a085; font-size:25px;"></i>
                                        <h5 id="pendingAocCount" class="mb-1 fw-bold">${pendingAoc}</h5>
                                        <p class="mb-0 small mt-1">Pending AOC</p>
                                    </div>
                                </a>
                            </div>  
                        </div>
                    </div>

                    <div class="statistics mt-2 py-2">
                        <div class="row g-3 row-cols-auto flex-nowrap ">
                            <div class="col">
                                <a class="card-link" href="javascript:void(0);" data-act="rejectedAocDashboad" style="text-decoration: none; color: inherit;">
                                    <div class="card-box rounded-3 d-flex align-items-center justify-content-center text-center px-3 py-3"style="background-color:#fceef5; border-top:3px solid #d63384; ">
                                        <div class="content">
                                            <i class="fas fa-circle-xmark"style="color:#d63384; font-size:28px;"></i>
                                            <h5 id="rejectedAocCount" class="mb-1 fw-bold">${rejectedAoc}</h5>
                                            <p class="mb-0 small">Rejected AOC</p>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <div class="col">
                                <a class="card-link" href="javascript:void(0);" data-act="unfieldKOMDashboad" style="text-decoration: none; color: inherit;">
                                    <div class="card-box rounded-3 d-flex align-items-center justify-content-center text-center px-3 py-3"style="background-color:#e8f7ee; border-top:3px solid #27ae60; ">
                                        <div class="content">
                                            <i class="fas fa-folder-open"style="color:#27ae60; font-size:28px;"></i>
                                            <h5 id="unfieldKOMCount" class="mb-1 fw-bold">${unfieldKOM}</h5>
                                            <p class="mb-0 small">Unfield KOM</p>
                                        </div>
                                    </div>
                                </a>
                            </div>                   

                            <div class="col">
                                <a class="card-link" href="javascript:void(0);" data-act="totalKomDashboad" style="text-decoration: none; color: inherit;">
                                    <div class="card-box rounded-3  d-flex align-items-center justify-content-center text-center px-3 py-3" style="background-color: #d4f4dd; border-top: 3px solid #2ecc71;">
                                        <div class="content">
                                            <i class="fas fa-layer-group" style="color: #2ecc71; font-size:25px;"></i>
                                            <h5 id="totalKomCount" class="mb-1 fw-bold">${totalKom}</h5>
                                            <p class="mb-0 small">Total KOM</p>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <div class="col">
                                <a class="card-link" href="javascript:void(0);" data-act="approvedKomDashboad" style="text-decoration: none; color: inherit;">
                                    <div class="card-box rounded-3  d-flex align-items-center justify-content-center text-center px-3 py-3" style="background-color: #ffd3b6; border-top: 3px solid #e67e22;">
                                        <div class="content">
                                            <i class="fas fa-shield-alt" style="color: #e67e22; font-size:25px;"></i>
                                            <h5 id="approvedKomCount" class="mb-1 fw-bold">${approvedKom}</h5>
                                            <p class="mb-0 small">Approved KOM</p>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <div class="col">
                                <a class="card-link" href="javascript:void(0);" data-act="pendingKomDashboad" style="text-decoration: none; color: inherit;">
                                    <div class="card-box rounded-3  d-flex align-items-center justify-content-center text-center px-3 py-3" style="background-color: #cddaebff; border-top: 3px solid #e67e22;">
                                        <div class="content">
                                            <i class="fas fa-clock" style="color: #e67e22; font-size:25px;"></i>
                                            <h5 id="pendingKomCount" class="mb-1 fw-bold">${pendingKom}</h5>
                                            <p class="mb-0 small"style="white-space: normal; word-wrap: break-word; overflow-wrap: break-word;">Pending KOM</p>
                                        </div>
                                    </div>
                                </a>
                            </div>  
                            <div class="col">
                                <a class="card-link" href="javascript:void(0);" data-act="rejectedKomDashboad" style="text-decoration: none; color: inherit;">
                                    <div class="card-box rounded-3  d-flex align-items-center justify-content-center text-center px-3 py-3" style="background-color: #FFB7CE; border-top: 3px solid #e67e22;">
                                        <div class="content">
                                            <i class="fas fa-user-cog" style="color: #e67e22; font-size:25px;"></i>
                                            <h5 id="rejectedKomCount" class="mb-1 fw-bold">${rejectedKom}</h5>
                                            <p class="mb-0 small"style="white-space: normal; word-wrap: break-word; overflow-wrap: break-word;">
                                                Rejected KOM
                                            </p>
                                        </div>
                                    </div>
                                </a>       
                            </div>
                        </div>               
                    </div>   
                    

                    <div class="row mt-4">
                        <div class="col-lg-6">
                            <div class="box-card rounded-2 p-3">
                                <div class="chart-title pb-2 d-flex align-items-center justify-content-between">
                                    <h6 class="fw-600 mb-1">Month Wise OAP</h6>
                                </div>
                                <div class="pt-2">
                                    <canvas id="oapLineChart"></canvas>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="box-card rounded-2 p-3">
                                <div class="chart-title pb-2 d-flex align-items-center justify-content-between">
                                    <h6 class="fw-600 mb-1">Month Wise AOC</h6>
                                </div>
                                <div class="pt-2">
                                    <canvas id="lineChart3"></canvas>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row mt-4">
                        <div class="col-lg-6">
                            <div class="box-card rounded-2 p-3">
                                <div class="chart-title pb-2 d-flex align-items-center justify-content-between">
                                    <h6 class="fw-600 mb-1">Designation-Wise Tracking  Project Coordinator</h6>
                                </div>
                                <div class="pt-2" style="height: 400px;">
                                    <canvas id="lineChart4"></canvas>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-6">
                            <div class="box-card rounded-2 p-3">
                                <div class="chart-title pb-2 d-flex align-items-center justify-content-between">
                                    <h6 class="fw-600 mb-1">Designation-Wise Tracking  Project Manager</h6>
                                </div>
                                <div class="pt-2" style="height: 400px;">
                                    <canvas id="lineChart5"></canvas> <!-- FIX ID -->
                                </div>
                            </div>
                        </div>
                    </div>



                    <div class="row mt-4">
                        <div class="col-lg-6">
                            <div class="box-card rounded-2 p-3">
                                <div class="chart-title pb-2 d-flex align-items-center justify-content-between">
                                    <h6 class="fw-600 mb-1">Month-wise analytics OAP</h6>
                                </div>
                                <div class="pt-2">
                                    <canvas id="oapAnalyticsLineChart"></canvas>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="box-card rounded-2 p-3">
                                <div class="chart-title pb-2 d-flex align-items-center justify-content-between">
                                    <h6 class="fw-600 mb-1">Month-wise analytics AOC</h6>
                                </div>
                                <div class="pt-2">
                                    <canvas id="aocAnalyticsLineChart"></canvas>
                                </div>
                            </div>
                        </div>
                    </div>                                         

                    <div class="row mt-4">
                        <div class="col-lg-6">
                            <div class="box-card rounded-2 p-3">
                                <div class="chart-title pb-2 d-flex align-items-center justify-content-between">
                                    <h6 class="fw-600 mb-1">  Bifurcation OAP Ethan Wise</h6>
                                </div>
                                <div class="pt-2">
                                    <canvas id="myChart" height="300"></canvas>
                                    <textarea id="chartDataHolder" style="display:none;">
                                        ${chartData}
                                    </textarea>
                                    <div id="chartTableContainer" style="margin-top:20px;"></div>
                                </div>

                            </div>
                        </div>                          
                        <div class="col-lg-6">
                            <div class="box-card rounded-2 p-3">
                                <div class="chart-title pb-2 d-flex align-items-center justify-content-between">
                                    <h6 class="fw-600 mb-1">Bifurcation OAP Equator Wise</h6>
                                </div>
                                <div class="pt-2">
                                    <canvas id="myChartEqua" height="300"></canvas>

                                    <textarea id="chartDataHolderEqua" style="display:none;">
                                        ${chartDataEqua}
                                    </textarea>

                                    <div id="chartTableContainerEqua" style="margin-top:20px;"></div>
                                </div>
                            </div>
                        </div>                          
                    </div>                         
                    <div class="row mt-4">
                        <div class="col-lg-6">
                            <div class="box-card rounded-2 p-3">
                                <div class="chart-title pb-2 d-flex align-items-center justify-content-between">
                                    <h6 class="fw-600 mb-1">Bifurcation OAP Hub Wise</h6>
                                </div>
                                <div class="pt-2">
                                    <canvas id="myChartHub" height="300"></canvas>

                                    <textarea id="chartDataHolderHub" style="display:none;">
                                        ${chartDataHub}
                                    </textarea>

                                    <div id="chartTableContainerHub" style="margin-top:20px;"></div>
                                </div>
                            </div>
                        </div>    
                        <div class="col-lg-6">
                            <div class="box-card rounded-2 p-3">
                                <div class="chart-title pb-2 d-flex align-items-center justify-content-between">
                                    <h6 class="fw-600 mb-1">Bifurcation OAP Capex Wise</h6>
                                </div>
                                <div class="pt-2">
                                    <canvas id="myChartCapex" height="300"></canvas>

                                    <textarea id="chartDataHolderCapex" style="display:none;">
                                        ${chartDataCapex}
                                    </textarea>

                                    <div id="chartTableContainerCapex" style="margin-top:20px;"></div>
                                </div>
                            </div>
                        </div>
                    </div>      
                    <div class="row mt-4">                                                
                        <div class="col-lg-6">
                            <div class="box-card rounded-2 p-3">
                                <div class="chart-title pb-2 d-flex align-items-center justify-content-between">
                                    <h6 class="fw-600 mb-1">Bifurcation AOC Ethan  Wise</h6>
                                </div>
                                <div class="pt-2">
                                    <canvas id="myChartEthan" height="300"></canvas>

                                    <textarea id="chartDataHolderEthan" style="display:none;">
                                        ${chartDataEthan}
                                    </textarea>

                                    <div id="chartTableContainerEthan" style="margin-top:20px;"></div>
                                </div>
                            </div>
                        </div>  

                        <div class="col-lg-6">
                            <div class="box-card rounded-2 p-3">
                                <div class="chart-title pb-2 d-flex align-items-center justify-content-between">
                                    <h6 class="fw-600 mb-1">Bifurcation AOC Equator  Wise</h6>
                                </div>
                                <div class="pt-2">
                                    <canvas id="myChartEquaAoc" height="300"></canvas>

                                    <textarea id="chartDataHolderEquaAoc" style="display:none;">
                                        ${chartDataEquaAoc}
                                    </textarea>

                                    <div id="chartTableContainerEquaAoc" style="margin-top:20px;"></div>
                                </div>
                            </div>
                        </div>
                    </div>  
                    <div class="row mt-4">     
                        <div class="col-lg-6">
                            <div class="box-card rounded-2 p-3">
                                <div class="chart-title pb-2 d-flex align-items-center justify-content-between">
                                    <h6 class="fw-600 mb-1">Bifurcation AOC Hub  Wise</h6>
                                </div>
                                <div class="pt-2">
                                    <canvas id="myChartHubAoc" height="300"></canvas>

                                    <textarea id="chartDataHolderHubAoc" style="display:none;">
                                        ${chartDataHubAoc}
                                    </textarea>

                                    <div id="chartTableContainerHubAoc" style="margin-top:20px;"></div>
                                </div>
                            </div>
                        </div> 
                        <div class="col-lg-6">
                            <div class="box-card rounded-2 p-3">
                                <div class="chart-title pb-2 d-flex align-items-center justify-content-between">
                                    <h6 class="fw-600 mb-1">Bifurcation AOC Capex  Wise</h6>
                                </div>
                                <div class="pt-2">
                                    <canvas id="myChartCapexAoc" height="300"></canvas>

                                    <textarea id="chartDataHolderCapexAoc" style="display:none;">
                                        ${chartDataCapexAoc}
                                    </textarea>

                                    <div id="chartTableContainerCapexAoc" style="margin-top:20px;"></div>
                                </div>
                            </div>
                        </div>         

                    </div>            
                    
                </form:form>
            </section>
        </main>
            
        <form id="cardLinkForm" method="post" style="display:none;">
            <input type="hidden" name="act" id="cardLinkAct">
            <input type="hidden" name="Fromdate" id="cardLinkFromdate">
            <input type="hidden" name="Todate" id="cardLinkTodate">
            <input type="hidden" name="Filter" id="cardLinkFilter">
        </form>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp" %>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="StorageYard/assets/js/dashboard.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
 
    
    <script>
if ($('#oapLineChart').length > 0) {

    const ctx = document.getElementById('oapLineChart').getContext('2d');

    // Labels
    const labels = [
        '${oapmonthName1}', '${oapmonthName2}', '${oapmonthName3}',
        '${oapmonthName4}', '${oapmonthName5}', '${oapmonthName6}',
        '${oapmonthName7}', '${oapmonthName8}', '${oapmonthName9}',
        '${oapmonthName10}', '${oapmonthName11}', '${oapmonthName12}'
    ];

    // Main graph data (ONLY this will be plotted)
    const oapData = [
        ${oapnumberOfValue1}, ${oapnumberOfValue2}, ${oapnumberOfValue3},
        ${oapnumberOfValue4}, ${oapnumberOfValue5}, ${oapnumberOfValue6},
        ${oapnumberOfValue7}, ${oapnumberOfValue8}, ${oapnumberOfValue9},
        ${oapnumberOfValue10}, ${oapnumberOfValue11}, ${oapnumberOfValue12}
    ];

   
    const oapTotalMWOfValue1 = [
        ${oapTotalMWOfValue1}, ${oapTotalMWOfValue2}, ${oapTotalMWOfValue3},
        ${oapTotalMWOfValue4}, ${oapTotalMWOfValue5}, ${oapTotalMWOfValue6},
        ${oapTotalMWOfValue7}, ${oapTotalMWOfValue8}, ${oapTotalMWOfValue9},
        ${oapTotalMWOfValue10}, ${oapTotalMWOfValue11}, ${oapTotalMWOfValue12}
    ];

    // Gradient
    let gradient1 = ctx.createLinearGradient(0, 0, 0, 400);
    gradient1.addColorStop(0, 'rgba(40, 167, 69, 0.4)');
    gradient1.addColorStop(1, 'rgba(40, 167, 69, 0)');

    new Chart(ctx, {
        type: 'line',
        data: {
            labels: labels,
            datasets: [
                {
                    label: 'MONTH WISE OAP DATA',
                    data: oapData, 
                    fill: true,
                    backgroundColor: gradient1,
                    borderColor: 'rgba(40,167,69,1)',
                    borderWidth: 2,
                    tension: 0.4,
                    pointRadius: 4
                }
            ]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,

            plugins: {
                legend: {
                    display: true,
                    labels: { color: '#333' }
                },

                
                tooltip: {
                    
                    callbacks: {
                        label: function(context) {
                            const index = context.dataIndex;

                            const oap = oapData[index];
                            const mw = oapTotalMWOfValue1[index];

                            return [
                "MONTH WISE OAP DATA: " + oap,
                "• MONTH WISE TOTAL MEGA WATT: " + mw
            ];
                        }
                    }
                }
            },

            scales: {
                x: {
                    ticks: { color: '#333' }
                },
                y: {
                    beginAtZero: true
                }
            },

            onClick: function (event, elements) {
                if (elements.length > 0) {
                    const index = elements[0].index;

                    const links = [
                        "oapForm.htm?act=monthWiseGraphOapDeatils&label=${oapmonthName1}&Filter=${Filter}",
                        "oapForm.htm?act=monthWiseGraphOapDeatils&label=${oapmonthName2}&Filter=${Filter}",
                        "oapForm.htm?act=monthWiseGraphOapDeatils&label=${oapmonthName3}&Filter=${Filter}",
                        "oapForm.htm?act=monthWiseGraphOapDeatils&label=${oapmonthName4}&Filter=${Filter}",
                        "oapForm.htm?act=monthWiseGraphOapDeatils&label=${oapmonthName5}&Filter=${Filter}",
                        "oapForm.htm?act=monthWiseGraphOapDeatils&label=${oapmonthName6}&Filter=${Filter}",
                        "oapForm.htm?act=monthWiseGraphOapDeatils&label=${oapmonthName7}&Filter=${Filter}",
                        "oapForm.htm?act=monthWiseGraphOapDeatils&label=${oapmonthName8}&Filter=${Filter}",
                        "oapForm.htm?act=monthWiseGraphOapDeatils&label=${oapmonthName9}&Filter=${Filter}",
                        "oapForm.htm?act=monthWiseGraphOapDeatils&label=${oapmonthName10}&Filter=${Filter}",
                        "oapForm.htm?act=monthWiseGraphOapDeatils&label=${oapmonthName11}&Filter=${Filter}",
                        "oapForm.htm?act=monthWiseGraphOapDeatils&label=${oapmonthName12}&Filter=${Filter}"
                    ];

                    window.location.href = links[index];
                }
            }
        }
    });

    // Debug check (DO NOT IGNORE THIS)
    console.log("OAP Data:", oapData);
    console.log("MW Data:", oapTotalMWOfValue1);
}
</script>
<script>
if ($('#lineChart3').length > 0) {

    const ctx = document.getElementById('lineChart3').getContext('2d');

    const labels = [
       '${aocmonthName1}', '${aocmonthName2}', '${aocmonthName3}',
       '${aocmonthName4}', '${aocmonthName5}', '${aocmonthName6}',
       '${aocmonthName7}', '${aocmonthName8}', '${aocmonthName9}',
       '${aocmonthName10}', '${aocmonthName11}', '${aocmonthName12}'
    ];

    const aocData = [
        ${aocnumberOfValue1}, ${aocnumberOfValue2}, ${aocnumberOfValue3},
        ${aocnumberOfValue4}, ${aocnumberOfValue5}, ${aocnumberOfValue6},
        ${aocnumberOfValue7}, ${aocnumberOfValue8}, ${aocnumberOfValue9},
        ${aocnumberOfValue10}, ${aocnumberOfValue11}, ${aocnumberOfValue12}
    ];

    const aocTotalMWOfValue1 = [
        ${aocTotalMWOfValue1}, ${aocTotalMWOfValue2}, ${aocTotalMWOfValue3},
        ${aocTotalMWOfValue4}, ${aocTotalMWOfValue5}, ${aocTotalMWOfValue6},
        ${aocTotalMWOfValue7}, ${aocTotalMWOfValue8}, ${aocTotalMWOfValue9},
        ${aocTotalMWOfValue10}, ${aocTotalMWOfValue11}, ${aocTotalMWOfValue12}
    ];

    let gradient1 = ctx.createLinearGradient(0, 0, 0, 400);
    gradient1.addColorStop(0, 'rgba(0, 123, 255, 0.5)');
    gradient1.addColorStop(1, 'rgba(0, 123, 255, 0)');

    new Chart(ctx, {
        type: 'line',
        data: {
            labels: labels,
            datasets: [
                {
                    label: 'MONTH WISE AOC DATA',
                    data: aocData,
                    fill: true,
                    backgroundColor: gradient1,
                    borderColor: 'rgba(0,123,255,1)',
                    borderWidth: 2,
                    tension: 0.4
                }
            ]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,
            plugins: {
                legend: {
                    display: true,
                    labels: { color: '#333' }
                }, // ✅ FIXED (comma added)
                tooltip: {
                    callbacks: {
                        label: function(context) {
                            const index = context.dataIndex;

                            const aoc = aocData[index];
                            const mw = aocTotalMWOfValue1[index];

                            return [
                                "MONTH WISE AOC DATA: " + aoc,
                                "• MONTH WISE TOTAL MEGA WATT: " + mw
                            ];
                        }
                    }
                }
            },
            scales: {
                y: { beginAtZero: true },
                x: { ticks: { color: '#333' } }
            },
            onClick: function (evt, elements) {
                if (elements.length > 0) {
                    const i = elements[0].index;
                    const links = [
                        "oapForm.htm?act=monthWiseGraphAocDeatils&label=${aocmonthName1}&Filter=${Filter}",
                        "oapForm.htm?act=monthWiseGraphAocDeatils&label=${aocmonthName2}&Filter=${Filter}",
                        "oapForm.htm?act=monthWiseGraphAocDeatils&label=${aocmonthName3}&Filter=${Filter}",
                        "oapForm.htm?act=monthWiseGraphAocDeatils&label=${aocmonthName4}&Filter=${Filter}",
                        "oapForm.htm?act=monthWiseGraphAocDeatils&label=${aocmonthName5}&Filter=${Filter}",
                        "oapForm.htm?act=monthWiseGraphAocDeatils&label=${aocmonthName6}&Filter=${Filter}",
                        "oapForm.htm?act=monthWiseGraphAocDeatils&label=${aocmonthName7}&Filter=${Filter}",
                        "oapForm.htm?act=monthWiseGraphAocDeatils&label=${aocmonthName8}&Filter=${Filter}",
                        "oapForm.htm?act=monthWiseGraphAocDeatils&label=${aocmonthName9}&Filter=${Filter}",
                        "oapForm.htm?act=monthWiseGraphAocDeatils&label=${aocmonthName10}&Filter=${Filter}",
                        "oapForm.htm?act=monthWiseGraphAocDeatils&label=${aocmonthName11}&Filter=${Filter}",
                        "oapForm.htm?act=monthWiseGraphAocDeatils&label=${aocmonthName12}&Filter=${Filter}"
                    ];
                    window.location.href = links[i];
                }
            }
        }
    });
}
</script>
  

<script>
    const ctx = document.getElementById('lineChart4').getContext('2d');

    const colors = {
        total: '#FF6384',
        live: '#36A2EB',
        close: '#FFCE56',
        pending: '#4BC0C0',
        pendingKom: '#FF8A65'
    };

    function shortLabel(text) {
        text = String(text);
        let name = text.split('.')[0];
        return name.length > 10 ? name.substring(0, 10) + '...' : name;
    }

    const rawLabels = [
        '${firstElement1_1}',
        '${secondElement1_1}',
        '${thirdElement1_1}',
        '${fourthElement1_1}',
        '${fifthElement1_1}',
        '${sixthElement1_1}',
        '${seventhElement1_1}',
        '${eighthElement1_1}',
        '${ninthElement1_1}',
        '${tenthElement1_1}'
    ];

    const rawTotal = [
        ${firstElement1_2}, ${secondElement1_2}, ${thirdElement1_2},
        ${fourthElement1_2}, ${fifthElement1_2}, ${sixthElement1_2},
        ${seventhElement1_2}, ${eighthElement1_2}, ${ninthElement1_2}, ${tenthElement1_2}
    ];

    const rawLive = [
        ${firstElement1_3}, ${secondElement1_3}, ${thirdElement1_3},
        ${fourthElement1_3}, ${fifthElement1_3}, ${sixthElement1_3},
        ${seventhElement1_3}, ${eighthElement1_3}, ${ninthElement1_3}, ${tenthElement1_3}
    ];

    const rawClose = [
        ${firstElement1_4}, ${secondElement1_4}, ${thirdElement1_4},
        ${fourthElement1_4}, ${fifthElement1_4}, ${sixthElement1_4},
        ${seventhElement1_4}, ${eighthElement1_4}, ${ninthElement1_4}, ${tenthElement1_4}
    ];

    const rawPending = [
        ${firstElement1_5}, ${secondElement1_5}, ${thirdElement1_5},
        ${fourthElement1_5}, ${fifthElement1_5}, ${sixthElement1_5},
        ${seventhElement1_5}, ${eighthElement1_5}, ${ninthElement1_5}, ${tenthElement1_5}
    ];

    // NEW DATASET
    const rawPendingKom = [
        ${firstElement1_6}, ${secondElement1_6}, ${thirdElement1_6},
        ${fourthElement1_6}, ${fifthElement1_6}, ${sixthElement1_6},
        ${seventhElement1_6}, ${eighthElement1_6}, ${ninthElement1_6}, ${tenthElement1_6}
    ];

    const validIndexes = rawLabels
        .map((val, i) => (val && val !== 'null' && val !== '' ? i : -1))
        .filter(i => i !== -1);

    const labels = validIndexes.map(i => shortLabel(rawLabels[i]));
    const totalData = validIndexes.map(i => rawTotal[i]);
    const liveData = validIndexes.map(i => rawLive[i]);
    const closeData = validIndexes.map(i => rawClose[i]);
    const closePending = validIndexes.map(i => rawPending[i]);

    // NEW FILTERED DATA
    const pendingKomData = validIndexes.map(i => rawPendingKom[i]);

    new Chart(ctx, {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [
                {
                    label: 'Total CRC&KOM',
                    data: totalData,
                    backgroundColor: colors.total,
                    borderColor: colors.total,
                    borderWidth: 1,
                    borderRadius: 6
                },
                {
                    label: 'Under Approval',
                    data: liveData,
                    backgroundColor: colors.live,
                    borderColor: colors.live,
                    borderWidth: 1,
                    borderRadius: 6
                },
                {
                    label: 'Approved CRC&KOM',
                    data: closeData,
                    backgroundColor: colors.close,
                    borderColor: colors.close,
                    borderWidth: 1,
                    borderRadius: 6
                },
                {
                    label: 'Pending CRC',
                    data: closePending,
                    backgroundColor: colors.pending,
                    borderColor: colors.pending,
                    borderWidth: 1,
                    borderRadius: 6
                },
                {
                    label: 'Pending KOM',
                    data: pendingKomData,
                    backgroundColor: colors.pendingKom,
                    borderColor: colors.pendingKom,
                    borderWidth: 1,
                    borderRadius: 6
                }
            ]
        },

        options: {
            responsive: true,
            maintainAspectRatio: false,

            onClick: function(evt, elements) {

                if (elements.length > 0) {

                    const clickedElementIndex = elements[0].index;
                    const datasetIndex = elements[0].datasetIndex;

                    const originalIndex = validIndexes[clickedElementIndex];

                    var links = {

                        // Total CRC&KOM
                        0: [
                            "oapForm.htm?act=projectcordTotal&contact=${firstElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${secondElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${thirdElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${fourthElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${fifthElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${sixthElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${seventhElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${eighthElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${ninthElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${tenthElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}"
                        ],

                        // Under Approval
                        1: [
                            "oapForm.htm?act=projectcordTotal&contact=${firstElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${secondElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${thirdElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${fourthElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${fifthElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${sixthElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${seventhElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${eighthElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${ninthElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${tenthElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}"
                        ],

                        // Approved CRC&KOM
                        2: [
                            "oapForm.htm?act=projectcordTotal&contact=${firstElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${secondElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${thirdElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${fourthElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${fifthElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${sixthElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${seventhElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${eighthElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${ninthElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${tenthElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}"
                        ],

                        // Pending CRC
                        3: [
                            "oapForm.htm?act=projectcordPendingCRC&contact=${firstElement1_1}&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordPendingCRC&contact=${secondElement1_1}&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordPendingCRC&contact=${thirdElement1_1}&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordPendingCRC&contact=${fourthElement1_1}&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordPendingCRC&contact=${fifthElement1_1}&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordPendingCRC&contact=${sixthElement1_1}&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordPendingCRC&contact=${seventhElement1_1}&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordPendingCRC&contact=${eighthElement1_1}&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordPendingCRC&contact=${ninthElement1_1}&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordPendingCRC&contact=${tenthElement1_1}&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}"
                        ],

                        // Pending KOM
                        4: [
                            "oapForm.htm?act=projectcordPendingKOM&contact=${firstElement1_1}&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordPendingKOM&contact=${secondElement1_1}&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordPendingKOM&contact=${thirdElement1_1}&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordPendingKOM&contact=${fourthElement1_1}&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordPendingKOM&contact=${fifthElement1_1}&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordPendingKOM&contact=${sixthElement1_1}&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordPendingKOM&contact=${seventhElement1_1}&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordPendingKOM&contact=${eighthElement1_1}&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordPendingKOM&contact=${ninthElement1_1}&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordPendingKOM&contact=${tenthElement1_1}&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}"
                        ]
                    };

                    if (links[datasetIndex] && links[datasetIndex][originalIndex]) {
                        window.location.href = links[datasetIndex][originalIndex];
                    } else {
                        console.error("No link found for the clicked element.");
                    }
                }
            },

            plugins: {
                legend: { display: true },
                tooltip: { enabled: true }
            },

            scales: {
                x: {
                    grid: { display: false }
                },
                y: {
                    beginAtZero: true
                }
            }
        }
    });
</script>



<script>
    var ctxBar4 = document.getElementById('lineChart4').getContext('2d');

    // ✅ GRADIENTS
    const gradient1 = ctxBar4.createLinearGradient(0, 0, 0, 600);
    gradient1.addColorStop(0, 'rgba(255, 99, 132, 0.8)');
    gradient1.addColorStop(1, 'rgba(255, 99, 132, 0.2)');

    const gradient2 = ctxBar4.createLinearGradient(0, 0, 0, 600);
    gradient2.addColorStop(0, 'rgba(54, 162, 235, 0.8)');
    gradient2.addColorStop(1, 'rgba(54, 162, 235, 0.2)');

    const gradient3 = ctxBar4.createLinearGradient(0, 0, 0, 600);
    gradient3.addColorStop(0, 'rgba(255, 206, 86, 0.8)');
    gradient3.addColorStop(1, 'rgba(255, 206, 86, 0.2)');

    const chartData2 = {
        labels: labels,
        datasets: [
            {
                label: 'Total CRC&KOM',
                data: totalData,
                backgroundColor: gradient1,
                borderRadius: 10
            },
            {
                label: 'Under Approval',
                data: liveData,
                backgroundColor: gradient2,
                borderRadius: 10
            },
            {
                label: 'Approved CRC&KOM',
                data: closeData,
                backgroundColor: gradient3,
                borderRadius: 10
            }
        ]
    };

    new Chart(ctxBar4, {
        type: 'bar',
        data: chartData2,
        options: {
            responsive: true,
            maintainAspectRatio: false,

            onClick: function(evt, elements) {

                if (elements.length > 0) {

                    const clickedElementIndex = elements[0].index;
                    const datasetIndex = elements[0].datasetIndex;

                    const originalIndex = validIndexes[clickedElementIndex];

                    var links = {

                         0: [
                            "oapForm.htm?act=projectcordTotal&contact=${firstElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${secondElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${thirdElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${fourthElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${fifthElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${sixthElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${seventhElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${eighthElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${ninthElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${tenthElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}"
                        ],

                         1: [
                            "oapForm.htm?act=projectcordTotal&contact=${firstElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${secondElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${thirdElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${fourthElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${fifthElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${sixthElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${seventhElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${eighthElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${ninthElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${tenthElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}"
                        ],

                        2: [
                            "oapForm.htm?act=projectcordTotal&contact=${firstElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${secondElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${thirdElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${fourthElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${fifthElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${sixthElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${seventhElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${eighthElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${ninthElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectcordTotal&contact=${tenthElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}"
                        ]
                    };

                    if (links[datasetIndex] && links[datasetIndex][originalIndex]) {
                        window.location.href = links[datasetIndex][originalIndex];
                    } else {
                        console.error("No link found for the clicked element.");
                    }
                }
            },

            plugins: {
                legend: { display: true }
            },
            scales: {
                x: { grid: { display: false } }
            }
        }
    });
</script>
                            
                            
                   
 <script>
    const ctx5 = document.getElementById('lineChart5').getContext('2d');

    const rawLabels5 = [
        '${firstElement1_10}',
        '${secondElement1_10}',
        '${thirdElement1_10}',
        '${fourthElement1_10}',
        '${fifthElement1_10}',
        '${sixthElement1_10}',
        '${seventhElement1_10}',
        '${eighthElement1_10}',
        '${ninthElement1_10}',
        '${tenthElement1_10}'
    ];

    const rawData1 = [
        ${firstElement1_20}, ${secondElement1_20}, ${thirdElement1_20},
        ${fourthElement1_20}, ${fifthElement1_20}, ${sixthElement1_20},
        ${seventhElement1_20}, ${eighthElement1_20}, ${ninthElement1_20}, ${tenthElement1_20}
    ];

    const rawData2 = [
        ${firstElement1_30}, ${secondElement1_30}, ${thirdElement1_30},
        ${fourthElement1_30}, ${fifthElement1_30}, ${sixthElement1_30},
        ${seventhElement1_30}, ${eighthElement1_30}, ${ninthElement1_30}, ${tenthElement1_30}
    ];

    const rawData3 = [
        ${firstElement1_40}, ${secondElement1_40}, ${thirdElement1_40},
        ${fourthElement1_40}, ${fifthElement1_40}, ${sixthElement1_40},
        ${seventhElement1_40}, ${eighthElement1_40}, ${ninthElement1_40}, ${tenthElement1_40}
    ];

    const validIndexes5 = rawLabels5
        .map((val, i) => (val && val !== 'null' && val !== '' ? i : -1))
        .filter(i => i !== -1);

    const labels5 = validIndexes5.map(i => shortLabel(rawLabels5[i]));
    const data1 = validIndexes5.map(i => rawData1[i]);
    const data2 = validIndexes5.map(i => rawData2[i]);
    const data3 = validIndexes5.map(i => rawData3[i]);

    new Chart(ctx5, {
        type: 'bar',
        data: {
            labels: labels5,
            datasets: [
                {
                    label: 'Total CRC&KOM',
                    data: data1,
                    backgroundColor: '#FF6384',
                    borderRadius: 6
                },
                {
                    label: 'Under Approval',
                    data: data2,
                    backgroundColor: '#36A2EB',
                    borderRadius: 6
                },
                {
                    label: 'Approved CRC&KOM',
                    data: data3,
                    backgroundColor: '#FFCE56',
                    borderRadius: 6
                }
            ]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,

            onClick: function(evt, elements) {
                if (elements.length > 0) {

                    const clickedElementIndex = elements[0].index;
                    const datasetIndex = elements[0].datasetIndex;

                    const originalIndex = validIndexes5[clickedElementIndex];

                    var links = {

                        0: [
                            "oapForm.htm?act=projectManagerTotal&contact=${firstElement1_10}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${secondElement1_10}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${thirdElement1_10}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${fourthElement1_10}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${fifthElement1_10}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${sixthElement1_10}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${seventhElement1_10}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${eighthElement1_10}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${ninthElement1_10}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${tenthElement1_10}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}"
                        ],

                        1: [
                            "oapForm.htm?act=projectManagerTotal&contact=${firstElement1_10}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${secondElement1_10}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${thirdElement1_10}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${fourthElement1_10}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${fifthElement1_10}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${sixthElement1_10}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${seventhElement1_10}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${eighthElement1_10}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${ninthElement1_10}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${tenthElement1_10}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}"
                        ],

                        2: [
                            "oapForm.htm?act=projectManagerTotal&contact=${firstElement1_10}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${secondElement1_10}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${thirdElement1_10}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${fourthElement1_10}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${fifthElement1_10}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${sixthElement1_10}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${seventhElement1_10}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${eighthElement1_10}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${ninthElement1_10}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${tenthElement1_10}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}"
                        ]
                    };

                    if (links[datasetIndex] && links[datasetIndex][originalIndex]) {
                        window.location.href = links[datasetIndex][originalIndex];
                    }
                }
            },

            scales: {
                x: { grid: { display: false } },
                y: { beginAtZero: true }
            }
        }
    });
</script>                       
    
<script>
    const ctxBar5 = document.getElementById('lineChart5').getContext('2d');

    const gradient1 = ctxBar5.createLinearGradient(0, 0, 0, 600);
    gradient1.addColorStop(0, 'rgba(255, 99, 132, 0.8)');
    gradient1.addColorStop(1, 'rgba(255, 99, 132, 0.2)');

    const gradient2 = ctxBar5.createLinearGradient(0, 0, 0, 600);
    gradient2.addColorStop(0, 'rgba(54, 162, 235, 0.8)');
    gradient2.addColorStop(1, 'rgba(54, 162, 235, 0.2)');

    const gradient3 = ctxBar5.createLinearGradient(0, 0, 0, 600);
    gradient3.addColorStop(0, 'rgba(255, 206, 86, 0.8)');
    gradient3.addColorStop(1, 'rgba(255, 206, 86, 0.2)');

    const chartData5 = {
        labels: labels5,
        datasets: [
            {
                label: 'Total',
                data: data1,
                backgroundColor: gradient1,
                borderRadius: 10
            },
            {
                label: 'Under Approval',
                data: data2,
                backgroundColor: gradient2,
                borderRadius: 10
            },
            {
                label: 'Approved',
                data: data3,
                backgroundColor: gradient3,
                borderRadius: 10
            }
        ]
    };

    new Chart(ctxBar5, {
        type: 'bar',
        data: chartData5,
        options: {
            responsive: true,
            maintainAspectRatio: false,

            onClick: function(evt, elements) {

                if (elements.length > 0) {

                    const clickedElementIndex = elements[0].index;
                    const datasetIndex = elements[0].datasetIndex;

                    const originalIndex = validIndexes5[clickedElementIndex];

                    var links = {

                         0: [
                            "oapForm.htm?act=projectManagerTotal&contact=${firstElement1_10}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${secondElement1_10}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${thirdElement1_10}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${fourthElement1_10}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${fifthElement1_10}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${sixthElement1_10}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${seventhElement1_10}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${eighthElement1_10}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${ninthElement1_10}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${tenthElement1_10}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}"
                        ],

                        1: [
                            "oapForm.htm?act=projectManagerTotal&contact=${firstElement1_10}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${secondElement1_10}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${thirdElement1_10}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${fourthElement1_10}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${fifthElement1_10}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${sixthElement1_10}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${seventhElement1_10}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${eighthElement1_10}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${ninthElement1_10}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${tenthElement1_10}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}"
                        ],

                        2: [
                            "oapForm.htm?act=projectManagerTotal&contact=${firstElement1_10}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${secondElement1_10}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${thirdElement1_10}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${fourthElement1_10}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${fifthElement1_10}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${sixthElement1_10}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${seventhElement1_10}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${eighthElement1_10}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${ninthElement1_10}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}",
                            "oapForm.htm?act=projectManagerTotal&contact=${tenthElement1_10}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}"
                        ]
                    };

                    if (links[datasetIndex] && links[datasetIndex][originalIndex]) {
                        window.location.href = links[datasetIndex][originalIndex];
                    } else {
                        console.error("No link found for clicked element");
                    }
                }
            },

            scales: {
                x: { grid: { display: false } }
            }
        }
    });
</script>

<script>
if ($('#oapAnalyticsLineChart').length > 0) {

    const ctx = document.getElementById('oapAnalyticsLineChart').getContext('2d');

    const labels = [
        '${noOfChargermonthNames1}', '${noOfChargermonthNames2}', '${noOfChargermonthNames3}',
        '${noOfChargermonthNames4}', '${noOfChargermonthNames5}', '${noOfChargermonthNames6}',
        '${noOfChargermonthNames7}', '${noOfChargermonthNames8}', '${noOfChargermonthNames9}',
        '${noOfChargermonthNames10}', '${noOfChargermonthNames11}', '${noOfChargermonthNames12}'
    ];

    const oapanalyticsData = [
        ${noOfChargernumberOfValue1}, ${noOfChargernumberOfValue2}, ${noOfChargernumberOfValue3},
        ${noOfChargernumberOfValue4}, ${noOfChargernumberOfValue5}, ${noOfChargernumberOfValue6},
        ${noOfChargernumberOfValue7}, ${noOfChargernumberOfValue8}, ${noOfChargernumberOfValue9},
        ${noOfChargernumberOfValue10}, ${noOfChargernumberOfValue11}, ${noOfChargernumberOfValue12}
    ];

    const totalChargerCapacityData = [
        ${totalChargerCapacitynumberOfValue1}, ${totalChargerCapacitynumberOfValue2}, ${totalChargerCapacitynumberOfValue3},
        ${totalChargerCapacitynumberOfValue4}, ${totalChargerCapacitynumberOfValue5}, ${totalChargerCapacitynumberOfValue6},
        ${totalChargerCapacitynumberOfValue7}, ${totalChargerCapacitynumberOfValue8}, ${totalChargerCapacitynumberOfValue9},
        ${totalChargerCapacitynumberOfValue10}, ${totalChargerCapacitynumberOfValue11}, ${totalChargerCapacitynumberOfValue12}
    ];

    const totalKwRatingData = [
        ${totalKwRatingnumberOfValue1}, ${totalKwRatingnumberOfValue2}, ${totalKwRatingnumberOfValue3},
        ${totalKwRatingnumberOfValue4}, ${totalKwRatingnumberOfValue5}, ${totalKwRatingnumberOfValue6},
        ${totalKwRatingnumberOfValue7}, ${totalKwRatingnumberOfValue8}, ${totalKwRatingnumberOfValue9},
        ${totalKwRatingnumberOfValue10}, ${totalKwRatingnumberOfValue11}, ${totalKwRatingnumberOfValue12}
    ];

    let gradient1 = ctx.createLinearGradient(0, 0, 0, 400);
    gradient1.addColorStop(0, 'rgba(100, 116, 139, 0.5)');
    gradient1.addColorStop(1, 'rgba(100, 116, 139, 0)');

    let gradient2 = ctx.createLinearGradient(0, 0, 0, 400);
    gradient2.addColorStop(0, 'rgba(251, 113, 133, 0.5)');
    gradient2.addColorStop(1, 'rgba(251, 113, 133, 0)');

    let gradient3 = ctx.createLinearGradient(0, 0, 0, 400);
    gradient3.addColorStop(0, 'rgba(45, 212, 191, 0.5)');
    gradient3.addColorStop(1, 'rgba(45, 212, 191, 0)');

    new Chart(ctx, {
        type: 'line',
        data: {
            labels: labels,
            datasets: [
                {
                    label: 'NO OF CHARGER',
                    data: oapanalyticsData,
                    fill: true,
                    backgroundColor: gradient1,
                    borderColor: 'rgba(100, 116, 139, 1)',
                    borderWidth: 2,
                    tension: 0.4,
                    pointRadius: 4
                },
                {
                    label: 'TOTAL CHARGER CAPACITY',
                    data: totalChargerCapacityData,
                    fill: true,
                    backgroundColor: gradient2,
                    borderColor: 'rgba(251, 113, 133, 1)',
                    borderWidth: 2,
                    tension: 0.4,
                    pointRadius: 4
                },
                {
                    label: 'TOTAL KW RATING',
                    data: totalKwRatingData,
                    fill: true,
                    backgroundColor: gradient3,
                    borderColor: 'rgba(45, 212, 191, 1)',
                    borderWidth: 2,
                    tension: 0.4,
                    pointRadius: 4
                }
            ]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,


            interaction: {
                mode: 'nearest',
                intersect: true
            },

            plugins: {
                legend: {
                    display: true,
                    labels: { color: '#333' }
                }
            },

            onClick: function(evt, elements) {

                if (!elements.length) return;

                const clickedElementIndex = elements[0].index;
                const datasetIndex = elements[0].datasetIndex;

                let originalIndex = clickedElementIndex;

                if (typeof validIndexes5 !== 'undefined' && validIndexes5[clickedElementIndex] !== undefined) {
                    originalIndex = validIndexes5[clickedElementIndex];
                }

                var links = {
                    0: [
                        "oapForm.htm?act=clickNoOfChargerDetails&label=${noOfChargermonthNames1}&Filter=${Filter}",
                        "oapForm.htm?act=clickNoOfChargerDetails&label=${noOfChargermonthNames2}&Filter=${Filter}",
                        "oapForm.htm?act=clickNoOfChargerDetails&label=${noOfChargermonthNames3}&Filter=${Filter}",
                        "oapForm.htm?act=clickNoOfChargerDetails&label=${noOfChargermonthNames4}&Filter=${Filter}",
                        "oapForm.htm?act=clickNoOfChargerDetails&label=${noOfChargermonthNames5}&Filter=${Filter}",
                        "oapForm.htm?act=clickNoOfChargerDetails&label=${noOfChargermonthNames6}&Filter=${Filter}",
                        "oapForm.htm?act=clickNoOfChargerDetails&label=${noOfChargermonthNames7}&Filter=${Filter}",
                        "oapForm.htm?act=clickNoOfChargerDetails&label=${noOfChargermonthNames8}&Filter=${Filter}",
                        "oapForm.htm?act=clickNoOfChargerDetails&label=${noOfChargermonthNames9}&Filter=${Filter}",
                        "oapForm.htm?act=clickNoOfChargerDetails&label=${noOfChargermonthNames10}&Filter=${Filter}",
                        "oapForm.htm?act=clickNoOfChargerDetails&label=${noOfChargermonthNames11}&Filter=${Filter}",
                        "oapForm.htm?act=clickNoOfChargerDetails&label=${noOfChargermonthNames12}&Filter=${Filter}"
                    ],
                    1: [
                        "oapForm.htm?act=clicktotalChargerCapacityDetails&label=${noOfChargermonthNames1}&Filter=${Filter}",
                        "oapForm.htm?act=clicktotalChargerCapacityDetails&label=${noOfChargermonthNames2}&Filter=${Filter}",
                        "oapForm.htm?act=clicktotalChargerCapacityDetails&label=${noOfChargermonthNames3}&Filter=${Filter}",
                        "oapForm.htm?act=clicktotalChargerCapacityDetails&label=${noOfChargermonthNames4}&Filter=${Filter}",
                        "oapForm.htm?act=clicktotalChargerCapacityDetails&label=${noOfChargermonthNames5}&Filter=${Filter}",
                        "oapForm.htm?act=clicktotalChargerCapacityDetails&label=${noOfChargermonthNames6}&Filter=${Filter}",
                        "oapForm.htm?act=clicktotalChargerCapacityDetails&label=${noOfChargermonthNames7}&Filter=${Filter}",
                        "oapForm.htm?act=clicktotalChargerCapacityDetails&label=${noOfChargermonthNames8}&Filter=${Filter}",
                        "oapForm.htm?act=clicktotalChargerCapacityDetails&label=${noOfChargermonthNames9}&Filter=${Filter}",
                        "oapForm.htm?act=clicktotalChargerCapacityDetails&label=${noOfChargermonthNames10}&Filter=${Filter}",
                        "oapForm.htm?act=clicktotalChargerCapacityDetails&label=${noOfChargermonthNames11}&Filter=${Filter}",
                        "oapForm.htm?act=clicktotalChargerCapacityDetails&label=${noOfChargermonthNames12}&Filter=${Filter}"
                    ],
                    
                    2: [
                        "oapForm.htm?act=clicktotalKwRatingDetails&label=${noOfChargermonthNames1}&Filter=${Filter}",
                        "oapForm.htm?act=clicktotalKwRatingDetails&label=${noOfChargermonthNames2}&Filter=${Filter}",
                        "oapForm.htm?act=clicktotalKwRatingDetails&label=${noOfChargermonthNames3}&Filter=${Filter}",
                        "oapForm.htm?act=clicktotalKwRatingDetails&label=${noOfChargermonthNames4}&Filter=${Filter}",
                        "oapForm.htm?act=clicktotalKwRatingDetails&label=${noOfChargermonthNames5}&Filter=${Filter}",
                        "oapForm.htm?act=clicktotalKwRatingDetails&label=${noOfChargermonthNames6}&Filter=${Filter}",
                        "oapForm.htm?act=clicktotalKwRatingDetails&label=${noOfChargermonthNames7}&Filter=${Filter}",
                        "oapForm.htm?act=clicktotalKwRatingDetails&label=${noOfChargermonthNames8}&Filter=${Filter}",
                        "oapForm.htm?act=clicktotalKwRatingDetails&label=${noOfChargermonthNames9}&Filter=${Filter}",
                        "oapForm.htm?act=clicktotalKwRatingDetails&label=${noOfChargermonthNames10}&Filter=${Filter}",
                        "oapForm.htm?act=clicktotalKwRatingDetails&label=${noOfChargermonthNames11}&Filter=${Filter}",
                        "oapForm.htm?act=clicktotalKwRatingDetails&label=${noOfChargermonthNames12}&Filter=${Filter}"
                    ]
                    
                };

                if (links[datasetIndex] && links[datasetIndex][originalIndex]) {
                    window.location.href = links[datasetIndex][originalIndex];
                }
            },

            scales: {
                x: {
                    ticks: { color: '#333' }
                },
                y: {
                    beginAtZero: true
                }
            }
        }
    });
}
</script>

<script>
if ($('#aocAnalyticsLineChart').length > 0) {

    const ctx = document.getElementById('aocAnalyticsLineChart').getContext('2d');

 
    const labels = [
        '${aocanalyticsmonthNames1}', '${aocanalyticsmonthNames2}', '${aocanalyticsmonthNames3}',
        '${aocanalyticsmonthNames4}', '${aocanalyticsmonthNames5}', '${aocanalyticsmonthNames6}',
        '${aocanalyticsmonthNames7}', '${aocanalyticsmonthNames8}', '${aocanalyticsmonthNames9}',
         '${aocanalyticsmonthNames10}', '${aocanalyticsmonthNames11}', '${aocanalyticsmonthNames12}'
    ];
    console.log(labels);
  
    const aocanalyticsData = [
         ${aocanalyticsnumberOfValue1}, ${aocanalyticsnumberOfValue2}, ${aocanalyticsnumberOfValue3},
         ${aocanalyticsnumberOfValue4}, ${aocanalyticsnumberOfValue5}, ${aocanalyticsnumberOfValue6},
         ${aocanalyticsnumberOfValue7}, ${aocanalyticsnumberOfValue8}, ${aocanalyticsnumberOfValue9},
         ${aocanalyticsnumberOfValue10}, ${aocanalyticsnumberOfValue11}, ${aocanalyticsnumberOfValue12}
    ];

const aoctotalChargerCapacityData = [
    ${aoctotalChargerCapacitynumberOfValue1}, ${aoctotalChargerCapacitynumberOfValue2}, ${aoctotalChargerCapacitynumberOfValue3},
    ${aoctotalChargerCapacitynumberOfValue4}, ${aoctotalChargerCapacitynumberOfValue5}, ${aoctotalChargerCapacitynumberOfValue6},
    ${aoctotalChargerCapacitynumberOfValue7}, ${aoctotalChargerCapacitynumberOfValue8}, ${aoctotalChargerCapacitynumberOfValue9},
    ${aoctotalChargerCapacitynumberOfValue10}, ${aoctotalChargerCapacitynumberOfValue11}, ${aoctotalChargerCapacitynumberOfValue12}
    ];
const aoctotalKwRatingData = [
    ${aoctotalKwRatingnumberOfValue1}, ${aoctotalKwRatingnumberOfValue2}, ${aoctotalKwRatingnumberOfValue3},
    ${aoctotalKwRatingnumberOfValue4}, ${aoctotalKwRatingnumberOfValue5}, ${aoctotalKwRatingnumberOfValue6},
    ${aoctotalKwRatingnumberOfValue7}, ${aoctotalKwRatingnumberOfValue8}, ${aoctotalKwRatingnumberOfValue9},
    ${aoctotalKwRatingnumberOfValue10}, ${aoctotalKwRatingnumberOfValue11}, ${aoctotalKwRatingnumberOfValue12}
    ];

                  let gradient1 = ctx.createLinearGradient(0, 0, 0, 400);
                    gradient1.addColorStop(0, 'rgba(239, 68, 68, 0.5)');
                    gradient1.addColorStop(1, 'rgba(239, 68, 68, 0)');

                    let gradient2 = ctx.createLinearGradient(0, 0, 0, 400);
                    gradient2.addColorStop(0, 'rgba(245, 158, 11, 0.5)');
                    gradient2.addColorStop(1, 'rgba(245, 158, 11, 0)');

                    let gradient3 = ctx.createLinearGradient(0, 0, 0, 400);
                    gradient3.addColorStop(0, 'rgba(37, 99, 235, 0.5)');
                    gradient3.addColorStop(1, 'rgba(37, 99, 235, 0)');
    new Chart(ctx, {
        type: 'line',
        data: {
            labels: labels,
            datasets: [
                {
                    label: 'NO OF CHARGER',
                    data: aocanalyticsData,
                    fill: true,
                    backgroundColor: gradient1,
                   borderColor: 'rgba(239, 68, 68, 1)',
                    borderWidth: 2,
                    tension: 0.4,
                    pointRadius: 4
                },
                {
                    label: 'TOTAL CHARGER CAPACITY',
                    data: aoctotalChargerCapacityData,
                    fill: true,
                    backgroundColor: gradient2,
                   borderColor: 'rgba(245, 158, 11, 1)',
                    borderWidth: 2,
                    tension: 0.4,
                    pointRadius: 4
                },
                {
                    label: 'TOTAL KW RATING',
                    data: aoctotalKwRatingData,
                    fill: true,
                    backgroundColor: gradient3,
                    borderColor: 'rgba(37, 99, 235, 1)',
                    borderWidth: 2,
                    tension: 0.4,
                    pointRadius: 4
                }
            ]
        },
        
        options: {
            responsive: true,
            maintainAspectRatio: false,

            interaction: {
                mode: 'nearest',
                intersect: true
            },

            plugins: {
                legend: {
                    display: true,
                    labels: { color: '#333' }
                }
            },

            onClick: function(evt, elements) {

                if (!elements.length) return;

                const clickedElementIndex = elements[0].index;
                const datasetIndex = elements[0].datasetIndex;

                let originalIndex = clickedElementIndex;

                if (typeof validIndexes5 !== 'undefined' && validIndexes5[clickedElementIndex] !== undefined) {
                    originalIndex = validIndexes5[clickedElementIndex];
                }

                var links = {
                    0: [
                        "oapForm.htm?act=clickaocNoOfChargerDetails&label=${aocanalyticsmonthNames1}&Filter=${Filter}",
                        "oapForm.htm?act=clickaocNoOfChargerDetails&label=${aocanalyticsmonthNames2}&Filter=${Filter}",
                        "oapForm.htm?act=clickaocNoOfChargerDetails&label=${aocanalyticsmonthNames3}&Filter=${Filter}",
                        "oapForm.htm?act=clickaocNoOfChargerDetails&label=${aocanalyticsmonthNames4}&Filter=${Filter}",
                        "oapForm.htm?act=clickaocNoOfChargerDetails&label=${aocanalyticsmonthNames5}&Filter=${Filter}",
                        "oapForm.htm?act=clickaocNoOfChargerDetails&label=${aocanalyticsmonthNames6}&Filter=${Filter}",
                        "oapForm.htm?act=clickaocNoOfChargerDetails&label=${aocanalyticsmonthNames7}&Filter=${Filter}",
                        "oapForm.htm?act=clickaocNoOfChargerDetails&label=${aocanalyticsmonthNames8}&Filter=${Filter}",
                        "oapForm.htm?act=clickaocNoOfChargerDetails&label=${aocanalyticsmonthNames9}&Filter=${Filter}",
                        "oapForm.htm?act=clickaocNoOfChargerDetails&label=${aocanalyticsmonthNames10}&Filter=${Filter}",
                        "oapForm.htm?act=clickaocNoOfChargerDetails&label=${aocanalyticsmonthNames11}&Filter=${Filter}",
                        "oapForm.htm?act=clickaocNoOfChargerDetails&label=${aocanalyticsmonthNames12}&Filter=${Filter}"
                    ],
                    1: [
                        "oapForm.htm?act=clickaoctotalChargerCapacityDetails&label=${aocanalyticsmonthNames1}&Filter=${Filter}",
                        "oapForm.htm?act=clickaoctotalChargerCapacityDetails&label=${aocanalyticsmonthNames2}&Filter=${Filter}",
                        "oapForm.htm?act=clickaoctotalChargerCapacityDetails&label=${aocanalyticsmonthNames3}&Filter=${Filter}",
                        "oapForm.htm?act=clickaoctotalChargerCapacityDetails&label=${aocanalyticsmonthNames4}&Filter=${Filter}",
                        "oapForm.htm?act=clickaoctotalChargerCapacityDetails&label=${aocanalyticsmonthNames5}&Filter=${Filter}",
                        "oapForm.htm?act=clickaoctotalChargerCapacityDetails&label=${aocanalyticsmonthNames6}&Filter=${Filter}",
                        "oapForm.htm?act=clickaoctotalChargerCapacityDetails&label=${aocanalyticsmonthNames7}&Filter=${Filter}",
                        "oapForm.htm?act=clickaoctotalChargerCapacityDetails&label=${aocanalyticsmonthNames8}&Filter=${Filter}",
                        "oapForm.htm?act=clickaoctotalChargerCapacityDetails&label=${aocanalyticsmonthNames9}&Filter=${Filter}",
                        "oapForm.htm?act=clickaoctotalChargerCapacityDetails&label=${aocanalyticsmonthNames10}&Filter=${Filter}",
                        "oapForm.htm?act=clickaoctotalChargerCapacityDetails&label=${aocanalyticsmonthNames11}&Filter=${Filter}",
                        "oapForm.htm?act=clickaoctotalChargerCapacityDetails&label=${aocanalyticsmonthNames12}&Filter=${Filter}"
                    ],
                    
                    2: [
                        "oapForm.htm?act=clickaoctotalKwRatingDetails&label=${aocanalyticsmonthNames1}&Filter=${Filter}",
                        "oapForm.htm?act=clickaoctotalKwRatingDetails&label=${aocanalyticsmonthNames2}&Filter=${Filter}",
                        "oapForm.htm?act=clickaoctotalKwRatingDetails&label=${aocanalyticsmonthNames3}&Filter=${Filter}",
                        "oapForm.htm?act=clickaoctotalKwRatingDetails&label=${aocanalyticsmonthNames4}&Filter=${Filter}",
                        "oapForm.htm?act=clickaoctotalKwRatingDetails&label=${aocanalyticsmonthNames5}&Filter=${Filter}",
                        "oapForm.htm?act=clickaoctotalKwRatingDetails&label=${aocanalyticsmonthNames6}&Filter=${Filter}",
                        "oapForm.htm?act=clickaoctotalKwRatingDetails&label=${aocanalyticsmonthNames7}&Filter=${Filter}",
                        "oapForm.htm?act=clickaoctotalKwRatingDetails&label=${aocanalyticsmonthNames8}&Filter=${Filter}",
                        "oapForm.htm?act=clickaoctotalKwRatingDetails&label=${aocanalyticsmonthNames9}&Filter=${Filter}",
                        "oapForm.htm?act=clickaoctotalKwRatingDetails&label=${aocanalyticsmonthNames10}&Filter=${Filter}",
                        "oapForm.htm?act=clickaoctotalKwRatingDetails&label=${aocanalyticsmonthNames11}&Filter=${Filter}",
                        "oapForm.htm?act=clickaoctotalKwRatingDetails&label=${aocanalyticsmonthNames12}&Filter=${Filter}"
                    ]
                    
                };

                if (links[datasetIndex] && links[datasetIndex][originalIndex]) {
                    window.location.href = links[datasetIndex][originalIndex];
                }
            },

            scales: {
                x: {
                    ticks: { color: '#333' }
                },
                y: {
                    beginAtZero: true
                }
            }
        }
        
        
        
        
        
    });
}
</script>


<script>
document.addEventListener("DOMContentLoaded", function () {

    var raw = document.getElementById("chartDataHolder").value;

    if (!raw) {
        console.error("No data");
        return;
    }

    var chartData = JSON.parse(raw);

    function hslToHex(h, s, l) {
        s = s / 100;
        l = l / 100;

        function k(n) {
            return (n + h / 30) % 12;
        }

        var a = s * Math.min(l, 1 - l);

        function f(n) {
            return Math.round(
                255 * (
                    l - a * Math.max(
                        -1,
                        Math.min(
                            k(n) - 3,
                            Math.min(9 - k(n), 1)
                        )
                    )
                )
            );
        }

        var r = f(0).toString(16).padStart(2, '0');
        var g = f(8).toString(16).padStart(2, '0');
        var b = f(4).toString(16).padStart(2, '0');

        return "#" + r + g + b;
    }

    function generateColor(index) {
        var hue = (index * 137.508) % 360;
        return hslToHex(hue, 65, 55);
    }

    var ctx = document.getElementById("myChart").getContext("2d");

    new Chart(ctx, {

        type: 'bar',

        data: {
            labels: chartData.labels,

            datasets: chartData.datasets.map(function (ds, index) {

                var color = generateColor(index);

                return {
                    label: ds.label,
                    data: ds.data,
                    backgroundColor: color,
                    borderColor: color,
                    borderWidth: 1
                };
            })
        },

        options: {

            responsive: true,
            maintainAspectRatio: false,

            plugins: {

                legend: {

                    position: 'top',
                    align: 'start',

                    labels: {

                        usePointStyle: true,
                        pointStyle: 'rect',
                        boxWidth: 12,
                        boxHeight: 12,
                        padding: 15,

                        font: {
                            size: 11,
                            weight: '600'
                        },

                        generateLabels: function (chart) {

                            const original =
                                Chart.defaults.plugins.legend.labels.generateLabels;

                            const labels = original(chart);

                            labels.forEach(function (l) {

                                if (l.text && l.text.length > 25) {
                                    l.text = l.text.substring(0, 25) + "...";
                                }

                            });

                            return labels;
                        }
                    }
                }
            },

            scales: {

                x: {
                    stacked: true,

                    ticks: {
                        maxRotation: 0,
                        autoSkip: true
                    }
                },

                y: {
                    stacked: true,
                    beginAtZero: true
                }
            },

//           onClick: function (evt, elements) {
//
//                    if (!elements.length) {
//                        return;
//                    }
//
//                    var el = elements[0];
//
//                    var datasetIndex = el.datasetIndex;
//                    var index = el.index;
//
//                    var ds = chartData.datasets[datasetIndex];
//
//                    var month = chartData.labels[index];
//                    var count = ds.data[index];
//                    var label = ds.label;
//
//                    // GET CLICKED BAR COLOR
//                    var color = this.data.datasets[datasetIndex].backgroundColor;
//
//                    console.log("Month:", month);
//                    console.log("Count:", count);
//                    console.log("Label:", label);
//                    console.log("Color:", color);
//
//                    window.location.href =
//                        "aocForm.htm?act=bifurcationOAPEthanWise"
//                        + "&month=" + encodeURIComponent(month)
//                        + "&count=" + encodeURIComponent(count)
//                        + "&label=" + encodeURIComponent(label)
//                        + "&color=" + encodeURIComponent(color);
//                }
        }
    });

});
</script>

<script>
document.addEventListener("DOMContentLoaded", function () {

    var rawEqua = document.getElementById("chartDataHolderEqua").value;

    if (!rawEqua) {
        console.error("No data");
        return;
    }

    var chartDataEqua = JSON.parse(rawEqua);

    function hslToHex(h, s, l) {
        s = s / 100;
        l = l / 100;

        function k(n) {
            return (n + h / 30) % 12;
        }

        var a = s * Math.min(l, 1 - l);

        function f(n) {
            return Math.round(
                255 * (l - a * Math.max(-1, Math.min(k(n) - 3, Math.min(9 - k(n), 1))))
            );
        }

        var r = f(0).toString(16).padStart(2, '0');
        var g = f(8).toString(16).padStart(2, '0');
        var b = f(4).toString(16).padStart(2, '0');

        return "#" + r + g + b;
    }

    function generateColor(index) {
        var hue = (index * 137.508) % 360;
        return hslToHex(hue, 65, 55);
    }

    var ctx = document.getElementById("myChartEqua").getContext("2d");

    new Chart(ctx, {
        type: 'bar',
        data: {
            /* FIX 4: chartData -> chartDataEqua */
            labels: chartDataEqua.labels,
            datasets: chartDataEqua.datasets.map(function (ds, index) {
                var color = generateColor(index);
                return {
                    label: ds.label,
                    data: ds.data,
                    backgroundColor: color,
                    borderColor: color,
                    borderWidth: 1
                };
            })
        },

        options: {
            responsive: true,
            maintainAspectRatio: false,

            plugins: {
                legend: {
                    position: 'top',
                    align: 'start',
                    labels: {
                        usePointStyle: true,
                        pointStyle: 'rect',
                        boxWidth: 12,
                        boxHeight: 12,
                        padding: 15,
                        font: {
                            size: 11,
                            weight: '600'
                        },
                        generateLabels: function (chart) {
                            const original =
                                Chart.defaults.plugins.legend.labels.generateLabels;

                            const labels = original(chart);

                            labels.forEach(l => {
                                if (l.text && l.text.length > 25) {
                                    l.text = l.text.substring(0, 25) + "...";
                                }
                            });

                            return labels;
                        }
                    }
                }
            },

            scales: {
                x: {
                    stacked: true,
                    ticks: {
                        maxRotation: 0,
                        autoSkip: true
                    }
                },
                y: {
                    stacked: true,
                    beginAtZero: true
                }
            },
//            onClick: function (evt, elements) {
//
//                    if (!elements.length) {
//                        return;
//                    }
//
//                    var clickedElementEqua = elements[0];
//
//                    var clickedDatasetIndexEqua = clickedElementEqua.datasetIndex;
//                    var clickedIndexEqua = clickedElementEqua.index;
//
//                    var clickedDatasetEqua =
//                        chartDataEqua.datasets[clickedDatasetIndexEqua];
//
//                    var clickedMonthEqua =
//                        chartDataEqua.labels[clickedIndexEqua];
//
//                    var clickedCountEqua =
//                        clickedDatasetEqua.data[clickedIndexEqua];
//
//                    var clickedLabelEqua =
//                        clickedDatasetEqua.label;
//
//                    var clickedColorEqua =
//                        this.data.datasets[clickedDatasetIndexEqua].backgroundColor;
//
//                    console.log("Month:", clickedMonthEqua);
//                    console.log("Count:", clickedCountEqua);
//                    console.log("Label:", clickedLabelEqua);
//                    console.log("Color:", clickedColorEqua);
//
//                    window.location.href =
//                        "aocForm.htm?act=bifurcationOAPEquatorWise"
//                        + "&month=" + encodeURIComponent(clickedMonthEqua)
//                        + "&count=" + encodeURIComponent(clickedCountEqua)
//                        + "&label=" + encodeURIComponent(clickedLabelEqua)
//                        + "&color=" + encodeURIComponent(clickedColorEqua);
//                }
            
            
        }
    });

});
</script>

<script>
document.addEventListener("DOMContentLoaded", function () {

    var rawHub = document.getElementById("chartDataHolderHub").value;

    if (!rawHub) {
        console.error("No Hub data");
        return;
    }

    var chartDataHub = JSON.parse(rawHub);

    function hslToHex(h, s, l) {
        s = s / 100;
        l = l / 100;

        function k(n) {
            return (n + h / 30) % 12;
        }

        var a = s * Math.min(l, 1 - l);

        function f(n) {
            return Math.round(
                255 * (
                    l - a * Math.max(
                        -1,
                        Math.min(
                            k(n) - 3,
                            Math.min(9 - k(n), 1)
                        )
                    )
                )
            );
        }

        var r = f(0).toString(16).padStart(2, '0');
        var g = f(8).toString(16).padStart(2, '0');
        var b = f(4).toString(16).padStart(2, '0');

        return "#" + r + g + b;
    }

    function generateColorHub(indexHub) {
        var hueHub = (indexHub * 137.508) % 360;
        return hslToHex(hueHub, 65, 55);
    }

    var ctxHub =
        document.getElementById("myChartHub").getContext("2d");

    new Chart(ctxHub, {

        type: 'bar',

        data: {
            labels: chartDataHub.labels,

            datasets: chartDataHub.datasets.map(function (datasetHub, datasetIndexHub) {

                var generatedColorHub =
                    generateColorHub(datasetIndexHub);

                return {
                    label: datasetHub.label,
                    data: datasetHub.data,
                    backgroundColor: generatedColorHub,
                    borderColor: generatedColorHub,
                    borderWidth: 1
                };
            })
        },

        options: {

            responsive: true,
            maintainAspectRatio: false,

//            onClick: function (evt, elements) {
//
//                if (!elements.length) {
//                    return;
//                }
//
//                var clickedElementHub = elements[0];
//
//                var clickedDatasetIndexHub =
//                    clickedElementHub.datasetIndex;
//
//                var clickedIndexHub =
//                    clickedElementHub.index;
//
//                var clickedDatasetHub =
//                    chartDataHub.datasets[clickedDatasetIndexHub];
//
//                var clickedMonthHub =
//                    chartDataHub.labels[clickedIndexHub];
//
//                var clickedCountHub =
//                    clickedDatasetHub.data[clickedIndexHub];
//
//                var clickedLabelHub =
//                    clickedDatasetHub.label;
//
//                var clickedColorHub =
//                    this.data.datasets[clickedDatasetIndexHub].backgroundColor;
//
//                console.log("Month:", clickedMonthHub);
//                console.log("Count:", clickedCountHub);
//                console.log("Label:", clickedLabelHub);
//                console.log("Color:", clickedColorHub);
//
//                window.location.href =
//                    "aocForm.htm?act=bifurcationOAPHubWise"
//                    + "&month=" + encodeURIComponent(clickedMonthHub)
//                    + "&count=" + encodeURIComponent(clickedCountHub)
//                    + "&label=" + encodeURIComponent(clickedLabelHub)
//                    + "&color=" + encodeURIComponent(clickedColorHub);
//            },

            plugins: {

                legend: {

                    position: 'top',
                    align: 'start',

                    labels: {

                        usePointStyle: true,
                        pointStyle: 'rect',
                        boxWidth: 12,
                        boxHeight: 12,
                        padding: 15,

                        font: {
                            size: 11,
                            weight: '600'
                        }
                    }
                }
            },

            scales: {

                x: {
                    stacked: true
                },

                y: {
                    stacked: true,
                    beginAtZero: true
                }
            }
        }
    });

});
</script>

<script>
document.addEventListener("DOMContentLoaded", function () {

    var rawCapex = document.getElementById("chartDataHolderCapex").value;

    if (!rawCapex) {
        console.error("No Capex data");
        return;
    }

    var chartDataCapex = JSON.parse(rawCapex);

    function hslToHex(h, s, l) {
        s = s / 100;
        l = l / 100;

        function k(n) {
            return (n + h / 30) % 12;
        }

        var a = s * Math.min(l, 1 - l);

        function f(n) {
            return Math.round(
                255 * (
                    l - a * Math.max(
                        -1,
                        Math.min(
                            k(n) - 3,
                            Math.min(9 - k(n), 1)
                        )
                    )
                )
            );
        }

        var r = f(0).toString(16).padStart(2, '0');
        var g = f(8).toString(16).padStart(2, '0');
        var b = f(4).toString(16).padStart(2, '0');

        return "#" + r + g + b;
    }

    function generateColorCapex(indexCapex) {

        var hueCapex =
            (indexCapex * 137.508) % 360;

        return hslToHex(hueCapex, 65, 55);
    }

    var ctxCapex =
        document.getElementById("myChartCapex").getContext("2d");

    new Chart(ctxCapex, {

        type: 'bar',

        data: {

            labels: chartDataCapex.labels,

            datasets: chartDataCapex.datasets.map(function (
                datasetCapex,
                datasetIndexCapex
            ) {

                var generatedColorCapex =
                    generateColorCapex(datasetIndexCapex);

                return {
                    label: datasetCapex.label,
                    data: datasetCapex.data,
                    backgroundColor: generatedColorCapex,
                    borderColor: generatedColorCapex,
                    borderWidth: 1
                };
            })
        },

        options: {

            responsive: true,
            maintainAspectRatio: false,

//            onClick: function (evt, elements) {
//
//                if (!elements.length) {
//                    return;
//                }
//
//                var clickedElementCapex =
//                    elements[0];
//
//                var clickedDatasetIndexCapex =
//                    clickedElementCapex.datasetIndex;
//
//                var clickedIndexCapex =
//                    clickedElementCapex.index;
//
//                var clickedDatasetCapex =
//                    chartDataCapex.datasets[clickedDatasetIndexCapex];
//
//                var clickedMonthCapex =
//                    chartDataCapex.labels[clickedIndexCapex];
//
//                var clickedCountCapex =
//                    clickedDatasetCapex.data[clickedIndexCapex];
//
//                var clickedLabelCapex =
//                    clickedDatasetCapex.label;
//
//                var clickedColorCapex =
//                    this.data.datasets[clickedDatasetIndexCapex].backgroundColor;
//
//                console.log("Month:", clickedMonthCapex);
//                console.log("Count:", clickedCountCapex);
//                console.log("Label:", clickedLabelCapex);
//                console.log("Color:", clickedColorCapex);
//
//                window.location.href =
//                    "aocForm.htm?act=bifurcationOAPCapexWise"
//                    + "&month=" + encodeURIComponent(clickedMonthCapex)
//                    + "&count=" + encodeURIComponent(clickedCountCapex)
//                    + "&label=" + encodeURIComponent(clickedLabelCapex)
//                    + "&color=" + encodeURIComponent(clickedColorCapex);
//            },

            plugins: {

                legend: {

                    position: 'top',
                    align: 'start',

                    labels: {

                        usePointStyle: true,
                        pointStyle: 'rect',
                        boxWidth: 12,
                        boxHeight: 12,
                        padding: 15,

                        font: {
                            size: 11,
                            weight: '600'
                        }
                    }
                }
            },

            scales: {

                x: {
                    stacked: true
                },

                y: {
                    stacked: true,
                    beginAtZero: true
                }
            }
        }
    });

});
</script>
<script>
document.addEventListener("DOMContentLoaded", function () {

    var rawEthan = document.getElementById("chartDataHolderEthan").value;

    if (!rawEthan) {
        console.error("No Ethan data");
        return;
    }

    var chartDataEthan = JSON.parse(rawEthan);

    function hslToHex(h, s, l) {

        s = s / 100;
        l = l / 100;

        function k(n) {
            return (n + h / 30) % 12;
        }

        var a = s * Math.min(l, 1 - l);

        function f(n) {

            return Math.round(
                255 * (
                    l - a * Math.max(
                        -1,
                        Math.min(
                            k(n) - 3,
                            Math.min(9 - k(n), 1)
                        )
                    )
                )
            );
        }

        var r = f(0).toString(16).padStart(2, '0');
        var g = f(8).toString(16).padStart(2, '0');
        var b = f(4).toString(16).padStart(2, '0');

        return "#" + r + g + b;
    }

    function generateColorEthan(indexEthan) {

        var hueEthan =
            (indexEthan * 137.508) % 360;

        return hslToHex(hueEthan, 65, 55);
    }

    var ctxEthan =
        document.getElementById("myChartEthan").getContext("2d");

    new Chart(ctxEthan, {

        type: 'bar',

        data: {

            labels: chartDataEthan.labels,

            datasets: chartDataEthan.datasets.map(function (
                datasetEthan,
                datasetIndexEthan
            ) {

                var generatedColorEthan =
                    generateColorEthan(datasetIndexEthan);

                return {
                    label: datasetEthan.label,
                    data: datasetEthan.data,
                    backgroundColor: generatedColorEthan,
                    borderColor: generatedColorEthan,
                    borderWidth: 1
                };
            })
        },

        options: {

            responsive: true,
            maintainAspectRatio: false,

//            onClick: function (evt, elements) {
//
//                if (!elements.length) {
//                    return;
//                }
//
//                var clickedElementEthan =
//                    elements[0];
//
//                var clickedDatasetIndexEthan =
//                    clickedElementEthan.datasetIndex;
//
//                var clickedIndexEthan =
//                    clickedElementEthan.index;
//
//                var clickedDatasetEthan =
//                    chartDataEthan.datasets[clickedDatasetIndexEthan];
//
//                var clickedMonthEthan =
//                    chartDataEthan.labels[clickedIndexEthan];
//
//                var clickedCountEthan =
//                    clickedDatasetEthan.data[clickedIndexEthan];
//
//                var clickedLabelEthan =
//                    clickedDatasetEthan.label;
//
//                var clickedColorEthan =
//                    this.data.datasets[clickedDatasetIndexEthan].backgroundColor;
//
//                console.log("Month:", clickedMonthEthan);
//                console.log("Count:", clickedCountEthan);
//                console.log("Label:", clickedLabelEthan);
//                console.log("Color:", clickedColorEthan);
//
//                window.location.href =
//                    "aocForm.htm?act=bifurcationAOCEthanWise"
//                    + "&month=" + encodeURIComponent(clickedMonthEthan)
//                    + "&count=" + encodeURIComponent(clickedCountEthan)
//                    + "&label=" + encodeURIComponent(clickedLabelEthan)
//                    + "&color=" + encodeURIComponent(clickedColorEthan);
//            },

            plugins: {

                legend: {

                    position: 'top',
                    align: 'start',

                    labels: {

                        usePointStyle: true,
                        pointStyle: 'rect',
                        boxWidth: 12,
                        boxHeight: 12,
                        padding: 15,

                        font: {
                            size: 11,
                            weight: '600'
                        }
                    }
                }
            },

            scales: {

                x: {
                    stacked: true
                },

                y: {
                    stacked: true,
                    beginAtZero: true
                }
            }
        }
    });

});
</script>

<script>
document.addEventListener("DOMContentLoaded", function () {

    var rawEquaAoc =
        document.getElementById("chartDataHolderEquaAoc").value;

    if (!rawEquaAoc) {
        console.error("No Equator AOC data");
        return;
    }

    var chartDataEquaAoc =
        JSON.parse(rawEquaAoc);

    function hslToHex(h, s, l) {

        s = s / 100;
        l = l / 100;

        function k(n) {
            return (n + h / 30) % 12;
        }

        var a =
            s * Math.min(l, 1 - l);

        function f(n) {

            return Math.round(
                255 * (
                    l - a * Math.max(
                        -1,
                        Math.min(
                            k(n) - 3,
                            Math.min(9 - k(n), 1)
                        )
                    )
                )
            );
        }

        var r =
            f(0).toString(16).padStart(2, '0');

        var g =
            f(8).toString(16).padStart(2, '0');

        var b =
            f(4).toString(16).padStart(2, '0');

        return "#" + r + g + b;
    }

    function generateColorEquaAoc(indexEquaAoc) {

        var hueEquaAoc =
            (indexEquaAoc * 137.508) % 360;

        return hslToHex(hueEquaAoc, 65, 55);
    }

    var ctxEquaAoc =
        document.getElementById("myChartEquaAoc").getContext("2d");

    new Chart(ctxEquaAoc, {

        type: 'bar',

        data: {

            labels: chartDataEquaAoc.labels,

            datasets: chartDataEquaAoc.datasets.map(function (
                datasetEquaAoc,
                datasetIndexEquaAoc
            ) {

                var generatedColorEquaAoc =
                    generateColorEquaAoc(datasetIndexEquaAoc);

                return {
                    label: datasetEquaAoc.label,
                    data: datasetEquaAoc.data,
                    backgroundColor: generatedColorEquaAoc,
                    borderColor: generatedColorEquaAoc,
                    borderWidth: 1
                };
            })
        },

        options: {

            responsive: true,
            maintainAspectRatio: false,

//            onClick: function (evt, elements) {
//
//                if (!elements.length) {
//                    return;
//                }
//
//                var clickedElementEquaAoc =
//                    elements[0];
//
//                var clickedDatasetIndexEquaAoc =
//                    clickedElementEquaAoc.datasetIndex;
//
//                var clickedIndexEquaAoc =
//                    clickedElementEquaAoc.index;
//
//                var clickedDatasetEquaAoc =
//                    chartDataEquaAoc.datasets[clickedDatasetIndexEquaAoc];
//
//                var clickedMonthEquaAoc =
//                    chartDataEquaAoc.labels[clickedIndexEquaAoc];
//
//                var clickedCountEquaAoc =
//                    clickedDatasetEquaAoc.data[clickedIndexEquaAoc];
//
//                var clickedLabelEquaAoc =
//                    clickedDatasetEquaAoc.label;
//
//                var clickedColorEquaAoc =
//                    this.data.datasets[clickedDatasetIndexEquaAoc].backgroundColor;
//
//                console.log("Month:", clickedMonthEquaAoc);
//                console.log("Count:", clickedCountEquaAoc);
//                console.log("Label:", clickedLabelEquaAoc);
//                console.log("Color:", clickedColorEquaAoc);
//
//                window.location.href =
//                    "aocForm.htm?act=bifurcationAOCEquatorWise"
//                    + "&month=" + encodeURIComponent(clickedMonthEquaAoc)
//                    + "&count=" + encodeURIComponent(clickedCountEquaAoc)
//                    + "&label=" + encodeURIComponent(clickedLabelEquaAoc)
//                    + "&color=" + encodeURIComponent(clickedColorEquaAoc);
//            },

            plugins: {

                legend: {

                    position: 'top',
                    align: 'start',

                    labels: {

                        usePointStyle: true,
                        pointStyle: 'rect',
                        boxWidth: 12,
                        boxHeight: 12,
                        padding: 15,

                        font: {
                            size: 11,
                            weight: '600'
                        }
                    }
                }
            },

            scales: {

                x: {
                    stacked: true
                },

                y: {
                    stacked: true,
                    beginAtZero: true
                }
            }
        }
    });

});
</script>


<script>
document.addEventListener("DOMContentLoaded", function () {

    var rawHubAoc =
        document.getElementById("chartDataHolderHubAoc").value;

    if (!rawHubAoc) {
        console.error("No Hub AOC data");
        return;
    }

    var chartDataHubAoc =
        JSON.parse(rawHubAoc);

    function hslToHex(h, s, l) {

        s = s / 100;
        l = l / 100;

        function k(n) {
            return (n + h / 30) % 12;
        }

        var a =
            s * Math.min(l, 1 - l);

        function f(n) {

            return Math.round(
                255 * (
                    l - a * Math.max(
                        -1,
                        Math.min(
                            k(n) - 3,
                            Math.min(9 - k(n), 1)
                        )
                    )
                )
            );
        }

        var r =
            f(0).toString(16).padStart(2, '0');

        var g =
            f(8).toString(16).padStart(2, '0');

        var b =
            f(4).toString(16).padStart(2, '0');

        return "#" + r + g + b;
    }

    function generateColorHubAoc(indexHubAoc) {

        var hueHubAoc =
            (indexHubAoc * 137.508) % 360;

        return hslToHex(hueHubAoc, 65, 55);
    }

    var ctxHubAoc =
        document.getElementById("myChartHubAoc").getContext("2d");

    new Chart(ctxHubAoc, {

        type: 'bar',

        data: {

            labels: chartDataHubAoc.labels,

            datasets: chartDataHubAoc.datasets.map(function (
                datasetHubAoc,
                datasetIndexHubAoc
            ) {

                var generatedColorHubAoc =
                    generateColorHubAoc(datasetIndexHubAoc);

                return {
                    label: datasetHubAoc.label,
                    data: datasetHubAoc.data,
                    backgroundColor: generatedColorHubAoc,
                    borderColor: generatedColorHubAoc,
                    borderWidth: 1
                };
            })
        },

        options: {

            responsive: true,
            maintainAspectRatio: false,

//            onClick: function (evt, elements) {
//
//                if (!elements.length) {
//                    return;
//                }
//
//                var clickedElementHubAoc =
//                    elements[0];
//
//                var clickedDatasetIndexHubAoc =
//                    clickedElementHubAoc.datasetIndex;
//
//                var clickedIndexHubAoc =
//                    clickedElementHubAoc.index;
//
//                var clickedDatasetHubAoc =
//                    chartDataHubAoc.datasets[clickedDatasetIndexHubAoc];
//
//                var clickedMonthHubAoc =
//                    chartDataHubAoc.labels[clickedIndexHubAoc];
//
//                var clickedCountHubAoc =
//                    clickedDatasetHubAoc.data[clickedIndexHubAoc];
//
//                var clickedLabelHubAoc =
//                    clickedDatasetHubAoc.label;
//
//                var clickedColorHubAoc =
//                    this.data.datasets[clickedDatasetIndexHubAoc].backgroundColor;
//
//                console.log("Month:", clickedMonthHubAoc);
//                console.log("Count:", clickedCountHubAoc);
//                console.log("Label:", clickedLabelHubAoc);
//                console.log("Color:", clickedColorHubAoc);
//
//                window.location.href =
//                    "aocForm.htm?act=bifurcationAOCHubWise"
//                    + "&month=" + encodeURIComponent(clickedMonthHubAoc)
//                    + "&count=" + encodeURIComponent(clickedCountHubAoc)
//                    + "&label=" + encodeURIComponent(clickedLabelHubAoc)
//                    + "&color=" + encodeURIComponent(clickedColorHubAoc);
//            },

            plugins: {

                legend: {

                    position: 'top',
                    align: 'start',

                    labels: {

                        usePointStyle: true,
                        pointStyle: 'rect',
                        boxWidth: 12,
                        boxHeight: 12,
                        padding: 15,

                        font: {
                            size: 11,
                            weight: '600'
                        }
                    }
                }
            },

            scales: {

                x: {
                    stacked: true
                },

                y: {
                    stacked: true,
                    beginAtZero: true
                }
            }
        }
    });

});
</script>

<script>
document.addEventListener("DOMContentLoaded", function () {

    var rawCapexAoc =
        document.getElementById("chartDataHolderCapexAoc").value;

    if (!rawCapexAoc) {
        console.error("No Capex AOC data");
        return;
    }

    var chartDataCapexAoc =
        JSON.parse(rawCapexAoc);

    function hslToHex(h, s, l) {

        s = s / 100;
        l = l / 100;

        function k(n) {
            return (n + h / 30) % 12;
        }

        var a =
            s * Math.min(l, 1 - l);

        function f(n) {

            return Math.round(
                255 * (
                    l - a * Math.max(
                        -1,
                        Math.min(
                            k(n) - 3,
                            Math.min(9 - k(n), 1)
                        )
                    )
                )
            );
        }

        var r =
            f(0).toString(16).padStart(2, '0');

        var g =
            f(8).toString(16).padStart(2, '0');

        var b =
            f(4).toString(16).padStart(2, '0');

        return "#" + r + g + b;
    }

    function generateColorCapexAoc(indexCapexAoc) {

        var hueCapexAoc =
            (indexCapexAoc * 137.508) % 360;

        return hslToHex(hueCapexAoc, 65, 55);
    }

    var ctxCapexAoc =
        document.getElementById("myChartCapexAoc").getContext("2d");

    new Chart(ctxCapexAoc, {

        type: 'bar',

        data: {

            labels: chartDataCapexAoc.labels,

            datasets: chartDataCapexAoc.datasets.map(function (
                datasetCapexAoc,
                datasetIndexCapexAoc
            ) {

                var generatedColorCapexAoc =
                    generateColorCapexAoc(datasetIndexCapexAoc);

                return {
                    label: datasetCapexAoc.label,
                    data: datasetCapexAoc.data,
                    backgroundColor: generatedColorCapexAoc,
                    borderColor: generatedColorCapexAoc,
                    borderWidth: 1
                };
            })
        },

        options: {

            responsive: true,
            maintainAspectRatio: false,

//            onClick: function (evt, elements) {
//
//                if (!elements.length) {
//                    return;
//                }
//
//                var clickedElementCapexAoc =
//                    elements[0];
//
//                var clickedDatasetIndexCapexAoc =
//                    clickedElementCapexAoc.datasetIndex;
//
//                var clickedIndexCapexAoc =
//                    clickedElementCapexAoc.index;
//
//                var clickedDatasetCapexAoc =
//                    chartDataCapexAoc.datasets[clickedDatasetIndexCapexAoc];
//
//                var clickedMonthCapexAoc =
//                    chartDataCapexAoc.labels[clickedIndexCapexAoc];
//
//                var clickedCountCapexAoc =
//                    clickedDatasetCapexAoc.data[clickedIndexCapexAoc];
//
//                var clickedLabelCapexAoc =
//                    clickedDatasetCapexAoc.label;
//
//                var clickedColorCapexAoc =
//                    this.data.datasets[clickedDatasetIndexCapexAoc].backgroundColor;
//
//                console.log("Month:", clickedMonthCapexAoc);
//                console.log("Count:", clickedCountCapexAoc);
//                console.log("Label:", clickedLabelCapexAoc);
//                console.log("Color:", clickedColorCapexAoc);
//
//                window.location.href =
//                    "aocForm.htm?act=bifurcationAOCCapexWise"
//                    + "&month=" + encodeURIComponent(clickedMonthCapexAoc)
//                    + "&count=" + encodeURIComponent(clickedCountCapexAoc)
//                    + "&label=" + encodeURIComponent(clickedLabelCapexAoc)
//                    + "&color=" + encodeURIComponent(clickedColorCapexAoc);
//            },

            plugins: {

                legend: {

                    position: 'top',
                    align: 'start',

                    labels: {

                        usePointStyle: true,
                        pointStyle: 'rect',
                        boxWidth: 12,
                        boxHeight: 12,
                        padding: 15,

                        font: {
                            size: 11,
                            weight: '600'
                        }
                    }
                }
            },

            scales: {

                x: {
                    stacked: true
                },

                y: {
                    stacked: true,
                    beginAtZero: true
                }
            }
        }
    });

});
</script>
</html>
