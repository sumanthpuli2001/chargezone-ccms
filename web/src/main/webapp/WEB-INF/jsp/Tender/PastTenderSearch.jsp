<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bid Open Tender List</title>
    </head>
    <body>


        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="tenderMaster.htm?act=pastTenderList" method="post" commandName="employeeMaster"
                           name='form1'  class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Bid Open Tender List</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a href="javascript:void(0)" id="exportExcelBtn" class="btn theme-btn">Export To Excel</a>
                        </div>
                    </div>

                    <hr>


                   <div class="rounded-4 mt-6 sticky-model1">

                        <div class="row mb-3">

                            <div class="col-lg-2 col-md-2">
                                <div class="form-group">
                                    <label class="label">Tender No.</label>
                                    <input type="text" name="tender_no" id="tender_no" class="input-field" placeholder="Search By Tender No" />
                                </div>
                            </div>

                            <div class="col-lg-2 col-md-2">
                                <div class="form-group">
                                    <label class="label">Project Name :</label>
                                    <input type="text" name="tender_title" id="tender_title" class="input-field" placeholder="Search By Project Name" />
                                </div>
                            </div>
                            
                            <div class="col-lg-2 col-md-2">
                                <div class="form-group">
                                    <label class="label">Start From Date :</label>
                                    <input id="open_from_date" name="open_from_date" type="text" class="input-field form_datetime" placeholder="DD/MM/YYYY" autocomplete="off" />
                                </div>
                            </div>                           

                            <div class="col-lg-2 col-md-2">
                                <div class="form-group">
                                    <label class="label">Start End Date :</label>
                                    <input id="open_to_date" name="open_to_date" type="text" class="input-field form_datetime" placeholder="DD/MM/YYYY" maxlength="30" autocomplete="off" />
                                </div>
                            </div>                            

                            <div class="col-lg-2 col-md-2">
                                <div class="form-group">
                                    <label class="label">Closing From Date :</label>
                                    <input name="close_from_date" id="close_from_date" type="text" class="input-field form_datetime" value=""   placeholder="DD/MM/YYYY" autocomplete="off"maxlength="30" />
                                </div>
                            </div>                            

                            <div class="col-lg-2 col-md-2">
                                <div class="form-group">
                                    <label class="label">Closing End Date :</label>
                                    <input name="close_to_date" id="close_to_date" type="text" class="input-field form_datetime" value=""  maxlength="30"  placeholder="DD/MM/YYYY" autocomplete="off">
                                </div>
                            </div>
                            
                            <script type="text/javascript">
                                $(document).ready(function () {

                                    flatpickr("#open_from_date", {
                                        dateFormat: "d-m-Y",
                                        allowInput: true
                                    });

                                    flatpickr("#open_to_date", {
                                        dateFormat: "d-m-Y",
                                        allowInput: true
                                    });
                                    flatpickr("#close_from_date", {
                                        dateFormat: "d-m-Y",
                                        allowInput: true
                                    });
                                    flatpickr("#close_to_date", {
                                        dateFormat: "d-m-Y",
                                        allowInput: true
                                    });

                                });
                            </script>
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

                        <table id="closeTenderTable" class="table table-striped bg-white" style="width:100%">

                            <thead>

                                <tr>

                                    <th>Sr. No.</th>

                                    <th style="min-width:180px;">Tender No.</th>

                                    <th style="min-width:180px;">Project Name</th>

                                    <th style="min-width:180px;">Tender Date</th>

                                    <th style="min-width:180px;">Tender Due Date</th>

                                    <th>EMD</th>

                                    <th style="min-width:180px;">Created By</th>

                                    <th style="min-width:180px;">Tender Type</th>

                                    <th style="min-width:180px;">Bid Sent To No. Of Vendor</th>

                                    <th style="min-width:180px;">Bid Received/Regret</th>

                                    <th style="min-width:180px;">Bid Status</th>

                                    <th style="min-width:180px;">Approval Status</th>

                                </tr>

                            </thead>

                        </table>

                    </div>

                    <script>

                        var table;

                        $(document).ready(function () {

                            table = $('#closeTenderTable').DataTable({

                                processing: true,

                                serverSide: true,

                                stateSave: false,

                                ordering: true,

                                orderMulti: false,

                                destroy: true,

                                aaSorting: [[0, 'desc']],

                                ajax: {

                                    url: 'tenderMaster.htm?act=pastTenderPaginationAjax',

                                    type: 'POST',

                                    cache: false,

                                    data: function (d) {

                                        d.tender_no = $('#tender_no').val();
                                        d.tender_title = $('#tender_title').val();

                                        d.open_from_date = $('#open_from_date').val();
                                        d.open_to_date = $('#open_to_date').val();

                                        d.close_from_date = $('#close_from_date').val();
                                        d.close_to_date = $('#close_to_date').val();
                                    },

                                    error: function (xhr) {

                                        console.log(xhr.responseText);

                                    }
                                },

                                columnDefs: [
                                    {
                                        targets: [8, 9, 10, 11],
                                        orderable: false,
                                        searchable: false
                                    }
                                ],

                                columns: [

                                    {
                                        data: 'srNo',
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
                                        data: 'tender_date',
                                        defaultContent: ''
                                    },

                                    {
                                        data: 'tender_due_date',
                                        defaultContent: ''
                                    },

                                    {
                                        data: 'emd',
                                        defaultContent: ''
                                    },

                                    {
                                        data: 'created_by',
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
                                        data: 'bid_status_text',
                                        orderable: false,
                                        searchable: false,
                                        defaultContent: ''
                                    },

                                    {
                                        data: 'approval_status',
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

                                scrollX: false,

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


                            $('#tender_no, #tender_title, #open_from_date, #open_to_date, #close_from_date, #close_to_date').on('keyup change', function () {

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
                                    action: 'tenderMaster.htm?act=pastTenderReportExportExcel'
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
                    <div class="modal fade" id="Bitsntvendor" data-backdrop="static" data-keyboard="false" tabindex="-1"
                         aria-labelledby="BitsntvendorLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">

                                <div class="modal-header align-items-center">
                                    <h5 class="modal-title" id="BitsntvendorLabel">Vendor Information</h5>
                                    <div class="cta-btn d-flex align-items-center">
                                        <button type="button" class="btn theme-btn light-btn" data-dismiss="modal" onclick="event.preventDefault();">Close</button>
                                    </div>
                                </div>                               

                                <div id="resultDiv" class="bg-white"></div>
                                <script>
                                    function loadBitSentVendor(tenderNo) {
//                                            console.log("Vendor No received:", tenderNo);
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
                                                if ($('#commonTable1').length){
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


                    <div class="modal fade" id="BitRRvendor" data-backdrop="static" data-keyboard="false" tabindex="-1"
                         aria-labelledby="BitRRvendorLabel" aria-hidden="true">
                        <div class="modal-dialog modal-xl">
                            <div class="modal-content">

                                <div class="modal-header align-items-center">
                                    <h5 class="modal-title" id="BitRRvendorLabel">Vendor Information</h5>
                                    <div class="cta-btn d-flex align-items-center">
                                        <button type="button" class="btn theme-btn light-btn" data-dismiss="modal" onclick="event.preventDefault();">Close</button>
                                    </div>
                                </div>                               

                                <div id="resultDiv1" class="bg-white"></div>
                                    <script>
                                        function loadBidRRVendor(tenderNo) {
    //                                        console.log("Vendor No received:", tenderNo);
                                            document.getElementById("tender_no").value = tenderNo;
                                            $.ajax({
                                                url: 'tenderMaster.htm?act=tenderBidVendorTotal',
                                                type: 'GET',
                                                data: {
                                                    tender_no: tenderNo
                                                },
                                                success: function (response) {
                                                    document.getElementById("resultDiv1").innerHTML = response;
                                                    $('#BitRRvendor').modal('show');
                                                    if ($('#commonTab').length) {
                                                        const table1 = initTable('#commonTab', {
                                                            columnDefs: [
                                                                { targets: [], orderable: false }
                                                            ],
                                                            order: [[1, 'asc']]
                                                        });
                                                    }
                                                    if ($('#commonTab1').length) {
                                                        const table1 = initTable('#commonTab1', {
                                                            columnDefs: [
                                                                { targets: [], orderable: false }
                                                            ],
                                                            order: [[1, 'asc']]
                                                        });
                                                    }
                                                    if ($('#commonTab2').length) {
                                                        const table1 = initTable('#commonTab2', {
                                                            columnDefs: [
                                                                { targets: [], orderable: false }
                                                            ],
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
                                    </script>
                            </div>
                        </div>
                    </div>    



                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
