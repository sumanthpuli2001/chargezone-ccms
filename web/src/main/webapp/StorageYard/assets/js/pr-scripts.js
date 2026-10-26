$(document).ready(function () {
    const bootoast = window.Bootoast;

    const today = new Date();
    const nextMonth = new Date(today.getFullYear(), today.getMonth() + 1, today.getDate());

    $("#pr_date").flatpickr({
        altInput: true,
        altFormat: "d-m-Y H:i",
        dateFormat: "Y-m-d H:i",
        enableTime: true,
        time_24hr: true,
        defaultDate: today
    });

    let filterDateOpt = {
        altInput: true,
        altFormat: "d-m-Y",
        dateFormat: "Y-m-d",
        allowInput: true,
    };

    $("#from_date").flatpickr({
        ...filterDateOpt,
        defaultDate: today,
    });

    $("#to_date").flatpickr({
        ...filterDateOpt,
        defaultDate: nextMonth,
    });


    // Common DataTable initializer
    function initTable(selector, obj = {}) {
        return $(selector).DataTable({
            paging: true,
            lengthChange: false,
            searching: true,
            info: true,
            autoWidth: false,
            ordering: true,
            scrollX: true,
            dom: 't<"table-bottom-info d-flex align-items-center justify-content-between pt-3"i p>',
            ...obj
        });
    }


    // Main PR Table logic
    if ($('#prTable').length) {
        let obj = {
            columnDefs: [
                { orderable: false, targets: [0, -1] }
            ],
            order: [[1, 'asc']],
        }

        let table = initTable('#prTable', obj);

        // Select all checkbox logic
        $('#select_all').on('change', function () {
            $('.rowCheckbox').prop('checked', this.checked).trigger('change');
        });

        // Individual row checkbox logic
        $('#prTable tbody').on('change', '.rowCheckbox', function () {
            const anyChecked = $('.rowCheckbox:checked').length > 0;
            $('#deleteSelected').toggleClass('d-none', !anyChecked).toggleClass('d-flex', anyChecked);

            $('#select_all').prop('checked', $('.rowCheckbox:checked').length === $('.rowCheckbox').length);
        });

        // Dropdown filters and search box
        $('.pr-listing #entriesPerPage').on('change', function () {
            table.page.len($(this).val()).draw();
        });

        $('.pr-listing #searchBox').on('keyup', function () {
            table.search(this.value).draw();
        });

        $('.pr-listing #from_date').on('change', function () {
            table.page.len($(this).val()).draw();
        });

        $('.pr-listing #to_date').on('change', function () {
            table.page.len($(this).val()).draw();
        });

        $('.pr-listing #categoryFilter').on('change', function () {
            table.page.len($(this).val()).draw();
        });

        $('.pr-listing #statusFilter').on('change', function () {
            table.page.len($(this).val()).draw();
        });

        $('#deleteSelected').on('click', function () {
            const selectedIds = [];

            $('.rowCheckbox:checked').each(function () {
                selectedIds.push($(this).data('id'));
            });

            if (selectedIds.length === 0) {
                return Swal.fire({
                    icon: 'warning',
                    title: 'No Selection',
                    text: 'Please select at least one row to delete.'
                });
            }

            const msg = selectedIds.length === 1
                ? 'Are you sure you want to delete this PR?'
                : `Are you sure you want to delete these ${selectedIds.length} PRs?`;

            const confirmText = selectedIds.length === 1
                ? 'Yes, delete it!'
                : 'Yes, delete them!';

            Swal.fire({
                title: msg,
                text: 'You will not be able to recover these records!',
                icon: 'warning',
                showCancelButton: true,
                confirmButtonText: confirmText,
                cancelButtonText: 'No, cancel',
                reverseButtons: true,
                customClass: {
                    confirmButton: 'confirm-delete',
                    cancelButton: 'theme-btn light-btn'
                },
            }).then((result) => {
                if (result.isConfirmed) {
                    $.ajax({
                        url: '/delete-pr',
                        type: 'POST',
                        data: JSON.stringify({ ids: selectedIds }),
                        contentType: 'application/json',
                        success: function (response) {
                            Swal.fire({
                                icon: 'success',
                                title: 'Deleted!',
                                text: response.message
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
    }

    // Items Table
    if ($('#itemsDetailsTable').length) {
        const table1 = initTable('#itemsDetailsTable');

        $('.items-details #entriesPerPage').on('change', function () {
            table1.page.len($(this).val()).draw();
        });

        $('.items-details #searchBox').on('keyup', function () {
            table1.search(this.value).draw();
        });
    }

    // Technical Docs Table
    if ($('#techDocumentsTable').length) {
        initTable('#techDocumentsTable');
    }

    // Approval History Table
    if ($('#approvalHistoryTable').length) {
        initTable('#approvalHistoryTable');
    }

    // Import Items Table
    if ($('#importItemsDetailsTable').length) {
        initTable('#importItemsDetailsTable');

        // Select all checkbox logic
        $('#select_all').on('change', function () {
            $('.rowCheckbox').prop('checked', this.checked).trigger('change');
        });

        // Individual row checkbox logic
        $('#importItemsDetailsTable tbody').on('change', '.rowCheckbox', function () {
            const anyChecked = $('.rowCheckbox:checked').length > 0;
            $('#deleteSelected').toggleClass('d-none', !anyChecked).toggleClass('d-flex', anyChecked);

            $('#select_all').prop('checked', $('.rowCheckbox:checked').length === $('.rowCheckbox').length);
        });

        $('#deleteSelected').on('click', function () {
            const selectedIds = [];

            $('.rowCheckbox:checked').each(function () {
                selectedIds.push($(this).data('id'));
            });

            if (selectedIds.length === 0) {
                return Swal.fire({
                    icon: 'warning',
                    title: 'No Selection',
                    text: 'Please select at least one row to delete.'
                });
            }

            const msg = selectedIds.length === 1
                ? 'Are you sure you want to delete this PR?'
                : `Are you sure you want to delete these ${selectedIds.length} PRs?`;

            const confirmText = selectedIds.length === 1
                ? 'Yes, delete it!'
                : 'Yes, delete them!';

            Swal.fire({
                title: msg,
                text: 'You will not be able to recover these records!',
                icon: 'warning',
                showCancelButton: true,
                confirmButtonText: confirmText,
                cancelButtonText: 'No, cancel',
                reverseButtons: true,
                customClass: {
                    confirmButton: 'confirm-delete',
                    cancelButton: 'theme-btn light-btn'
                },
            }).then((result) => {
                if (result.isConfirmed) {
                    $.ajax({
                        url: '/delete-pr',
                        type: 'POST',
                        data: JSON.stringify({ ids: selectedIds }),
                        contentType: 'application/json',
                        success: function (response) {
                            Swal.fire({
                                icon: 'success',
                                title: 'Deleted!',
                                text: response.message
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
    }

    // File Upload Drag & Drop Area
    let $fileUploadArea = $('#file-upload-area');
    let $fileInput = $('#fileInput');
    let $browseFile = $('#browseFile');

    let dragCounter = 0;

    $fileUploadArea.on('dragenter', function (e) {
        e.preventDefault();
        dragCounter++;
        $fileUploadArea.addClass('dragover');
    });

    $fileUploadArea.on('dragleave', function (e) {
        e.preventDefault();
        dragCounter--;
        if (dragCounter === 0) {
            $fileUploadArea.removeClass('dragover');
        }
    });

    $fileUploadArea.on('dragover', function (e) {
        e.preventDefault();
    });

    $fileUploadArea.on('drop', function (e) {
        e.preventDefault();
        dragCounter = 0;
        $fileUploadArea.removeClass('dragover');

        let file = e.originalEvent.dataTransfer.files[0];
        handleFile(file);
    });

    $browseFile.on('click', function () {
        $fileInput.click();
    });

    $fileInput.on('change', function () {
        let file = this.files[0];
        handleFile(file);
    });

    function handleFile(file) {
        let allowedTypes = [
            'text/csv',
            'application/vnd.ms-excel',
            'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'
        ];

        let options = {
            position: "top-center",
            timeout: 2.5,
            animationDuration: 250,
            dismissable: true
        }

        if (!allowedTypes.includes(file.type)) {
            $fileInput.val(''); // Clear file input

            $('.modal-body.import-items').addClass('blank');
            $('.importedDataTable, #importSubmitBtn').addClass('d-none');

            bootoast.toast({
                message: 'Please upload a valid CSV or Excel file.!',
                type: "error",
                ...options
            });

            return;
        }
        else {
            $('.modal-body.import-items').removeClass('blank');
            $('.importedDataTable, #importSubmitBtn').removeClass('d-none');

            bootoast.toast({
                message: `Uploaded file <br/> <span class="fw-500">${file.name}</span>`,
                type: "success",
                position: "top-center",
                ...options
            })
        }
    }

    
    window.setTimeout(function () {
        $(".alert-danger").fadeTo(500, 0).slideUp(500, function () {
            $(this).remove();
        });
    }, 11000);
    window.setTimeout(function () {
        $(".alert-info").fadeTo(500, 0).slideUp(500, function () {
            $(this).remove();
        });
    }, 8000);
    window.setTimeout(function () {
        $(".alert-warning").fadeTo(500, 0).slideUp(500, function () {
            $(this).remove();
        });
    }, 11000);
    window.setTimeout(function () {
        $(".alert-success").fadeTo(500, 0).slideUp(500, function () {
            $(this).remove();
        });
    }, 8000);
})