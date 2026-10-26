
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PR Summary Report</title>
    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="prMaster.htm?act=prSummaryReportList" method="post" commandName="employeeMaster"
                           name='form1'  class="form-horizontal" role="form">

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">PR Summary Report</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a href="javascript:void(0)" id="exportExcelBtn" class="btn theme-btn">Export To Excel</a>
                        </div>
                    </div>

                    <hr>


                    <div class="rounded-4 mt-6 sticky-model1">
                        <div class="row mb-4">
                            <div class="col-lg-2 col-md-6">
                                <div class="form-group">
                                    <label for="control-label" class="label">Enter PR Number:<span
                                            class="text"></span></label>
                                    <input type="text" name="prNumber" id="prNumber" class="input-field" placeholder="Search By PR No" />
                                </div>
                            </div>
                            <div class="col-lg-3 col-md-2">
                                <div class="form-group">
                                    <label  class="label">Enter Project Name :</label>
                                    <input type="text" name="projectName" id="projectName" value="" class="input-field" placeholder="Search By Project Name" />
                                </div>   
                            </div>
                            <div class="col-lg-3 col-md-6">
                                <div class="form-group">
                                    <label class="label">Department  :</label>
                                    <select id="committee_approval" name="department" class="select-input" >
                                        <option value="">--SELECT--</option>
                                        <c:forEach var="DepartmentList" items="${DepartmentList}" varStatus="status">
                                            <option value="${DepartmentList.departmentName}">${DepartmentList.departmentName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="col-lg-2 col-md-6">
                                <div class="form-group">
                                    <label class="label">Start From Date :</label>
                                    <div class="form-group date" id="datetimepickers6">
                                        <input id="open_from_date" style="background: white;" name="open_from_date"  type="text"class="input-field form_datetime" placeholder="DD/MM/YYYY" maxlength="30"autocomplete="off" />
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-2 col-md-6">
                                <div class="form-group">
                                    <label class="label">Start End Date :</label>
                                    <div class="form-group date" id="datetimepickers5">
                                        <input id="open_to_date"name="open_to_date" style="background: white;"  type="text"class="input-field form_datetime" placeholder="DD/MM/YYYY"maxlength="30"autocomplete="off" />
                                    </div>
                                </div>
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

                        <table id="saerchPrSummaryTable" class="table table-striped bg-white" style="width:100%">

                            <thead>

                                <tr>

                                    <th>Sr. No.</th>
                                    <th style="min-width: 190px;">PR Number</th>
                                    <th style="min-width: 180px;">Project Name</th>
                                    <th style="min-width: 180px;">Project ID</th>
                                    <th style="min-width: 180px;">PR Subject Description</th>
                                    <th style="min-width: 180px;">Department</th>
                                    <th style="min-width: 180px;">Billing Location</th>
                                    <th style="min-width: 180px;">Created By</th>
                                    <th style="min-width: 180px;">PR Date Time</th>
                                    <th style="min-width: 180px;">PR Approval User</th>
                                    <th style="min-width: 180px;">PR Approval Date</th>                                    
                                    <th style="min-width: 180px;">Approval Status</th>

                                </tr>

                            </thead>

                        </table>

                    </div>

                </form:form>
            </section>
        </main>
        <script>

            var table;

            $(document).ready(function () {

                table = $('#saerchPrSummaryTable').DataTable({

                    processing: true,

                    serverSide: true,

                    stateSave: false,

                    ordering: true,

                    orderMulti: false,

                    aaSorting: [[0, 'asc']],

                    columnDefs: [
                        {
                            targets: [11],
                            orderable: false,
                            searchable: false
                        }
                    ],

                    ajax: {

                        url: 'prMaster.htm?act=searchPRSummaryReportPaginationAjax',

                        type: 'POST',

                        cache: false,

                        data: function (d) {

                            d.prNumber = $('#prNumber').val();

                            d.projectName = $('#projectName').val();

                            d.department = $('#committee_approval').val();

                            d.open_from_date = $('#open_from_date').val();

                            d.open_to_date = $('#open_to_date').val();
                        },

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

                        {data: 'prNo'},
                        {data: 'title'},
                        {data: 'projectId'},
                        {data: 'workDesc'},
                        {data: 'department'},
                        {data: 'billingLocation'},
                        {data: 'contactPerson'},
                        {data: 'announceDate'},
                        {data: 'prAuthorizeUser'},
                        {data: 'prAuthorizeDate'},                        
                        {data: 'status'},
                        
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
                
                $('#prNumber, #projectName, #committee_approval, #open_from_date, #open_to_date')
                .on('change keyup', function () {

                    table.ajax.reload(null, true);

                });
                
                //      For Export To Excel            
                $('#exportExcelBtn').on('click', function () {

                    var params = {
                        searchValue: $('#searchBox').val(),

                        prNumber: $('#prNumber').val(),
                        projectName: $('#projectName').val(),
                        committee_approval: $('#committee_approval').val(),

                        open_from_date: $('#open_from_date').val(),
                        open_to_date: $('#open_to_date').val()
                    };

                    var $form = $('<form>', {
                        method: 'POST',
                        action: 'prMaster.htm?act=prSummaryReportExportExcel'
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
            
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
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
                                onChange: function (selectedDates) {
                                toDate = selectedDates[0];
                                        if (fromDate && toDate < fromDate) {
                                showInvalidToast(`${label}To date cannot be earlier than From date.`);
                                        toPicker.clear();
                                        toDate = null;
                                }
                                }
                        });
                        const fromPicker = flatpickr(fromSelector, {
                        dateFormat: "d-m-Y",
                                onChange: function (selectedDates) {
                                fromDate = selectedDates[0];
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
                });
    </script>
</html>
