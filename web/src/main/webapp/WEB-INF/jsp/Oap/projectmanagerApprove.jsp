<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deliverable Approved By Manager</title>
    </head>

    <style>
        .text-width-btn {
            width: fit-content;
            white-space: nowrap;
        }

    </style>

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

                            <h5 class="fw-600 mb-0">Deliverable Approved By Manager</h5>
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
                    
                    <h6 class="fw-600">OAP Details</h6>
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
            <input type="text" id="searchBox" class="input-field"
                   placeholder="Search here...">
        </div>
    </div>

    <table id="projMgrApprovalTable"
           class="table table-striped bg-white" style="width:100%">
        <thead>
            <tr>
                <th>Sr.No</th>                                     
                <th style="min-width:190px;">OAP Document ID</th>   
                <th style="min-width:190px;">CRC Document ID</th>   
                <th style="min-width:190px;">PCS Name</th>          
                <th style="min-width:190px;">Project Name</th>      
                <th style="min-width:190px;">Client Name</th>       
                <th style="min-width:190px;">Department</th>        
                <th style="min-width:190px;">Created Date</th>    
                <th style="min-width:190px;">Created By</th>       
                <th data-dt-order="disable">View</th>              
                <th data-dt-order="disable">Action</th>            
            </tr>
        </thead>
    </table>
</div>

<script>
    $(document).ready(function () {
        var table = $('#projMgrApprovalTable').DataTable({
            processing:  true,
            serverSide:  true,
            stateSave:   false,
            ordering:    true,
            orderMulti:  false,
            order:       [[0, 'desc']],
            ajax: {
                url:   'formsCommon.htm?act=oapprojmanaApprmultiPaginationAjax',
                type:  'POST',
                cache: false
            },
            columns: [
                { data: 'srNo',          orderable: true,  searchable: false },  
                { data: 'oapDocumentNo', orderable: true,  searchable: true  },  
                { data: 'crcDocumentNo', orderable: true,  searchable: true  },  
                { data: 'pcsName',       orderable: true,  searchable: true  },  
                { data: 'projectName',   orderable: true,  searchable: true  },  
                { data: 'mobileNo',      orderable: true,  searchable: true  },  
                { data: 'department',    orderable: true,  searchable: true  },  
                { data: 'createdDate',   orderable: true,  searchable: true  }, 
                { data: 'userId',        orderable: true,  searchable: true  },  
                { data: 'view',          orderable: false, searchable: false,
                  render: function (data) { return data; } },                    
                { data: 'action',        orderable: false, searchable: false,
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
                

                    <hr style="border-top:1px solid #2ecc71; margin:30px 0;">
                    
                    <h6 class="fw-600">AOC Details</h6>
                   <div class="mt-3 table-responsive">
    <div class="d-flex align-items-center justify-content-between mb-3">
        <div>
            <select id="entriesPerPageAoc" class="select-input">
                <option value="10">10</option>
                <option value="20">20</option>
                <option value="50">50</option>
                <option value="100">100</option>
                <option value="-1">ALL</option>
            </select>
        </div>
        <div>
            <input type="text" id="searchBoxAoc" class="input-field" placeholder="Search here...">
        </div>
    </div>

    <table id="aocProjMgrApprovalTable"class="table table-striped bg-white" style="width:100%">
        <thead>
            <tr>
                <th>Sr.No</th>                                          
                <th style="min-width:190px;">AOC Document ID</th>       
                <th style="min-width:190px;">KickOff Document ID</th>  
                <th style="min-width:190px;">Hub Depo Name</th>         
                <th style="min-width:190px;">Project Name</th>          
                <th style="min-width:190px;">Created By</th>            
                <th style="min-width:190px;">Designation</th>           
                <th style="min-width:190px;">Created Date</th>          
                <th data-dt-order="disable">View</th>                  
                <th data-dt-order="disable">Action</th>                 
            </tr>
        </thead>
    </table>
</div>

<script>
    $(document).ready(function () {
        var aocTable = $('#aocProjMgrApprovalTable').DataTable({
            processing:  true,
            serverSide:  true,
            stateSave:   false,
            ordering:    true,
            orderMulti:  false,
            order:       [[0, 'desc']],
            ajax: {
                url:   'formsCommon.htm?act=aocprojmanaApprmultiPaginationAjax',
                type:  'POST',
                cache: false
            },
            columns: [
                { data: 'srNo',              orderable: true,  searchable: false }, 
                { data: 'aocDocumentNo',     orderable: true,  searchable: true  }, 
                { data: 'kickOffDocumentNo', orderable: true,  searchable: true  }, 
                { data: 'hubDepoName',       orderable: true,  searchable: true  }, 
                { data: 'clientProjectName', orderable: true,  searchable: true  }, 
                { data: 'userId',            orderable: true,  searchable: true  }, 
                { data: 'designation',       orderable: true,  searchable: true  }, 
                { data: 'createdDate',       orderable: true,  searchable: true  }, 
                { data: 'view',              orderable: false, searchable: false,
                  render: function (data) { return data; } },                       
                { data: 'action',            orderable: false, searchable: false,
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

        $('#searchBoxAoc').on('keyup', function () {
            aocTable.search(this.value).draw();
        });
        
        $('#entriesPerPageAoc').on('change', function () {
            var val = $(this).val();
            if (val === "" || val === "-1") {
                var total = aocTable.page.info().recordsTotal;
                aocTable.page.len(total > 0 ? total : 1).draw();
            } else {
                aocTable.page.len(parseInt(val, 10)).draw();
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
