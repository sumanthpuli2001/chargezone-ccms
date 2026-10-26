$(document).ready(function () {

    const today = new Date();
    const nextMonth = new Date(today.getFullYear(), today.getMonth() + 1, today.getDate());

    function initTable(selector, options = {}) {
        return $(selector).DataTable({
            paging: true,
            lengthChange: false,
            searching: true,
            info: true,
            autoWidth: true,
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
        const rowDateStr = data[3];

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


    if ($('#searchPRTb').length) {
        let obj = {
            columnDefs: [
                { orderable: false, targets: [5] }
            ],
            order: [[0, 'asc']],
        }

        let table = initTable('#searchPRTb', obj);

        //$('#searchPRTb').DataTable().columns.adjust().draw(false);

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


        $('.pr-listing #statusFilter').on('change', function () {
            var selectedStatus = $(this).val() || [];

            if (selectedStatus.length) {

                table.column(5).search(selectedStatus.join('|'), true, false).draw();
            } else {
                table.column(5).search('').draw();
            }
        });

    }
})
