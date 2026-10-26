<%-- 
    Document   : All Vendor
    Created on : 13 Oct, 2025, 12:04:04 PM
    Author     : fnp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>ALL Vendor List</title>        
    </head>

    <body>
        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

            <section class="main-content">
                <form:form action="" method="post" commandName="rightMaster"
                           name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
                    <div class="card-box rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)" alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)" alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">ALL Vendor List</h5>
                        </div>
                        <div class="cta d-flex align-items-center">                            
                            <c:if test="${fn:contains(sessionScope.userRights.venderInvite,'1')}">
                                <a onclick="window.location = 'vendorInvitation.htm?act=addVendorInvitation'" class="btn theme-btn flex mr-3">
                                    <img src="StorageYard/assets/images/plus.svg" onload="SVGInject(this)" class="mr-2 icon" alt="Plus Icon">
                                    Invite Vendor
                                </a>
                            </c:if>
                            <a href="javascript:void(0)" id="exportExcelBtn" class="btn theme-btn">Export To Excel</a>
                        </div>                            
                    </div>
                    <hr>                    
                    
                    <div class="card-box rounded-3 mt-3 py-2 px-3 top-0 sticky-model1">
                        <ul class="list-unstyled mb-0 d-flex align-items-center overflow-auto">
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.allVendor=='1'}">
                                    <a href="vendorInformation.htm?act=allVendor" class="tab-link active transition-0">All Vendors</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.venderInvite=='1'}">
                                    <a href="vendorInformation.htm?act=newVendor" class="tab-link transition-0">Invited Vendor</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.venderRequest=='1'}">
                                    <a href="vendorInformation.htm?act=inprogressVendor" class="tab-link transition-0">In Progress</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.buyerApproval=='1'}">
                                    <a href="vendorInformation.htm?act=firstLevelnApprove" class="tab-link transition-0">Buyer</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.procurementHead=='1'}">
                                    <a href="vendorInformation.htm?act=procurementHeadApproval" class="tab-link transition-0">Procurement Head Approval</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.financialApproval=='1'}">
                                    <a href="vendorInformation.htm?act=finacialApproval" class="tab-link transition-0">Financial Approval</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.technicalApproval=='1'}">
                                    <a href="vendorInformation.htm?act=technicalApproval" class="tab-link transition-0">Technical Approval</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.hrApproval=='1'}">
                                    <a href="vendorInformation.htm?act=hrApproval" class="tab-link transition-0">HR Approval</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.safetyApproval=='1'}">
                                    <a href="vendorInformation.htm?act=safetyApproval" class="tab-link transition-0">Safety Approval</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.itApproval=='1'}">
                                    <a href="vendorInformation.htm?act=itApproval" class="tab-link transition-0">IT Approval</a>
                                </c:if>
                            </li>

                        </ul>
                    </div>
                    <c:if test="${!empty failureMessage}">
                        <br>
                        <div class="fadeOutEffect alert alert-danger" style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                            <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                            <div>
                                <strong>Note:</strong> <strong class="text-danger fs-13">${failureMessage} </strong><br>                            
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${!empty successMessage}">
                        <br>
                        <div class="fadeOutEffect alert alert-info" style="display: flex; align-items: center; gap: 12px; background: #F0FFF4; color: #0F5132; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #198754; box-shadow: 2px 2px 10px rgba(25, 135, 84, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">                        
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
                        <table id="allVendorTable" class="table table-striped dt-scroll bg-white" style="width:100%;">

                            <thead>
                                <tr>
                                    <th>Sr.No.</th>
                                    <th>Company Name</th>
                                    <th>Email Id</th>
                                    <th>Contact No</th>
                                    <th style="min-width: 400px;">Status</th>
                                    <th>Action</th>
                                </tr>
                            </thead>

                            <tbody>
                            </tbody>

                            <tfoot>
                                <tr>
                                    <td colspan="6">
                                        <span class="fa fa-user-plus text-primary"></span> New Vendor
                                        &nbsp;&nbsp;&nbsp;
                                        <span class="fa fa-arrow-right-from-bracket text-primary"></span> Send
                                        &nbsp;&nbsp;&nbsp;
                                        <span class="fa fa-hourglass-half text-warning"></span> Pending
                                        &nbsp;&nbsp;&nbsp;
                                        <span class="fa fa-recycle text-danger"></span> Recycle
                                        &nbsp;&nbsp;&nbsp;
                                        <span class="fa fa-circle-check text-success"></span> Approved
                                        &nbsp;&nbsp;&nbsp;
                                        <span class="fa fa-circle-xmark text-danger"></span> Reject
                                    </td>
                                </tr>
                            </tfoot>

                        </table>
                    </div>
                         
                    <script>
                        var table;

                        $(document).ready(function () {

                            table = $('#allVendorTable').DataTable({

                                processing: true,

                                serverSide: true,

                                stateSave: false,

                                ordering: true,

                                orderMulti: false,

                                aaSorting: [[0, 'asc']],
                                
                                scrollCollapse: true,
                                
                                scrollY: '80vh',                               

                                ajax: {

                                    url: 'vendorInformation.htm?act=allVendorAjax',

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
                                    {data: 'contactNo'},                    

                                    {
                                        data: 'status',
                                        orderable: false,
                                        searchable: false
                                    },
                                    
                                    {
                                        data: 'view',
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
                            
                            //      For Export To Excel
                            $('#exportExcelBtn').on('click', function () {

                                var params = {
                                    searchValue: $('#searchBox').val()
                                };

                                var $form = $('<form>', {
                                    method: 'POST',
                                    action: 'vendorInformation.htm?act=allVendorExportExcel'
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
