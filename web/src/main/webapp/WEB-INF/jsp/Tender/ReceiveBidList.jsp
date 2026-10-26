

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>RECEIVE BID LIST</title>
    </head>

    <body>
        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

            <section class="main-content">
                <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                    <div class="page-title d-flex align-items-center">
                        <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                            <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                 alt="Menu collapse">
                            <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                 alt="Menu collapse">
                        </div>

                        <h5 class="fw-600 mb-0">RECEIVE BID LIST</h5>
                    </div>

                    <div class="cta d-flex align-items-center">
                        <a href="javascript:void(0)" id="exportExcelBtn" class="btn theme-btn">Export To Excel</a>
                    </div>
                </div>

                <hr>
                <c:if test="${!empty failureMessage}">
                    <div class="fadeOutEffect alert alert-danger mt-2 mb-2" style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <strong>Note:</strong> <strong class="text-danger fs-13">${failureMessage} </strong><br>                            
                        </div>
                    </div>
                </c:if>
                <c:if test="${!empty successMessage}">
                    <div class="fadeOutEffect alert alert-info mt-2 mb-2" style="display: flex; align-items: center; gap: 12px; background: #F0FFF4; color: #0F5132; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #198754; box-shadow: 2px 2px 10px rgba(25, 135, 84, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">                        
                        <div style="background: #198754; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px; ">✓</div>  
                        <div>                             
                            <strong>Note:</strong> <strong class="text-success fs-13">${successMessage} </strong><br>                            
                        </div>
                    </div>
                </c:if>
                
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

                    <table id="receiveBidTable" class="table table-striped bg-white dt-scroll" style="width:100%">

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
                                <th>Bid Received/Regret From No. Of Vendor</th>
                                <th style="min-width: 180px;" data-dt-order="disable">Bid Status</th>

                            </tr>

                        </thead>

                    </table>

                    <script>

                        var table;

                        $(document).ready(function () {

                            table = $('#receiveBidTable').DataTable({

                                processing: true,

                                serverSide: true,

                                stateSave: false,

                                ordering: true,

                                orderMulti: false,

                                aaSorting: [[0, 'desc']],

                                ajax: {

                                    url: 'tenderMaster.htm?act=receiveBidListAjax',

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
                                
                                scrollCollapse: true,

                                scrollY: '80vh',
                                
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
                                var val = $(this).val();

                                if (val === "" || val === "-1") {
                                    var total = table.page.info().recordsTotal;
                                    table.page.len(total > 0 ? total : 1).draw();
                                } else {
                                    table.page.len(parseInt(val, 10)).draw();
                                }
                            }); 
                            
                            var $bottomInfo = $('#receiveBidTable_wrapper > .table-bottom-info');
                            $('.table-responsive').after($bottomInfo);
                                                        
                            //      For Export To Excel            
                            $('#exportExcelBtn').on('click', function () {

                                var params = {
                                    searchValue: $('#searchBox').val()
                                };

                                var $form = $('<form>', {
                                    method: 'POST',
                                    action: 'tenderMaster.htm?act=receiveBidReportExportExcel'
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
                </div>
                    
                

            </section>
        </main> 
    </body>

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





    <script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>


</html>


