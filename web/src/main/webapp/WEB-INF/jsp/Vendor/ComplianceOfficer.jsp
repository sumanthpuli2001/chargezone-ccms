<%-- 
    Document   : ShowDepartmentList
    Created on : 2 Jan, 2024, 6:01:06 PM
    Author     : Bulwark-5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>Compliance Officer</title>
        <script>        
            function viewClickss(id) {
                window.location = 'vendorInformation.htm?act=approveoneviewClickTwo&id=' + id;
            }
            function viewClickss1(id) {
                window.location = 'vendorInformation.htm?act=ComplianceOfficerViewAndApproved&id=' + id;
            }
            function deleteCheck11() {
                var checkboxes = "";
                checkboxes = document.getElementsByName('checkId');
                for (var i = 0, n = checkboxes.length; i < n; i++) {
                    if (checkboxes[i].checked) {
                        return true;
                    }
                }
                alert("Please, Select one or more record(s).");
                return false;
            }
        </script>
    </head>
    
    <body>
        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

            <section class="main-content">
                <div class="card-box rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                    <div class="page-title d-flex align-items-center">
                        <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                            <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                 alt="Menu collapse">
                            <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                 alt="Menu collapse">
                        </div>

                        <h5 class="fw-600 mb-0">Compliance Officer</h5>
                    </div>

                    <div class="cta d-flex align-items-center">
                         <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a> 
                         <a href="javascript:void(0)" id="exportExcelBtn" class="btn theme-btn">Export To Excel</a>
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
                    <table id="complianceOfficerTable" class="table table-striped dt-scroll bg-white" style="width:100%;">

                        <thead>
                            <tr>
                                <th>Sr.No.</th>
                                <th>Company Name</th>
                                <th>Email Id</th>
                                <th>Status</th>
                                <th>Action</th>
                            </tr>
                        </thead>

                        <tbody></tbody>                        

                    </table>
                </div>
                
                <script>
                    var table;

                    $(document).ready(function () {

                        table = $('#complianceOfficerTable').DataTable({

                            processing: true,

                            serverSide: true,

                            stateSave: false,

                            ordering: true,

                            orderMulti: false,

                            aaSorting: [[0, 'asc']],

                            scrollCollapse: true,

                            scrollY: '80vh',                               

                            ajax: {

                                url: 'vendorInformation.htm?act=complianceOfficerAjax',

                                type: 'POST',

                                cache: false,
                            },

                            columns: [

                                {
                                    data: 'srNo',
                                    orderable: true,
                                    searchable: false
                                },

                                {data: 'companyName'},
                                {data: 'vendorEmailId'},

                                {
                                    data: 'status',
                                    orderable: false,
                                    searchable: false
                                },

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

                            scrollX: false,

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

                        // For Export To Excel
                        $('#exportExcelBtn').on('click', function () {

                            var params = {
                                searchValue: $('#searchBox').val()
                            };

                            var $form = $('<form>', {
                                method: 'POST',
                                action: 'vendorInformation.htm?act=complianceOfficerExportExcel'
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

            </section>
        </main> 
    </body>

    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
    
</html>


