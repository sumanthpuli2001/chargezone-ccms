$(document).ready(function () {
    const bootoast = window.Bootoast;

    const today = new Date();
    const nextMonth = new Date(today.getFullYear(), today.getMonth() + 1, today.getDate());

    // File Upload Drag & Drop Area
    let $fileUploadArea = $('#file-upload-area');
    let $fileInput = $('#fileInput1').length ? $('#fileInput1') : $('#fileInput');
    let $browseFile = $('#browseFile1').length ? $('#browseFile1') : $('#browseFile');

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
            $('#resultDiv, #resultDiv1, #importSubmitBtn').addClass('d-none');

            bootoast.toast({
                message: 'Please upload a valid CSV or Excel file.!',
                type: "error",
                ...options
            });

            return;
        }
        else {

            $('.modal-body.import-items').removeClass('blank');
            $('#resultDiv, #resultDiv1, #importSubmitBtn,#importSubmitBtn1 ').removeClass('d-none');

            bootoast.toast({
                message: `Uploaded file <br/> <span class="fw-500">${file.name}</span>`,
                type: "success",
                position: "top-center",
                ...options
            })
        }
    }

})