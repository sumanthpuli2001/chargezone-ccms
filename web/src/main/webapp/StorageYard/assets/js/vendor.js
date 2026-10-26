$(document).ready(function () {
  const bootoast = window.Bootoast;
  let $fileUploadArea = $("#file-upload-area");
  let $uploadedFileArea = $("#uploaded-file-area");
  let $fileInput = $("#fileInput");
  let $browseFile = $("#browseFile");
  let $resetFile = $("#resetFile");
  let dragCounter = 0;
  $fileUploadArea.on("dragenter", function (e) {
    e.preventDefault();
    dragCounter++;
    $fileUploadArea.addClass("dragover");
  });
  $fileUploadArea.on("dragleave", function (e) {
    e.preventDefault();
    dragCounter--;
    if (dragCounter === 0) {
      $fileUploadArea.removeClass("dragover");
    }
  });
  $fileUploadArea.on("dragover", function (e) {
    e.preventDefault();
  });
  $fileUploadArea.on("drop", function (e) {
    e.preventDefault();
    dragCounter = 0;
    $fileUploadArea.removeClass("dragover");
    let file = e.originalEvent.dataTransfer.files[0];
    handleFile(file);
  });
  $browseFile.on("click", function () {
    $fileInput.click();
  });
  $fileInput.on("change", function () {
    let file = this.files[0];
    handleFile(file);
  });
  function handleFile(file) {
    let allowedTypes = [
      "text/csv",
      "application/vnd.ms-excel",
      "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
    ];
    let options = {
      position: "top-center",
      timeout: 2.5,
      animationDuration: 250,
      dismissable: true,
    };

    if (!allowedTypes.includes(file.type)) {
      bootoast.toast({
        message: "Please upload a valid CSV or Excel file.!",
        type: "error",
        ...options,
      });
      $(".upload-file-cta").empty();
      return;
    } else {
      $fileUploadArea.removeClass("d-flex").addClass("d-none");
      $uploadedFileArea.removeClass("d-none").addClass("d-flex");
      $(".uploaded-file-name").empty().append(file.name);
      $(".upload-file-cta")
        .empty()
        .append(
          '<button type="button" class="btn theme-btn" onclick="document.getElementById(\'vendorForm\').action=\'vendor.htm?act=uploadVendorSubmit\'; document.getElementById(\'vendorForm\').submit();">Submit</button>'
        );
      $(".vendor-listing").addClass("defocus");
      bootoast.toast({
        message: `Uploaded file <br /> <span class = "fw-500"> ${file.name} </span>`,
        type: "success",
        position: "top-center",
        ...options,
      });
    }
  }

  // Reset logic added here
  $resetFile.on("click", function () {
    $fileInput.val(""); // Clear file input

    $uploadedFileArea.removeClass("d-flex").addClass("d-none");
    $fileUploadArea.removeClass("d-none").addClass("d-flex");
    $(".vendor-listing").removeClass("defocus");
    $(".uploaded-file-name").empty();
    $(".upload-file-cta").empty();
  });
  $('button[type="submit"]').on("click", function () {
    $(".vendor-listing").removeClass("defocus");
  });

  // DataTable Init
  var table = $("#vendorTable").DataTable({
    paging: true,
    lengthChange: false,
    searching: true,
    info: true,
    autoWidth: false,
    ordering: true,
    scrollX: true,
    columnDefs: [{ orderable: false, targets: [-1] }],
    order: [[0, "asc"]],
    dom: 't<"table-bottom-info d-flex align-items-center justify-content-between pt-3"i p>',
  });
  $(function () {
    table.page.len($("#entriesPerPage").val()).draw();
  });
  // Entries Per Page Control
  $("#entriesPerPage").on("change", function () {
    table.page.len($(this).val()).draw();
  });
  // Global Search Box
  $("#searchBox").on("keyup", function () {
    table.search(this.value).draw();
  });
  // Department Filter (Multiple Select)
  $("#typeFilter").on("change", function () {
    var selectedDepartments = $(this).val() || [];
    if (selectedDepartments.length) {
      table.column(5).search(selectedDepartments.join("|"), true, false).draw();
    } else {
      table.column(5).search("").draw();
    }
  });
});