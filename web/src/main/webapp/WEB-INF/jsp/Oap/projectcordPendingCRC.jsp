<%-- 
    Document   : projectcordPending
    Created on : Apr 20, 2026, 10:50:33 AM
    Author     : Sumanth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Total Pending OAP To Create CRC</title>
    </head>

    <body>
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

            <section class="main-content">
                <form:form action="" method="post" commandName="" class="form-horizontal" role="form">

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars"
                                     onload="SVGInject(this)" alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort"
                                     onload="SVGInject(this)" alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">Total Pending OAP To Create CRC</h5>
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
                                    <select id="entriesPerPagePendingCRC" class="select-input">
                                        <option value="10">10</option>
                                        <option value="20">20</option>
                                        <option value="50">50</option>
                                        <option value="100">100</option>
                                    </select>
                                </div>
                                <div>
                                    <input type="text" id="searchBoxPendingCRC"
                                           class="input-field" placeholder="Search here...">
                                </div>
                            </div>

                            <table id="pendingCRCTable"
                                   class="table table-striped bg-white" style="width:100%">
                                <thead>
                                    <tr>
                                        <th>Sr.No</th>                                  
                                        <th style="min-width:180px;">Document No</th>   
                                        <th style="min-width:180px;">PCS Name</th>      
                                        <th style="min-width:180px;">Department</th>    
                                        <th style="min-width:180px;">Created Date</th>  
                                        <th style="min-width:180px;">Designation</th>    
                                    </tr>
                                </thead>
                            </table>

                        </div>

                    </div>

                </form:form>
            </section>
        </main>

        <script>
            $(document).ready(function () {

                // ← Destroy if already initialized
                if ($.fn.DataTable.isDataTable('#pendingCRCTable')) {
                    $('#pendingCRCTable').DataTable().destroy();
                }

                var pendingCRCTable = $('#pendingCRCTable').DataTable({
                    processing:  true,
                    serverSide:  true,
                    stateSave:   false,
                    ordering:    true,
                    orderMulti:  false,
                    order:       [[0, 'desc']],
                    ajax: {
                        url:   'formsCommon.htm?act=projectcordPendingCRCPagination1Ajax',
                        type:  'POST',
                        cache: false,
                        data: function (d) {
                            d.contact            = '${ContactPerson}'; // ← from model
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
                        { data: 'srNo',        orderable: true,  searchable: false }, 
                        { data: 'documentNo',  orderable: true,  searchable: true  }, 
                        { data: 'pcsName',     orderable: true,  searchable: true  },
                        { data: 'department',  orderable: true,  searchable: true  }, 
                        { data: 'createdDate', orderable: true,  searchable: true  }, 
                        { data: 'designation', orderable: true,  searchable: true  }  
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

                $('#searchBoxPendingCRC').on('keyup', function () {
                    pendingCRCTable.search(this.value).draw();
                });

                $('#entriesPerPagePendingCRC').on('change', function () {
                    pendingCRCTable.page.len($(this).val()).draw();
                });

                $('#Fromdate, #Todate, #Filter').on('change keyup', function () {
                    pendingCRCTable.ajax.reload(null, true);
                });
            });
        </script>

        <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
    </body>
</html>