<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PR of ${MonthName}</title>
    </head>

    <body>
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="dashboard.htm?act=monthWisePr&label=${MonthName0}" method="post"
                           commandName="prFilterForm" class="form-horizontal" role="form">

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)" alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)" alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">Live PR List of ${MonthName}</h5>
                        </div>
                        <div class="cta d-flex align-items-center">

                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>
                        </div>
                    </div>
                    
                    <div class="rounded-4 mt-3 sticky-model1">
                        <div class="form-group">
                            <div class="row">
                                <div class="col-sm-6">
                                    <label>Department:</label>
                                    <select class="select-input" name="Department" id="Department">
                                        <option value="">Select Department</option>
                                        <c:forEach var="dept" items="${list0}">
                                            <option value="${dept.departmentName}"
                                                    ${Department == dept.departmentName ? 'selected' : ''}>
                                                ${dept.departmentName}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="col-sm-6">
                                    <label>Filter By:</label>
                                    <select id="Filter" name="Filter" class="select-input">
                                        <option value="">--SELECT--</option>
                                        <option value="last-week"    ${Filter == 'last-week'    ? 'selected' : ''}>Last-1-Week</option>
                                        <option value="last-month"   ${Filter == 'last-month'   ? 'selected' : ''}>Last-1-Month</option>
                                        <option  value="last-6-month" ${Filter == 'last-6-month' ? 'selected' : ''}>Last-6-Month</option>
                                        <option value="last-year"    ${Filter == 'last-year'    ? 'selected' : ''}>Last-1-Year</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>

                   
                    <div class=" mt-3 table-responsive">
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

                        <table id="monthWisePrTable" class="table table-striped bg-white" style="min-width:100%;">
                            <thead>
                                <tr>
                                    <th>Sr. No.</th>
                                    <th style="min-width:190px;">PR Number</th>
                                    <th style="min-width:230px;">Project Name</th>
                                    <th style="min-width:230px;">Project ID</th>
                                    <th style="min-width:190px;">Created By</th>
                                    <th style="min-width:190px;">Date Time</th>
                                    <th>Approval Status</th>
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

            var table = $('#monthWisePrTable').DataTable({
                processing:  true,
                serverSide:  true,
                stateSave:   false,
                ordering:    true,
                orderMulti:  false,
                aaSorting:   [[0, 'desc']],

                ajax: {
                    url:   'dashboard.htm?act=monthWisePrDashboadPaginationAjax',
                    type:  'POST',
                    cache: false,
                    data: function (d) {
                        d.label      = '${MonthName0}';
                        d.Filter     = $('#Filter').val().trim();
                        d.Department = $('#Department').val().trim();
                    },
                    error: function (xhr) {
                        console.error("Status  : " + xhr.status);
                        console.error("Response: " + xhr.responseText);
                        Bootoast.toast({
                            message:  'Error loading data. Please try again.',
                            type:     'danger',
                            timeout:  3000,
                            position: 'top-center'
                        });
                    }
                },

                columns: [
                    { data: 'srNo',          orderable: true,  searchable: false },
                    { data: 'prNo',          orderable: true,  searchable: true  },
                    { data: 'title',         orderable: true,  searchable: true  },
                    { data: 'projectId',     orderable: true,  searchable: true  },
                    { data: 'contactPerson', orderable: true,  searchable: true  },
                    { data: 'announceDate',  orderable: true,  searchable: true  },
                    { data: 'authorizeFlag', orderable: true,  searchable: true  }
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

            // ── Search Box ──────────────────────────────────────────────────
            $('#searchBox').on('keyup', function () {
                table.search(this.value).draw();
            });

            // ── Entries Per Page ────────────────────────────────────────────
            $('#entriesPerPage').on('change', function () {
                var val = $(this).val();

                if (val === "" || val === "-1") {
                    var total = table.page.info().recordsTotal;
                    table.page.len(total > 0 ? total : 1).draw();
                } else {
                    table.page.len(parseInt(val, 10)).draw();
                }
            });

            // ── Apply Filter button: close modal and reload table ───────────
            $('#applyFilter').on('click', function () {
                $('#searchModal').modal('hide');
                table.ajax.reload(null, true);
            });

            // ── Filter / Department change also triggers reload ─────────────
            $('#Filter, #Department').on('change', function () {
                table.ajax.reload(null, true);
            });

        });
    </script>

</html>
