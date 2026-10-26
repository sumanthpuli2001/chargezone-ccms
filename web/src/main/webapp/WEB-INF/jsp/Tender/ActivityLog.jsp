<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Activity Log</title>
    </head>
    <body>
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form method="post" name='form1' class="form-horizontal" role="form">

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)" alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)" alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">Activity Log</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <!--<a id="searchBtn" class="btn theme-btn mr-3">Search</a>-->
                            <a href="javascript:void(0)" id="exportExcelBtn" class="btn theme-btn">Export To Excel</a>
                        </div>
                    </div>
                    <hr>

                    <div class="rounded-4 mt-6 sticky-model1">
                        <div class="row mb-3">

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">User Name</label>
                                    <input type="text" id="userName" class="input-field" maxlength="30" autocomplete="off"/>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">From Date</label>
                                    <input type="text" id="fromDate" class="input-field" placeholder="DD-MM-YYYY" style="background: white;" autocomplete="off"/>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">To Date</label>
                                    <input type="text" id="toDate" class="input-field" placeholder="DD-MM-YYYY" style="background: white;" autocomplete="off"/>
                                </div>
                            </div>

                        </div>
                    </div>

                    <script type="text/javascript">
                        $(function () {
                            let selectedFromDate = null;
                            let selectedToDate = null;

                            function showInvalidToast() {
                                Bootoast.toast({
                                    message: 'To Date cannot be earlier than From Date.',
                                    type: 'warn',
                                    timeout: 2000,
                                    position: 'top-center'
                                });
                                toDatePicker.clear();
                                selectedToDate = null;
                            }

                            const toDatePicker = flatpickr("#toDate", {
                                dateFormat: "d-m-Y",
                                onChange: function (selectedDates) {
                                    selectedToDate = selectedDates[0];
                                }
                            });

                            flatpickr("#fromDate", {
                                dateFormat: "d-m-Y",
                                onChange: function (selectedDates) {
                                    const newFromDate = selectedDates[0];
                                    if (selectedToDate && newFromDate && selectedToDate.getTime() < newFromDate.getTime()) {
                                        showInvalidToast();
                                    }
                                    selectedFromDate = newFromDate;
                                    if (selectedFromDate) {
                                        toDatePicker.set('minDate', selectedFromDate);
                                    }
                                }
                            });
                        });
                    </script>

                    <br>

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
                            <table id="activityLogsTable" class="table table-striped bg-white dt-scroll" style="width:100%">
                                <thead>
                                    <tr>
                                        <th>Sr. No.</th>
                                        <th>User Name</th>
                                        <th>Activity</th>
                                        <th>Date Time</th>
                                        <th>IP</th>
                                    </tr>
                                </thead>
                                <tbody></tbody>
                            </table>
                        </div>

                    </div>

                    <script type="text/javascript">
                        var table = null;
                        
                        $(document).ready(function () {

                            $('#tableSection').show();

                            if (table !== null) {
                                table.ajax.reload(null, true);
                                return;
                            }

                            table = $('#activityLogsTable').DataTable({

                                processing: true,
                                serverSide: true,
                                stateSave:  false,
                                ordering:   true,
                                orderMulti: false,
                                destroy:    true,

                                aaSorting: [[0, 'desc']],

                                ajax: {
                                    url:   'tenderMaster.htm?act=activityLogsPaginationAjax',
                                    type:  'POST',
                                    cache: false,
                                    data: function (d) {
                                        d.searchValue = d.search.value;
                                        d.userName    = $('#userName').val();
                                        d.fromdate    = $('#fromDate').val();
                                        d.todate      = $('#toDate').val();
                                    }
                                },

                                columns: [
                                    { data: 'srNo', orderable: false },
                                    { data: 'userName' },
                                    { data: 'activity'},
                                    { data: 'dateTime'},
                                    { data: 'ipAddress'}
                                ],

                                pageLength:   10,
                                lengthChange: false,
                                searching:    true,
                                info:         true,
                                autoWidth:    false,
                                responsive:   true,
                                scrollX:      false,                                
                                scrollCollapse: true,
                                scrollY: '80vh',
                                
                                language: {
                                    processing:   "Loading...",
                                    info:         "Showing _START_ to _END_ of _TOTAL_ filtered records",
                                    infoFiltered: "(filtered from _MAX_ total records)",
                                    zeroRecords:  "No matching records found"
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
                            
                            $('#userName, #fromDate, #toDate').on('change keyup', function () {

                                table.ajax.reload(null, true);

                            });
                            
                            var $bottomInfo = $('#activityLogsTable_wrapper .table-bottom-info');
                            $('#tableSection').after($bottomInfo);                            

                            //      For Export To Excel            
                            $('#exportExcelBtn').on('click', function () {

                                var params = {
                                    searchValue: $('#searchBox').val(),

                                    userName: $('#userName').val(),
                                    fromDate: $('#fromDate').val(),
                                    toDate: $('#toDate').val()
                                };

                                var $form = $('<form>', {
                                    method: 'POST',
                                    action: 'tenderMaster.htm?act=activityLogsReportExportExcel'
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
                            
                        });
                    </script>

                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>