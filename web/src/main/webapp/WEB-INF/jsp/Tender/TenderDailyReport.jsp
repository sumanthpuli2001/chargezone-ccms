<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tender Daily Report</title>
    </head>
    <body>


        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp" %>
            <section class="main-content">
                <form:form action="tenderMaster.htm?act=tenderDailyReportList" method="post"
                    commandName="employeeMaster" name='form1' class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars"
                                    onload="SVGInject(this)" alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort"
                                    onload="SVGInject(this)" alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Tender Daily Report</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a id="searchBtn" class="btn theme-btn mr-3">Search</a>
                            <a href="javascript:void(0)" id="exportExcelBtn" class="btn theme-btn" style="display:none;">Export To Excel</a>
                        </div>
                    </div>
                    
                    <div class="rounded-4 mt-3 mb-2 sticky-model1">
                        <div class="row mb-3">
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label for="control-label" class="label">Search Date
                                    </label>
                                    <div class="form-group date">
                                        <input id="openFromDate" name="openFromDate" type="text" class="input-field"/>

                                        <script type="text/javascript">
                                            $(document).ready(function () {
                                                flatpickr("#openFromDate", {
                                                    dateFormat: "d-m-Y",
                                                    allowInput: true,
                                                    defaultDate: "today"
                                                });
                                            });
                                        </script>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div id="tableSection" style="display: none;">

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

                        <div class="table-responsive">
                            <table id="tenderDailyReportTable" class="table table-striped bg-white dt-scroll"
                                style="width:100%">
                                <thead>
                                    <tr>
                                        <th>Sr. No.</th>
                                        <th>Tender No.</th>
                                        <th>Contact Name</th>
                                        <th>Tender Admin</th>
                                        <th>Vendor Code</th>
                                        <th>Vendor Name</th>
                                    </tr>
                                </thead>
                                <tbody></tbody>
                            </table>
                        </div>

                    </div>

                    <script type="text/javascript">
                        var table = null;

                        $('#searchBtn').on('click', function () {

                            $('#tableSection').show();
                            $('#exportExcelBtn').show();

                            if (table !== null) {
                                table.ajax.reload(null, true);
                                return;
                            }

                            table = $('#tenderDailyReportTable').DataTable({

                                processing: true,
                                serverSide: true,
                                stateSave: false,
                                ordering: true,
                                orderMulti: false,
                                destroy: true,

                                aaSorting: [[0, 'asc']],

                                ajax: {
                                    url: 'tenderMaster.htm?act=tenderDailyReportPaginationAjax',
                                    type: 'POST',
                                    cache: false,
                                    data: function (d) {
                                        d.searchValue = d.search.value;
                                        d.openFromDate = $('#openFromDate').val();
                                    }
                                },

                                columns: [
                                    { data: 'srNo', orderable: false },
                                    { data: 'tenderNo' },
                                    { data: 'contactName' },
                                    { data: 'tenderAdmin' },
                                    { data: 'vendorCode' },
                                    { data: 'vendorName' }
                                ],

                                pageLength: 10,
                                lengthChange: false,
                                searching: true,
                                info: true,
                                autoWidth: false,
                                responsive: true,
                                scrollX: false,
                                scrollCollapse: true,
                                scrollY: '80vh',

                                language: {
                                    processing: "Loading...",
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

                            var $bottomInfo = $('#tenderDailyReportTable_wrapper .table-bottom-info');
                            $('#tableSection').after($bottomInfo);
                        });
                    </script>
                    
                    <script type="text/javascript">
                        //      For Export To Excel
                        $('#exportExcelBtn').on('click', function () {

                            var params = {
                                searchValue: $('#searchBox').val(),
                                openFromDate: $('#openFromDate').val()
                            };

                            var $form = $('<form>', {
                                method: 'POST',
                                action: 'tenderMaster.htm?act=tenderDailyReportExportExcel'
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
