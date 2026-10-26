<%-- 
    Document   : NewUIFooter
    Created on : Jul 4, 2025, 3:59:50 PM
    Author     : Sumanth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--Test Text-->
<!-- Js -->
<script src="StorageYard/assets/js/TableScript/commonDocTableScript.js" ></script>
<script src="StorageYard/assets/js/TableScript/commonTableScript.js"></script>
<script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>
<script src="StorageYard/assets/js/TableScript/commonNoPageScript.js" type="text/javascript"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" rel="stylesheet">  
</head>


<!--<script src="./departments.js"></script>-->
<%-- Below script is for text Area Charecter Limit--%>
<script>
    function updateCharCount(textarea, counter) {
        const maxLength = parseInt(textarea.getAttribute('maxlength'), 10);
        const currentLength = textarea.value.length;
        const remaining = maxLength - currentLength;
        counter.textContent = currentLength;
        textarea.classList.toggle('limit-reached', remaining === 0);
        if (remaining <= 20) {
            counter.classList.add('text-danger');
        } else {
            counter.classList.remove('text-danger');
        }
    }

    document.querySelectorAll('.comment-box').forEach(box => {
        const textarea = box.querySelector('.comment');
        const counter = box.querySelector('.charCount');
        updateCharCount(textarea, counter);
        textarea.addEventListener('input', () => {
            updateCharCount(textarea, counter);
        });
    });
</script>

 <style>
    .custom-table,
    .custom-table th,
    .custom-table td {
        border: 1px solid black !important;
    }
    .custom-table td{
        max-width: 200px; 
        word-break: break-all !important; 
        overflow-wrap: break-word !important;
        white-space: normal
    }
</style>
        
<style>
    .sticky { 
        position: sticky; 
        top: -21px;
        z-index: 9; 
        background: #ffffff;
        padding: 10px 20px;
        border-bottom: 1px solid #ddd;
        box-shadow: 0 2px 5px rgba(0,0,0,0.08);
    }      

    .sticky-model { 
        position: sticky; 
        top: -18px;
        z-index: 9; 
        background: #ffffff;
        padding: 10px 20px;
        border-bottom: 1px solid #ddd;
        box-shadow: 0 2px 5px rgba(0,0,0,0.08);
    }   

    .sticky-model0 {
        position: sticky;
        top: -21px;
        z-index: 30;
        background: #fff;
        padding: 10px 20px;
        border-bottom: 1px solid #ddd;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.08);
    }

    .sticky-model1 {
        position: sticky;
        top: 30px;
        z-index: 20;
        background: #fff;
        padding: 10px 20px;
        border-bottom: 1px solid #ddd;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.08);
    }

    .sticky-model2 {
        position: sticky;
        top: 70px;
        z-index: 10;
        background: #fff;
        padding: 10px 20px;
        border-bottom: 1px solid #ddd;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.08);
    }
</style>
        
        
<script>
                if ($('#listCommonSearch').length) {
        const table = initTable('#listCommonSearch')
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
                // Select All Checkbox
                $('#select_all').on('change', function () {
        $('.rowCheckbox').prop('checked', this.checked).trigger('change');
        });
                // Individual Row Checkbox
                $('#CommonTable tbody').on('change', '.rowCheckbox', function () {
        if ($('.rowCheckbox:checked').length > 0) {
        $('#deleteSelected').removeClass('d-none').addClass('d-flex');
        } else {
        $('#deleteSelected').addClass('d-none').removeClass('d-flex');
        }

        if ($('.rowCheckbox:checked').length === $('.rowCheckbox').length) {
        $('#select_all').prop('checked', true);
        } else {
        $('#select_all').prop('checked', false);
        }
        });
                // Delete Multiple Records
                $('#deleteSelected').on('click', function () {
        var selectedIds = [];
                $('.rowCheckbox:checked').each(function () {
        var selectedId = $(this).val(); // Get the value from the checkbox
                selectedIds.push(selectedId);
        });
                if (selectedIds.length === 0) {
        Swal.fire({
        icon: 'warning',
                title: 'No Selection',
                text: 'Please select at least one row to delete.'
        });
                return;
        }        
        });
        };
    </script>
    <script>
  document.querySelectorAll('.riskCategory').forEach(function(td) {
    let text = td.textContent.trim();
    if (text) {
      td.textContent = text.charAt(0).toUpperCase() + text.slice(1);
    }
  });
</script>
<script>
    function formatCurrency(value) {
        if (!value) return value;

        let cleanValue = value.replace(/[₹,\s]/g, '');

        let num = parseFloat(cleanValue);
        if (isNaN(num)) return value;

        return "₹ " + num.toFixed(2);
    }

    window.onload = function() {
        document.querySelectorAll('.format-2dec').forEach(function(el) {
            el.textContent = formatCurrency(el.textContent);
        });
    };
</script>
<style>
    .terms-details {
        font-family: 'Poppins', Verdana, Geneva, Tahoma, sans-serif;
        /*font-size: 14px;*/
        line-height: 1.5;
        white-space: pre-wrap;

    }
</style>
    
      