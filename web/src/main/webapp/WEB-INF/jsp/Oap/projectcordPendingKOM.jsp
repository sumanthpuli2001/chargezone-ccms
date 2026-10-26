<%-- 
    Document   : projectcordPendingKOM
    Created on : May 16, 2026, 10:34:09 AM
    Author     : Sumanth
--%>





<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Total Pending AOC To Create KOM</title>
    </head>

    <body >


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
                            <h5 class="fw-600 mb-0">Total Pending AOC To Create KOM</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>
                        </div>
                    </div>
                    <hr>

                    <div class="container-fluid px-4">
                        <div class="mt-3 table-responsive">

                            <div class="d-flex align-items-center justify-content-between mb-3">
                                <div>
                                    <select id="entriesPerPagePendingKOM" class="select-input">
                                        <option value="10">10</option>
                                        <option value="20">20</option>
                                        <option value="50">50</option>
                                        <option value="100">100</option>
                                    </select>
                                </div>
                                <div>
                                    <input type="text" id="searchBoxPendingKOM"
                                           class="input-field" placeholder="Search here...">
                                </div>
                            </div>

                            <table id="pendingKOMTable" class="table table-striped bg-white" style="width:100%">
                                <thead>
                                    <tr>
                                        <th>Sr.No</th>                                         
                                        <th style="min-width:190px;">Document No</th>           
                                        <th style="min-width:190px;">Hub Depo Name</th>         
                                        <th style="min-width:190px;">Client Project Name</th>   
                                        <th style="min-width:190px;">Date</th>                  
                                        <th style="min-width:190px;">Designation</th>                  
                                    </tr>
                                </thead>
                            </table>

                        </div>
                    </div>

            </section>
        </main>

        <script>
            $(document).ready(function () {

                if ($.fn.DataTable.isDataTable('#pendingKOMTable')) {
                    $('#pendingKOMTable').DataTable().destroy();
                }

                var pendingKOMTable = $('#pendingKOMTable').DataTable({
                    processing:  true,
                    serverSide:  true,
                    stateSave:   false,
                    ordering:    true,
                    orderMulti:  false,
                    order:       [[0, 'desc']],
                    ajax: {
                        url:   'formsCommon.htm?act=projectcordPendingKOMPagination1Ajax',
                        type:  'POST',
                        cache: false,
                        data: function (d) {
                            d.contact            = '${ContactPerson}'; 
                            d.Fromdate           = $('#Fromdate').val();
                            d.Todate             = $('#Todate').val();
                            d.Filter             = $('#Filter').val();
                            d.formattedDate      = $('#formattedDate').val();
                            d.formattedStartDate = $('#formattedStartDate').val();
                        },
                        error: function (xhr) {
                            console.log(xhr.responseText);
                        }
                    },
                    columns: [
                        { data: 'srNo',              orderable: true,  searchable: false },
                        { data: 'documentNo',        orderable: true,  searchable: true  }, 
                        { data: 'hubDepoName',       orderable: true,  searchable: true  }, 
                        { data: 'clientProjectName', orderable: true,  searchable: true  }, 
                        { data: 'createdDate',       orderable: true,  searchable: true  },  
                        { data: 'designation',       orderable: true,  searchable: true  }  
                    ],
                    pageLength:   10,
                    lengthChange: false,
                    searching:    true,
                    info:         true,
                    autoWidth:    false,
                    responsive:   true,
                    scrollX:      true,
                    dom: 'rt<"table-bottom-info d-flex align-items-center justify-content-between pt-3"i p>'
                });

                $('#searchBoxPendingKOM').on('keyup', function () {
                    pendingKOMTable.search(this.value).draw();
                });

                $('#entriesPerPagePendingKOM').on('change', function () {
                    pendingKOMTable.page.len($(this).val()).draw();
                });

                $('#Fromdate, #Todate, #Filter').on('change keyup', function () {
                    pendingKOMTable.ajax.reload(null, true);
                });
            });
        </script>

                                   
           
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>





