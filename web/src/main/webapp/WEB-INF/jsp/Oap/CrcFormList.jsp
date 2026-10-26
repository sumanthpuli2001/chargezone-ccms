

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>CRC Form List</title>
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

                        <h5 class="fw-600 mb-0">CRC Form List</h5>
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
                                <option value="-1">ALL</option>
                            </select>
                        </div>
                        <div>
                            <input type="text" id="searchBox" class="input-field" placeholder="Search here...">
                        </div>
                    </div>
                    <table id="crcFormListTable" class="table table-striped bg-white" style="width:100%">
                        <thead>
                            <tr>
                                <th>Sr.No</th>
                                <th>Document No</th>
                                <th>PCS Name </th>
                                <th>Created By </th>
                                <th>Designation </th>
                                <th>Status </th>
                                <th >Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>

              

            </section>
        </main> 
    </body>
    <script>
        $(document).ready(function () {
            var table = $('#crcFormListTable').DataTable({
                processing: true,
                serverSide: true,
                stateSave: false,
                ordering: true,
                orderMulti: false,
                order:       [[0, 'desc']],
                ajax: {
                    url: 'formsCommon.htm?act=CrcFormListPaginationAjax',
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
                        searchable: true
                    },
                    {
                        data: 'documentNo',
                        orderable: true,
                        searchable: true
                    },
                    {
                        data: 'pcsName',
                        orderable: true,
                        searchable: true
                    },
                    {
                        data: 'userid',
                        orderable: true,
                        searchable: true
                    },
                    {
                        data: 'designation',
                        orderable: true,
                        searchable: true
                    },
                    {
                        data: 'flagStatus',
                        orderable: true,
                        searchable: true
                    },
                    {
                        data: 'action',
                        orderable: false,
                        searchable: false,
                        render: function (data) {
                            return data;
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
                dom: 'rt<"table-bottom-info d-flex align-items-center justify-content-between pt-3"i p>'
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

        });
    </script>
    <script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>


</html>


