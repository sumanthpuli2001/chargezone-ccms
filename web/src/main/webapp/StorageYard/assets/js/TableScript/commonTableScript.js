// Common DataTable initializer
function initTable(selector, obj = {}) {
  return $(selector).DataTable({
    paging: true,
    lengthChange: false,
    searching: true,
    info: true,
    autoWidth: true,
    ordering: true,
    scrollX: true,
    dom: 't<"table-bottom-info d-flex align-items-center justify-content-between pt-3"i p>',
    ...obj,
  });
}

if ($("#commonTable").length) {
  const table1 = initTable("#commonTable");
  $("#entriesPerPage").on("change", function () {
    table1.page.len($(this).val()).draw();
  });
  $("#searchBox").on("keyup", function () {
    table1.search(this.value).draw();
  });
}

if ($("#commonTable0").length) {
  const table1 = initTable("#commonTable0");
  $("#entriesPerPage0").on("change", function () {
    table1.page.len($(this).val()).draw();
  });
  $("#searchBox0").on("keyup", function () {
    table1.search(this.value).draw();
  });
}

if ($("#commonTable1").length) {
  const table1 = initTable("#commonTable1");
  $("#entriesPerPage1").on("change", function () {
    table1.page.len($(this).val()).draw();
  });
  $("#searchBox1").on("keyup", function () {
    table1.search(this.value).draw();
  });
}

if ($("#commonTable2").length) {
  const table1 = initTable("#commonTable2");
  $("#entriesPerPage2").on("change", function () {
    table1.page.len($(this).val()).draw();
  });
  $("#searchBox2").on("keyup", function () {
    table1.search(this.value).draw();
  });
}

if ($("#commonTable3").length) {
  const table1 = initTable("#commonTable3");
  $("#entriesPerPage3").on("change", function () {
    table1.page.len($(this).val()).draw();
  });
  $("#searchBox3").on("keyup", function () {
    table1.search(this.value).draw();
  });
}

if ($("#commonTable4").length) {
  const table1 = initTable("#commonTable4");
  $("#entriesPerPage4").on("change", function () {
    table1.page.len($(this).val()).draw();
  });
  $("#searchBox4").on("keyup", function () {
    table1.search(this.value).draw();
  });
}

if ($("#commonTable5").length) {
  const table1 = initTable("#commonTable5");
  $("#entriesPerPage5").on("change", function () {
    table1.page.len($(this).val()).draw();
  });
  $("#searchBox5").on("keyup", function () {
    table1.search(this.value).draw();
  });
}

if ($("#commonTable6").length) {
  const table1 = initTable("#commonTable6");
  $("#entriesPerPage6").on("change", function () {
    table1.page.len($(this).val()).draw();
  });
  $("#searchBox6").on("keyup", function () {
    table1.search(this.value).draw();
  });
}

if ($("#commonTable7").length) {
  const table1 = initTable("#commonTable7");
  $("#entriesPerPage7").on("change", function () {
    table1.page.len($(this).val()).draw();
  });
  $("#searchBox7").on("keyup", function () {
    table1.search(this.value).draw();
  });
}
if ($("#commonTable8").length) {
  let obj = {
    columnDefs: [
      { orderable: false, targets: [0] } 
    ],
    order: [[1, 'asc']] 
  };

  const table1 = initTable("#commonTable8", obj);

  $("#entriesPerPage8").on("change", function () {
    table1.page.len($(this).val()).draw();
  });

  $("#searchBox8").on("keyup", function () {
    table1.search(this.value).draw();
  });
}

if ($("#commonTable9").length) {
  const table1 = initTable("#commonTable9");
  $("#entriesPerPage9").on("change", function () {
    table1.page.len($(this).val()).draw();
  });
  $("#searchBox9").on("keyup", function () {
    table1.search(this.value).draw();
  });
}
if ($("#commonTable10").length) {
  const table1 = initTable("#commonTable10");
  $("#entriesPerPage10").on("change", function () {
    table1.page.len($(this).val()).draw();
  });
  $("#searchBox10").on("keyup", function () {
    table1.search(this.value).draw();
  });
}