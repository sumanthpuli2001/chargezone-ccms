<%-- 
    Document   : ClosePr
    Created on : 4 Jun, 2022, 9:46:31 AM
    Author     : admin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search All Closed PR</title>
    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">

                <c:if test="${!empty successMessage}">
                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                </c:if>
                <c:if test="${!empty failureMessage}">
                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                </c:if>
                <form:form action="prMaster.htm?act=closePRList" method="post" name='form1'  class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">All Closed PR</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a href="javascript:void(0)" id="exportExcelBtn" class="btn theme-btn">Export To Excel</a>
                        </div>
                    </div>
                    
                    
                    <div class="rounded-4 mt-4 sticky-model1">
                        <div class="row mb-3">
                            <div class="col-lg-3 col-md-6">
                                <div class="form-group">
                                    <label  class="label">Enter PR Number :</label>
                                    <input type="text" name="prNumber" id="prNumber" value="" class="input-field" maxlength="30" />
                                </div>   
                            </div>
                            <div class="col-lg-3 col-md-6">
                                <div class="form-group">
                                    <label  class="label">Department :</label>
                                    <select id="department" name="department" class="select-input" >
                                        <option value="">--SELECT--</option>
                                        <c:forEach var="DepartmentList" items="${DepartmentList}" varStatus="status">
                                            <option value="${DepartmentList.departmentName}">${DepartmentList.departmentName}</option>
                                        </c:forEach>
                                    </select>
                                </div>   
                            </div>
                            <div class="col-lg-3 col-md-6">
                                <div class="form-group">
                                    <label  class="label">From Date</label>
                                    <div class="form-group date" >
                                        <input placeholder="DD/MM/YYYY" name="open_from_date" id="open_from_date" type="text"  class="input-field form_datetime" maxlength="30" autocomplete="off" />                                        
                                    </div>  
                                </div>   
                            </div>                            
                             
                            <div class="col-lg-3 col-md-6">
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

                        <table id="closePrTable" class="table table-striped bg-white" style="width:100%">

                            <thead>

                                <tr>

                                    <th>Sr. No.</th>
                                    <th>PR Number</th>
                                    <th>Closed By</th>
                                    <th>Date Time</th>
                                    <th>View</th>

                                </tr>

                            </thead>

                        </table>

                    </div>

                    <script>

                        var table;

                        $(document).ready(function () {

                            table = $('#closePrTable').DataTable({

                                processing: true,

                                serverSide: true,

                                stateSave: false,

                                ordering: true,

                                orderMulti: false,

                                aaSorting: [[0, 'asc']],

                                columnDefs: [
                                    {
                                        targets: [4],
                                        orderable: false,
                                        searchable: false
                                    }
                                ],

                                ajax: {

                                    url: 'prMaster.htm?act=closePRListAjax',

                                    type: 'POST',

                                    cache: false,

                                    data: function (d) {

                                        d.prNumber = $('#prNumber').val();

                                        d.department = $('#department').val();

                                        d.open_from_date = $('#open_from_date').val();

                                        d.open_to_date = $('#open_to_date').val();
                                    },

                                    error: function (xhr) {

                                        console.log(xhr.responseText);

                                    }

                                },

                                columns: [

                                    {
                                        data: 'srNo',
                                        orderable: true,
                                        searchable: false
                                    },

                                    {data: 'prNo'},
                                    {data: 'closedBy'},
                                    {data: 'dateTime'},
                                    {data: 'view'}

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

                            $('#prNumber, #department, #open_from_date, #open_to_date').on('change keyup', function () {

                                        table.ajax.reload(null, true);

                            });
                            
                            //      For Export To Excel            
                            $('#exportExcelBtn').on('click', function () {

                                var params = {
                                    searchValue: $('#searchBox').val(),
                                    
                                    prNumber: $('#prNumber').val(),
                                    department: $('#department').val(),
                                    open_from_date: $('#open_from_date').val(),
                                    open_to_date: $('#contactNoFilter').val()
                                };

                                var $form = $('<form>', {
                                    method: 'POST',
                                    action: 'prMaster.htm?act=closePRReportExportExcel'
                                });

                                $.each(params, function (key, value) {
                                    $form.append($('<input>', {
                                        type: 'hidden',
                                        name: key,
                                        value: value || ''
                                    }));
                                });

                                $form.appendTo('body').submit().remove();
                            });
                        });

                    </script>
                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
