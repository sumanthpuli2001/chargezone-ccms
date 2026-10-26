function initTable(selector, obj = {}) {
  return $(selector).DataTable({
    paging: false,
    lengthChange: false,
    searching: false,
    info: false,
    autoWidth: true,
    ordering: false,
    scrollX: false,
    dom: 't<"table-bottom-info d-flex align-items-center justify-content-between pt-3"i p>',
    ...obj,
  });
}

if ($("#commonDocTable").length) {
  const table1 = initTable("#commonDocTable");
}

if ($("#commonDocTable0").length) {
  const table1 = initTable("#commonDocTable0");
}

if ($("#commonDocTable1").length) {
  const table1 = initTable("#commonDocTable1");
}

if ($("#commonDocTable2").length) {
  const table1 = initTable("#commonDocTable2");
}

if ($("#commonDocTable3").length) {
  const table1 = initTable("#commonDocTable3");
}

if ($("#commonDocTable4").length) {
  const table1 = initTable("#commonDocTable4");
}

function initClassTable(selector, obj = {}) {
    return $(selector).DataTable({
        paging: false,
        lengthChange: false,
        searching: false,
        info: false,
        autoWidth: true,
        ordering: false,
        scrollX: true,
        dom: 't<"table-bottom-info d-flex align-items-center justify-content-between pt-3"i p>',
        ...obj,
    });
}

$(document).ready(function () {
    $('.myTable').each(function () {
        initClassTable(this);
    });
});
function initClassTableNoSorting(selector, obj = {}) {
    return $(selector).DataTable({
        paging: false,
        lengthChange: false,
        searching: false,
        info: false,
        autoWidth: true,
        ordering: false,
        scrollX: false,
//        sorting: false,
        dom: 't<"table-bottom-info d-flex align-items-center justify-content-between pt-3"i p>',
        ...obj,
    });
}

$(document).ready(function () {
    $('.myTableNoSorting').each(function () {
        initClassTableNoSorting(this);
    });
});

