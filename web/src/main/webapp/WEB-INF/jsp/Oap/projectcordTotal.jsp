<%-- 
    Document   : projectcordTotal
    Created on : Apr 7, 2026, 2:53:44 PM
    Author     : Sumanth
--%>






<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Designation-Wise Tracking Project Coordinator</title>
    </head>

    <body >


        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="" method="post" commandName="" class="form-horizontal" role="form">

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">Designation-Wise Tracking Project Coordinator-${ContactPerson}</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>
                        </div>
                    </div>
                        
                    <div class="mt-3 table-responsive">
                        <div class="d-flex align-items-center justify-content-between mb-3">
                            <div>
                                <select id="entriesPerPagePCTotal" class="select-input">
                                    <option value="10">10</option>
                                    <option value="20">20</option>
                                    <option value="50">50</option>
                                    <option value="100">100</option>
                                    <option value="-1">ALL</option>
                                </select>
                            </div>
                            <div>
                                <input type="text" id="searchBoxPCTotal" class="input-field" placeholder="Search here...">
                            </div>
                        </div>

                        <table id="crcFormListTable"class="table table-striped bg-white" style="width:100%">
                            <thead>
                                <tr>
                                    <th>Sr.No</th>                              
                                    <th style="min-width:180px;">Document No</th>   
                                    <th style="min-width:180px;">PCS Name</th>      
                                    <th style="min-width:180px;">Created By</th>   
                                    <th style="min-width:180px;">Designation</th>   
                                </tr>
                            </thead>
                        </table>
                    </div>

<script>
        $(document).ready(function () {
            var table = $('#crcFormListTable').DataTable({
                processing: true,
                serverSide: true,
                stateSave: false,
                ordering: true,
                orderMulti: false,
                order:       [[0, 'desc']],
                 ajax: {
                url:   'formsCommon.htm?act=projectcordTotalPaginationAjax',
                type:  'POST',
                cache: false,
                data: function (d) {
                    
                    d.contact = '${ContactPerson}';  
                    d.Value   = '${Value}';           
                },
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
                        data: 'userid',
                        orderable: true,
                        searchable: true
                    },
                    {
                        data: 'designation',
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

            $('#searchBoxPCTotal').on('keyup', function () {
                table.search(this.value).draw();
            });

            $('#entriesPerPagePCTotal').on('change', function () {
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
    
    <hr style="border-top:1px solid #2ecc71;margin:30px 0;">
    
     <div class="mt-3 table-responsive">
         <div class="d-flex align-items-center justify-content-between mb-3">
             <div>
                 <select id="entriesPerPagePCTotal1" class="select-input">
                     <option value="10">10</option>
                     <option value="20">20</option>
                     <option value="50">50</option>
                     <option value="100">100</option>
                     <option value="-1">ALL</option>
                 </select>
             </div>
             <div>
                 <input type="text" id="searchBoxPCTotal1" class="input-field" placeholder="Search here...">
             </div>
         </div>

         <table id="komFormListTable" class="table table-striped bg-white" style="width:100%">
             <thead>
                 <tr>
                     <th>Sr.No</th>                                      
                     <th style="min-width:150px;">Document No</th>       
                     <th style="min-width:190px;">Hub Location</th>      
                     <th style="min-width:150px;">Created By</th>        
                     <th style="min-width:150px;">Designation</th>       
                 </tr>
             </thead>
         </table>
     </div>

<script>
    $(document).ready(function () {

        // ← Fix: destroy before reinit to prevent "Cannot reinitialise" error
        if ($.fn.DataTable.isDataTable('#komFormListTable')) {
            $('#komFormListTable').DataTable().destroy();
        }

        var komTable = $('#komFormListTable').DataTable({
            processing:  true,
            serverSide:  true,
            stateSave:   false,
            ordering:    true,
            orderMulti:  false,
            order:       [[0, 'desc']],
            ajax: {
                url:   'formsCommon.htm?act=projectcordTotalPagination1Ajax',
                type:  'POST',
                cache: false,
                data: function (d) {
                    // ← Pass ContactPerson and Value from model
                    d.contact = '${ContactPerson}';
                    d.Value   = '${Value}';
                },
                error: function (xhr) {
                    console.log(xhr.responseText);
                }
            },
            columns: [
                { data: 'srNo',        orderable: true,  searchable: false }, // 0 → d.id
                { data: 'documentNo',  orderable: true,  searchable: true  }, // 1 → d.documentNo
                { data: 'hubLocation', orderable: true,  searchable: true  }, // 2 → d.hubLocation
                { data: 'userId',      orderable: true,  searchable: true  }, // 3 → d.userId
                { data: 'designation', orderable: true,  searchable: true  }  // 4 → d.designation
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

        $('#searchBoxPCTotal1').on('keyup', function () {
            komTable.search(this.value).draw();
        });

        $('#entriesPerPagePCTotal1').on('change', function () {
            var val = $(this).val();

            if (val === "" || val === "-1") {
                var total = komTable.page.info().recordsTotal;
                komTable.page.len(total > 0 ? total : 1).draw();
            } else {
                komTable.page.len(parseInt(val, 10)).draw();
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









