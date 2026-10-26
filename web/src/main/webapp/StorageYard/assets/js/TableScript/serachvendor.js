$(document).ready(function () {
   
    var table = $('#searchvendor').DataTable({
        "paging": true,
        "lengthChange": false,
        "searching": true,
        "info": true,
//        "autoWidth": false,
        "ordering": true,
        scrollX: true,
        "columnDefs": [
            { "orderable": false, "targets": [6] }
        ],
        "order": [[1, 'asc']],
        "dom": 't<"table-bottom-info d-flex align-items-center justify-content-between pt-3"i p>'
        
    });
   

    $(function () {
        table.page.len($('#entriesPerPage').val()).draw();
          
    });

    // Entries Per Page Control
    $('#entriesPerPage').on('change', function () {
        table.page.len($(this).val()).draw();
    });
    
 $('#typeFilter').on('change', function () {
        var selectedDepartments = $(this).val() || [];
        if (selectedDepartments.length) {
            table.column(4).search(selectedDepartments.join('|'), true, false).draw();
        } else {
            table.column(4).search('').draw();
        }
    });	
    
    // Global Search Box
    $('#searchBox').on('keyup', function () {
        table.search(this.value).draw();
    });

    // Select All Checkbox
    $('#select_all').on('change', function () {
        $('.rowCheckbox').prop('checked', this.checked).trigger('change');
    });

    // Individual Row Checkbox
    $('#serachvendor tbody').on('change', '.rowCheckbox', function () {
        if ($('.rowCheckbox:checked').length > 0) {
            $('#deleteSelected').removeClass('d-none').addClass('d-flex');
        } else {
            $('#deleteSelected').addClass('d-none').removeClass('d-flex');
        }

        if ($('.rowCheckbox:checked').length === $('.rowCheckbox').length) {
            $('#select_all').prop('checked', true);
        } else {
            $('#select_all').prop('checked', false);
        }
    });


    // Delete Multiple Records
    $('#deleteSelected').on('click', function () {
        var selectedIds = [];

        $('.rowCheckbox:checked').each(function () {
           
           var selectedId = $(this).val();  // Get the value from the checkbox\
           
    selectedIds.push(selectedId);
    
        });

        if (selectedIds.length === 0) {
            Swal.fire({
                icon: 'warning',
                title: 'No Selection',
                text: 'Please select at least one row to delete.'
            });
            return;
        }
	

        // Set dynamic messages based on selection
       
        const message = selectedIds.length === 1
            ? 'Are you sure you want to delete this department?'
            : `Are you sure you want to delete these ${selectedIds.length} departments?`;

        const confirmButtonText = selectedIds.length === 1
            ? 'Yes, delete it!'
            : `Yes, delete them!`;

        Swal.fire({
            title: message,
            text: 'You will not be able to recover these records!',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: confirmButtonText,
            cancelButtonText: 'No, cancel',
            reverseButtons: true,
            customClass: {
                confirmButton: 'confirm-delete',
                cancelButton: 'cancel-action'
            },
        }).then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                    url: '.htm?act==' + selectedIds.join(','),
                    type: 'POST',
                    data: JSON.stringify({ ids: selectedIds }),
                    contentType: 'application/json',
                    success: function (response) {
                        Swal.fire({
                            icon: 'success',
                            title: 'Deleted!',
                            text: response.message
                        }).then(() => {
                   window.location.href = 'employeeMaster.htm?act=showDepartmentList';  // Refresh the list page after "OK"
                });
                        table.rows('.rowCheckbox:checked').remove().draw();
                    },
                    error: function (xhr) {
                        Swal.fire({
                            icon: 'error',
                            title: 'Error!',
                            text: 'Error deleting records: ' + xhr.responseText
                        });
                    }
                });
				
            }
        });
    });
});