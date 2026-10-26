<%-- 
    Document   : LoginHomePage
    Created on : 17 Oct, 2023, 11:31:29 AM
    Author     : Seth
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>Auditor Approval</title>
    </head>

    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNewAuditor.jsp"%>

            <section class="main-content">
                <form:form action="approvalSetting.htm?act=deleteapprovalSetting" method="post" commandName="vendorInformation1"
                           name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)" alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)" alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Auditor Approval</h5>
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

                    <table id="CommonTable" class="table table-striped bg-white" align="center">
                        <thead>
                            <tr>
                                <th>Sr.No.</th>
                                <th>Company Name</th>
                                <th>Email ID</th>
                                <th>Status</th>
                                <th data-dt-order="disable">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="list" items="${list}" varStatus="status">
                                <tr>
                                    <td style="width: 10%">${status.count}</td>
                                    <td>${list.companyName}</td> 
                                    <td>${list.vendorEmailId}</td> 
                                    <td>
                                        <c:if test="${list.auditorFlag=='1' && list.status1!='10'}">
                                            Approved
                                        </c:if>
                                        <c:if test="${list.auditorFlag=='0'}">
                                            Pending
                                        </c:if>
                                        <c:if test="${list.auditorFlag=='3' && list.status1=='4'}">
                                            Recycle
                                        </c:if>                                        
                                    </td>
                                    <td>
                                        <c:if test="${list.auditorFlag=='0'}">
                                            <div class="btn-group">
                                                <button type="button" class="btn theme-btn"
                                                        id="${status.count}" value="${list.id}"  
                                                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"  
                                                        onclick="viewClick(${list.id});"
                                                        style="background-color: skyblue; color: white; border-color: skyblue;">
                                                    &nbsp; View And Accept
                                                </button>
                                            </div>
                                        </c:if>

                                        <c:if test="${list.auditorFlag=='3' || list.auditorFlag=='1' || list.status1=='10' || list.status1=='4'}">
                                            <div class="btn-group">
                                                <button type="button" class="btn theme-btn light-btn"
                                                        id="${status.count}" value="${list.id}"  
                                                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"  
                                                        onclick="viewClick2(${list.id});"
                                                        style="background-color: skyblue; color: white; border-color: skyblue;">
                                                    &nbsp; View
                                                </button>
                                            </div>
                                        </c:if>
                                    </td>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>


                </form:form>
            </section>
        </main> 
    </body>

    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
    <script>
        if ($('#CommonTable').length) {
            const table = initTable('#CommonTable')
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
                    var selectedId = $(this).val();
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

                // Set dynamic messages based on selection
                const message = selectedIds.length === 1
                    ? 'Are you sure you want to delete this Record?'
                    : `Are you sure you want to delete these ${selectedIds.length} Records?`;
                const confirmButtonText = selectedIds.length === 1
                    ? 'Yes, delete it!'
                    : `Yes, delete them!`;
                Swal.fire({
                    title: message,
                    text: 'You will not be able to recover these records!',
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonText: confirmButtonText,
                    cancelButtonText: 'No, cancel',
                    reverseButtons: true,
                    customClass: {
                        confirmButton: 'confirm-delete',
                        cancelButton: 'theme-btn light-btn'
                    },
                }).then((result) => {
                    if (result.isConfirmed) {
                        $.ajax({
                            url: 'approvalSetting.htm?act=deleteapprovalSetting&ids=' + selectedIds.join(','),
                            type: 'POST',
                            data: JSON.stringify({ ids: selectedIds }),
                            contentType: 'application/json',
                            success: function (response) {
                                Swal.fire({
                                    icon: 'success',
                                    title: 'Deleted!',
                                    text: response.message
                                }).then(() => {

                                });
                                $('#CommonTable')
                                    .DataTable()
                                    .rows(function (idx, data, node) {
                                        return $(node).find('.rowCheckbox').is(':checked');
                                    })
                                    .remove()
                                    .draw();
                            },
                            error: function (xhr) {
                                Swal.fire({
                                    icon: 'error',
                                    title: 'Error!',
                                    text: 'Error deleting records: ' + xhr.responseText
                                });
                            }
                        });
                    }
                });
            });
        };
    </script>
    <script>
        function viewClick(id) {
            window.location = 'vendorInformation.htm?act=auditorApprovePage&id=' + id;
        }
    </script>
    
    <script>
        function viewClick2(id) {
            window.location = 'vendorInformation.htm?act=auditorApprovalActiveDetailsView&id=' + id;
        }
    </script
</html>
