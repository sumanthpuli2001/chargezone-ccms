<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>Total KOM </title>

    </head>

    <body>
        <main class="d-flex align-items-end justify-content-end">

            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                    <div class="page-title d-flex align-items-center">
                        <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                            <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)" alt="Menu collapse">
                            <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)" alt="Menu collapse">
                        </div>
                        <h5 class="fw-600 mb-0">Total KOM</h5>
                    </div>

                    <div class="cta d-flex align-items-center" style="gap: 10px;">
                        <li class="search-container" style="margin-left: auto; display: flex; align-items: center;">
                            <a href="oapForm.htm?act=oapAndAocDashboard" class="btn theme-btn light-btn mr-3 no-print">Back</a>
                            <button type="button" style="background-color: #00bcd4; color: white;" class="btn theme-btn" data-toggle="modal" data-target="#searchModal">
                                Filter
                            </button>
                        </li>
                    </div>
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
                                            <input type="text" autocomplete="off" name="fromDate" placeholder="DD-MM-YYYY" id="fromDate" value="${Fromdate}" class="input-field " >
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">To Date :</label>
                                        <div class="col-sm-9">
                                            <input type="text" autocomplete="off" name="toDate"  placeholder="DD-MM-YYYY" id="toDate" value="${Todate}" class="input-field">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label" for="date-filter">Filter By :</label>
                                        <div class="col-sm-9">
                                            <select id="date-filter" name="Filter" class="select-input" >
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
                    <table id="totalKOMDashboadTable" class="table table-striped bg-white" style="width:100%">
                        <thead>
                            <tr>
                                <th>Sr.No</th>
                                <th style="min-width: 150px;">Document No</th>
                                <th style="min-width: 190px;">Hub Location</th>
                                <th style="min-width: 190px;">Project Name</th>
                                <th>Designation</th>
                                <th style="min-width: 150px;">Date & Time</th>
                                <th style="min-width: 190px;">Status</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
                <script>

                    $(document).ready(function () {
                        var pageFromDate = '${Fromdate}';
                        var pageToDate = '${Todate}';
                        var pageFilter = '${Filter}';

                        var table = $('#totalKOMDashboadTable').DataTable({
                            processing: true,
                            serverSide: true,
                            stateSave: false,
                            ordering: true,
                            orderMulti: false,
                            aaSorting: [[0, 'desc']],
                            ajax: {
                                url: 'formsCommon.htm?act=totalKomDashboadPaginationAjax',
                                type: 'POST',
                                cache: false,
                                data: function (d) {
                                    d.Fromdate = pageFromDate;
                                    d.Todate = pageToDate;
                                    d.Filter = pageFilter;
                                }
                            },
                            columns: [
                                {
                                    data: 'srNo',
                                    orderable: true,
                                    searchable: true
                                },
                                {
                                    data: 'documentNo',
                                    orderable: true,
                                    searchable: true
                                },
                                {
                                    data: 'hubLocation',
                                    orderable: true,
                                    searchable: true
                                },
                                {
                                    data: 'projectName',
                                    orderable: true,
                                    searchable: true
                                },
                                {
                                    data: 'designation',
                                    orderable: true,
                                    searchable: true
                                },
                                {
                                    data: 'dateTime',
                                    orderable: true,
                                    searchable: true
                                },
                                {
                                    data: 'flagStatus',
                                    orderable: false,
                                    searchable: true
                                }

                            ],
                            pageLength: 10,
                            lengthChange: false,
                            searching: true,
                            info: true,
                            autoWidth: false,
                            responsive: true,
                            scrollX: true,
                            scrollCollapse: true,
                            scrollY: '80vh',
                            dom: 'rt<"table-bottom-info d-flex align-items-center justify-content-between pt-3"i p>'

                        });
                        
                        $('#fromDate').val(pageFromDate);
                        $('#toDate').val(pageToDate);
                        $('#date-filter').val(pageFilter || '--select--');

                        $('#applyFilter').off('click').on('click', function (e) {
                            e.preventDefault();

                            pageFromDate = $('#fromDate').val();
                            pageToDate = $('#toDate').val();
                            pageFilter = $('#date-filter').val();

                            table.ajax.reload();
                            $('#searchModal').modal('hide');
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
                    });

                </script>
            </section>
        </main>
    </body>
    <script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>


</html>