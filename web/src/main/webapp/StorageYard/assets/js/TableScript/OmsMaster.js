$(document).ready(function () {
    var table = $('#OmsTable').DataTable({
        "paging": true,
        "lengthChange": false,
        "searching": true,
        "info": true,
        "autoWidth": false,
        "ordering": true,
        "scrollX": true,
        "dom": 't<"table-bottom-info d-flex align-items-center justify-content-between pt-3"i p>'
    });

    $(function () {
        table.page.len($('#entriesPerPage').val()).draw();
    });

    $('#entriesPerPage').on('change', function () {
        table.page.len($(this).val()).draw();
    });

    $('#searchBox').on('keyup', function () {
        table.search(this.value).draw();
    });
	

    $('#select_all').on('change', function () {
        var rows = table.rows({ search: 'applied' });
        var rowNodes = rows.nodes();
        var totalRows = rows.count();

        if (totalRows === 0) {
            $('#deleteSelected').addClass('d-none');
            return;
        }
        $('input.rowCheckbox', rowNodes).prop('checked', this.checked);
        $('#deleteSelected').toggleClass('d-none', !this.checked);
    });

    $('#OmsTable tbody').on('change', '.rowCheckbox', function () {
        var totalRows = table.rows({ search: 'applied' }).nodes().length;
        var checkedRows = table.rows().nodes().to$().find('.rowCheckbox:checked').length;

        $('#deleteSelected').toggleClass('d-none', checkedRows === 0);
        $('#select_all').prop('checked', checkedRows === totalRows);
    });

    $('#deleteSelected').on('click', function () {
        var selectedIds = [];
        table.rows().nodes().to$().find('.rowCheckbox:checked').each(function () {
            selectedIds.push($(this).val());
        });

        if (selectedIds.length === 0) {
            Swal.fire({
                icon: 'warning',
                title: 'No Selection',
                text: 'Please select at least one row to delete.'
            });
            return;
        }

        var id = selectedIds.join(',');
        const message = selectedIds.length === 1
            ? 'Are you sure you want to delete this record?'
            : `Are you sure you want to delete these ${selectedIds.length} records?`;

        Swal.fire({
            title: message,
            text: 'You will not be able to recover these records!',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: 'Yes, delete!',
            cancelButtonText: 'Cancel',
            reverseButtons: true,
            customClass: {
                confirmButton: 'confirm-delete',
                cancelButton: 'theme-btn light-btn'
            }
        }).then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                    url: 'omsMaster.htm?act=deleteMultipleOms' ,
                    type: 'POST',
                    data: {
                        ids:id 
                    },
                    success: function (data) {
                        if (data.status === 'success') {
                            Swal.fire({
                                icon: 'success',
                                title: 'Deleted!',
                                text: data.message
                            });
                            $('#OmsTable').DataTable().rows(function (idx, data, node) {
                                    return $(node).find('.rowCheckbox').is(':checked');
                                }).remove().draw();
                            $('#deleteSelected').addClass('d-none');
                        } else if (data.status === 'error') {
                            Swal.fire({
                                icon: 'error',
                                title: 'Error!',
                                text: data.message
                            });
                        } else {
                            Swal.fire({
                                icon: 'warning',
                                title: 'Unexpected response',
                                text: 'Please try again.'
                            });
                        }
                    },

                    error: function (xhr, status, error) {
                        Swal.fire({
                            icon: 'error',
                            title: 'Server Error',
                            text: 'Could not delete records. Please try again.'
                        });
                    }
                });
            }
        });
    });
});

