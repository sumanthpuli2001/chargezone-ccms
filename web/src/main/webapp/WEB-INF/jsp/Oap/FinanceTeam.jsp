<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Finance Team</title>
    </head>



    <body>

        <main class="d-flex align-items-end justify-content-end">

            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

            <section class="main-content">

                <form:form action=".htm?act=" commandName="departmentMaster" method="post">

                    <!-- PAGE HEADER -->
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Finance Team</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                             <c:if test="${not empty list}">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                            </c:if>
                        </div>
                    </div>

                    <hr>
                    

                    <h6 class="fw-600">OAP Details</h6>
                    <div class="mt-3 table-responsive">
                        <div class="d-flex align-items-center justify-content-between mb-3">
                            <div>
                                <select id="entriesPerPageNetwork" class="select-input">
                                    <option value="10">10</option>
                                    <option value="20">20</option>
                                    <option value="50">50</option>
                                    <option value="100">100</option>
                                    <option value="-1">ALL</option>
                                </select>
                            </div>
                            <div>
                                <input type="text" id="searchBoxNetwork" class="input-field"
                                       placeholder="Search here...">
                            </div>
                        </div>

                        <table id="networkTeamTable"
                               class="table table-striped bg-white" style="width:100%">
                            <thead>
                                <tr>
                                    <th>Sr.No</th>                                 
                                    <th style="min-width:190px;">Document ID</th>   
                                    <th style="min-width:190px;">PCS Name</th>     
                                    <th style="min-width:190px;">Project Name</th>  
                                    <th style="min-width:190px;">Client Name</th>   
                                    <th style="min-width:190px;">Department</th>    
                                    <th style="min-width:190px;">Created Date</th>  
                                    <th style="min-width:190px;">Created By</th>   
                                    <th data-dt-order="disable">Status</th>        
                                    <th data-dt-order="disable">View</th>          
                                </tr>
                            </thead>
                        </table>
                    </div>

<script>
    $(document).ready(function () {
        var networkTable = $('#networkTeamTable').DataTable({
            processing:  true,
            serverSide:  true,
            stateSave:   false,
            ordering:    true,
            orderMulti:  false,
            order:       [[0, 'desc']],
            ajax: {
                url:   'formsCommon.htm?act=financeTeamPaginationAjax',
                type:  'POST',
                cache: false
            },
            columns: [
                { data: 'srNo',        orderable: true,  searchable: false }, 
                { data: 'documentNo',  orderable: true,  searchable: true  }, 
                { data: 'pcsName',     orderable: true,  searchable: true  }, 
                { data: 'projectName', orderable: true,  searchable: true  }, 
                { data: 'mobileNo',    orderable: true,  searchable: true  }, 
                { data: 'department',  orderable: true,  searchable: true  }, 
                { data: 'createdDate', orderable: true,  searchable: true  }, 
                { data: 'userId',      orderable: true,  searchable: true  }, 
                { data: 'status',      orderable: false, searchable: false  }, 
                { data: 'view',        orderable: false, searchable: false,
                  render: function (data) { return data; } }                  
            ],
            pageLength:   10,
            lengthChange: false,
            searching:    true,
            info:         true,
            autoWidth:    false,
            responsive:   true,
            scrollX:      true,
            scrollCollapse: true,
            scrollY: '80vh',
            dom: 'rt<"table-bottom-info d-flex align-items-center justify-content-between pt-3"i p>'
        });

        $('#searchBoxNetwork').on('keyup', function () {
            networkTable.search(this.value).draw();
        });
        
        $('#entriesPerPageNetwork').on('change', function () {
            var val = $(this).val();
            if (val === "" || val === "-1") {
                var total = networkTable.page.info().recordsTotal;
                networkTable.page.len(total > 0 ? total : 1).draw();
            } else {
                networkTable.page.len(parseInt(val, 10)).draw();
            }
        });
    });
</script>

                    <hr style="border-top:1px solid #2ecc71; margin:30px 0;">


                    <h6 class="fw-600">AOC Details</h6>
                    <div class="mt-3 table-responsive">
                        <div class="d-flex align-items-center justify-content-between mb-3">
                            <div>
                                <select id="entriesPerPageAocNetwork" class="select-input">
                                    <option value="10">10</option>
                                    <option value="20">20</option>
                                    <option value="50">50</option>
                                    <option value="100">100</option>
                                    <option value="-1">ALL</option>
                                </select>
                            </div>
                            <div>
                                <input type="text" id="searchBoxAocNetwork" class="input-field"
                                       placeholder="Search here...">
                            </div>
                        </div>

                        <table id="aocNetworkTeamTable"
                               class="table table-striped bg-white" style="width:100%">
                            <thead>
                                <tr>
                                    <th>Sr.No</th>                                          
                                    <th style="min-width:190px;">Document ID</th>           
                                    <th style="min-width:190px;">Hub Depo Name</th>        
                                    <th style="min-width:190px;">Project Name</th>         
                                    <th style="min-width:190px;">Created By</th>           
                                    <th style="min-width:190px;">Designation</th>          
                                    <th style="min-width:190px;">Created Date</th>          
                                    <th data-dt-order="disable">Status</th>                
                                    <th data-dt-order="disable">View</th>                   
                                </tr>
                            </thead>
                        </table>
                    </div>

<script>
    $(document).ready(function () {
        var aocNetworkTable = $('#aocNetworkTeamTable').DataTable({
            processing:  true,
            serverSide:  true,
            stateSave:   false,
            ordering:    true,
            orderMulti:  false,
            order:       [[0, 'desc']],
            ajax: {
                url:   'formsCommon.htm?act=aocFinanceTeamPaginationAjax',
                type:  'POST',
                cache: false
            },
            columns: [
                { data: 'srNo',              orderable: true,  searchable: false }, 
                { data: 'documentNo',        orderable: true,  searchable: true  }, 
                { data: 'hubDepoName',       orderable: true,  searchable: true  }, 
                { data: 'clientProjectName', orderable: true,  searchable: true  }, 
                { data: 'userId',            orderable: true,  searchable: true  }, 
                { data: 'designation',       orderable: true,  searchable: true  }, 
                { data: 'createdDate',       orderable: true,  searchable: true  }, 
                { data: 'status',            orderable: false, searchable: false  }, 
                { data: 'view',              orderable: false, searchable: false,
                  render: function (data) { return data; } }                        
            ],
            pageLength:   10,
            lengthChange: false,
            searching:    true,
            info:         true,
            autoWidth:    false,
            responsive:   true,
            scrollX:      true,
            scrollCollapse: true,
            scrollY: '80vh',
            dom: 'rt<"table-bottom-info d-flex align-items-center justify-content-between pt-3"i p>'
        });

        $('#searchBoxAocNetwork').on('keyup', function () {
            aocNetworkTable.search(this.value).draw();
        });
        
        $('#entriesPerPageAocNetwork').on('change', function () {
            var val = $(this).val();
            if (val === "" || val === "-1") {
                var total = aocNetworkTable.page.info().recordsTotal;
                aocNetworkTable.page.len(total > 0 ? total : 1).draw();
            } else {
                aocNetworkTable.page.len(parseInt(val, 10)).draw();
            }
        });
    });
</script>


                </form:form>

            </section>
        </main>

        <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>

    </body>
    
</html>
