<%-- 
    Document   : clickaocNoOfChargerDetails
    Created on : Apr 15, 2026, 10:33:11 AM
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
        <title>AOC No Of Charger</title>
    </head>

    <body>
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

            <section class="main-content">

                <%-- Top Header Bar --%>
                <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                    <div class="page-title d-flex align-items-center">
                        <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                            <img src="StorageYard/assets/images/menu-collapse.svg"
                                 class="fa-bars" onload="SVGInject(this)" alt="Menu collapse">
                            <img src="StorageYard/assets/images/menu-expand.svg"
                                 class="fa-bars-sort" onload="SVGInject(this)" alt="Menu collapse">
                        </div>
                        <h5 class="fw-600 mb-0">AOC No Of Charger - ${MonthName}</h5>
                    </div>
                    <div class="cta d-flex align-items-center">
                        <a onclick="history.back();"
                           class="btn theme-btn light-btn mr-3 no-print">Back</a>
                    </div>
                </div>

                <div class="content-top mb-0 d-flex align-items-center justify-content-between row my-3">
                    <div class="col-md-1 pr-md-1">
                        <select id="entriesPerPageAocCharger" class="select-input">
                            <option value="10">10</option>
                            <option value="25">25</option>
                            <option value="50">50</option>
                            <option value="100">100</option>
                            <option value="-1">ALL</option>
                        </select>
                    </div>
                    <div class="col-md-3 pl-md-1" >
                        <input id="searchBoxAocCharger" type="text" class="input-field" placeholder="Search here...">
                    </div>
                </div>

                <table id="aocNoOfChargerTable" class="table table-striped bg-white" style="min-width: 100%;">

                    <thead>
                        <tr>
                            <th>Sr.No</th>                                     
                            <th style="min-width:180px;">Document Number</th>   
                            <th style="min-width:180px;">Depo Name</th>         
                            <th style="min-width:180px;">Project Name</th>       
                            <th style="min-width:190px;">No Of Charger</th>     
                            <th style="min-width:180px;">Client Name</th>       
                            <th style="min-width:150px;">Date</th>              
                        </tr>
                    </thead>
                    <tbody></tbody>

                </table>




            </section>
        </main>

        <script>
            $(document).ready(function () {

                if ($.fn.DataTable.isDataTable('#aocNoOfChargerTable')) {
                    $('#aocNoOfChargerTable').DataTable().destroy();
                }

                var aocNoOfChargerTable = $('#aocNoOfChargerTable').DataTable({
                    processing: true,
                    serverSide: true,
                    stateSave: false,
                    ordering: true,
                    orderMulti: false,
                    order: [[0, 'desc']],
                    ajax: {
                        url: 'formsCommon.htm?act=monthWiseClickAocNoOfChargerDetailsPaginationAjax',
                        type: 'POST',
                        cache: false,
                        data: function (d) {
                            d.label = '${MonthName0}';
                            d.Filter = '${Filter}';
                            d.Fromdate = $('#Fromdate').val();
                            d.Todate = $('#Todate').val();
                            d.formattedDate = $('#formattedDate').val();
                            d.formattedStartDate = $('#formattedStartDate').val();
                        },
                        error: function (xhr) {
                            console.log(xhr.responseText);
                        }
                    },
                    columns: [
                        {data: 'srNo', orderable: true, searchable: false},
                        {data: 'documentNo', orderable: true, searchable: true},
                        {data: 'hubDepoName', orderable: true, searchable: true},
                        {data: 'clientProjectName', orderable: true, searchable: true},
                        {data: 'noOfCharger', orderable: true, searchable: true},
                        {data: 'mobileNo', orderable: true, searchable: true},
                        {data: 'createdDate', orderable: true, searchable: true}
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

                $('#searchBoxAocCharger').on('keyup', function () {
                    aocNoOfChargerTable.search(this.value).draw();
                });

                $('#entriesPerPageAocCharger').on('change', function () {
                    var val = $(this).val();

                    if (val === "" || val === "-1") {
                        var total = aocNoOfChargerTable.page.info().recordsTotal;
                        aocNoOfChargerTable.page.len(total > 0 ? total : 1).draw();
                    } else {
                        aocNoOfChargerTable.page.len(parseInt(val, 10)).draw();
                    }
                });

                $('#Fromdate, #Todate, #Filter').on('change keyup', function () {
                    aocNoOfChargerTable.ajax.reload(null, true);
                });
            });
        </script>

        <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
    </body>
</html>