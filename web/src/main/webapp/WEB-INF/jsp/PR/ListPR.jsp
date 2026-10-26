<%-- 
    Document   : ListPR
    Created on : 22 May, 2024, 12:50:05 PM
    Author     : Bulwark-5
--%>
 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp" %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PR LIST</title>
    </head>

    <body>
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp" %>
                <section class="main-content">
                    <form:form action="prMaster.htm?act=listPRList" method="post" commandName="employeeMaster"
                        name='form1' class="form-horizontal" role="form">
                        <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                            <div class="page-title d-flex align-items-center">
                                <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                    <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars"
                                        onload="SVGInject(this)" alt="Menu collapse">
                                    <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort"
                                        onload="SVGInject(this)" alt="Menu collapse">
                                </div>

                                <h5 class="fw-600 mb-0">PR LIST</h5>
                            </div>

                            <div class="cta d-flex align-items-center">

                                <a href="prMaster.htm?act=selectPR" class="btn theme-btn">
                                    <img src="StorageYard/assets/images/plus.svg" class="icon d-inline attachment mr-2"
                                        alt="Plus Icon">
                                    Create PR
                                </a>
                            </div>
                        </div>
                        <hr>
                        <c:if test="${!empty failureMessage}">
                            <div class="fadeOutEffect alert alert-danger mt-2 mb-2"
                                style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                                <div
                                    style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">
                                    !</div>
                                <div>
                                    <strong>Note:</strong> <strong class="text-danger fs-13">${failureMessage}
                                    </strong><br>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${!empty successMessage}">
                            <div class="fadeOutEffect alert alert-info mt-2 mb-2"
                                style="display: flex; align-items: center; gap: 12px; background: #F0FFF4; color: #0F5132; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #198754; box-shadow: 2px 2px 10px rgba(25, 135, 84, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                                <div style="background: #198754; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px; ">✓</div>
                                <div>
                                    <strong>Note:</strong> <strong class="text-success fs-13">${successMessage}
                                    </strong><br>
                                </div>
                            </div>
                        </c:if>

                        <div class="mt-3 table-responsive">

                            <div class="d-flex align-items-center justify-content-between mb-3">

                                <div class="col-md-1 pl-0">
                                    <select id="entriesPerPage" class="select-input">
                                        <option value="10">10</option>
                                        <option value="20">20</option>
                                        <option value="50">50</option>
                                        <option value="100">100</option>
                                        <option value="-1">ALL</option>
                                    </select>
                                </div>

                                <div class="col-md-8">
                                    <input type="text" id="searchBox" class="input-field" placeholder="Search here...">
                                </div>

                                <div class="col-md-3 pr-0">
                                    <select id="statusFilter" class="select-input" title="Select Status" multiple>
                                        <option value="Approve">Approve</option>
                                        <option value="Pending">Pending</option>
                                        <option value="Rework">Rework</option>
                                        <option value="Tender Created">Tender Created</option>
                                        <option value="Draft">Draft</option>
                                    </select>
                                    <input type="hidden" id="hiddenStatus" name="hiddenStatus">
                                </div>
                            </div>

                            <table id="saerchListPRTable" class="table table-striped bg-white" style="width:100%">

                                <thead>

                                    <tr>

                                        <th>Sr. No.</th>
                                        <th style="min-width: 190px;">PR Number</th>
                                        <th style="min-width: 190px;">Project Name</th>
                                        <th style="min-width: 190px;">Project ID</th>
                                        <th style="min-width: 190px;">Created By</th>
                                        <th style="min-width: 190px;">Date Time</th>
                                        <th>Approval Status</th>
                                        <th style="min-width: 190px;" data-dt-order="disable">View</th>

                                    </tr>

                                </thead>

                            </table>

                        </div>
                        <script>
                            $(document).ready(function () {

                                var table = $('#saerchListPRTable').DataTable({

                                    processing: true,
                                    serverSide: true,
                                    paging: true,
                                    searching: true,
                                    ordering: true,
                                    lengthChange: false,
                                    pageLength: 10,
                                    scrollX: true,
                                    autoWidth: false,
                                    scrollCollapse: true,
                                    scrollY: '80vh',

                                    dom: 't<"table-bottom-info d-flex align-items-center justify-content-between pt-3"ip>',

                                    ajax: {
                                        url: 'prMaster.htm?act=listPRPeginationAjax',
                                        type: 'POST',

                                        data: function (d) {

                                            d.statusFilter = $('#hiddenStatus').val();

                                        }
                                    },

                                    columns: [
                                        {
                                            data: 'srNo',
                                            orderable: false
                                        },
                                        {
                                            data: 'prNo'
                                        },
                                        {
                                            data: 'title'
                                        },
                                        {
                                            data: 'projectId'
                                        },
                                        {
                                            data: 'contactPerson'
                                        },
                                        {
                                            data: 'announceDate'
                                        },
                                        {
                                            data: 'status'
                                        },
                                        {
                                            data: 'action',
                                            orderable: false
                                        }
                                    ]

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

                                $('#searchBox').on('keyup', function () {

                                    table.search(this.value).draw();

                                });

                                $('#statusFilter').on('change', function () {

                                    var selectedStatus = $(this).val();

                                    if (selectedStatus != null) {

                                        $('#hiddenStatus').val(selectedStatus.join(','));

                                    } else {

                                        $('#hiddenStatus').val('');
                                    }

                                    table.draw();

                                });

                            });
                        </script>
                    </form:form>
                </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp" %>

        <script>
            function initTable(selector, obj = {}) {

                if ($.fn.DataTable.isDataTable(selector)) {
                    return $(selector).DataTable();
                }

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

            $(document).ready(function () {

                if ($('#prTable').length) {

                    const table1 = initTable("#prTable");

                    $("#entriesPerPage").on("change", function () {
                        table1.page.len($(this).val()).draw();
                    });

                    $("#searchBox").on("keyup", function () {
                        table1.search(this.value).draw();
                    });

                    $('#select_all').on('change', function () {
                        $('.rowCheckbox').prop('checked', this.checked).trigger('change');
                    });

                    $('#statusFilter').on('change', function () {
                        var selectedDepartments = $(this).val() || [];
                        if (selectedDepartments.length) {
                            table1.column(6).search(selectedDepartments.join('|'), true, false).draw();
                        } else {
                            table1.column(6).search('').draw();
                        }
                    });

                    $('#prTable tbody').on('change', '.rowCheckbox', function () {
                        const anyChecked = $('.rowCheckbox:checked').length > 0;

                        $('#deleteSelected')
                            .toggleClass('d-none', !anyChecked)
                            .toggleClass('d-flex', anyChecked);

                        $('#select_all').prop(
                            'checked',
                            $('.rowCheckbox:checked').length === $('.rowCheckbox').length
                        );
                    });

                    $('.pr-listing #entriesPerPage').on('change', function () {
                        table1.page.len($(this).val()).draw();
                    });

                    $('.pr-listing #searchBox').on('keyup', function () {
                        table1.search(this.value).draw();
                    });

                    $('.pr-listing #categoryFilter').on('change', function () {
                        table1.column(5).search($(this).val()).draw();
                    });
                }

            });
        </script>

</html>
