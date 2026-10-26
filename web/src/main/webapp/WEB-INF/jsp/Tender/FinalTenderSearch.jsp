<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Final Close Tender List</title>
    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="tenderMaster.htm?act=finalTenderList" method="post" commandName="employeeMaster"
                           name='form1'  class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Final Close Tender List</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a href="javascript:void(0)" id="exportExcelBtn" class="btn theme-btn">Export To Excel</a>
                        </div>
                    </div>

                    <hr>                  
                    
                    <div class="row rounded-4 mt-6 sticky-model1">

                     
                        <div class="col-lg-2 col-md-6">
                            <div class="form-group">
                                <label class="label">Tender No</label>
                                <input type="text" name="tender_no" id="tender_no" value="" class="input-field" placeholder="Search By Tender No" />
                            </div>
                        </div>

                      
                        <div class="col-lg-2 col-md-6">
                            <div class="form-group">
                                <label class="label">Project Name</label>
                                <input type="text" name="tender_title" id="tender_title" value="" class="input-field" placeholder="Search By Project Name" />
                            </div>
                        </div>
                   
                  
                        <div class="col-lg-2 col-md-6">
                            <div class="form-group">
                                <label class="label">Opening From Date</label>
                                <div class="form-group date">
                                    <input id="open_from_date" style="background: white;" name="open_from_date" type="text" class="input-field form_datetime" placeholder="DD/MM/YYYY" maxlength="30"autocomplete="off" />

                                </div>
                            </div>
                        </div>

                     
                        <div class="col-lg-2 col-md-6">
                            <div class="form-group">
                                <label class="label">Opening To Date</label>
                                <div class="form-group date">
                                    <input id="open_to_date" style="background: white;" name="open_to_date" type="text"class="input-field form_datetime"placeholder="DD/MM/YYYY" maxlength="30"autocomplete="off" />
                                </div>
                            </div>
                        </div>

               
                        <div class="col-lg-2 col-md-6">
                            <div class="form-group">
                                <label class="label">Closing From Date</label>
                                <div class="form-group date">
                                    <input name="close_from_date" style="background: white;" id="close_from_date" type="text" class="input-field form_datetime" value=""   placeholder="DD/MM/YYYY"
                                           autocomplete="off"maxlength="30" />

                                </div>
                            </div>
                        </div>

                     
                        <div class="col-lg-2 col-md-6">
                            <div class="form-group">
                                <label class="label">Closing To Date</label>
                                <div class="form-group date">
                                    <input name="close_to_date" style="background: white;" id="close_to_date" type="text" class="input-field form_datetime" value=""  maxlength="30"  placeholder="DD/MM/YYYY" autocomplete="off">
                                </div>
                            </div>
                        </div>
                        
                    </div>
                    <br>
                    <script type="text/javascript">
                        $(function () {
                            function showInvalidToast(message) {
                                Bootoast.toast({
                                    message: message || 'To Date cannot be earlier than From Date.',
                                    type: 'warn',
                                    timeout: 2000,
                                    position: 'top-center'
                                });
                            }

                            function setupRange(fromSelector, toSelector, label = '') {
                                let fromDate = null;
                                let toDate = null;

                                const toPicker = flatpickr(toSelector, {
                                    dateFormat: "d-m-Y",
                                    onChange: function (sd) {
                                        toDate = sd[0];
                                        if (fromDate && toDate < fromDate) {
                                            showInvalidToast(`${label}To date cannot be earlier than From date.`);
                                            toPicker.clear();
                                            toDate = null;
                                        }
                                    }
                                });

                                const fromPicker = flatpickr(fromSelector, {
                                    dateFormat: "d-m-Y",
                                    onChange: function (sd) {
                                        fromDate = sd[0];
                                        if (toDate && toDate < fromDate) {
                                            showInvalidToast(`${label}To date cannot be earlier than From date.`);
                                            toPicker.clear();
                                            toDate = null;
                                        }
                                        toPicker.set('minDate', fromDate);
                                    }
                                });
                            }

                            setupRange("#open_from_date", "#open_to_date", "Open: ");
                            setupRange("#close_from_date", "#close_to_date", "Close: ");
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

                        <table id="finalCloseTenderTable" class="table table-striped bg-white" style="width:100%">

                                <thead>

                                    <tr>

                                        <th>Sr. No.</th>

                                        <th style="min-width: 190px;">Tender No.</th>

                                        <th style="min-width: 190px;">Project Name</th>

                                        <th style="min-width: 190px;">Tender Date</th>

                                        <th style="min-width: 190px;">Tender Due Date</th>

                                        <th>EMD</th>

                                        <th style="min-width: 190px;">Created By</th>

                                        <th style="min-width: 120px;">Tender Type</th>

                                        <th style="min-width: 120px;">Bid Sent To No. Of Vendor</th>

                                        <th>Bid Received/Regret</th>

                                        <th style="min-width: 190px;">Bid Status</th>

                                    </tr>

                                </thead>

                            </table>
                        
                        </div>

                        <script>
                            var table;

                            $(document).ready(function () {

                                table = $('#finalCloseTenderTable').DataTable({

                                    processing: true,

                                    serverSide: true,

                                    stateSave: false,

                                    ordering: true,

                                    orderMulti: false,

                                    destroy: true,

                                    aaSorting: [[0, 'desc']],

                                    ajax: {

                                        url: 'tenderMaster.htm?act=finalTenderPaginationAjax',

                                        type: 'POST',

                                        cache: false,

                                        data: function (d) {

                                            d.tender_no = $('input[name="tender_no"]').val();

                                            d.tender_title = $('input[name="tender_title"]').val();

                                            d.open_from_date = $('#open_from_date').val();

                                            d.open_to_date = $('#open_to_date').val();

                                            d.close_from_date = $('#close_from_date').val();

                                            d.close_to_date = $('#close_to_date').val();
                                        }
                                    },

                                    columnDefs: [
                                        {
                                            targets: [10],
                                            orderable: false,
                                            searchable: false
                                        }
                                    ],

                                    columns: [

                                        {
                                            data: 'srNo',
                                            orderable: true,
                                            searchable: false
                                        },

                                        {
                                            data: 'refNo',
                                            defaultContent: ''
                                        },

                                        {
                                            data: 'title',
                                            defaultContent: ''
                                        },

                                        {
                                            data: 'announceDate',
                                            defaultContent: ''
                                        },

                                        {
                                            data: 'submitLastdate',
                                            defaultContent: ''
                                        },

                                        {
                                            data: 'emd',
                                            defaultContent: ''
                                        },

                                        {
                                            data: 'contactPerson',
                                            defaultContent: ''
                                        },

                                        {
                                            data: 'tenderPhase',
                                            defaultContent: ''
                                        },

                                        {
                                            data: 'vendor_total',
                                            orderable: false,
                                            searchable: false,
                                            defaultContent: ''
                                        },

                                        {
                                            data: 'bid_received',
                                            orderable: false,
                                            searchable: false,
                                            defaultContent: ''
                                        },

                                        {
                                            data: 'bid_status',
                                            orderable: false,
                                            searchable: false,
                                            defaultContent: ''
                                        }
                                    ],

                                    pageLength: 10,

                                    lengthMenu: [
                                        [10, 20, 50, 100],
                                        [10, 20, 50, 100]
                                    ],

                                    lengthChange: false,

                                    searching: true,

                                    info: true,

                                    autoWidth: false,

                                    responsive: true,

                                    scrollX: true,
                                    
                                    scrollCollapse: true,

                                    scrollY: '80vh',

                                    language: {

                                        info: "Showing _START_ to _END_ of _TOTAL_ filtered records",

                                        infoFiltered: "(filtered from _MAX_ total records)",

                                        zeroRecords: "No matching records found",

                                        processing: "Loading..."
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


                                $('#tender_no, #tender_title, #open_from_date, #open_to_date, #close_from_date, #close_to_date')
                                .on('keyup change', function () {

                                    table.ajax.reload(null, true);

                                });
                                
                                //      For Export To Excel            
                                $('#exportExcelBtn').on('click', function () {

                                    var params = {
                                        searchValue: $('#searchBox').val(),

                                        tender_no: $('#tender_no').val(),
                                        tender_title: $('#tender_title').val(),

                                        open_from_date: $('#open_from_date').val(),
                                        open_to_date: $('#open_to_date').val(),

                                        close_from_date: $('#close_from_date').val(),
                                        close_to_date: $('#close_to_date').val()
                                    };

                                    var $form = $('<form>', {
                                        method: 'POST',
                                        action: 'tenderMaster.htm?act=finalTenderReportExportExcel'
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
                <form:form id="myForm" enctype="multipart/form-data" commandName="prMaster" name="form" class="form-horizontal" role="form">
                    <div class="modal fade" id="Bitsntvendor" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="BitsntvendorLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-header align-items-center">
                                    <h5 class="fw-600 modal-title" id="BitsntvendorLabel">Vendor Information</h5>
                                    <div class="cta-btn d-flex align-items-center">
                                        <button type="button" class="btn theme-btn light-btn" data-dismiss="modal" onclick="event.preventDefault();">Close</button>
                                    </div>
                                </div>                                

                                <div id="resultDiv" class="bg-white">
                                    <script>
                                        function loadBitSentVendor(tenderNo) {
                                            console.log("Vendor No received:", tenderNo);
                                            document.getElementById("tender_no").value = tenderNo;

                                            $.ajax({
                                                url: 'tenderMaster.htm?act=tenderVendorTotal',
                                                type: 'GET',
                                                data: {
                                                    tender_no: tenderNo 
                                                },
                                                success: function(response) {
                                                    document.getElementById("resultDiv").innerHTML = response;
                                                    $('#Bitsntvendor').modal('show');
                                                    if($('#commonTable1').length){
                                                        const table1 = initTable('#commonTable1', {
                                                            columnDefs: [
                                                                { targets: [], orderable: false }
                                                            ],
                                                            order: [[1, 'asc']]
                                                        });
                                                    }
                                                },
                                                error: function(xhr, status, error) {
                                                    console.error("AJAX Error:", error);
                                                }
                                            });
                                            return false;
                                        }
                                    </script>

                                </div>
                            </div>
                        </div>
                    </div>      
        
                    <div class="modal fade" id="BitRRvendor" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="BitRRvendorLabel" aria-hidden="true">
                        <div class="modal-dialog modal-xl">
                            <div class="modal-content">
                                <div class="modal-header align-items-center">
                                    <h5 class="fw-600 modal-title" id="BitRRvendorLabel">Vendor Information</h5>
                                    <div class="cta-btn d-flex align-items-center">
                                        <button type="button" class="btn theme-btn light-btn" data-dismiss="modal" onclick="event.preventDefault();">Close</button>
                                    </div>
                                </div>                                

                                <div id="resultDiv1" class="bg-white">
                                    <script>
                                        function loadBidRRVendor(tenderNo) {
                                            console.log("Vendor No received:", tenderNo);
                                            document.getElementById("tender_no").value = tenderNo;

                                            $.ajax({
                                                url: 'tenderMaster.htm?act=tenderBidVendorTotal',
                                                type: 'GET',
                                                data: {
                                                    tender_no: tenderNo 
                                                },
                                                success: function(response) {
                                                    document.getElementById("resultDiv1").innerHTML = response;

                                                    $('#BitRRvendor').modal('show');
                                                    if($('#commonTab').length){
                                                        const table1 = initTable('#commonTab', {
                                                            columnDefs: [
                                                                { targets: [], orderable: false }
                                                            ],
                                                            order: [[1, 'asc']]
                                                        });
                                                    }
                                                     if($('#commonTab1').length){
                                                        const table1 = initTable('#commonTab1', {
                                                            columnDefs: [
                                                                { targets: [], orderable: false }
                                                            ],
                                                            order: [[1, 'asc']]
                                                        });
                                                    }
                                                    if($('#commonTab2').length){
                                                        const table1 = initTable('#commonTab2', {
                                                            columnDefs: [
                                                                { targets: [], orderable: false }
                                                            ],
                                                            order: [[1, 'asc']]
                                                        });
                                                    }
                                                },
                                                error: function(xhr, status, error) {
                                                    console.error("AJAX Error:", error);
                                                }
                                            });
                                            return false;
                                        }
                                    </script>

                                </div>
                            </div>
                        </div>
                    </div>        
                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
