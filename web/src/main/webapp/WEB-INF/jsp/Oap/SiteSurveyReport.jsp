
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Site Survey Report</title>
    </head>
    <body>        
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

                            <h5 class="fw-600 mb-0">Site Survey Report</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <c:if test="${not empty list}">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>
                            </c:if>
                            <!--<button type="submit" class="btn theme-btn">Search</button>-->
                        </div>
                    </div>

                    <hr>

                    <div class="rounded-4 mt-6 sticky-model1">

                        <div class="row mb-3">

                            <!-- Tender No -->
                            <div class="col-lg-4 col-md-2">
                                <div class="form-group">
                                    <label  class="label">Enter Survey Document No</label>

                                    <input type="text" name="SiteSurveyNumber" id="SiteSurveyNumber" value="" class="input-field" maxlength="30" autocomplete="off"/>
                                </div>
                            </div>     
                            <div class="col-lg-4 col-md-2">
                                <div class="form-group">
                                    <label  class="label">From Date</label>

                                    <div  class="form-group date" id="datetimepickers6" >
                                        <input placeholder="DD/MM/YYYY" name="open_from_date" style="background: white;" id="open_from_date" type="text" 
                                               class="input-field form_datetime" maxlength="30" autocomplete="off"  
                                               />
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-2">
                                <div class="form-group">
                                    <label  class="label">To Date</label>
                                    <div  class="form-group date" id="datetimepickers5" >
                                        <input placeholder="DD/MM/YYYY" name="open_to_date" style="background: white;" id="open_to_date"  type="text" class="input-field form_datetime"  maxlength="30" autocomplete="off"    />
                                    </div>
                                </div>
                            </div>


                        </div>     
                    </div>
                    
                    <script>
                        $(function () {

                            $(function () {
                                let selectedFromDate = null;
                                let selectedToDate = null;
                                function showInvalidToast() {
                                    Bootoast.toast({
                                        message: 'To Date cannot be earlier than From Date.',
                                        type: 'warn',
                                        timeout: 2000,
                                        position: 'top-center'
                                    });
                                    toDatePicker.clear();
                                    selectedToDate = null;
                                }

                                const toDatePicker = flatpickr("#open_to_date", {
                                    dateFormat: "d-m-Y",
                                    onChange: function (selectedDates) {
                                        selectedToDate = selectedDates[0];
                                    },
                                    onValueUpdate: function (selectedDates) {
                                        selectedToDate = selectedDates[0];
                                    }
                                });
                                const fromDatePicker = flatpickr("#open_from_date", {
                                    dateFormat: "d-m-Y",
                                    onChange: function (selectedDates, dateStr) {
                                        const newFromDate = selectedDates[0];
                                        if (selectedToDate && newFromDate && selectedToDate.getTime() < newFromDate.getTime()) {
                                            showInvalidToast();
                                        }

                                        selectedFromDate = newFromDate;
                                        if (selectedFromDate) {
                                            toDatePicker.set('minDate', selectedFromDate);
                                        }
                                    },
                                    onValueUpdate: function (selectedDates) {
                                        selectedFromDate = selectedDates[0];
                                    }
                                });
                            });
                        }); 
                    </script>
                    
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

                        <table id="siteSurveyReportTable" class="table table-striped bg-white" style="width:100%">

                            <thead>

                                <tr>
                                    <th>Sr.No</th>
                                    <th>Survey Document No</th>
                                    <th>Site Name</th>
                                    <th>Site Address</th>
                                    <th>Created By</th>
                                    <th>Description </th>
                                </tr>

                            </thead>

                        </table>

                    </div>

                    <script>

                        var table;

                        $(document).ready(function () {

                            table = $('#siteSurveyReportTable').DataTable({

                                processing: true,

                                serverSide: true,

                                stateSave: false,

                                ordering: true,

                                orderMulti: false,

                                aaSorting: [[0, 'desc']],

                                ajax: {

                                    url: 'formsCommon.htm?act=siteSurveyReportPaginationAjax',

                                    type: 'POST',

                                    cache: false,

                                    data: function (d) {

                                        d.SiteSurveyNumber = $('#SiteSurveyNumber').val();

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

                                    { data: 'surveyDocumentNo' },
                                    { data: 'siteName' },
                                    { data: 'siteAddress' },
                                    { data: 'createdBy' },
                                    { data: 'description' }

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

                            $('#SiteSurveyNumber, #open_from_date, #open_to_date')
                                .on('change keyup', function () {

                                    table.ajax.reload(null, true);

                                });

                        });
                    </script>
                
                    
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
    <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
</html>
