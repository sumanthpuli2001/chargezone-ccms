

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>KickOff Form List</title>
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

                        <h5 class="fw-600 mb-0">KickOff Form List</h5>
                    </div>

                    <!-- If No data available then Hide this button -->
                    <div class="cta d-flex align-items-center">
                        <c:if test="${not empty list}">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                        </c:if>
                    </div>
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
                    <table id="komFormListTable" class="table table-striped bg-white" style="width:100%">
                        <thead>
                            <tr>
                                <th>Sr.No</th>
                                <th style="min-width: 150px;">Document No</th>
                                <th style="min-width: 190px;">Hub Location</th>
                                <th style="min-width: 190px;">Project Name</th>
                                <th>Designation</th>
                                <th style="min-width: 150px;">Date & Time</th>
                                <th style="min-width: 190px;">Status</th>
                                <th >Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>  



            </section>
        </main> 
    </body>
    <script>
    $(document).ready(function () {
        var table = $('#komFormListTable').DataTable({
            processing: true,
            serverSide: true,
            stateSave: false,
            ordering: true,
            orderMulti: false,
            order:    [[0, 'desc']],
            ajax: {
                url: 'formsCommon.htm?act=komFormListPaginationAjax',
                type: 'POST',
                cache: false
            },
            columns: [
                {
                    data: 'srNo',
                    orderable: true,
                    searchable: true
                },
                {
                    data: 'documentNo',
                    orderable: true,
                    searchable: true
                },
                {
                    data: 'hubLocation',
                    orderable: true,
                    searchable: true
                },
                {
                    data: 'projectName',
                    orderable: true,
                    searchable: true
                },
                {
                    data: 'designation',
                    orderable: true,
                    searchable: true
                },
                {
                    data: 'dateTime',
                    orderable: true,
                    searchable: true
                },
                {
                    data: 'flagStatus',
                    orderable: true,
                    searchable: true
                },
                {
                    data: 'action',
                    orderable: false,
                    searchable: false
                }
            ],
            pageLength: 10,
            lengthChange: false,
            searching: true,
            info: true,
            autoWidth: false,
            scrollX: true,
            scrollCollapse: true,
            scrollY: '80vh',
            dom: 'rt<"table-bottom-info d-flex align-items-center justify-content-between pt-3"i p>'
        });

        var searchTimeout;
        $('#searchBox').on('keyup', function () {
            clearTimeout(searchTimeout);
            var value = this.value;
            searchTimeout = setTimeout(function () {
                table.search(value).draw();
            }, 400);
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
    <script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>


</html>


