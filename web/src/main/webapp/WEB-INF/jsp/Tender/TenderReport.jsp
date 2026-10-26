<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tender Report</title>
    </head>
    <body>
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form method="post" name='form1' class="form-horizontal" role="form">

                    <!-- ── Page Header ──────────────────────────────────────── -->
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)" alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)" alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">Tender Report</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a id="searchBtn" class="btn theme-btn mr-2">Search</a>
                            <a href="javascript:void(0)" id="exportExcelBtn" class="btn theme-btn" style="display:none;">Export To Excel</a>
                        </div>
                    </div>
                    <hr>

                    <!-- ── Filter Fields ────────────────────────────────────── -->
                    <div class="rounded-4 mt-6 sticky-model1">
                        <div class="row mb-3">                            
                            
                            <div class="col-lg-2 col-md-2">
                                <div class="form-group">
                                    <label class="label">Tender No.</label>
                                    <input type="text" id="tenderNo" class="input-field" autocomplete="off" placeholder="Tender No" />
                                </div>
                            </div>

                            <div class="col-lg-2 col-md-2">
                                <div class="form-group">
                                    <label class="label">Project Name</label>
                                    <input type="text" id="projectName" class="input-field" autocomplete="off" placeholder="Project Name"/>
                                </div>
                            </div>

                            <div class="col-lg-2 col-md-2">
                                <div class="form-group">
                                    <label class="label">Start From Date</label>
                                    <input type="text" id="open_from_date" class="input-field" placeholder="DD-MM-YYYY" style="background: white;" autocomplete="off"/>
                                </div>
                            </div>

                            <div class="col-lg-2 col-md-2">
                                <div class="form-group">
                                    <label class="label">Start End Date</label>
                                    <input type="text" id="open_to_date" class="input-field" placeholder="DD-MM-YYYY" style="background: white;" autocomplete="off"/>
                                </div>
                            </div>

                            <div class="col-lg-2 col-md-2">
                                <div class="form-group">
                                    <label class="label">Closing From Date</label>
                                    <input type="text" id="close_from_date" class="input-field" placeholder="DD-MM-YYYY" style="background: white;" autocomplete="off"/>
                                </div>
                            </div>

                            <div class="col-lg-2 col-md-2">
                                <div class="form-group">
                                    <label class="label">Closing End Date</label>
                                    <input type="text" id="close_to_date" class="input-field" placeholder="DD-MM-YYYY" style="background: white;" autocomplete="off"/>
                                </div>
                            </div>

                            
                        </div>

                        <div class="row mb-2">
                            <div class="col-lg-2 col-md-2">
                                <div class="form-group">
                                    <label class="label">Days</label>
                                    <select id="lastDays" class="select-input">
                                        <option value="1">1 Day</option>
                                        <option value="7">7 Days</option>
                                        <option value="15">15 Days</option>
                                        <option value="30">1 Month</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>

                    <script type="text/javascript">
                        $(function () {

                            function showInvalidToast(message) {
                                Bootoast.toast({
                                    message: message,
                                    type: 'warn',
                                    timeout: 2000,
                                    position: 'top-center'
                                });
                            }

                            function setupRange(fromSelector, toSelector, label) {
                                let fromDate = null;
                                let toDate   = null;

                                const toPicker = flatpickr(toSelector, {
                                    dateFormat: "d-m-Y",
                                    onChange: function (sd) {
                                        toDate = sd[0];
                                        if (fromDate && toDate < fromDate) {
                                            showInvalidToast(label + 'To date cannot be earlier than From date.');
                                            toPicker.clear();
                                            toDate = null;
                                        }
                                    }
                                });

                                flatpickr(fromSelector, {
                                    dateFormat: "d-m-Y",
                                    onChange: function (sd) {
                                        fromDate = sd[0];
                                        if (toDate && toDate < fromDate) {
                                            showInvalidToast(label + 'To date cannot be earlier than From date.');
                                            toPicker.clear();
                                            toDate = null;
                                        }
                                        toPicker.set('minDate', fromDate);
                                    }
                                });
                            }

                            setupRange("#open_from_date",  "#open_to_date",  "Open: ");
                            setupRange("#close_from_date", "#close_to_date", "Close: ");
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
                            <table id="tenderReportTable" class="table table-striped bg-white dt-scroll" style="width:100%">
                                <thead>
                                    <tr>
                                        <th>Sr. No.</th>
                                        <th style="min-width: 190px;">Tender No.</th>
                                        <th style="min-width: 190px;">Project Name</th>
                                        <th style="min-width: 190px;">Tender Start Date</th>
                                        <th style="min-width: 190px;">Tender End Date</th>
                                        <th>EMD</th>
                                        <th style="min-width: 190px;">Created By</th>
                                        <th>Tender Type</th>
                                        <th style="min-width: 190px;">Bid Sent To No. Of Vendor</th>
                                        <th style="min-width: 190px;">Bid Received/Regret From No. Of Vendor</th>
                                        <th style="min-width: 190px;">Bid Status</th>
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

                            table = $('#tenderReportTable').DataTable({

                                processing:  true,
                                serverSide:  true,
                                stateSave:   false,
                                ordering:    true,
                                orderMulti:  false,
                                destroy:     true,

                                aaSorting: [[0, 'desc']],

                                ajax: {
                                    url:   'tenderMaster.htm?act=tenderReportPaginationAjax',
                                    type:  'POST',
                                    cache: false,
                                    data: function (d) {
                                        d.searchValue   = d.search.value;
                                        d.tenderNo      = $('#tenderNo').val();
                                        d.projectName   = $('#projectName').val();
                                        d.openFromDate  = $('#open_from_date').val();
                                        d.openToDate    = $('#open_to_date').val();
                                        d.closeFromDate = $('#close_from_date').val();
                                        d.closeToDate   = $('#close_to_date').val();
                                        d.lastDays      = $('#lastDays').val();
                                    }
                                },

                                columns: [
                                    { data: 'srNo' },
                                    { data: 'refNo',
                                      render: function (data, type, row) {
                                          return '<a class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=tenderInfo&tender_no=' + data + '">' + data + '</a>';
                                      }
                                    },
                                    { data: 'title' },
                                    { data: 'tenderDate',    orderable: false },
                                    { data: 'tenderDueDate', orderable: false },
                                    { data: 'emd' },
                                    { data: 'createdBy' },
                                    { data: 'tenderPhase',
                                      orderable: false,
                                      render: function (data) {
                                          return data + ' Part';
                                      }
                                    },
                                    { data: 'vendorTotal',
                                      orderable: false,
                                      render: function (data, type, row) {
                                          return '<a class="fw-600 text-break gradient-text" href="" onclick="loadBitSentVendor(\'' + row.refNo + '\')" data-toggle="modal" data-target="#Bitsntvendor">' + data + '</a>';
                                      }
                                    },
                                    { data: 'totalBid',
                                      orderable: false,
                                      render: function (data, type, row) {
                                          return '<a class="fw-600 text-break gradient-text" href="" onclick="loadBidRRVendor(\'' + row.refNo + '\')" data-toggle="modal" data-target="#BitRRvendor">' + data + '/' + row.totalRegret + '</a>';
                                      }
                                    },
                                    { data: 'bidStatus', orderable: false }
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

                            var $bottomInfo = $('#tenderReportTable_wrapper .table-bottom-info');
                            $('#tableSection').after($bottomInfo);                            
                            
                        });
                    </script>
                    
                    <script type="text/javascript">
                    //      For Export To Excel
                    $('#exportExcelBtn').on('click', function () {

                        var params = {
                            searchValue:   $('#searchBox').val(),
                            tenderNo:      $('#tenderNo').val(),
                            projectName:   $('#projectName').val(),
                            openFromDate:  $('#open_from_date').val(),
                            openToDate:    $('#open_to_date').val(),
                            closeFromDate: $('#close_from_date').val(),
                            closeToDate:   $('#close_to_date').val(),
                            lastDays:      $('#lastDays').val()
                        };

                        var $form = $('<form>', {
                            method: 'POST',
                            action: 'tenderMaster.htm?act=tenderReportExportExcel'
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

                <!-- ── Bid Sent Vendor Modal ─────────────────────────────── -->
                <form:form id="myForm" enctype="multipart/form-data" commandName="prMaster" name="form" class="form-horizontal" role="form">

                    <div class="modal fade" id="Bitsntvendor" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="BitsntvendorLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-header align-items-center">
                                    <h5 class="modal-title" id="BitsntvendorLabel">Vendor Information</h5>
                                    <div class="cta-btn d-flex align-items-center">
                                        <button type="button" class="btn theme-btn light-btn" data-dismiss="modal" onclick="event.preventDefault();">Close</button>
                                    </div>
                                </div>
                                <div class="modal-body">
                                    <input type="hidden" id="tender_no_sent" name="tender_no"/>
                                </div>
                                <div id="resultDiv" class="bg-white"></div>
                            </div>
                        </div>
                    </div>

                    <!-- ── Bid RR Vendor Modal ───────────────────────────────── -->
                    <div class="modal fade" id="BitRRvendor" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="BitRRvendorLabel" aria-hidden="true">
                        <div class="modal-dialog modal-xl">
                            <div class="modal-content">
                                <div class="modal-header align-items-center">
                                    <h5 class="modal-title" id="BitRRvendorLabel">Vendor Information</h5>
                                    <div class="cta-btn d-flex align-items-center">
                                        <button type="button" class="btn theme-btn light-btn" data-dismiss="modal" onclick="event.preventDefault();">Close</button>
                                    </div>
                                </div>
                                <div class="modal-body">
                                    <input type="hidden" id="tender_no_rr" name="tender_no"/>
                                </div>
                                <div id="resultDiv1" class="bg-white"></div>
                            </div>
                        </div>
                    </div>

                </form:form>

                <!-- ── Modal AJAX Functions ──────────────────────────────── -->
                <script type="text/javascript">

                    function loadBitSentVendor(tenderNo) {
                        document.getElementById("tender_no_sent").value = tenderNo;
                        $.ajax({
                            url:  'tenderMaster.htm?act=tenderVendorTotal',
                            type: 'GET',
                            data: { tender_no: tenderNo },
                            success: function (response) {
                                document.getElementById("resultDiv").innerHTML = response;
                                $('#Bitsntvendor').modal('show');
                                if ($('#commonTable1').length) {
                                    initTable('#commonTable1', {
                                        columnDefs: [{ targets: [], orderable: false }],
                                        order: [[1, 'asc']]
                                    });
                                }
                            },
                            error: function (xhr, status, error) {
                                console.error("AJAX Error:", error);
                            }
                        });
                        return false;
                    }

                    function loadBidRRVendor(tenderNo) {
                        document.getElementById("tender_no_rr").value = tenderNo;
                        $.ajax({
                            url:  'tenderMaster.htm?act=tenderBidVendorTotal',
                            type: 'GET',
                            data: { tender_no: tenderNo },
                            success: function (response) {
                                document.getElementById("resultDiv1").innerHTML = response;
                                $('#BitRRvendor').modal('show');
                                if ($('#commonTab').length) {
                                    initTable('#commonTab',  { columnDefs: [{ targets: [], orderable: false }], order: [[1, 'asc']] });
                                }
                                if ($('#commonTab1').length) {
                                    initTable('#commonTab1', { columnDefs: [{ targets: [], orderable: false }], order: [[1, 'asc']] });
                                }
                                if ($('#commonTab2').length) {
                                    initTable('#commonTab2', { columnDefs: [{ targets: [], orderable: false }], order: [[1, 'asc']] });
                                }
                            },
                            error: function (xhr, status, error) {
                                console.error("AJAX Error:", error);
                            }
                        });
                        return false;
                    }

                </script>

            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>