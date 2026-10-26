<%-- 
    Document   : clickNoOfChargerDetails
    Created on : Apr 14, 2026, 5:10:09 PM
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
        <title>OAP No of Chargers</title>
    </head>

    <body>
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

            <section class="main-content">

                <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                    <div class="page-title d-flex align-items-center">
                        <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                            <img src="StorageYard/assets/images/menu-collapse.svg"
                                 class="fa-bars" onload="SVGInject(this)" alt="Menu collapse">
                            <img src="StorageYard/assets/images/menu-expand.svg"
                                 class="fa-bars-sort" onload="SVGInject(this)" alt="Menu collapse">
                        </div>
                        <h5 class="fw-600 mb-0">OAP No of Chargers - ${MonthName}</h5>
                    </div>
                    <div class="cta d-flex align-items-center">
                        <a onclick="history.back();"
                           class="btn theme-btn light-btn mr-3 no-print">Back</a>
                    </div>
                </div>

                <c:if test="${!empty successMessage}">
                    <div id="successMsg" class="fadeOutEffect alert alert-info" role="alert">
                        ${successMessage}
                    </div>
                </c:if>
                <c:if test="${!empty failureMessage}">
                    <div id="failureMsg" class="fadeOutEffect alert alert-danger" role="alert">
                        ${failureMessage}
                    </div>
                </c:if>


                <div class="content-top mb-0 d-flex align-items-center justify-content-between row my-3">
                    <div class="col-md-1 pr-md-1">
                        <select id="entriesPerPageCharger" class="select-input">
                            <option value="10">10</option>
                            <option value="25">25</option>
                            <option value="50">50</option>
                            <option value="100">100</option>
                            <option value="-1">ALL</option>
                        </select>
                    </div>
                    <div class="col-md-3 pl-md-1" >
                        <input id="searchBoxCharger" type="text" class="input-field" placeholder="Search here...">
                    </div>
                </div>

                <table id="noOfChargerTable" class="table table-striped bg-white" style="min-width: 100%;">

                    <thead>
                        <tr>
                            <th>Sr.No</th>                                     
                            <th style="min-width:190px;">Document No</th>       
                            <th style="min-width:190px;">PCS Name</th>           
                            <th style="min-width:190px;">No of Chargers</th>    
                            <th style="min-width:190px;">Project Name</th>      
                            <th style="min-width:190px;">Department</th>        
                            <th style="min-width:190px;">Date</th>              
                        </tr>
                    </thead>


                    <tbody>
                    </tbody>

                </table>        

            </section>
        </main>

        <script>
            $(document).ready(function () {

                if ($.fn.DataTable.isDataTable('#noOfChargerTable')) {
                    $('#noOfChargerTable').DataTable().destroy();
                }

                var noOfChargerTable = $('#noOfChargerTable').DataTable({
                    processing: true,
                    serverSide: true,
                    stateSave: false,
                    ordering: true,
                    orderMulti: false,
                    order: [[0, 'desc']],
                    ajax: {
                        url: 'formsCommon.htm?act=monthWiseClickNoOfChargerDetailsPaginationAjax',
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
                        {data: 'pcsName', orderable: true, searchable: true},
                        {data: 'noofchargers', orderable: true, searchable: true},
                        {data: 'projectName', orderable: true, searchable: true},
                        {data: 'department', orderable: true, searchable: true},
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

                $('#searchBoxCharger').on('keyup', function () {
                    noOfChargerTable.search(this.value).draw();
                });

                $('#entriesPerPageCharger').on('change', function () {
                    var val = $(this).val();

                    if (val === "" || val === "-1") {
                        var total = noOfChargerTable.page.info().recordsTotal;
                        noOfChargerTable.page.len(total > 0 ? total : 1).draw();
                    } else {
                        noOfChargerTable.page.len(parseInt(val, 10)).draw();
                    }
                });

                $('#Fromdate, #Todate, #Filter').on('change keyup', function () {
                    noOfChargerTable.ajax.reload(null, true);
                });
            });
        </script>

        <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
    </body>
</html>