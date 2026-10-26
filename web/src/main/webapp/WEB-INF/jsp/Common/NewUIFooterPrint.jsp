<%-- 
    Document   : NewUIFooterPrint
    Created on : Feb 9, 2026, 10:46:53 AM
    Author     : Sumanth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--Test Text-->
<!-- Js -->
<script src="StorageYard/assets/js/TableScript/commonDocTableScript.js" ></script>
<script src="StorageYard/assets/js/TableScript/commonTableScript.js"></script>
<script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>
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
        
        
<script>
(function () {
  let storedLinks = [];

  window.onbeforeprint = function () {
    storedLinks = [];
    document.querySelectorAll('a').forEach(a => {
      const href = a.getAttribute('href');
      if (href) {
        storedLinks.push({ el: a, href });
        a.removeAttribute('href');
      }
    });
  };

  window.onafterprint = function () {
    storedLinks.forEach(item => {
      item.el.setAttribute('href', item.href);
    });
  };
})();
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
            .custom-table,
            .custom-table th,
            .custom-table td {
                word-break: break-all;
                overflow-wrap: break-word;
                border: 1px solid black !important;
            }   
            
            .nav-tabs-custom {
                border-top: 0px solid #00a65a;
            }
            
            .table-bordered {
                border-collapse: collapse;
                border: 0px solid #000 !important; 
            }

            .main-container {

                margin: 20px auto;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
                background-color: #f9f9f9;
                font-family: Arial, sans-serif;
            }

            .flex-row {
                display: flex;
                justify-content: space-between;
                gap: 20px;
                margin-bottom: 20px;
            }

            .flex-table {
                flex: 1;
                border-collapse: collapse;
                width: 100%;
                /*border-radius: 8px;*/
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                overflow: hidden;
                background-color: #ffffff;
            }                        
            
            #flex-table1 {
                flex: 1;
                border-collapse: collapse;
                width: 100%;
                border-radius: 8px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                overflow: hidden;
                background-color: #ffffff;
            }

            .table-title {
                font-size: 18px;
                font-weight: bold;
                padding: 12px;

                text-align: center;
                background-color: #e0e7ff;

            }
            #table_2 {
                border-radius: 0 !important;
            }


            th, td {
                padding: 12px;
                text-align: left;
                border-bottom: 1px solid #dddddd;
            }

            tr:nth-child(even) {
                background-color: #f2f2f2;
            }

            tr:hover {
                background-color: #e9f5ff;
            }

            .bottom-table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
                border-radius: 8px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                overflow: hidden;
                background-color: #ffffff;
            }            
            
            a {
                text-decoration: none;
            }

            a:hover {
            }


            td:first-child {

                color: #333;
            }

            @media print {

                @page {
                    size: A4 landscape;
                    margin: 10mm;
                }

                .printup{
                    margin-top: -75px !important;
                }


                html, body {
                    margin: 0 !important;
                    padding: 0 !important;
                    -webkit-print-color-adjust: exact !important;
                    print-color-adjust: exact !important;
                }

                .sidebar,
                .toggle-sidebar,
                .no-print {
                    display: none !important;
                }

                main,
                .main-content,
                .container,
                .container-fluid,
                .row,
                [class^="col-"] {
                    margin-left: 0 !important;
                    padding-left: 0 !important;
                    max-width: 100% !important;
                    width: 100% !important;
                }

                .flex-row {
                    display: block !important;
                }

                .main-container,
                .flex-table,
                .bottom-table {
                    padding: 1 !important;
                    width: 100% !important;
                    height: auto !important;
                    overflow: visible !important;
                }

                table {
                    width: 100% !important;
                    border-collapse: separate !important;
                    border-spacing: 0 !important;
                }

                thead {
                    display: table-header-group !important;
                }

                tfoot {
                    display: table-footer-group !important;
                }

                tr {
                    page-break-inside: avoid !important;
                    break-inside: avoid !important;
                }

                th, td {
                    border: 1px solid #000 !important;
                    color: #000 !important;
                }

                * {
                    box-shadow: none !important;
                    overflow: visible !important;
                }


                a {
                    pointer-events: none;
                    text-decoration: none !important;
                    color: black !important;
                    border-bottom: none !important;
                }

                .gradient-text {
                    background: none !important;
                    -webkit-background-clip: initial !important;
                    -webkit-text-fill-color: black !important;
                    color: black !important;
                    border-bottom: none !important;
                }
                .page-break-section {
                    page-break-before: always !important;
                }

            }
            #table_1 td {
                height: auto !important;
            }

            #table_1 img {
                width: auto;
                display: block;
                margin: 0 auto;
            }

            #table_1 td:last-child {
                font-size: 16px !important;
                padding: 6px !important;
            }

            .sticky { 
                position: sticky; 
                top: -21px;
                z-index: 1000; 
                background: #ffffff;
                padding: 10px 20px;
                border-bottom: 1px solid #ddd;
                box-shadow: 0 2px 5px rgba(0,0,0,0.08);
            }  

            .table-title td {
                font-size: 12px;
            }

            p {
                word-wrap: break-word;
                max-width: 100ch;
            }

            .break-after-80 {
                word-wrap: break-word;
                overflow-wrap: break-word;
                max-width: 120ch;
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
<style>
    .terms-details {
        font-family: 'Poppins', Verdana, Geneva, Tahoma, sans-serif;
        font-size: 11px;
        line-height: 1.5;
        white-space: pre-wrap;

    }
</style>