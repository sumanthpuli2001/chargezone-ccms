function initNoPageTable(selector, obj = {}) {
  return $(selector).DataTable({
    paging: false,
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



if ($("#commonNoPageTable").length) {
  const table1 = initNoPageTable("#commonNoPageTable");
  $("#entriesPerPage").on("change", function () {
    table1.page.len($(this).val()).draw();
  });
  $("#searchBox").on("keyup", function () {
    table1.search(this.value).draw();
  });
}

if ($("#commonNoPageTable0").length) {
  const table1 = initNoPageTable("#commonNoPageTable0");
  $("#entriesPerPage0").on("change", function () {
    table1.page.len($(this).val()).draw();
  });
  $("#searchBox0").on("keyup", function () {
    table1.search(this.value).draw();
  });
}

if ($("#commonNoPageTable1").length) {
  const table1 = initNoPageTable("#commonNoPageTable1");
  $("#entriesPerPage1").on("change", function () {
    table1.page.len($(this).val()).draw();
  });
  $("#searchBox1").on("keyup", function () {
    table1.search(this.value).draw();
  });
}

if ($("#commonNoPageTable2").length) {
  const table1 = initNoPageTable("#commonNoPageTable2");
  $("#entriesPerPage2").on("change", function () {
    table1.page.len($(this).val()).draw();
  });
  $("#searchBox2").on("keyup", function () {
    table1.search(this.value).draw();
  });
}

if ($("#commonNoPageTable3").length) {
  const table1 = initNoPageTable("#commonNoPageTable3");
  $("#entriesPerPage3").on("change", function () {
    table1.page.len($(this).val()).draw();
  });
  $("#searchBox3").on("keyup", function () {
    table1.search(this.value).draw();
  });
}

if ($("#commonNoPageTable4").length) {
  const table1 = initNoPageTable("#commonNoPageTable4");
  $("#entriesPerPage4").on("change", function () {
    table1.page.len($(this).val()).draw();
  });
  $("#searchBox4").on("keyup", function () {
    table1.search(this.value).draw();
  });
}

if ($("#commonNoPageTable5").length) {
  const table1 = initNoPageTable("#commonNoPageTable5");
  $("#entriesPerPage5").on("change", function () {
    table1.page.len($(this).val()).draw();
  });
  $("#searchBox5").on("keyup", function () {
    table1.search(this.value).draw();
  });
}

if ($("#commonNoPageTable6").length) {
  const table1 = initNoPageTable("#commonNoPageTable6");
  $("#entriesPerPage6").on("change", function () {
    table1.page.len($(this).val()).draw();
  });
  $("#searchBox6").on("keyup", function () {
    table1.search(this.value).draw();
  });
}

if ($("#commonNoPageTable7").length) {
  const table1 = initNoPageTable("#commonNoPageTable7");
  $("#entriesPerPage7").on("change", function () {
    table1.page.len($(this).val()).draw();
  });
  $("#searchBox7").on("keyup", function () {
    table1.search(this.value).draw();
  });
}
if ($("#commonNoPageTable8").length) {
  let obj = {
    columnDefs: [
      { orderable: false, targets: [0] } 
    ],
    order: [[1, 'asc']] 
  };

  const table1 = initNoPageTable("#commonNoPageTable8", obj);

  $("#entriesPerPage8").on("change", function () {
    table1.page.len($(this).val()).draw();
  });

  $("#searchBox8").on("keyup", function () {
    table1.search(this.value).draw();
  });
}

if ($("#commonNoPageTable9").length) {
  const table1 = initNoPageTable("#commonNoPageTable9");
  $("#entriesPerPage9").on("change", function () {
    table1.page.len($(this).val()).draw();
  });
  $("#searchBox9").on("keyup", function () {
    table1.search(this.value).draw();
  });
}
if ($("#commonNoPageTable10").length) {
  const table1 = initNoPageTable("#commonNoPageTable10");
  $("#entriesPerPage10").on("change", function () {
    table1.page.len($(this).val()).draw();
  });
  $("#searchBox10").on("keyup", function () {
    table1.search(this.value).draw();
  });
}