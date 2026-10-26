<%-- 
    Document   : monthWiseGraphAocDeatils
    Author     : Sumanth
--%>




<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> AOC of ${MonthName}</title>
    </head>

    <body >




        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="oapForm.htm?act=monthWiseGraphAocDeatils&label=${MonthName0}" method="post" commandName="OAPFilterForm" class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">Live AOC List of ${MonthName}</h5>
                        </div>
                        <div class="cta d-flex align-items-center">

<!--                            <button type="button" class="btn theme-btn mr-3" data-toggle="modal" data-target="#searchModal">
                                Filter
                            </button>-->
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>
                        </div>
                    </div>  
                        
                    <div class="cta d-flex align-items-center" style="gap: 10px;">
                        <!-- Bootstrap 3 Modal -->
                        <div id="searchModal" class="modal fade" tabindex="-1" role="dialog">
                            <div class="modal-dialog modal-md" style="margin-top:100px;" role="document">
                                <div class="modal-content">

                                    <div class="modal-header">
                                        <h5 class="modal-title pull-left">Search</h5>
                                        <button type="button" class="close pull-right" data-dismiss="modal" aria-label="Close">
                                            &times;
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label" for="date-filter">Filter By :</label>
                                            <div class="col-sm-9">
                                                <select id="date-filter" name="Filter" class="select-input">
                                                    <option value="--select--">--SELECT--</option>
                                                    <option value="last-week">Last-1-Week</option>
                                                    <option value="last-month">Last-1-Month</option>
                                                    <option value="last-6-month">Last-6-Month</option>
                                                    <option value="last-year">Last-1-Year</option>
                                                </select>
                                            </div>
                                        </div>


                                    </div>

                                    <div class="modal-footer">
                                        <button type="submit" class="btn theme-btn" name="btn" value="1">Apply</button>
                                        <a  class="btn theme-btn light-btn mr-3" data-dismiss="modal">Close</a>
                                        <!--                                    <button class="btn thead-light mr-2" data-dismiss="modal">Close</button>-->
                                    </div>
                                </div>
                            </div>
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
                        <table id="monthWiseGraphAOCDashboadTable" class="table table-striped bg-white" style="width:100%">

                            <thead>
                                <tr>
                                    <th>Sr.No.</th>
                                    <th style="min-width: 180px;">Document Number</th>
                                    <th>Depo.Name</th>
                                    <th style="min-width: 180px;">Project Name</th>
                                    <th style="min-width: 180px;">Created By</th>
                                    <th style="min-width: 180px;">Client Name</th>
                                    <th style="min-width: 150px;">Date</th>
                                    <th style="min-width: 180px;">Status</th>
                                    <th style="min-width: 190px;">Action</th>

                                </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </div>
            <script>
                
                $(document).ready(function () {

                    var table = $('#monthWiseGraphAOCDashboadTable').DataTable({
                        processing: true,
                        serverSide: true,
                        stateSave: false,
                        ordering: true,
                        orderMulti: false,
                        aaSorting: [[0, 'desc']],
                        ajax: {
                            url: 'formsCommon.htm?act=monthWiseGraphAOCPaginationAjax',
                            type: 'POST',
                            cache: false,
                            data: function (d) {
                                d.label = '${MonthName0}';  
                                return d;
                            }
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
                                data: 'hubDepoName',
                                orderable: true,
                                searchable: true
                            },
                            {
                                data: 'clientProjectName',
                                orderable: true,
                                searchable: true
                            },
                            {
                                data: 'userId',
                                orderable: true,
                                searchable: true
                            },
                            {
                                data: 'mobileNo',
                                orderable: true,
                                searchable: true
                            },
                            {
                                data: 'createdDate',
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
                                orderable: true,
                                searchable: true
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
                        dom: 'rt<"table-bottom-info d-flex align-items-center justify-content-between pt-3"i p>'

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
                });

            </script>
                </form:form>  
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>


</html>

