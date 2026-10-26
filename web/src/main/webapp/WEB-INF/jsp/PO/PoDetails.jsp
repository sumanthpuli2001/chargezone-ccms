<%-- 
    Document   : PoDetails
    Created on : 29 Sep, 2026, 4:11:01 PM
    Author     : Admin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>PO Details List</title>
        <style>
            .table-card {
                background: #fff;
                border-radius: 10px;
                padding: 15px;
                box-shadow: 0 2px 10px rgba(0,0,0,0.05);
            } 

            .table-bottom-info {
                margin-top: 15px;
            }

            .input-field {
                height: 40px;
                border: 1px solid #cfd4dc;
                border-radius: 8px;
                padding: 5px 12px;
                width: 250px;
                outline: none;
            }

            .table-bottom-info {
                margin-top: 15px;
            }        
        </style>
    </head>

    <body>
        <main class="d-flex align-items-end justify-content-end">

            <%@include file="/WEB-INF/jsp/Common/NavbarNewVendor.jsp"%>
            <section class="main-content">
                <div class="content-top rounded-3 mb-3 d-flex align-items-center justify-content-between sticky-model0">
                    <div class="page-title d-flex align-items-center">
                        <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                            <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)" alt="Menu collapse">
                            <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)" alt="Menu collapse">
                        </div>
                        <h5 class="fw-600 mb-0">PO Details List</h5>
                    </div>


                </div>
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
                    <table id="poDetailsTable"
                           class="table table-striped bg-white"
                           style="width:100%">

                        <thead>
                            <tr>
                                <th>PO Number</th>
                                <th>Tender Number</th>
                                <th style="min-width:190px;">PO Date</th>
                                <th>PO Value</th>
                                <th>No of Document Attached</th>
                                <th>Status</th>
                                <th data-dt-order="disable">Action</th>
                            </tr>
                        </thead>

                        <tbody>
                        </tbody>

                    </table>
                </div>
            </section>
        </main>
    </body>
    <script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
    <script>
                                 $(document).ready(function () {

                                     var table = $('#poDetailsTable').DataTable({
                                         processing: true,
                                         serverSide: true,
                                         stateSave: false,
                                         ordering: true,
                                         orderMulti: false,
                                         aaSorting: [[0, 'asc']],
                                         ajax: {
                                             url: 'poDetails.htm?act=poDetailsPaginationAjax',
                                             type: 'POST',
                                             cache: false,
                                             error: function (xhr) {
                                                 console.log(xhr.responseText);
                                             }
                                         },
                                         columns: [
                                             {
                                                 data: 'poNo',
                                                 orderable: true,
                                                 searchable: true
                                             },
                                             {
                                                 data: 'tenderNo',
                                                 orderable: true,
                                                 searchable: true
                                             },
                                             {
                                                 data: 'poDate',
                                                 orderable: true,
                                                 searchable: true
                                             },
                                             {
                                                 data: 'poValue',
                                                 orderable: true,
                                                 searchable: true
                                             },
                                             {
                                                 data: 'noDocumentAttached',
                                                 orderable: true,
                                                 searchable: true
                                             },
                                             {
                                                 data: 'status',
                                                 orderable: true,
                                                 searchable: true
                                             },
                                             {
                                                 data: 'action',
                                                 orderable: false,
                                                 searchable: false,
                                                 className: 'text-center',
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


                                     // Search
                                     $('#searchBox').on('keyup', function () {
                                         table.search(this.value).draw();
                                     });


                                     // Entries per page
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
