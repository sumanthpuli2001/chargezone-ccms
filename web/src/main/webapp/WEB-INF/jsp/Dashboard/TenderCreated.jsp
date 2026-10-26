<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Tender Created</title>
    </head>

    <body>

        <script>
            $('#select_all').on('change', function () {
                $('.switch-input').prop('checked', this.checked).trigger('change');
            });
        </script>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="dashboard.htm?act=tenderCreated" method="post" commandName="prFilterForm" class="form-horizontal" role="form">

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)" alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)" alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0"> Tender Created</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>
                            <!--<button type="button" id="btnReset" class="btn theme-btn light-btn mr-3">Reset</button>-->
<!--                            <button type="submit" class="btn theme-btn mr-3">Apply Filters</button>-->
                        </div>
                    </div>
                    <div class="rounded-4 mt-3 sticky-model1">
                        <div class="form-group">
                            <div class="row">
                                <div class="col-sm-3">
                                    <label>From Date:</label>
                                    <input type="text" name="Fromdate" id="Fromdate" value="${Fromdate}"
                                           class="input-field" placeholder="DD-MM-YYYY">
                                </div>

                                <div class="col-sm-3">
                                    <label>To Date:</label>
                                    <input type="text" name="Todate" id="Todate" value="${Todate}"
                                           class="input-field" placeholder="DD-MM-YYYY">
                                </div>

                                <div class="col-sm-3">
                                    <label>Department:</label>
                                    <select class="select-input" name="Department" id="Department">
                                        <option value="">Select Department</option>
                                        <c:forEach var="list" items="${list0}">
                                            <option value="${list.departmentName}" ${Department == list.departmentName ? 'selected' : ''}>
                                                ${list.departmentName}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="col-sm-3">
                                    <label>Filter By:</label>
                                    <select class="select-input" name="Filter" id="Filter">
                                        <option value="">--SELECT--</option>
                                        <option value="last-week"    ${Filter == "last-week"    ? 'selected' : ''}>Last-1-Week</option>
                                        <option value="last-month"   ${Filter == "last-month"   ? 'selected' : ''}>Last-1-Month</option>
                                        <option value="last-6-month" ${Filter == "last-6-month" ? 'selected' : ''}>Last-6-Month</option>
                                        <option value="last-year"    ${Filter == "last-year"    ? 'selected' : ''}>Last-1-Year</option>
                                    </select>
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

                        <table id="tenderCreatedTable" class="table table-striped bg-white" style="width:100%">
                            <thead>
                                 <tr>
                                <th>Sr. No. </th>
                                <th style="min-width: 190px;">Ref No. </th>
                                <th style="min-width: 190px;">Title </th>
                                <th style="min-width: 190px;">Project Id </th>
                                <th style="min-width: 190px;">Category Id </th>
                                <th style="min-width: 190px;">Type </th>
                                <th style="min-width: 190px;">PR Created By </th>
                                <th style="min-width: 190px;">PR Date Time </th>
                                <th style="min-width: 190px;">Tender Created By </th>
                                <th style="min-width: 190px;">Tender Date Time </th>

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

            var fromDatePicker = flatpickr("#Fromdate", {
                enableTime: false,
                dateFormat: "d-m-Y",
                allowInput: true,
                onChange: function () {
                    table.ajax.reload(null, true);
                }
            });

            var toDatePicker = flatpickr("#Todate", {
                enableTime: false,
                dateFormat: "d-m-Y",
                allowInput: true,
                onChange: function () {
                    table.ajax.reload(null, true);
                }
            });

            var table = $('#tenderCreatedTable').DataTable({
                processing:  true,
                serverSide:  true,
                stateSave:   false,
                ordering:    true,
                orderMulti:  false,
                aaSorting:   [[0, 'desc']],

                ajax: {
                    url:   'dashboard.htm?act=tenderCreatedDashboadPaginationAjax',
                    type:  'POST',
                    cache: false,
                    data: function (d) {
                        d.Filter     = $('#Filter').val().trim();
                        d.Department = $('#Department').val().trim();
                        d.Fromdate   = $('#Fromdate').val().trim();
                        d.Todate     = $('#Todate').val().trim();
                    }
                },
                columns: [
                    { data: 'srNo', orderable: true, searchable: false },
                    { data: 'refNo', orderable: true, searchable: true },
                    { data: 'title', orderable: true, searchable: true },
                    { data: 'projectId', orderable: true, searchable: true },
                    { data: 'categoryId', orderable: true, searchable: true },
                    { data: 'type', orderable: true, searchable: true },
                    { data: 'contactPerson', orderable: true, searchable: true },
                    { data: 'announceDate', orderable: true, searchable: true },
                    { data: 'prAdmin', orderable: true, searchable: true },
                    { data: 'authorizeDate', orderable: true, searchable: true }
                ],


                pageLength:   10,
                lengthChange: false,
                searching:    true,
                info:         true,
                autoWidth:    false,
                responsive:   true,
                scrollX:      true,
                scrollCollapse: true,                    
                scrollY: '80vh',

                language: {
                    processing:   "Loading...",
                    info:         "Showing _START_ to _END_ of _TOTAL_ filtered records",
                    infoFiltered: "(filtered from _MAX_ total records)",
                    zeroRecords:  "No matching records found",
                    infoEmpty:    "Showing 0 to 0 of 0 records"
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

            $('#btnReset').on('click', function () {
                $('#Filter').val('');
                $('#Department').val('');
                fromDatePicker.clear();
                toDatePicker.clear();
                $('#searchBox').val('');
                table.search('').ajax.reload(null, true);
            });

            $('#Filter, #Department').on('change', function () {
                table.ajax.reload(null, true);
            });
        });
    </script>

</html>
