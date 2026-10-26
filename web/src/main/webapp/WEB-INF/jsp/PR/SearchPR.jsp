<%-- 
    Document   : Search PR
    Created on : 4 Jun, 2022, 9:46:31 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search PR</title>
    </head>
    <body>


        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="prMaster.htm?act=searchPRList" method="post" name='form1'  class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Search PR</h5>
                        </div>

                        <div class="cta d-flex align-items-center"> 
                            <a href="javascript:void(0)" id="exportExcelBtn" class="btn theme-btn ">Export To Excel</a>
                            <!--<button type="submit" class="btn theme-btn">Search</button>-->
                        </div>
                    </div>

                    <hr>

                    <div class="rounded-4 mt-4 sticky-model1">
                        <div class="row mb-3">
                            <div class="col-lg-2 col-md-2">
                                <div class="form-group">
                                    <label  class="label">Enter PR Number :</label>
                                    <input type="text" name="prNumber" id="prNumber" value="" class="input-field" maxlength="30" />
                                </div>   
                            </div>
                            <div class="col-lg-3 col-md-2">
                                <div class="form-group">
                                    <label  class="label">Enter Project Name :</label>
                                    <input type="text" name="projectName" id="projectName" value="" class="input-field" maxlength="30" />
                                </div>   
                            </div>

                            <div class="col-lg-3 col-md-2">
                                <div class="form-group">
                                    <label  class="label">Department :</label>
                                    <select id="committee_approval" name="department" class="select-input" >
                                        <option value="">--SELECT--</option>
                                        <c:forEach var="DepartmentList" items="${DepartmentList}" varStatus="status">
                                            <option value="${DepartmentList.departmentName}">${DepartmentList.departmentName}</option>
                                        </c:forEach>
                                    </select>
                                </div>   
                            </div>

                            <div class="col-lg-2 col-md-2">
                                <div class="form-group">
                                    <label  class="label">From Date</label>
                                    <div  class="form-group date" id="datetimepickers6" >
                                        <input placeholder="DD/MM/YYYY" name="open_from_date" id="open_from_date" type="text" 
                                               class="input-field form_datetime" maxlength="30" autocomplete="off" />
                                    </div>
                                </div>   
                            </div>
                            <div class="col-lg-2 col-md-2">
                                <div class="form-group">
                                    <label  class="label">To Date</label>
                                    <div  class="form-group date" id="datetimepickers5" >
                                        <input placeholder="DD/MM/YYYY" name="open_to_date" id="open_to_date"  type="text" class="input-field form_datetime"  maxlength="30" autocomplete="off"    />
                                    </div>
                                </div> 
                            </div>
                            
                            <script type="text/javascript">
                                $(document).ready(function () {

                                    flatpickr("#open_from_date", {
                                        dateFormat: "d-m-Y",
                                        allowInput: true
                                    });

                                    flatpickr("#open_to_date", {
                                        dateFormat: "d-m-Y",
                                        allowInput: true
                                    });

                                });
                            </script>                  
                        </div>
                    </div>
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

                        <table id="saerchPrTable" class="table table-striped bg-white" style="width:100%">

                            <thead>

                                <tr>

                                    <th>Sr. No.</th>
                                    <th style="min-width: 190px;">PR Number</th>
                                    <th style="min-width: 180px;">Project Name</th>
                                    <th style="min-width: 180px;">Project ID</th>
                                    <th style="min-width: 180px;">PR Subject Description</th>
                                    <th style="min-width: 180px;">Department</th>
                                    <th style="min-width: 180px;">Billing Location</th>
                                    <th style="min-width: 180px;">Created By</th>
                                    <th style="min-width: 180px;">PR Date Time</th>
                                    <th style="min-width: 180px;">PR Approval User</th>
                                    <th style="min-width: 180px;">PR Approval Date</th>
                                    <th style="min-width: 180px;">Tender Assign To</th>
                                    <th style="min-width: 180px;">Tender Assign By</th>
                                    <th style="min-width: 180px;">Tender Assign Date</th>
                                    <th style="min-width: 180px;">Tender Create By</th>
                                    <th style="min-width: 180px;">Tender Create Date</th>
                                    <th style="min-width: 180px;">Technical Bid Open By</th>
                                    <th style="min-width: 180px;">Technical Bid Open Date</th>
                                    <th style="min-width: 180px;">Technical Bid Approve By</th>
                                    <th style="min-width: 180px;">Technical Bid Approve Date</th>
                                    <th style="min-width: 180px;">Price Bid Initiate By</th>
                                    <th style="min-width: 180px;">Price Bid Initiate Date</th>
                                    <th style="min-width: 180px;">Price Bid Open By</th>
                                    <th style="min-width: 180px;">Price Bid Open Date</th>
                                    <th style="min-width: 180px;">Tender Award By</th>
                                    <th style="min-width: 180px;">Tender Award Date</th>
                                    <th style="min-width: 180px;">Accept By</th>
                                    <th style="min-width: 180px;">Accept Date</th>
                                    <th style="min-width: 180px;">Final Close By</th>
                                    <th style="min-width: 180px;">Final Close Date</th>
                                    <th style="min-width: 180px;">Approval Status</th>
                                    <th>View</th>

                                </tr>

                            </thead>

                        </table>

                    </div>

                </form:form>
            </section>
        </main>
        <script>

            var table;

            $(document).ready(function () {

                table = $('#saerchPrTable').DataTable({

                    processing: true,

                    serverSide: true,

                    stateSave: false,

                    ordering: true,

                    orderMulti: false,

                    aaSorting: [[0, 'asc']],

                    columnDefs: [
                        {
                            targets: [31],
                            orderable: false,
                            searchable: false
                        }
                    ],

                    ajax: {

                        url: 'prMaster.htm?act=searchPRPaginationAjax',

                        type: 'POST',

                        cache: false,

                        data: function (d) {

                            d.prNumber = $('#prNumber').val();

                            d.projectName = $('#projectName').val();

                            d.department = $('#committee_approval').val();

                            d.open_from_date = $('#open_from_date').val();

                            d.open_to_date = $('#open_to_date').val();
                        }

                    },

                    columns: [

                        {
                            data: 'srNo',
                            orderable: true,
                            searchable: false
                        },

                        {data: 'prNo'},
                        {data: 'title'},
                        {data: 'projectId'},
                        {data: 'workDesc'},
                        {data: 'department'},
                        {data: 'billingLocation'},
                        {data: 'contactPerson'},
                        {data: 'announceDate'},
                        {data: 'prAuthorizeUser'},
                        {data: 'prAuthorizeDate'},
                        {data: 'tenderCreaterId'},
                        {data: 'tenderAssignUser'},
                        {data: 'tenderAssignDate'},
                        {data: 'tenderCreaterUser'},
                        {data: 'tenderCreaterDate'},
                        {data: 'techBidOpenUser'},
                        {data: 'techBidOpenDate'},
                        {data: 'techBidApproveUser'},
                        {data: 'techBidApproveDate'},
                        {data: 'priceBidStartUser'},
                        {data: 'priceBidStartDate'},
                        {data: 'priceBidOpenUser'},
                        {data: 'priceBidOpenDate'},
                        {data: 'tenderAwardUser'},
                        {data: 'tenderAwardDate'},
                        {data: 'tenderAcceptUser'},
                        {data: 'tenderAcceptDate'},
                        {data: 'finalCloseUser'},
                        {data: 'finalCloseDate'},
                        {data: 'status'},

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

                    responsive: true,

                    scrollX: true,
                    
                    scrollCollapse: true,
                    
                    scrollY: '80vh',

                    language: {

                        info: "Showing _START_ to _END_ of _TOTAL_ filtered records",

                        infoFiltered: "(filtered from _MAX_ total records)",

                        zeroRecords: "No matching records found"
                    },

                    dom: 'rt<"table-bottom-info d-flex align-items-center justify-content-between pt-3"ip>'

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
                
                $('#prNumber, #projectName, #committee_approval, #open_from_date, #open_to_date')
                .on('keyup', function () {

                    table.ajax.reload(null, true);

                });

            });

            $('#exportExcelBtn').on('click', function () {

                var searchValue = $('#searchBox').val();

                var order = table.order();

                var orderColumn = order[0][0];

                var orderDir = order[0][1];

                var prNumber = $('#prNumber').val();

                var projectName = $('#projectName').val();

                var department = $('#committee_approval').val();

                var fromDate = $('#open_from_date').val();

                var toDate = $('#open_to_date').val();

                var exportUrl =
                        'prMaster.htm?act=searchPRListExport'
                        + '&searchValue=' + encodeURIComponent(searchValue)
                        + '&orderColumn=' + orderColumn
                        + '&orderDir=' + orderDir
                        + '&prNumber=' + encodeURIComponent(prNumber)
                        + '&projectName=' + encodeURIComponent(projectName)
                        + '&department=' + encodeURIComponent(department)
                        + '&open_from_date=' + encodeURIComponent(fromDate)
                        + '&open_to_date=' + encodeURIComponent(toDate);

                window.location.href = exportUrl;

            });

        </script>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
