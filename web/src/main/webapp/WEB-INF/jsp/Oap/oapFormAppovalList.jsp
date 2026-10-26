<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>OAP Form List</title>
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

                        <h5 class="fw-600 mb-0">OAP Form List</h5>
                    </div>

                    <!-- If No data available then Hide this button -->
                    <div class="cta d-flex align-items-center">
                        <button id="deleteSelected" class="btn theme-btn delete-btn d-none">
                            <img src="StorageYard/assets/images/delete-icon.svg" class="icon" onload="SVGInject(this)"
                                 alt="Delete Icon">
                            Delete Selected
                        </button>
                        <a onclick="window.location = 'oapForm.htm?act=oapForm'" class="btn theme-btn flex ml-3">
                            <img src="StorageYard/assets/images/plus.svg" onload="SVGInject(this)" class="mr-2 icon" alt="Plus Icon">
                            Add New
                        </a>
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
                    <table id="oapFormListTable" class="table table-striped bg-white" style="width:100%">
                        <thead>
                            <tr>
                                <th>Sr.No</th>
                                <th style="min-width: 190px;">Document No</th>
                                <th style="min-width: 190px;">Pcs Name</th>
                                <th style="min-width: 190px;">Project Name</th>
                                <th style="min-width: 190px;">Department</th>
                                <th style="min-width: 190px;">Date</th>
                                <th style="min-width: 190px;">Status</th>
                                <th class="text-center" style="min-width: 180px;">Actions</th>
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
            var table = $('#oapFormListTable').DataTable({
                processing: true,
                serverSide: true,
                stateSave: false,
                ordering: true,
                orderMulti: false, 
                order:       [[0, 'desc']],
                ajax: {
                    url: 'formsCommon.htm?act=oapFormListPaginationAjax',
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
                        data: 'projectName',
                        orderable: true,
                        searchable: true
                    },
                    {
                        data: 'department',
                        orderable: true,
                        searchable: true
                    },
                    {
                        data: 'createdDate',
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

            $(document).on('click', '.delete-btn1', function (e) {
                e.preventDefault();
                var id = $(this).data('id');
                Swal.fire({
                    title: 'Are you sure?',
                    text: 'Do you really want to delete this OAP Form Data?',
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonText: 'Yes Delete',
                    customClass: {
                        confirmButton: 'confirm-delete',  
                        cancelButton: 'theme-btn light-btn'
                    }
                }).then((result) => {
                    if (result.isConfirmed) {
                        $.ajax({
                            url: 'oapForm.htm?act=oapFormDelete',
                            type: 'POST',
                            data: {
                                id: id
                            },
                            success: function () {
                                Swal.fire({
                                    icon: 'success',
                                    title: 'Deleted',
                                    text: 'Record deleted successfully'
                                });
                                table.ajax.reload(null, false);
                            },
                            error: function (xhr) {
                                Swal.fire({
                                    icon: 'error',
                                    title: 'Error',
                                    text: 'Delete failed'
                                });
                            }
                        });
                    }
                });
            });

        });
    </script>
    <script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>

</html>
