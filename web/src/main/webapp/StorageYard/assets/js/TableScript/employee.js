$(document).ready(function () {
    var table = $('#employeeTable').DataTable({
        "paging": true,
        "lengthChange": false,
        "searching": true,
        "info": true,
        "autoWidth": false,
        "ordering": true,
        scrollX: true,
        "columnDefs": [
            { "orderable": false, "targets": [0, -1] }
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

    // Global Search Box
    $('#searchBox').on('keyup', function () {
        table.search(this.value).draw();
    });

    // Department Filter (Multiple Select)
	
    $('#departmentFilter').on('change', function () {
        var selectedDepartments = $(this).val() || [];
		
        if (selectedDepartments.length) {
			
            table.column(5).search(selectedDepartments.join('|'), true, false).draw();
        } else {
            table.column(5).search('').draw();
        }
    });

    // Designation Filter (Multiple Select)
    $('#designationFilter').on('change', function () {
        var selectedDesignations = $(this).val() || [];
        if (selectedDesignations.length) {
            table.column(6).search(selectedDesignations.join('|'), true, false).draw();
        } else {
            table.column(6).search('').draw();
        }
    });

    // Role Filter (Multiple Select)
    $('#roleFilter').on('change', function () {
        var selectedRoles = $(this).val() || [];
        if (selectedRoles.length) {
            table.column(7).search(selectedRoles.join('|'), true, false).draw();
        } else {
            table.column(7).search('').draw();
        }
    });

    // Select All Checkbox
    $('#select_all').on('change', function () {
        $('.rowCheckbox').prop('checked', this.checked).trigger('change');
    });

    // Individual Row Checkbox
    $('#employeeTable tbody').on('change', '.rowCheckbox', function () {
        const anyChecked = $('.rowCheckbox:checked').length > 0;
        $('#deleteSelected').toggleClass('d-none', !anyChecked).toggleClass('', anyChecked);
        $('#select_all_pipeLine').prop('checked', $('.rowCheckbox:checked').length === $('.rowCheckbox').length);
    });

    // Delete Multiple Records
    $('#deleteSelected').on('click', function () {
        var selectedIds = [];
//        var $row = $(this).closest('tr');
        $('.rowCheckbox:checked').each(function () {
            var selectedId = $(this).val();  // Get the value from the checkbox
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
            ? 'Are you sure you want to delete this employee?'
            : `Are you sure you want to delete these ${selectedIds.length} employees?`;

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
                cancelButton: 'theme-btn light-btn'
            },
        }).then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                    url: 'employeeMaster.htm?act=disableEmployee&ids=' + selectedIds.join(','),
                    type: 'POST',
                    data: JSON.stringify({ ids: selectedIds }),
                    contentType: 'application/json',
                    success: function (response) {
                        Swal.fire({
                            icon: 'success',
                            title: 'Deleted!',
                            text: response.message
                        });
//                        window.location.href = 'employeeMaster.htm?act=showList';
                        $('#employeeTable').DataTable().rows(function (idx, data, node) {
                            return $(node).find('.rowCheckbox').is(':checked');
                        }).remove().draw();
                        $('#deleteSelected').addClass('d-none');
//                        table.rows('.rowCheckbox:checked').remove().draw();
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