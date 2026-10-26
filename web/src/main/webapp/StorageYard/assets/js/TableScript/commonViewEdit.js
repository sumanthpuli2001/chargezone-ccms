$(document).ready(function () {

    var table = $('#viewEditTable').DataTable({
        "paging": true,
        "lengthChange": false,
        "searching": true,
        "info": true,
        "ordering": true,
        scrollX: true,
        "columnDefs": [
            {"orderable": false, "targets": [5]}
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

});