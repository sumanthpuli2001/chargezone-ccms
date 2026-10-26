
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Material</title>
    </head>
    <body>


        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="materialMaster.htm?act=search" commandName="materialMaster" method="post">

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Search Material</h5>
                        </div>
                        
                    </div>
                    
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

                    <div class="rounded-4 mt-4 sticky-model1">
                        <div class="row mb-3">
                            <div class="col-lg-6 col-md-6">
                                <div class="form-group">
                                    <label  class="label">Material Group :</label>
                                    <select class="select-input" id="group" name="group">
                                        <option value="">-- Select --</option>
                                        <c:forEach var="group" items="${group}">
                                            <option value="${group.id}">${group.materialGroupName}</option>                                               
                                        </c:forEach>
                                    </select>
                                </div>   
                            </div>
                            <div class="col-lg-6 col-md-6">
                                <div class="form-group">
                                    <label  class="label">Material Type :</label>
                                    <select class="select-input" id="type" name="type">
                                        <option value="">--- Select ---</option>
                                        <c:forEach var="type" items="${type}">
                                            <option value="${type.id}">${type.materialType}</option>
                                        </c:forEach>
                                    </select>
                                </div>   
                            </div>
                            <div class="col-lg-6 col-md-6">
                                <div class="form-group">
                                    <label  class="label">Enter Material Code :</label>
                                    <input name="materialCode" id="materialCode" class="input-field"/>
                                </div>   
                            </div>
                            <div class="col-lg-6 col-md-6">
                                <div class="form-group">
                                    <label  class="label">Enter Material Description:</label>
                                    <input name="materialDescription" id="materialDescription" class="input-field"/>
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

                            <div class="d-flex align-items-center ml-auto">

                                <div class="cta d-flex mr-1">
                                    <input type="text" id="searchBox" class="input-field" placeholder="Search here...">
                                </div>

                                <div class="cta d-flex ml-2">
                                    <a href="materialMaster.htm?act=showviewList" class="btn theme-btn flex">
                                        <img src="StorageYard/assets/images/plus.svg" onload="SVGInject(this)" class="mr-3 icon" alt="Plus Icon">
                                        Add New
                                    </a>
                                </div>

                            </div>

                        </div>

                        <table id="materialTable" class="table table-striped bg-white dt-scroll" style="width:100%">

                            <thead>

                                <tr>
                                    <th>Sr. No</th>
                                    <th>Material Type</th>
                                    <th>Material Group</th>
                                    <th>Material code</th>
                                    <th>Material Description</th>
                                    <th>Material Long Description</th>
                                    <th>UOM</th>
                                    <th>Hsn No.</th>
                                    <th>GST</th>
                                    <th>Actions</th>
                                </tr>

                            </thead>

                        </table>

                    </div>
                    
                    <script>

                        var table;

                        $(document).ready(function () {

                            table = $('#materialTable').DataTable({

                                processing: true,

                                serverSide: true,

                                stateSave: false,

                                ordering: true,

                                orderMulti: false,

                                aaSorting: [[0, 'asc']],

                                columnDefs: [
                                    {
                                        targets: [9],
                                        orderable: false,
                                        searchable: false
                                    }
                                ],

                                ajax: {

                                    url: 'materialMaster.htm?act=materialPaginationAjax',

                                    type: 'POST',

                                    cache: false,

                                    data: function (d) {

                                        d.group = $('#group').val();

                                        d.type = $('#type').val();

                                        d.materialCode = $('#materialCode').val();

                                        d.materialDescription = $('#materialDescription').val();

                                    }

                                },

                                columns: [

                                    {
                                        data: 'srNo',
                                        orderable: true,
                                        searchable: false
                                    },

                                    {data: 'materialTypeMaster'},
                                    {data: 'materialGroupMaster'},                                    
                                    {data: 'materialCode'},                                    
                                    {data: 'materialDescription'},                                    
                                    {data: 'materialLongDescription'},                                    
                                    {data: 'uom'},                                    
                                    {data: 'hsnNo'},                                    
                                    {data: 'gst'},                                    

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

                            $('#group, #type, #materialCode, #materialDescription')
                            .on('keyup', function () {

                                table.ajax.reload(null, true);

                            });
                            
                            $(document).on(
                                'click',
                                '.delete-btn1',
                                function (e) {
                                    e.preventDefault();
                                    var id = $(this).data('id');
                                    Swal.fire({
                                        title: 'Are you sure?',
                                        text: 'Do You Really Want To Delete This Material Data?',
                                        icon: 'warning',
                                        showCancelButton: true,
                                        confirmButtonText: 'Yes Delete',
                                        customClass:{
                                            comfirmButton: 'confirm-delete',
                                            cancelButton: 'theme-btn light-btn'
                                        }

                                    }).then((result) => {
                                        if (result.isConfirmed) {
                                            $.ajax({
                                                url: 'materialMaster.htm?act=deleteSubmit',
                                                type: 'POST',
                                                data: {
                                                    id: id
                                                },

                                                success: function () {
                                                    Swal.fire({
                                                        icon: 'success',
                                                        title: 'Deleted',
                                                        text: 'Record deleted successfully'
                                                    });
                                                    table.ajax.reload(null, false);
                                                },

                                                error: function (xhr) {
                                                    Swal.fire({
                                                        icon: 'error',
                                                        title: 'Error',
                                                        text: 'Delete failed'
                                                    });
                                                }
                                            });
                                        }
                                    });
                                });
                            

                        });

                       

                    </script>

                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>

</script>
</html>

