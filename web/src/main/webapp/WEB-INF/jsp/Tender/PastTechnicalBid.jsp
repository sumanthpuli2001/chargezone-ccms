/<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Past Tender Technical List</title>
    </head>
    <body>
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="tenderMaster.htm?act=pastTechnicalBid" method="post" commandName="employeeMaster"
                           name='form1'  class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Past Tender Technical List</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn">Back</a>
                        </div>
                    </div>

                    <div class="row rounded-4 mt-3">

                        <div class="col-lg-2 col-md-2">
                            <div class="form-group">
                                <label class="label">Tender No.</label>
                                <input type="text" name="tenderNo" id="tenderNo" class="input-field" maxlength="30" />
                            </div>
                        </div>

                        <div class="col-lg-2 col-md-2">
                            <div class="form-group">
                                <label class="label">Project Name :</label>
                                <input type="text" name="tenderTitle" id="tenderTitle" class="input-field" maxlength="30" />
                            </div>
                        </div>

                        <div class="col-lg-2 col-md-2">
                            <div class="form-group">
                                <label class="label"> Start From Date :</label>
                                <div class="form-group date">
                                    <input id="openFromDate" name="openFromDate" type="text" class="input-field form_datetime" placeholder="DD/MM/YYYY" maxlength="30" autocomplete="off" />
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-2 col-md-2">
                            <div class="form-group">
                                <label class="label">Start End Date :</label>
                                <div class="form-group date">
                                    <input id="openToDate" name="openToDate" type="text" class="input-field form_datetime" placeholder="DD/MM/YYYY" maxlength="30" autocomplete="off" />
                                </div>
                            </div>
                        </div>


                        <div class="col-lg-2 col-md-2">
                            <div class="form-group">
                                <label class="label"> Closing From Date :</label>
                                <div class="form-group date">
                                    <input name="closeFromDate" id="closeFromDate" type="text" class="input-field form_datetime" value=""   placeholder="DD/MM/YYYY" autocomplete="off"maxlength="30" />
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-2 col-md-2">
                            <div class="form-group">
                                <label class="label">Closing End Date :</label>
                                <div class="form-group date" id="datetimepickers6">
                                    <input name="closeToDate" id="closeToDate" type="text" class="input-field form_datetime" value=""  maxlength="30"  placeholder="DD/MM/YYYY" autocomplete="off">
                                </div>
                            </div>
                        </div>
                    </div>

                    <script type="text/javascript">
                        $(document).ready(function () {
                            flatpickr("#openFromDate", {
                                dateFormat: "d-m-Y",
                                allowInput: true
                            });
                            flatpickr("#openToDate", {
                                dateFormat: "d-m-Y",
                                allowInput: true
                            });
                            flatpickr("#closeFromDate", {
                                dateFormat: "d-m-Y",
                                allowInput: true
                            });
                            flatpickr("#closeToDate", {
                                dateFormat: "d-m-Y",
                                allowInput: true
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
                                </select>
                            </div>

                            <div>
                                <input type="text" id="searchBox" class="input-field" placeholder="Search here...">
                            </div>

                        </div>

                        <table id="pastTenderTechTable" class="table table-striped bg-white" style="width:100%">

                            <thead>

                                <tr>

                                    <th>Sr. No.</th>
                                    <th style="min-width: 180px;">Tender No.</th>
                                    <th style="min-width: 230px;">Project Name</th>
                                    <th style="min-width: 180px;">Tender Date</th>
                                    <th style="min-width: 180px;">Tender Due Date</th>
                                    <th style="min-width: 180px;">Created By</th>
                                    <th>Tender Type</th>
                                    <th style="min-width: 180px;">Bid Sent To No. Of Vendor</th>
                                    <th style="min-width: 180px;">Bid Received/Regret From No. Of Vendor</th>
                                    <th style="min-width: 180px;">View</th>

                                </tr>

                            </thead>

                        </table>

                    </div>
                    
                   <script>

                        var table;

                        $(document).ready(function () {

                            table = $('#pastTenderTechTable').DataTable({

                                processing: true,

                                serverSide: true,

                                stateSave: false,

                                ordering: true,

                                orderMulti: false,

                                aaSorting: [[0, 'asc']],

                                columnDefs: [
                                    {
                                        targets: [7, 8, 9],
                                        orderable: false,
                                        searchable: false
                                    }
                                ],

                                ajax: {

                                    url: 'tenderMaster.htm?act=pastTechnicalBidAjax',

                                    type: 'POST',

                                    cache: false,

                                    data: function (d) {

                                        d.tenderNo = $('#tenderNo').val();

                                        d.tenderTitle = $('#tenderTitle').val();

                                        d.openFromDate = $('#openFromDate').val();

                                        d.openToDate = $('#openToDate').val();

                                        d.closeFromDate = $('#closeFromDate').val();

                                        d.closeToDate = $('#closeToDate').val();
                                    }

                                },

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
                                        data: 'tenderDate',
                                        defaultContent: ''
                                    },

                                    {
                                        data: 'tenderDueDate',
                                        defaultContent: ''
                                    },

                                    {
                                        data: 'createdBy',
                                        defaultContent: ''
                                    },

                                    {
                                        data: 'tenderPhase',
                                        defaultContent: ''
                                    },

                                    {
                                        data: 'vendorTotal',
                                        orderable: false,
                                        searchable: false,
                                        defaultContent: ''
                                    },

                                    {
                                        data: 'bidRegret',
                                        orderable: false,
                                        searchable: false,
                                        defaultContent: ''
                                    },

                                    {
                                        data: 'action',
                                        orderable: false,
                                        searchable: false,
                                        defaultContent: ''
                                    }

                                ],

                                pageLength: 10,

                                lengthChange: false,

                                searching: true,

                                info: true,

                                autoWidth: false,

                                responsive: true,

                                scrollX: true,

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

                            $('#tenderNo, #tenderTitle, #openFromDate, #openToDate, #closeFromDate, #closeToDate')
                                .on('keyup change', function () {

                                    table.ajax.reload(null, true);

                                });

                        });

                    </script>
                </section>
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
                                                            success: function(response) {
                                                            document.getElementById("resultDiv1").innerHTML = response;
                                                                    $('#BitRRvendor').modal('show');
                                                                    if ($('#commonTab').length){
                                                            const table1 = initTable('#commonTab', {
                                                            columnDefs: [
                                                            { targets: [], orderable: false }
                                                            ],
                                                                    order: [[1, 'asc']]
                                                            });
                                                            }
                                                            if ($('#commonTab1').length){
                                                            const table1 = initTable('#commonTab1', {
                                                            columnDefs: [
                                                            { targets: [], orderable: false }
                                                            ],
                                                                    order: [[1, 'asc']]
                                                            });
                                                            }
                                                            if ($('#commonTab2').length){
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

        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
