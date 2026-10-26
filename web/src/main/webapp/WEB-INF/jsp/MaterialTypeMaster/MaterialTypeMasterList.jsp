<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

<head>
    <title>Material List</title>
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

        <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
        <section class="main-content">
            <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                <div class="page-title d-flex align-items-center">
                    <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                        <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)" alt="Menu collapse">
                        <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)" alt="Menu collapse">
                    </div>
                    <h5 class="fw-600 mb-0">Material Type List</h5>
                </div>

                <div class="cta d-flex align-items-center">

                    <button id="deleteSelected" class="btn theme-btn delete-btn d-none">
                        <img src="StorageYard/assets/images/delete-icon.svg" class="icon mr-1" onload="SVGInject(this)" alt="Delete Icon">
                        Delete Selected
                    </button>

                    <a onclick="window.location='materialTypeMaster.htm?act=showList'"class="btn theme-btn flex ml-3">
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
                <table id="typeTable" class="table table-striped bg-white" style="width:100%">
                    <thead>
                        <tr>
                            <th class="text-center">
                                <input type="checkbox" name="select_all_rows" id="select_all">
                            </th>
                            <th>Sr.No.</th>
                            <th>Material Type </th>
                            <th>View/Edit</th>
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

    var table = $('#typeTable').DataTable({
        processing: true,
        serverSide: true,
        stateSave: false,
        ordering: true,
        orderMulti: false,
        aaSorting: [[1, 'asc']],
        columnDefs: [
            {
                targets: [2],
                orderSequence: ["asc", "desc"]
            }
        ],
        ajax: {
            url: 'materialTypeMaster.htm?act=materialTypePaginationAjax',
            type: 'POST',
            cache: false,
            error: function (xhr) {
                console.log(xhr.responseText);
            }
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
                orderable: true,
                searchable: true
            },
            {
                data: 'materialType',
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

    $(document).on(
        'change',
        '#select_all',
        function () {
            $('.rowCheckbox').prop('checked', this.checked);
            toggleDeleteButton();
        });

    $(document).on(
        'change',
        '.rowCheckbox',
        function () {
            toggleDeleteButton();
            if ($('.rowCheckbox:checked').length === $('.rowCheckbox').length) {
                $('#select_all').prop(
                    'checked',
                    true
                );
            } else {
                $('#select_all').prop(
                    'checked',
                    false
                );
            }
        });

    function toggleDeleteButton() {
        if ($('.rowCheckbox:checked').length > 0) {
            $('#deleteSelected')
                .removeClass('d-none')
                .addClass('d-flex');
        } else {
            $('#deleteSelected')
                .addClass('d-none')
                .removeClass('d-flex');

        }

    }

   $(document).on('click', '.delete-btn1', function (e) {
    e.preventDefault();

    var id = $(this).data('id');

    Swal.fire({
        title: 'Are you sure?',
        text: 'Do you really want to delete this material type master?',
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
                url: 'materialTypeMaster.htm?act=deleteSubmit',
                type: 'POST',
                data: {
                    id: id
                },

                success: function (response) {

                    Swal.fire({
                        icon: 'success',
                        title: 'Deleted',
                        text: 'Record deleted successfully'
                    });

                    table.ajax.reload(null, false);
                },

                error: function (xhr, status, error) {

                    console.log(xhr.responseText);

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

      $(document).on(
        'click',
        '#deleteSelected',
        function () {
            var selectedIds = [];
            $('.rowCheckbox:checked').each(function () {
                selectedIds.push(
                    $(this).val()
                );
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
                text: 'Delete selected Material ?',
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
                        url: 'materialTypeMaster.htm?act=deleteAll',
                        type: 'POST',
                        data: {
                            ids: selectedIds.join(',')
                        },
                        success: function () {
                            Swal.fire({
                                icon: 'success',
                                title: 'Deleted',
                                text: 'Material  deleted successfully'
                            });
                            table.ajax.reload(null, false);
                            $('#deleteSelected')
                                .addClass('d-none')
                                .removeClass('d-flex');
                            $('#select_all').prop(
                                'checked',
                                false
                            );
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