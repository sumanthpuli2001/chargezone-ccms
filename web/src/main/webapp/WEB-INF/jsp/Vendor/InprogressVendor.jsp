<%-- 
    Document   : InprogressVendor
    Created on : 13 Oct, 2025, 03:59:00 PM
    Author     : fnp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>In Progress Vendor List</title>
    </head>

    <body>
        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

            <section class="main-content">
                <form:form action="" method="post" commandName="rightMaster"
                           name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
                    <div class="card-box rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)" alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)" alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">In Progress Vendor List</h5>
                        </div>
                        <c:if test="${fn:contains(sessionScope.userRights.venderInvite,'1')}">
                        <div class="cta d-flex align-items-center">                            
                            <a onclick="window.location = 'vendorInvitation.htm?act=addVendorInvitation'" class="btn theme-btn flex ml-3">
                                <img src="StorageYard/assets/images/plus.svg" onload="SVGInject(this)" class="mr-2 icon" alt="Plus Icon">
                                Invite Vendor
                            </a>
                        </div>
                        </c:if>
                    </div>
                    <hr>                    
                    <div class="card-box rounded-3 mt-3 py-2 px-3 top-0 sticky-model1">
                        <ul class="list-unstyled mb-0 d-flex align-items-center overflow-auto">
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.allVendor=='1'}">
                                    <a href="vendorInformation.htm?act=allVendor" class="tab-link transition-0">All Vendors</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.venderInvite=='1'}">
                                    <a href="vendorInformation.htm?act=newVendor" class="tab-link transition-0">Invited Vendor</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.venderRequest=='1'}">
                                    <a href="vendorInformation.htm?act=inprogressVendor" class="tab-link active transition-0">In Progress</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.buyerApproval=='1'}">
                                    <a href="vendorInformation.htm?act=firstLevelnApprove" class="tab-link transition-0">Buyer</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.procurementHead=='1'}">
                                    <a href="vendorInformation.htm?act=procurementHeadApproval" class="tab-link transition-0">Procurement Head Approval</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.financialApproval=='1'}">
                                    <a href="vendorInformation.htm?act=finacialApproval" class="tab-link transition-0">Financial Approval</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.technicalApproval=='1'}">
                                    <a href="vendorInformation.htm?act=technicalApproval" class="tab-link transition-0">Technical Approval</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.hrApproval=='1'}">
                                    <a href="vendorInformation.htm?act=hrApproval" class="tab-link transition-0">HR Approval</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.safetyApproval=='1'}">
                                    <a href="vendorInformation.htm?act=safetyApproval" class="tab-link transition-0">Safety Approval</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.itApproval=='1'}">
                                    <a href="vendorInformation.htm?act=itApproval" class="tab-link transition-0">IT Approval</a>
                                </c:if>
                            </li>
                        </ul>
                    </div>

                    <%@include file="/WEB-INF/jsp/Common/TablePageNew.jsp"%>
                    <table id="listCommonSearch" class="table table-striped bg-white" style="min-width: 100%;" align="Center"  >
                        <c:choose>
                            <c:when test="${empty vendorInformation1}"></c:when>
                            <c:otherwise>
                                <thead>
                                    <tr>                                        
                                        <th>Sr.No.</th>
                                        <th>Company Name</th>
                                        <th>Email Id</th>                                      
                                    </tr>
                                </thead>
                                <c:set var="count" value="0" scope="page" />
                                <tbody>
                                    <c:forEach var="list" items="${vendorInformation1}" varStatus="status">
                                        <tr>
                                            <td> ${status.count}</td>
                                            <td>${list[1]}</td>                                            
                                            <td>${list[2]}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </c:otherwise>
                        </c:choose>
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
        }
        ;
    </script>
</html>
