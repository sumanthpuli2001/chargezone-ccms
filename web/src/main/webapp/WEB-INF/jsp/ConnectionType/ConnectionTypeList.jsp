<%-- 
    Document   : ShowDepartmentList
    Created on : 2 Jan, 2024, 6:01:06 PM
    Author     : Bulwark-5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>Connection Type List</title>
    </head>
    
    <body>
        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

            <section class="main-content">
                <div class="card-box rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                    <div class="page-title d-flex align-items-center">
                        <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                            <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                 alt="Menu collapse">
                            <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                 alt="Menu collapse">
                        </div>

                        <h5 class="fw-600 mb-0">Connection Type List</h5>
                    </div>

                    <!-- If No data available then Hide this button -->
                    <div class="cta d-flex align-items-center">
                        <button id="deleteSelected" class="btn theme-btn delete-btn d-none">
                            <img src="StorageYard/assets/images/delete-icon.svg" class="icon" onload="SVGInject(this)"
                                 alt="Delete Icon">
                            Delete Selected
                        </button>
                        <a href="connectionType.htm?act=ConnectionTypeCreate" class="btn theme-btn flex ml-3">
                            <img src="StorageYard/assets/images/plus.svg" onload="SVGInject(this)" class="mr-2 icon" alt="Plus Icon">
                            Add New
                        </a>
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
                <hr>

                <%@include file="/WEB-INF/jsp/Common/TablePageNew.jsp"%>
                <div class="bg-white card-full-h">
                    <table id="ConnectionTypeTable" class="table table-striped" style="width:100%">

                        <thead>
                            <tr>
                                <th class="text-center">
                                    <input type="checkbox" name="select_all_rows" id="select_all">
                                </th>
                                <th>Sr.No</th>
                                <th>Connection Type</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                    </table>
                </div>

            </section>
        </main> 
    </body>

    <script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>

    <script>
        $(document).ready(function () {
            var table = $('#ConnectionTypeTable').DataTable({
                processing: true,
                serverSide: true,
                stateSave: false,
                ordering: true,
                orderMulti: false,
                aaSorting: [[1, 'asc']],

                ajax: {
                    url: 'connectionType.htm?act=connectionTypeMasterAjax',
                    type: 'POST',
                    cache: false
                },

                columns: [
                    {
                        data: 'checkbox',
                        orderable: false,
                        searchable: false,
                        className: 'text-center',
                        render: function (data) {
                            return data;
                        }
                    },
                    {
                        data: 'srNo',                
                    },
                    {
                        data: 'connectionType',
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

            $(document).on( 'change', '#select_all', function () {
                $('.rowCheckbox').prop('checked', this.checked);
                toggleDeleteButton();
            });

            $(document).on( 'change', '.rowCheckbox', function () {
                toggleDeleteButton();
                if ($('.rowCheckbox:checked').length === $('.rowCheckbox').length) {
                    $('#select_all').prop('checked', true);
                } else {
                    $('#select_all').prop('checked', false);
                }
            });

            function toggleDeleteButton() {
                if ($('.rowCheckbox:checked').length > 0) {
                    $('#deleteSelected').removeClass('d-none').addClass('d-flex');
                } else {
                    $('#deleteSelected').addClass('d-none').removeClass('d-flex');
                }
            }

            $(document).on('click','.delete-btn1',function (e) {
                e.preventDefault();
                var id = $(this).data('id');
                Swal.fire({
                    title: 'Are you sure?',
                    text: 'Do you really want to delete this Connection Type ?',
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonText: 'Yes Delete',
                    customClass:{
                        comfirmButton: 'confirm-delete',
                        cancelButton: 'theme-btn light-btn'
                    }
                }).then((result) => {
                    if (result.isConfirmed) {
                        $.ajax({
                            url: 'connectionType.htm?act=deleteConnectionById',
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

            $(document).on('click', '#deleteSelected', function () {
                var selectedIds = [];
                $('.rowCheckbox:checked').each(function () {
                    selectedIds.push($(this).val());
                });

                if (selectedIds.length === 0) {
                    Swal.fire({
                        icon: 'warning',
                        title: 'No Selection',
                        text: 'Please select at least one row.'
                    });
                    return;
                }

                Swal.fire({
                    title: 'Are you sure?',
                    text: 'Delete selected records?',
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonText: 'Yes Delete',
                    customClass:{
                        comfirmButton: 'confirm-delete',
                        cancelButton: 'theme-btn light-btn'
                    }
                }).then((result) => {
                    if (result.isConfirmed) {
                        $.ajax({
                            url: 'connectionType.htm?act=deleteConnectionTypeList',
                            type: 'POST',
                            data: {
                                ids: selectedIds.join(',')
                            },
                            success: function () {
                                Swal.fire({
                                    icon: 'success',
                                    title: 'Deleted',
                                    text: 'Records deleted successfully'
                                });
                                table.ajax.reload(null, false);
                                $('#deleteSelected').addClass('d-none').removeClass('d-flex');
                                $('#select_all').prop('checked',false);
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



</html>


