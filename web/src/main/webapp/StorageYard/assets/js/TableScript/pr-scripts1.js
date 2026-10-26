$(document).ready(function () {
    const bootoast = window.Bootoast;

    const today = new Date();
    const nextMonth = new Date(today.getFullYear(), today.getMonth() + 1, today.getDate());

    // File Upload Drag & Drop Area
    let $fileUploadArea = $('#file-upload-area');
// This will select the first element that exists among the given IDs
    let $fileInput = $('#fileInput1, #pipeFileInput, #fileInput , #fileInput3');
    let $browseFile = $('#browseFile1,  #pipeBrowseFile, #browseFile, #browseFile3');

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

    let selectedFileInput = null;
    $('.browseFile').on('click', function () {
        const targetInput = $(this).data('target');
        selectedFileInput = $(targetInput);
        selectedFileInput.trigger('click');
    });
    
    $('.browseFile').each(function () {
        const targetInput = $(this).data('target');
        $(targetInput).on('change', function () {
            let file = this.files[0];
            if (file) {
                handleFile(file, $(this));
            }
        });
    });

//    $browseFile.on('click', function () {
//        $fileInput.click();
//    });

//    $('input[type="file"]').on('change', function () {
//        let file = this.files[0];
//        if (file) {
//            handleFile(file, $(this));
//        }
//    });

    function handleFile(file, $input) {
        if (!file) {
            return;
        }
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
            $fileInput.val('');

            $('.modal-body.import-items').addClass('blank');
            $('#resultDiv, #resultDiv1, #importSubmitBtn, #resultDivPipe, #importSubmitBtnpipe').addClass('d-none');

            bootoast.toast({
                message: 'Please upload a valid Excel file.!',
                type: "error",
                ...options
            });

            return;
        } else {

            $('.modal-body.import-items').removeClass('blank');
            $('#resultDiv, #resultDiv1, #importSubmitBtn, #importSubmitBtn1, #resultDivPipe, #importSubmitBtnpipe').removeClass('d-none');
            bootoast.toast({
                message: `Uploaded file <br/> <span class="fw-500">${file.name}</span>`,
                type: "success",
                position: "top-center",
                ...options
            })
        }
    }
    
    function initTable(selector, options = {}) {
        return $(selector).DataTable({
            paging: true,
            lengthChange: false,
            searching: true,
            info: true,
            autoWidth: false,
            ordering: true,
            scrollX: true,
            dom: 't<"table-bottom-info d-flex align-items-center justify-content-between pt-3"i p>',
            ...options
        });
    }
    
    let isDateFilterActive = false;


    //  PR date input
    $("#pr_date").flatpickr({
        altInput: true,
        altFormat: "d-m-Y H:i",
        dateFormat: "Y-m-d H:i",
        enableTime: true,
        time_24hr: true,
        defaultDate: today
    });
    const filterDateOpt = {
        altInput: true,
        altFormat: "d-m-Y",
        dateFormat: "Y-m-d",
        allowInput: true,
    };
    $("#from_date").flatpickr({
        ...filterDateOpt,
        defaultDate: today
    });
    $("#to_date").flatpickr({
        ...filterDateOpt,
        defaultDate: nextMonth
    });

    $.fn.dataTable.ext.search.push(function (settings, data, dataIndex) {
        const fromDateStr = $('#from_date').val();
        const toDateStr = $('#to_date').val();
        const rowDateStr = data[6];

        if (!isDateFilterActive || (!fromDateStr && !toDateStr)) return true;
        if (!rowDateStr) return false;
        const [datePart, timePart = '00:00:00'] = rowDateStr.trim().split(' ');
        const [day, month, year] = datePart.split('-').map(Number);
        const [hour, minute, second] = timePart.split(':').map(Number);
        const rowDate = new Date(year, month - 1, day, hour, minute, second);
        if (isNaN(rowDate.getTime())) return false;
        const fromDate = fromDateStr ? new Date(`${fromDateStr}T00:00:00`) : null;
        const toDate = toDateStr ? new Date(`${toDateStr}T23:59:59`) : null;
        if (fromDate && rowDate < fromDate) return false;
        if (toDate && rowDate > toDate) return false;
        return true;
    });


    if ($('#prTable').length) {
        let obj = {
            columnDefs: [
                { orderable: false, targets: [9] }
            ]
//            order: [[0, 'asc']],
        }

        let table = initTable('#prTable', obj);

        //$('#prTable').DataTable().columns.adjust().draw(false);
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

        $('#from_date, #to_date').on('change', function () {
            isDateFilterActive = true;
            table.draw();
        });

        $('.pr-listing #categoryFilter').on('change', function () {
            var selectedCategory = $(this).val() || [];

            if (selectedCategory.length) {

                table.column(3).search(selectedCategory.join('|'), true, false).draw();
            } else {
                table.column(3).search('').draw();
            }
        });

        $('.pr-listing #statusFilter').on('change', function () {
            var selectedStatus = $(this).val() || [];

            if (selectedStatus.length) {

                table.column(7).search(selectedStatus.join('|'), true, false).draw();
            } else {
                table.column(7).search('').draw();
            }
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
        setTimeout(insertMiddleScroll, 100);
        function insertMiddleScroll() {
            const dtScroll = $('#prTable').closest('.dt-scroll');
            const head = dtScroll.find('.dt-scroll-head');
            const headInner = head.find('.dt-scroll-headInner');
            const body = dtScroll.find('.dt-scroll-body');
            const foot = dtScroll.find('.dt-scroll-foot');

            if (!dtScroll.length || !body.length) return;

            if (!dtScroll.find('.middle-scrollbar').length) {
                $('<div class="middle-scrollbar"><div></div></div>').insertAfter(head);
            }

            const middleScroll = dtScroll.find('.middle-scrollbar');
            const inner = middleScroll.find('div');

            inner.width(body.get(0).scrollWidth);
            middleScroll.off('scroll');
            body.off('scroll');
            head.off('scroll');
            foot.off('scroll');

            function syncScroll(source, scrollLeft) {
                if (source !== 'middle') middleScroll.scrollLeft(scrollLeft);
                if (source !== 'body') body.scrollLeft(scrollLeft);
                if (source !== 'head') head.scrollLeft(scrollLeft);
                if (source !== 'foot') foot.scrollLeft(scrollLeft);
            }

            middleScroll.on('scroll', function() {
                syncScroll('middle', $(this).scrollLeft());
            });

            body.on('scroll', function() {
                syncScroll('body', $(this).scrollLeft());
            });

            head.on('scroll', function() {
                syncScroll('head', $(this).scrollLeft());
            });

            foot.on('scroll', function() {
                syncScroll('foot', $(this).scrollLeft());
            });
        }
    }

    if ($('#approvalHistoryTable').length) {
        initTable('#approvalHistoryTable');
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