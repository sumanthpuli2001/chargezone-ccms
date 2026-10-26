<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>

    <html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp" %>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Technical Bid Approval List</title>
        </head>

        <body>

            <main class="d-flex align-items-end justify-content-end">
                <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp" %>
                    <section class="main-content">
                        <form:form action=".htm?act=" commandName="departmentMaster" method="post">

                            <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                                <div class="page-title d-flex align-items-center">
                                    <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                        <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars"
                                            onload="SVGInject(this)" alt="Menu collapse">
                                        <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort"
                                            onload="SVGInject(this)" alt="Menu collapse">
                                    </div>

                                    <h5 class="fw-600 mb-0">Technical Bid Approval List</h5>
                                </div>

                                <div class="cta d-flex align-items-center">
                                    <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                                </div>
                            </div>

                            <hr>
                            <div class="mt-3 table-responsive">

                                <div class="d-flex align-items-center justify-content-between mb-3">

                                    <div>
                                        <select id="entriesPerPage" class="select-input">
                                            <option value="10">10</option>
                                            <option value="20">20</option>
                                            <option value="50">50</option>
                                            <option value="100">100</option>
                                        </select>
                                    </div>

                                    <div>
                                        <input type="text" id="searchBox" class="input-field" placeholder="Search here...">
                                    </div>

                                </div>
                                <table id="receiveTechBidApproval" class="table table-striped bg-white dt-scroll" style="width: 100%" align="Center">
                                    <thead>
                                        <tr>
                                            <th>Sr. No.</th>
                                            <th>Tender No.</th>
                                            <th style="min-width:180px;">Project Name</th>
                                            <th style="min-width:180px;">Tender Date</th>
                                            <th style="min-width:180px;">Tender Due Date</th>
                                            <th style="min-width:180px;">Created By</th>
                                            <th>Tender Type</th>
                                            <th style="min-width:180px;">Bid Sent To No. Of Vendor</th>
                                            <th style="min-width:180px;">Bid Received/Regret From No. Of Vendor</th>
                                            <th style="min-width:180px;">Bid Status</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    </tbody>
                                </table>
                            </div>
                            
                            <script>

                                var table;

                                $(document).ready(function () {

                                    table = $('#receiveTechBidApproval').DataTable({

                                        processing: true,

                                        serverSide: true,

                                        stateSave: false,

                                        ordering: true,

                                        orderMulti: false,

                                        aaSorting: [[0, 'desc']],

                                        ajax: {

                                            url: 'tenderMaster.htm?act=receiveBidListBuyerAjax',

                                            type: 'POST',

                                            cache: false,

                                            error: function (xhr) {

                                                console.log(xhr.responseText);

                                            }

                                        },

                                        columns: [

                                            {
                                                data: 'srNo',
                                                orderable: true,
                                                searchable: false
                                            },

                                            {
                                                data: 'refNo'
                                            },

                                            {
                                                data: 'title'
                                            },

                                            {
                                                data: 'tenderDate'
                                            },

                                            {
                                                data: 'tenderDueDate'
                                            },

                                            {
                                                data: 'createdBy'
                                            },

                                            {
                                                data: 'tenderPhase'
                                            },

                                            {
                                                data: 'vendorTotal',
                                                orderable: false,
                                                searchable: false
                                            },
                                            {
                                                data: 'bidReceived',
                                                orderable: false,
                                                searchable: false
                                            },

                                            {
                                                data: 'bidStatus',
                                                orderable: false,
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

                                        table.page.len($(this).val()).draw();

                                    });

                                    var $topControls = $('.table-responsive > .d-flex.align-items-center.justify-content-between.mb-3');
                                    $('.table-responsive').before($topControls);

                                    var $bottomInfo = $('#receiveTechBidApproval_wrapper > .table-bottom-info');
                                    $('.table-responsive').after($bottomInfo);

                                });

                            </script>

                        </form:form>

                        <form:form id="myForm" enctype="multipart/form-data" commandName="prMaster" name="form"
                            class="form-horizontal" role="form">
                            <div class="modal fade" id="Bitsntvendor" data-backdrop="static" data-keyboard="false"
                                tabindex="-1" aria-labelledby="BitsntvendorLabel" aria-hidden="true">
                                <div class="modal-dialog modal-lg">
                                    <div class="modal-content">

                                        <div class="modal-header align-items-center">
                                            <h5 class="modal-title" id="BitsntvendorLabel">Vendor Information</h5>
                                            <div class="cta-btn d-flex align-items-center">
                                                <button type="button" class="btn theme-btn light-btn"
                                                    data-dismiss="modal"
                                                    onclick="event.preventDefault();">Close</button>
                                            </div>
                                        </div>

                                        <div class="modal-body">
                                            <input type="hidden" id="tender_no" name="tender_no" />
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
                                                        success: function (response) {
                                                            document.getElementById("resultDiv").innerHTML = response;
                                                            $('#Bitsntvendor').modal('show');
                                                            if ($('#commonTable1').length) {
                                                                const table1 = initTable('#commonTable1', {
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
                            </div>


                            <div class="modal fade" id="BitRRvendor" data-backdrop="static" data-keyboard="false"
                                tabindex="-1" aria-labelledby="BitRRvendorLabel" aria-hidden="true">
                                <div class="modal-dialog modal-xl">
                                    <div class="modal-content">

                                        <div class="modal-header align-items-center">
                                            <h5 class="modal-title" id="BitRRvendorLabel">Vendor Information</h5>
                                            <div class="cta-btn d-flex align-items-center">
                                                <button type="button" class="btn theme-btn light-btn"
                                                    data-dismiss="modal"
                                                    onclick="event.preventDefault();">Close</button>
                                            </div>
                                        </div>

                                        <div class="modal-body">
                                            <input type="hidden" id="tender_no" name="tender_no" />
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
                            </div>



                        </form:form>


                    </section>
            </main>
        </body>
        <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp" %>

    </html>