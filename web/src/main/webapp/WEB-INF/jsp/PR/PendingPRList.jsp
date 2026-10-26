
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PR DETAILS</title>
    </head>

    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="" method="post" commandName="employeeMaster"
                           name='form1'  class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">PR DETAILS</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <!--<a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>-->
<!--                            <a onclick="window.location = 'tenderMaster.htm?act=selectTypeTender'" class="btn theme-btn flex ml-3">
                                <img src="StorageYard/assets/images/plus.svg" onload="SVGInject(this)" class="mr-2 icon" alt="Plus Icon">
                                Create Tender
                            </a>-->
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
                
                    <div class="pr-listing">
                       <div class="row my-3">
                        <div class="col-md-1 pr-md-1">
                            <select id="entriesPerPage" class="select-input">
                                <option value="10">10</option>
                                <option value="25">25</option>
                                <option value="50">50</option>
                                <option value="-1">All</option>
                            </select>
                        </div>
                        <div class="col-md-8 pl-md-1">
                            <input id="searchBox" type="text" class="input-field" placeholder="Search here...">
                        </div>

                        <div class="col-md-3 pl-md-1 ">
                            <select id="statusFilter" class="select-input" title="Select Status" multiple>
                                <option value="Pending">Pending</option>
                                <option value="Approve">Approve</option>
                                
                            </select>

                        </div>
                    </div>

                        <div class="bg-white card-full-h">
                            <table id="prTable" class="table table-striped bg-white" style="width:100%">
                                <c:choose>
                                    <c:when test="${empty prMaster}">

                                    </c:when>
                                    <c:otherwise>
                                        <thead style="font-weight: bold; font-size: 14px">
                                            <tr>
                                                <th>Sr. No.</th>
                                                <th  style="min-width: 190px;">PR Number</th>
                                                <th  style="min-width: 230px;">Title</th>
                                                <th  style="min-width: 190px;">Created By</th>
                                                <th style="min-width: 190px;">Date Time</th>
                                                <th  style="min-width: 190px;">Approval Status</th>
                                                <th  style="min-width: 190px;">Assign Tender</th>
                                                <th data-dt-order="disable">Action</th>



                                            </tr>
                                        </thead>
                                        <c:set var="count" value="0" scope="page" />
                                        <tbody>
                                            <c:forEach var="list" items="${prMaster}" varStatus="status">
                                            <input type="hidden" name="id" id="id" value="${list.id}">
                                            <tr>
                                                <td >${status.count}</td>
                                                <td >${list.prNo}</td>
                                                <td >${list.title}</td>
                                                <td >${list.contactPerson}</td>
                                                <td >${list.announceDate}</td>

                                                <c:if test="${list.authorizeFlag == 0}">
                                                    <td >Pending</td>
                                                </c:if>

                                                <c:if test="${list.authorizeFlag == 1}">
                                                    <td>Approve</td>
                                                </c:if>
                                                <td >${list.tenderCreaterId}</td>


                                                <td >
                                                    <div style="display: flex; flex-direction: column; align-items: center; gap: 15px;">
                                                        <c:if test="${list.authorizeFlag == 1}">
                                                            <form action="prMaster.htm" method="get">
                                                                <input type="hidden" name="act" value="searchView">
                                                                <input type="hidden" name="id" value="${list.id}">
                                                                <button style="width: 150px;" type="submit" class="btn theme-btn light-btn" formaction="prMaster.htm?act=searchView" >View</button>
                                                            </form>
                                                        </c:if>
                                                        <c:if test="${list.authorizeFlag == 1}">
                                                            <form action="prMaster.htm" method="get">
                                                                <input type="hidden" name="act" value="searchView1">
                                                                <input type="hidden" name="id" value="${list.id}">
                                                                <button style="width: 150px;" type="submit" class="btn theme-btn light-btn">Create Tender</button>
                                                            </form>

                                                            <c:if test="${list.tenderFlag == 0}">
                                                                <form action="prMaster.htm" method="get">
                                                                    <input type="hidden" name="act" value="searchView2">
                                                                    <input type="hidden" name="id" value="${list.id}">
                                                                    <button style="width: 150px;" type="submit" class="btn theme-btn light-btn" >Assign Tender</button>
                                                                </form>
                                                            </c:if>

                                                            <c:if test="${list.tenderFlag == 1}">
                                                                <form action="prMaster.htm" method="get">
                                                                    <input type="hidden" name="act" value="searchView2">
                                                                    <input type="hidden" name="id" value="${list.id}">
                                                                    <button style="width: 150px;" type="submit" class="btn theme-btn light-btn" >Re-assign Tender</button>
                                                                </form>
                                                            </c:if>
                                                            <c:if test="${list.authorizeFlag == 1}">
                                                                <form action="prMaster.htm" method="get">
                                                                    <input type="hidden" name="act" value="searchView3">
                                                                    <input type="hidden" name="id" value="${list.id}">
                                                                    <button style="width: 150px;" type="submit" class="btn theme-btn light-btn" >Recycle PR</button>
                                                                </form>
                                                            </c:if>

                                                            <form action="prMaster.htm" method="get">
                                                                <input type="hidden" name="act" value="searchView4">
                                                                <input type="hidden" name="id" value="${list.id}">
                                                                <button style="width: 150px;" type="submit" class="btn theme-btn light-btn" >Offline Tender</button>
                                                            </form>
                                                        </c:if>
                                                    </div>
                                                </td>

                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </c:otherwise>
                                </c:choose>


                            </table>
                        </div>

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
            ...obj
        });
    }

    $(document).ready(function () {
        // Main PR Table logic
        if ($('#prTable').length) {

            let table = initTable('#prTable');
            // Select all checkbox logic
            $('#select_all').on('change', function () {
                $('.rowCheckbox').prop('checked', this.checked).trigger('change');
            });
           $('#statusFilter').on('change', function () {
                var selectedDepartments = $(this).val() || [];
                if (selectedDepartments.length) {
                    table.column(5).search(selectedDepartments.join('|'), true, false).draw();
                } else {
                    table.column(5).search('').draw();
                }
            });

            // Individual row checkbox logic
            $('#prTable tbody').on('change', '.rowCheckbox', function () {
                const anyChecked = $('.rowCheckbox:checked').length > 0;
                $('#deleteSelected').toggleClass('d-none', !anyChecked).toggleClass('d-flex', anyChecked);
                $('#select_all').prop('checked', $('.rowCheckbox:checked').length === $('.rowCheckbox').length);
            });
            // Dropdown filters and search box entriesPerPage
            $('.pr-listing #entriesPerPage').on('change', function () {
                table.page.len($(this).val()).draw();
            });
            $('.pr-listing #searchBox').on('keyup', function () {
                table.search(this.value).draw();
            });
           
            $('.pr-listing #categoryFilter').on('change', function () {
                table.page.len($(this).val()).draw();
            });

            
        }
    })

  


</script>
</html>
