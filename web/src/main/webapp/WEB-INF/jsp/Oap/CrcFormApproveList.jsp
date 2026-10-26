<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OAP Form List</title>
    </head>



    <body>

        <main class="d-flex align-items-end justify-content-end">
                  
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

            <section class="main-content">


                    <!-- PAGE HEADER -->
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">OAP Form List</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <c:if test="${not empty list}">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                             </c:if>
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
                        <table id="oapFormList" class="table table-striped bg-white" style="width:100%">
                            <thead>
                                <tr>
                                    <th>Sr.No</th>
                                    <th>Document ID</th>
                                    <th>PCS Name</th>
                                    <th>Project Name</th>
                                    <th>Department</th>
                                    <th>Created Date </th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </div>

                    
                    
                    <hr style="border-top:1px solid #2ecc71; margin:30px 0;">


                    <h6 style="font-weight:600; margin-bottom:15px;">OAP Exited Details</h6>
                   
                    <div class="mt-3 table-responsive">
    <div class="d-flex align-items-center justify-content-between mb-3">
        <div>
            <select id="entriesPerPage1" class="select-input">
                <option value="10">10</option>
                <option value="20">20</option>
                <option value="50">50</option>
                <option value="100">100</option>
                <option value="-1">ALL</option>
            </select>
        </div>
        <div>
            <input type="text" id="searchBox1" class="input-field" placeholder="Search here...">
        </div>
    </div>

    <table id="oapExitedDetails" class="table table-striped bg-white" style="width:100%">
        <thead>
            <tr>
                <th>Sr.No</th>
                <th>Document No</th>
                <th>PCS Name</th>
                <th>Project Name</th>
                <th>Department</th>
                <th>Created Date</th>
                <th data-dt-order="disable">Actions</th>
            </tr>
        </thead>
        <tbody></tbody>
    </table>
</div>
                                       
                               
                                



            </section>
        </main>
<script>
        $(document).ready(function () {
            var table = $('#oapFormList').DataTable({
                processing: true,
                serverSide: true,
                stateSave: false,
                ordering: true,
                orderMulti: false, 
                order:       [[0, 'desc']],
                ajax: {
                    url: 'formsCommon.htm?act=CrcFormApproveListPaginationAjax',
                    type: 'POST',
                    cache: false,
                    error: function (xhr) {
                        console.log(xhr.responseText);
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
                        data: 'pcsName',
                        orderable: true,
                        searchable: true
                    },
                    {
                        data: 'projectName',
                        orderable: true,
                        searchable: true
                    },
                    {
                        data: 'department',
                        orderable: true,
                        searchable: true
                    },
                    {
                        data: 'createdDate',
                        orderable: true,
                        searchable: true
                    },
                    
                    {
                        data: 'action',
                        orderable: false,
                        searchable: false,
                        render: function (data) {
                            return data;
                        }
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

            $('#searchBox1').on('keyup', function () {
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
    
    <script>
    $(document).ready(function () {
        var table = $('#oapExitedDetails').DataTable({
            processing:  true,
            serverSide:  true,
            stateSave:   false,
            ordering:    true,
            orderMulti:  false,
            order:       [[0, 'desc']],
            ajax: {
                url:   'formsCommon.htm?act=oapExitedDetailsPaginationAjax',
                type:  'POST',
                cache: false,
                error: function (xhr) {
                    console.error('DataTable ajax error:', xhr.responseText);
                }
            },

            columns: [
                { data: 'srNo',        orderable: false, searchable: false },  
                { data: 'documentNo',  orderable: true,  searchable: true  },
                { data: 'pcsName',     orderable: true,  searchable: true  },
                { data: 'projectName', orderable: true,  searchable: true  },
                { data: 'department',  orderable: true,  searchable: true  },
                { data: 'createdDate', orderable: true,  searchable: true  },
                {
                    data:       'action',
                    orderable:  false,
                    searchable: false,
                    render: function (data) { return data; }
                }
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

        $('#searchBox1').on('keyup', function () {
            table.search(this.value).draw();
        });
        
        $('#entriesPerPage1').on('change', function () {
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
    
    
    
    
    
        <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>

    </body>
    
   
</html>
