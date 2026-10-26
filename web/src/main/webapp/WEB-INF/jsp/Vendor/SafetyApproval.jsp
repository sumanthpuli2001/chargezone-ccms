<%-- 
    Document   : SafetyApproval
    Created on : 14 Oct, 2025, 09:52:57 AM
    Author     : fnp
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>Safety Approval List</title>
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

                            <h5 class="fw-600 mb-0">Safety Approval List</h5>
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
                                    <a href="vendorInformation.htm?act=inprogressVendor" class="tab-link transition-0">In Progress</a>
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
                                    <a href="vendorInformation.htm?act=safetyApproval" class="tab-link active transition-0">Safety Approval</a>
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
                    <table id="CommonTable" class="table table-striped bg-white" style="min-width: 100%;" align="Center"  >
                        <c:choose>
                            <c:when test="${empty vendorInformation1}"></c:when>
                            <c:otherwise>
                                <thead>
                                    <tr>                                        
                                        <th>Sr.No.</th>
                                        <th>Company Name</th>
                                        <th>Email Id</th>
                                        <th>Status</th>
                                        <th data-dt-order="disable">Action</th>
                                    </tr>
                                </thead>
                                <c:set var="count" value="0" scope="page" />
                                <tbody>
                                    <c:forEach var="list" items="${vendorInformation1}" varStatus="status">
                                        <tr>


                                            <td> ${status.count}</td>
                                            <td>${list[1]}</td>
                                            <td>${list[2]}</td> 
                                            <td>
                                                <c:if test="${list[6]=='1' && list[3]!='10'}">
                                                    Approved
                                                </c:if>
                                                <c:if test="${list[6]=='0'}">
                                                    Pending
                                                </c:if>
                                                <c:if test="${list[6]=='3' && list[3]!='10'}">
                                                    Recycle
                                                </c:if>
                                                <c:if test="${list[6]=='1' && list[3]=='10'}">
                                                    Active Vender
                                                </c:if>
                                                <c:if test="${list[6]=='3' && list[3]=='10'}">
                                                    Send To Vendor
                                                </c:if>

                                            </td>  
                                            <td>
                                                <c:if test="${list[6]=='0'}">
                                                    <div class="btn-group">
                                                        <a href="vendorInformation.htm?act=safetyApprovalView&id=${list[0]}" class="btn theme-btn">Accept</a>
                                                    </div>
                                                </c:if>

                                                <c:if test="${list[6]=='3' || list[6]=='1' || list[3]=='10'}">

                                                    <div class="btn-group">
                                                        <a href="vendorInformation.htm?act=safetyApprovalDetailsView&id=${list[0]}" class="btn theme-btn light-btn">View</a>
                                                    </div>

                                                </c:if>

                                            </td>
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
        }
        ;
    </script>
</html>

