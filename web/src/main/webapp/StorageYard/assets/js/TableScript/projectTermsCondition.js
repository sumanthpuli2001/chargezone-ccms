$(document).ready(function () {
    var table = $('#projectTermsCondition').DataTable({
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

    // Select All Checkbox
    $('#select_all').on('change', function () {
        $('.rowCheckbox').prop('checked', this.checked).trigger('change');
    });

    // Individual Row Checkbox
    $('#projectTermsCondition tbody').on('change', '.rowCheckbox', function () {
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


    });
});