<%-- 
    Document   : ShowDepartmentList
    Created on : 2 Jan, 2024, 6:01:06 PM
    Author     : Bulwark-5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>Vendor Percentage List</title>
    </head>
   
    <body>
        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

            <section class="main-content">
                <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                    <div class="page-title d-flex align-items-center">
                        <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                            <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                 alt="Menu collapse">
                            <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                 alt="Menu collapse">
                        </div>

                        <h5 class="fw-600 mb-0">Vendor Percentage List</h5>
                    </div>

                    <!-- If No data available then Hide this button -->
                    
                </div>

                <hr>
                <c:if test="${!empty failureMessage}">
                    <div class="fadeOutEffect alert alert-danger mt-2 mb-2" style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <strong>Note:</strong> <strong class="text-danger fs-13">${failureMessage} </strong><br>                            
                        </div>
                    </div>
                </c:if>
                <c:if test="${!empty successMessage}">
                    <div class="fadeOutEffect alert alert-info mt-2 mb-2" style="display: flex; align-items: center; gap: 12px; background: #F0FFF4; color: #0F5132; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #198754; box-shadow: 2px 2px 10px rgba(25, 135, 84, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">                        
                        <div style="background: #198754; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px; ">✓</div>  
                        <div>                             
                            <strong>Note:</strong> <strong class="text-success fs-13">${successMessage} </strong><br>                            
                        </div>
                    </div>
                </c:if>

                <div class="mt-3 table-responsive">
                    <div class="d-flex align-items-center justify-content-between mb-3">
                        <div>
                            <select id="entriesPerPage" class="select-input">
                                <option value="10">10</option>
                                <option value="20">20</option>
                                <option value="50">50</option>
                                <option value="100">100</option>
                                <option value="-1">ALL</option>
                            </select>
                        </div>
                        <div>
                            <input type="text" id="searchBox" class="input-field" placeholder="Search here...">
                        </div>
                    </div>
                    <table id="vendorPercentageTable" class="table table-striped bg-white" style="width:100%">
                        <thead>
                            <tr>
                                <th>Sr No</th>
                                <th>Technical Percentage</th>
                                <th>HR Percentage</th>
                                <th>Safety Percentage</th>
                                <th>IT Percentage</th>
                                <th class="text-center">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>

                
               

            </section>
        </main> 
    </body>

    <script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
     <script>
       $(document).ready(function () {

        var table = $('#vendorPercentageTable').DataTable({
            processing: true,
            serverSide: true,
            stateSave: false,
            ordering: true,
            orderMulti: false,
            aaSorting: [[1, 'asc']],
            columnDefs: [
                {
                    targets: [2],
                    orderSequence: ["asc", "desc"]
                }
            ],
            ajax: {
                url: 'vendor.htm?act=vendorPercentagePaginationAjax',
                type: 'POST',
                cache: false,
                error: function (xhr) {
                    console.log(xhr.responseText);
                }
            },

            columns: [
               
                {
                    data: 'srNo',                    
                },
                {
                    data: 'technicalPercentage',
                    orderable: true,
                    searchable: true
                },
                {
                    data: 'hrPercentage',
                    orderable: true,
                    searchable: true
                },
                {
                    data: 'safteyPercentage',
                    orderable: true,
                    searchable: true
                },
                {
                    data: 'itPercentage',
                    orderable: true,
                    searchable: true
                },
                {
                    data: 'action',
                    orderable: false,
                    searchable: false,
                    render: function (data) {
                        return data;
                    }
                }

            ],

            pageLength: 10,
            lengthChange: false,
            searching: true,
            info: true,
            autoWidth: false,
            responsive: true,
            scrollX: true,
            scrollCollapse: true,
            scrollY: '80vh',
            dom: 'rt<"table-bottom-info d-flex align-items-center justify-content-between pt-3"i p>'

        });

        $('#searchBox').on('keyup', function () {
            table.search(this.value).draw();
        });

        $('#entriesPerPage').on('change', function () {
            var val = $(this).val();

            if (val === "" || val === "-1") {
                var total = table.page.info().recordsTotal;
                table.page.len(total > 0 ? total : 1).draw();
            } else {
                table.page.len(parseInt(val, 10)).draw();
            }
        });

    });

    </script>
    
    



</html>


