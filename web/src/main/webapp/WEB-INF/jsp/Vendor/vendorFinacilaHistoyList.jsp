<%-- 
    Document   : vendorFinacilaHistoyList
    Created on : Jul 24, 2026, 12:47:49 PM
    Author     : Sumanth
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Financial Details History</title>
    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNewVendor.jsp"%>
            <section class="main-content">
                <form:form action=".htm?act=" commandName="departmentMaster" method="post">

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Financial Details History</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                        </div>
                    </div>

                    <hr>

                    <div class="mt-3 table-responsive">
                        <div class="d-flex align-items-center justify-content-between mb-3">
                            <div>
                                <select id="entriesPerPage8" class="select-input">
                                    <option value="10">10</option>
                                    <option value="20">20</option>
                                    <option value="50">50</option>
                                    <option value="100">100</option>
                                </select>
                            </div>
                            <div>
                                <input type="text" id="searchBox9" class="input-field" placeholder="Search here...">
                            </div>
                        </div>  

                        <table id="FinancialDetailsHistory" class="table  table-striped bg-white" style="" align="Center"  >

                            <thead>
                                <tr>

                                    <th>Sr.No</th>
                                    <th>Company Name</th>
                                    <th>Vendor Email</th>
                                    <th>Date&Time</th>
                                    <th>Revision No</th>
                                    <th>Action</th>

                                </tr>
                            </thead>
                            <c:set var="count" value="0" scope="page" />

                            <tbody>
                                <c:forEach var="list" items="${vendorFinHistory}" varStatus="status">
                                    <tr>

                                        <td>${status.count}</td>
                                        <td>${list[4]}</td>
                                        <td>${list[5]}</td>
                                        <td>${list[2]}</td>
                                        <td>${list[3]}</td>

                                        <td>
                                            <div class="btn-group">
                                                <button type="button" class="btn theme-btn light-btn"
                                                        onclick="window.location = 'vendorInformation.htm?act=vendorFinacilaHistoyListView&id=${list[0]}&VInfoId=${list[1]}'">
                                                    View
                                                </button>
                                            </div>
                                        </td>

                                    </tr>
                                </c:forEach>
                            </tbody> 
                            </tbody>


                        </table>




                    </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
    <script>
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

                if ($("#FinancialDetailsHistory").length) {
                let obj = {
                columnDefs: [
                { orderable: false, targets: [5] }
                ],
                        order: [[0, 'asc']]
                };
                        const table1 = initTable("#FinancialDetailsHistory", obj);
                        $("#entriesPerPage8").on("change", function () {
                table1.page.len($(this).val()).draw();
                });
                        $("#searchBox9").on("keyup", function () {
                table1.search(this.value).draw();
                });
                        }
    </script>
</html>
