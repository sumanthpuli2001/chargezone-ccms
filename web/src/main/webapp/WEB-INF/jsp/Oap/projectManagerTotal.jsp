<%-- 
    Document   : projectManagerTotal
    Created on : 9 Apr, 2026, 11:10:44 AM
    Author     : admin
--%>







<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Designation-Wise Tracking Project Manager</title>
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
                            <h5 class="fw-600 mb-0">Designation-Wise Tracking Project Manager-${ContactPerson}</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>
                        </div>
                    </div>                                       
                        
                        <div class="content-top mb-0 d-flex align-items-center justify-content-between row my-3">
                            <div class="col-md-1 pr-md-1">
                                <select id="entriesPerPagePMTotalCRC" class="select-input">
                                    <option value="10">10</option>
                                    <option value="25">25</option>
                                    <option value="50">50</option>
                                    <option value="100">100</option>
                                    <option value="-1">ALL</option>
                                </select>
                            </div>
                            <div class="col-md-3 pl-md-1" ><h6>CRC Form</h6></div>
                            <div class="col-md-3 pl-md-1" >
                                <input id="searchBoxPMTotalCRC" type="text" class="input-field" placeholder="Search here...">
                            </div>
                        </div>
                        <!--<h6>CRC Form</h6>-->
                        <table id="pmTotalCRCTable" class="table table-striped bg-white" style="min-width: 100%;">

                            <thead>
                                <tr>
                                    <th>Sr.No</th>                                  
                                    <th style="min-width:180px;">Document No</th>   
                                    <th style="min-width:180px;">PCS Name</th>      
                                    <th style="min-width:180px;">Designation</th>  
                                </tr>
                            </thead>


                            </tbody>

                        </table>  
                  
                     
                    
                    
                     <script>
            $(document).ready(function () {

                if ($.fn.DataTable.isDataTable('#pmTotalCRCTable')) {
                    $('#pmTotalCRCTable').DataTable().destroy();
                }

                var pmTotalCRCTable = $('#pmTotalCRCTable').DataTable({
                    processing:  true,
                    serverSide:  true,
                    stateSave:   false,
                    ordering:    true,
                    orderMulti:  false,
                    order:       [[0, 'desc']],
                    ajax: {
                        url:   'formsCommon.htm?act=projectManagerTotalCRCPaginationAjax',
                        type:  'POST',
                        cache: false,
                        data: function (d) {
                            d.contact            = '${ContactPerson}';
                            d.Value              = '${Value}';          
                            d.Fromdate           = $('#Fromdate').val();
                            d.Todate             = $('#Todate').val();
                            d.Filter             = $('#Filter').val();
                            d.formattedDate      = $('#formattedDate').val();
                            d.formattedStartDate = $('#formattedStartDate').val();
                        },
                        error: function (xhr) {
                            console.log(xhr.responseText);
                        }
                    },
                    columns: [
                        { data: 'srNo',        orderable: true,  searchable: false }, 
                        { data: 'documentNo',  orderable: true,  searchable: true  }, 
                        { data: 'pcsName',     orderable: true,  searchable: true  }, 
                        { data: 'designation', orderable: true,  searchable: true  }
                    ],
                    pageLength:   10,
                    lengthChange: false,
                    searching:    true,
                    info:         true,
                    autoWidth:    false,
                    responsive:   true,
                    scrollX:      false,
                    scrollCollapse: true,                    
                    scrollY: '80vh',
                    dom: 'rt<"table-bottom-info d-flex align-items-center justify-content-between pt-3"i p>'
                });

                $('#searchBoxPMTotalCRC').on('keyup', function () {
                    pmTotalCRCTable.search(this.value).draw();
                });
                
                $('#entriesPerPagePMTotalCRC').on('change', function () {
                    var val = $(this).val();

                    if (val === "" || val === "-1") {
                        var total = pmTotalCRCTable.page.info().recordsTotal;
                        pmTotalCRCTable.page.len(total > 0 ? total : 1).draw();
                    } else {
                        pmTotalCRCTable.page.len(parseInt(val, 10)).draw();
                    }
                });

                $('#Fromdate, #Todate, #Filter').on('change keyup', function () {
                    pmTotalCRCTable.ajax.reload(null, true);
                });
            });
        </script>
                     
        <hr style="border-top:1px solid #2ecc71;margin:30px 0;">                    
            <div class="content-top mb-0 d-flex align-items-center justify-content-between row my-3">
                <div class="col-md-1 pr-md-1">
                    <select id="entriesPerPagePMKOM" class="select-input">
                        <option value="10">10</option>
                        <option value="25">25</option>
                        <option value="50">50</option>
                        <option value="100">100</option>
                        <option value="-1">ALL</option>
                    </select>
                </div>
                <div class="col-md-3 pl-md-1" ><h6>KOM Form</h6></div>
                <div class="col-md-3 pl-md-1" >
                    <input id="searchBoxPMKOM" type="text" class="input-field" placeholder="Search here...">
                </div>
            </div>        

            <table id="pmTotalKOMTable" class="table table-striped bg-white" style="min-width: 100%;">

                <thead>
                    <tr>
                        <th>Sr.No</th>                                  
                        <th style="min-width:150px;">Document No</th>   
                        <th style="min-width:190px;">Hub Location</th>
                        <th style="min-width:150px;">Project Name</th>  
                    </tr>
                </thead>                          
            </table>   
        
        <script>
            $(document).ready(function () {

                if ($.fn.DataTable.isDataTable('#pmTotalKOMTable')) {
                    $('#pmTotalKOMTable').DataTable().destroy();
                }

                var pmTotalKOMTable = $('#pmTotalKOMTable').DataTable({
                    processing:  true,
                    serverSide:  true,
                    stateSave:   false,
                    ordering:    true,
                    orderMulti:  false,
                    order:       [[0, 'desc']],
                    ajax: {
                        url:   'formsCommon.htm?act=projectManagerTotalKOMPaginationAjax',
                        type:  'POST',
                        cache: false,
                        data: function (d) {
                            d.contact            = '${ContactPerson}'; 
                            d.Value              = '${Value}';          
                            d.Fromdate           = $('#Fromdate').val();
                            d.Todate             = $('#Todate').val();
                            d.Filter             = $('#Filter').val();
                            d.formattedDate      = $('#formattedDate').val();
                            d.formattedStartDate = $('#formattedStartDate').val();
                        },
                        error: function (xhr) {
                            console.log(xhr.responseText);
                        }
                    },
                    columns: [
                        { data: 'srNo',        orderable: true,  searchable: false }, 
                        { data: 'documentNo',  orderable: true,  searchable: true  }, 
                        { data: 'hubLocation', orderable: true,  searchable: true  }, 
                        { data: 'projectName', orderable: true,  searchable: true  }
                    ],
                    pageLength:   10,
                    lengthChange: false,
                    searching:    true,
                    info:         true,
                    autoWidth:    false,
                    responsive:   true,
                    scrollX:      false,
                    scrollCollapse: true,                    
                    scrollY: '80vh',
                    dom: 'rt<"table-bottom-info d-flex align-items-center justify-content-between pt-3"i p>'
                });

                $('#searchBoxPMKOM').on('keyup', function () {
                    pmTotalKOMTable.search(this.value).draw();
                });
                
                $('#entriesPerPagePMKOM').on('change', function () {
                    var val = $(this).val();

                    if (val === "" || val === "-1") {
                        var total = pmTotalKOMTable.page.info().recordsTotal;
                        pmTotalKOMTable.page.len(total > 0 ? total : 1).draw();
                    } else {
                        pmTotalKOMTable.page.len(parseInt(val, 10)).draw();
                    }
                });

                $('#Fromdate, #Todate, #Filter').on('change keyup', function () {
                    pmTotalKOMTable.ajax.reload(null, true);
                });
            });
        </script>
                    
                    
                    
                </form:form>  
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
     
</html>

</html>
