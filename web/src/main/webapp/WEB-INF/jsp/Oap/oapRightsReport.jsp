
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OAP Rights Report</title>
    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="" method="post" commandName="rightMaster"
                           name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">           
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">OAP Rights Report</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                            <!--<button type="submit" class="btn theme-btn mr-3">Search</button>-->
                            
                        <a class="btn theme-btn" href="oapForm.htm?act=oapReportexcel&document=${oapdocumentNumber}&fromdate=${open_from_date}&todate=${open_to_date}" title="Export data to Excel">
                           Excel
                        </a>
                        </div>
                    </div>

                    <hr>
                    <div class="rounded-4 mt-4 sticky-model1">
                        <div class="row mb-3">
                            <div class="col-lg-3 col-md-6">
                                <div class="form-group">
                                    <label  class="label">Enter Document No :</label>
                                    <input type="text" name="oapdocumentNumber"  id="oapdocumentNumber" value="" class="input-field" placeholder="Search By Document No..." autocomplete="off"/>
                                </div>
                            </div>
                            
                            <div class="col-lg-3 col-md-6">
                                <div class="form-group">
                                    <label  class="label">Enter Name:</label>
                                    <input type="text" name="projectName"  id="projectName" value="" class="input-field" placeholder="Search By Project Name..." autocomplete="off"/>
                                </div>
                            </div>

                            <div class="col-lg-3 col-md-6">
                                <div class="form-group">
                                    <label  class="label">From Date</label>
                                    <div class='input-group date' id='open_from_date'>
                                        <input name="open_from_date" style="background: white;"  type="text" class="input-field form_datetime" id="open_from_date"  placeholder="DD-MM-YYYY"  autocomplete="off"/>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-3 col-md-6">
                                <div class="form-group">
                                    <label  class="label">To Date</label>
                                    <div class='input-group date' id='open_to_date'>
                                        <input name="open_to_date" type="text" style="background: white;"  class="input-field form_datetime" id="open_to_date" placeholder="DD-MM-YYYY"   autocomplete="off"/>
                                    </div>
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

                            const toDatePicker = flatpickr("#open_to_date", {
                                dateFormat: "d-m-Y",
                                onChange: function (selectedDates) {
                                    selectedToDate = selectedDates[0];
                                },
                                onValueUpdate: function (selectedDates) {
                                    selectedToDate = selectedDates[0];
                                }
                            });

                            const fromDatePicker = flatpickr("#open_from_date", {
                                dateFormat: "d-m-Y",
                                onChange: function (selectedDates, dateStr) {
                                    const newFromDate = selectedDates[0];

                                    if (selectedToDate && newFromDate && selectedToDate.getTime() < newFromDate.getTime()) {
                                        showInvalidToast();
                                    }

                                    selectedFromDate = newFromDate;

                                    if (selectedFromDate) {
                                        toDatePicker.set('minDate', selectedFromDate);
                                    }
                                },
                                onValueUpdate: function (selectedDates) {
                                    selectedFromDate = selectedDates[0];
                                }
                            });
                        });
                    </script> 
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

                        <table id="oapReportTable" class="table table-striped bg-white" style="width:100%">
                            <thead>
                                <tr>
                                    <th>Sr.No</th>
                                    <th style="min-width:180px;">Document No</th>
                                    <th style="min-width:180px;">Pcs Name</th>
                                    <th style="min-width:180px;">Project Name</th>
                                    <th style="min-width: 190px;">OAP Release (From Date)</th>
                                    <th style="min-width: 190px;"> OAP Release (To Date)</th>
                                    <th>Time Period (Days)</th>
                                    <th>No Of Charger</th>
                                    <th>No of Charge Charge Points</th>
                                    <th>Overall station capacity(kW)</th>
                                    <th>Department</th>
                                    <th>Date</th>
                                    <th style="min-width:180px;">OAP Status</th>
                                    <th style="min-width:180px;">CRC Status</th>
                                    <th data-dt-order="disable">Action</th>
                                </tr>
                            </thead>
                        </table>

                    </div>

                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
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

                    const toDatePicker = flatpickr("#open_to_date", {
                        dateFormat: "d-m-Y",
                        onChange: function (selectedDates) {
                            selectedToDate = selectedDates[0] || null;
                        }
                    });

                    const fromDatePicker = flatpickr("#open_from_date", {
                        dateFormat: "d-m-Y",
                        onChange: function (selectedDates) {
                            const newFromDate = selectedDates[0] || null;
                            if (selectedToDate && newFromDate && selectedToDate.getTime() < newFromDate.getTime()) {
                                showInvalidToast();
                            }
                            selectedFromDate = newFromDate;
                            if (selectedFromDate) {
                                toDatePicker.set('minDate', selectedFromDate);
                            } else {
                                toDatePicker.set('minDate', null);
                            }
                        }
                    });

                    // ── DataTable Init ──────────────────────────────────────────────────
                    var table = $('#oapReportTable').DataTable({

                        processing: true,
                        serverSide: true,
                        stateSave: false,
                        ordering: true,
                        orderMulti: false,
                        aaSorting: [[0, 'desc']],

                        ajax: {
                            url: 'formsCommon.htm?act=oapRightsReportPaginationAjax',
                            type: 'POST',
                            cache: false,
                            data: function (d) {
                                d.oapdocumentNumber = $('#oapdocumentNumber').val().trim();
                                d.projectName = $('#projectName').val().trim();
                                d.open_from_date = $('#open_from_date').val().trim();
                                d.open_to_date = $('#open_to_date').val().trim();
                            },
                            error: function (xhr, error, thrown) {
                                console.error("DataTable Ajax Error:");
                                console.error("Status  : " + xhr.status);
                                console.error("Response: " + xhr.responseText);
                                console.error("Error   : " + error);
                                console.error("Thrown  : " + thrown);
                                Bootoast.toast({
                                    message: 'Error loading data. Please try again.',
                                    type: 'danger',
                                    timeout: 3000,
                                    position: 'top-center'
                                });
                            }
                        },

                        columns: [
                            { data: 'srNo', orderable: true, searchable: false },
                            { data: 'documentNo', orderable: true, searchable: true },
                            { data: 'pcsName', orderable: true, searchable: true },
                            { data: 'projectName', orderable: true, searchable: true },
                            { data: 'timeLineFromDate', orderable: true, searchable: true },
                            { data: 'timeLineToDate', orderable: true, searchable: true },
                            { data: 'chargingRatePerUnit', orderable: true, searchable: true },
                            { data: 'noOfCharger', orderable: true, searchable: true },
                            { data: 'noOfChargePoints', orderable: true, searchable: true },
                            { data: 'overallStationCapacityKw', orderable: true, searchable: true },
                            { data: 'department', orderable: true, searchable: true },
                            { data: 'createdDate', orderable: true, searchable: true },
                            { data: 'flagStatusOAP', orderable: true, searchable: true },
                            { data: 'flagStatusCRC', orderable: false, searchable: true },
                            {
                                data: 'action',
                                orderable: false,
                                searchable: false,
                                render: function (data) {
                                    return data ? data : '';
                                }
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

                        language: {
                            processing: "Loading...",
                            info: "Showing _START_ to _END_ of _TOTAL_ filtered records",
                            infoFiltered: "(filtered from _MAX_ total records)",
                            zeroRecords: "No matching records found",
                            infoEmpty: "Showing 0 to 0 of 0 records"
                        },

                        dom: 'rt<"table-bottom-info d-flex align-items-center justify-content-between pt-3"ip>'

                    });

                    // ── Search Box ──────────────────────────────────────────────────────
                    $('#searchBox').on('keyup', function () {
                        table.search(this.value).draw();
                    });

                    // ── Entries Per Page ────────────────────────────────────────────────
                    $('#entriesPerPage').on('change', function () {
                        var val = $(this).val();
                        if (val === "" || val === "-1") {
                            var total = table.page.info().recordsTotal;
                            table.page.len(total > 0 ? total : 1).draw();
                        } else {
                            table.page.len(parseInt(val, 10)).draw();
                        }
                    });

                    // ── Search Button ───────────────────────────────────────────────────
                    $('#btnSearch').on('click', function () {
                        table.ajax.reload(null, true);
                    });

                    // ── Reset Button ────────────────────────────────────────────────────
                    $('#btnReset').on('click', function () {
                        $('#oapdocumentNumber').val('');
                        $('#projectName').val('');
                        fromDatePicker.clear();
                        toDatePicker.clear();
                        toDatePicker.set('minDate', null);
                        selectedFromDate = null;
                        selectedToDate = null;
                        $('#searchBox').val('');
                        table.search('').ajax.reload(null, true);
                    });

                    // ── Filter inputs trigger reload ────────────────────────────────────
                    $('#oapdocumentNumber, #projectName').on('keyup', function () {
                        table.ajax.reload(null, true);
                    });

                    $('#open_from_date, #open_to_date').on('change', function () {
                        table.ajax.reload(null, true);
                    });

                });

            </script>
    <script>
    function parseDate(dateStr) {
        // Convert DD-MM-YYYY to Date object
        let parts = dateStr.split("-");
        return new Date(parts[2], parts[1] - 1, parts[0]);
    }

    function validateDates() {
        let fromDateVal = document.getElementById("open_from_date").value;
        let toDateVal = document.getElementById("open_to_date").value;

        if (fromDateVal && toDateVal) {
            let fromDate = parseDate(fromDateVal);
            let toDate = parseDate(toDateVal);

            if (toDate < fromDate) {
                Swal.fire({
                    icon: 'warning',
                    title: 'Invalid Date Selection',
                    text: 'To Date cannot be earlier than From Date.',
                });

                document.getElementById("open_to_date").value = "";
            }
        }
    }

    document.getElementById("open_from_date").addEventListener("change", validateDates);
    document.getElementById("open_to_date").addEventListener("change", validateDates);
</script>
</html>
