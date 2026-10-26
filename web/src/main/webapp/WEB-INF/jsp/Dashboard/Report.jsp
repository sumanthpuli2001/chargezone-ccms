<%-- 
Document   : report
Created on : Apr 16, 2025, 11:34:53 AM
Author     : Mayur Mishra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>Register PR</title>

    </head>

    <body>
        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>            
            <section class="main-content">
                <form:form >
                    <div class="card-box rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars"
                                     onload="SVGInject(this)" alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort"
                                     onload="SVGInject(this)" alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Register PR</h5>
                        </div>                    
                        <div class="cta d-flex align-items-center" style="gap: 10px;">
                            <li class="search-container" style="margin-left: auto; display: flex; align-items: center;">
                                <a onclick="history.back();" class="btn theme-btn light-btn mr-3 no-print">Back</a>
                                <button type="button" class="btn theme-btn mr-3" data-toggle="modal" data-target="#searchModal">
                                    Filter
                                </button>
                                <button type="button" class="btn theme-btn light" id="exportExcelBtn">
                                    Export Excel
                                </button>
                            </li>
                        </div>
                    </div>

                    <div class="cta d-flex align-items-center" style="gap: 10px;">
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
                                        <div class="form-horizontal">
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">From Date :</label>
                                                <div class="col-sm-12">
                                                    <input autocomplete="off" name="fromDate" id="fromDate" type="text" class="input-field" placeholder="dd-MM-yyyy" />
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">To Date :</label>
                                                <div class="col-sm-12">
                                                    <input  autocomplete="off" name="toDate" id="toDate" type="text" class="input-field" placeholder="dd-MM-yyyy"/>
                                                </div>
                                            </div>                                              
                                            <script type="text/javascript">
                                                $(function () {
                                                    flatpickr("#fromDate", {
                                                        enableTime: false,
                                                        dateFormat: "d-m-Y",
                                                        allowInput: true
                                                    });
                                                    flatpickr("#toDate", {
                                                        enableTime: false,
                                                        dateFormat: "d-m-Y",
                                                        allowInput: true
                                                    });
                                                });
                                            </script>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" id="applyDateFilter" class="btn theme-btn">
                                            Apply
                                        </button>
                                        <a  class="btn theme-btn light-btn mr-3" data-dismiss="modal">Close</a>
                                    </div>
                                </div>
                            </div>
                        </div>                                                     
                    </div>

                    <div class="card-box rounded-3 mt-3 py-2 px-3 top-0 sticky-model1">
                        <ul class="list-unstyled mb-0 d-flex align-items-center overflow-auto">
                            <li class="tab-item mr-2">
                                <a href="dashboard.htm?act=tenderDashboard" class="tab-link transition-0 ">Dashboard</a>
                            </li>
                            <li class="tab-item mr-2">
                                <a href="oapForm.htm?act=oapAndAocDashboard" class="tab-link transition-0">OAP & AOC DashBoard</a>
                            </li>
                            <li class="tab-item mr-2">
                                <a href="dashboard.htm?act=report" class="tab-link transition-0 active">PR Register</a>
                            </li>
                            <li class="tab-item mr-2">
                                <a href="dashboard.htm?act=activeVendorDashboard" class="tab-link transition-0 ">Active Vendor</a>
                            </li>
                            <li class="tab-item mr-2">
                                <a href="dashboard.htm?act=oapTracker" class="tab-link transition-0">OAP Tracker</a>
                            </li>
                            <li class="tab-item mr-2">
                                <a href="dashboard.htm?act=aocTracker" class="tab-link transition-0">AOC Tracker</a>
                            </li>

                        </ul>
                    </div>
                    <br>
                    <div class="table-responsive">

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

                        <table id="prRegisterTable" class="table table-striped bg-white dt-scroll" style="width:100%">
                            <thead>
                                <tr>

                                    <th>Sr No.</th>
                                    <th style="min-width: 190px;">PR  No.</th>
                                    <th>PR Created By</th>
                                    <th style="min-width: 190px;">PR Date</th>
                                    <th style="min-width: 190px;">PR Approval By</th>
                                    <th style="min-width: 190px;">PR Approval Date</th>
                                    <th style="min-width: 190px;">Tender Assign Date</th>
                                    <th style="min-width: 190px;">Status</th>
                                    <th style="min-width: 190px;">Assigned To</th>
                                    <th style="min-width: 190px;">Date Of Enquiry Floated</th>
                                    <th style="min-width: 190px;">PR Date of Reckoning by SCM Team</th>
                                    <th style="min-width: 190px;">Commercial RFQ Issued to Suppliers Date</th>
                                    <th style="min-width: 190px;">Site Name</th>
                                    <th style="min-width: 230px;">Reasons for difference between PR approval date and Reconing date</th>
                                    <th style="min-width: 190px;">Bid Evaluation approved date</th>
                                    <th style="min-width: 190px;">Segment</th>
                                    <th style="min-width: 190px;">Days Past from PR approval</th>
                                    <th style="min-width: 190px;">Latency from PR approval date</th>
                                    <th style="min-width: 190px;">Latency from PR Reckoning Date</th>
                                    <th style="min-width: 230px;">Date of Pre-Bid/Review with Initiator and Supplier completed date</th>
                                    <th style="min-width: 190px;">PR Value in INR Taxes...</th>
                                    <th style="min-width: 190px;">PO No.</th>
                                    <th style="min-width: 190px;">PO Issued Date</th>
                                    <th style="min-width: 190px;">PO Value with Taxes</th>
                                    <th style="min-width: 190px;">Supplier Code</th>

                                </tr>       

                                <tr id="thead_1" data-dt-order="disable">


                                    <th><input type="text" id="id" class="input-field" placeholder="Search Sr No"></th>

                                    <th><input type="text" id="prNo" class="input-field" placeholder="Search PR No"></th>

                                    <th>
                                        <select id="prAdmin" name="prAdmin" class="select-input">
                                            <option value="">All</option>
                                            <c:forEach var="item" items="${list3}">
                                                <option value="${item}">${item}</option>
                                            </c:forEach>
                                        </select>
                                    </th>

                                    <th><input type="text" id="announceDate" class="input-field" placeholder="Search PR Date"></th>

                                    <th><input type="text" id="prAuthorizeUser" class="input-field" placeholder="Search PR Approval By"></th>

                                    <th><input type="text" id="prAuthorizeDate" class="input-field" placeholder="Search PR Approval Date"></th>

                                    <th><input type="text" id="tenderAssignDate" class="input-field" placeholder="Search Tender Assign Date"></th>

                                    <th><select class="select-input" name="statusFilter" id="statusFilter">
                                            <option value="">All</option>
                                            <option value="PO Issued">PO Issued</option>
                                            <option value="PR Cancelled">PR Cancelled</option>
                                            <option value="Tender Created">Tender Created</option>
                                            <option value="Unapproved PR">Unapproved PR</option>
                                            <option value="Unassigned PR">Unassigned PR</option>
                                        </select> 
                                    </th>

                                    <th>
                                        <select id="tenderCreaterId" name="tenderCreaterId" class="select-input">
                                            <option value="">All</option>
                                            <c:forEach var="item" items="${list0}">
                                                <option value="${item}">${item}</option>
                                            </c:forEach>
                                        </select>
                                    </th>

                                    <th><input type="text" id="tenderCreaterDate" class="input-field" placeholder="Search Enquiry Floated"></th>

                                    <th><input type="text" id="prReworkDate" class="input-field" placeholder="Search Reckoning Date"></th>

                                    <th><input type="text" id="submitLastdate" class="input-field" placeholder="Search RFQ Date"></th>

                                    <th><input type="text" id="title" class="input-field" placeholder="Search Site Name"></th>

                                    <th><input type="text" id="prComment" class="input-field" placeholder="Search Reason"></th>

                                    <th><input type="text" id="finalCloseDate" class="input-field" placeholder="Search Bid Evaluation Date"></th>

                                    <th><input type="text" id="businessType" class="input-field" placeholder="Search Segment"></th>

                                    <th><input type="text" id="daysLeft" class="input-field" placeholder="Search Days Past"></th>

                                    <th><input type="text" id="announceApprovalDiff" class="input-field" placeholder="Search Approval Latency"></th>

                                    <th><input type="text" id="prReworkDiff" class="input-field" placeholder="Search Reckoning Latency"></th>

                                    <th><input type="text" id="preBidDate" class="input-field" placeholder="Search Pre-Bid Date"></th>

                                    <th><input type="text" id="value" class="input-field" placeholder="Search PR Value"></th>

                                    <th><input type="text" id="poNo" class="input-field" placeholder="Search PO No"></th>

                                    <th><input type="text" id="poDate" class="input-field" placeholder="Search PO Date"></th>

                                    <th><input type="text" id="poValue" class="input-field" placeholder="Search PO Value"></th>

                                    <th><input type="text" id="vendorCode" class="input-field" placeholder="Search Supplier Code"></th>

                                </tr>

                            </thead>

                            <tbody></tbody>
                            
                            <tfoot>
                                <tr>
                                    <th colspan="20" style="text-align:right;font-weight:bold;">
                                        Total :
                                    </th>

                                    <th id="totalPRValueFooter" style="text-align:right;font-weight:bold;">
                                        0.00 Cr
                                    </th>

                                    <th colspan="2"></th>

                                    <th id="totalPOValueFooter" style="text-align:right;font-weight:bold;">
                                        0.00 Cr
                                    </th>

                                    <th></th>
                                </tr>
                            </tfoot>

                        </table>

                    </div>

                    <script>
                        var table;

                        $(document).ready(function () {

                            table = $('#prRegisterTable').DataTable({

                                processing: true,

                                serverSide: true,

                                stateSave: false,

                                ordering: true,

                                orderMulti: false,

                                destroy: true,

                                aaSorting: [[0, 'desc']],
                                
                                scrollCollapse: true,
                                
                                scrollY: '80vh',

                                ajax: {

                                    url: 'dashboard.htm?act=reportPaginationAjax',

                                    type: 'POST',

                                    cache: false,

                                    dataSrc: function (json) {

                                        $('#totalPRValueFooter').html(
                                                Number(json.totalPRValue).toFixed(2) + ' Cr'
                                                );

                                        $('#totalPOValueFooter').html(
                                                Number(json.totalPOValue).toFixed(2) + ' Cr'
                                                );

                                        return json.data;
                                    },

                                    data: function (d) {

                                        d.fromdate = $('#fromDate').val();
                                        d.todate = $('#toDate').val();

                                        d.id = $('#id').val();
                                        d.prNo = $('#prNo').val();
                                        d.prAdmin = $('#prAdmin').val();
                                        d.announceDate = $('#announceDate').val();
                                        d.prAuthorizeUser = $('#prAuthorizeUser').val();
                                        d.prAuthorizeDate = $('#prAuthorizeDate').val();
                                        d.value = $('#value').val();
                                        d.tenderAssignDate = $('#tenderAssignDate').val();
                                        d.statusFilter = $('#statusFilter').val();
                                        d.tenderCreaterId = $('#tenderCreaterId').val();
                                        d.tenderCreaterDate = $('#tenderCreaterDate').val();
                                        d.prReworkDate = $('#prReworkDate').val();
                                        d.title = $('#title').val();
                                        d.prComment = $('#prComment').val();
                                        d.finalCloseDate = $('#finalCloseDate').val();
                                        d.businessType = $('#businessType').val();
                                        d.daysLeft = $('#daysLeft').val();
                                        d.announceApprovalDiff = $('#announceApprovalDiff').val();
                                        d.prReworkDiff = $('#prReworkDiff').val();
                                        d.preBidDate = $('#preBidDate').val();
                                        d.submitLastdate = $('#submitLastdate').val();
                                        d.poNo = $('#poNo').val();
                                        d.poDate = $('#poDate').val();
                                        d.poValue = $('#poValue').val();
                                        d.vendorCode = $('#vendorCode').val();
                                    }
                                },

                                columns: [
                                    {data: 'srNo'},
                                    {
                                        data: 'prNo',
                                        render: function (data) {
                                            return '<a class="fw-600 text-break gradient-text" href="prMaster.htm?act=PRHistory&pr_no='
                                                    + data + '">' + data + '</a>';
                                        }
                                    },
                                    {data: 'prAdmin'},
                                    {data: 'announceDate'},
                                    {data: 'prAuthorizeUser'},
                                    {data: 'prAuthorizeDate'},
                                    {data: 'tenderAssignDate'},
                                    {data: 'status'},
                                    {data: 'assignedTo'},
                                    {data: 'dateOfEnquiryFloated'},
                                    {data: 'prReworkDate'},
                                    {data: 'dateOfEnquiryFloated'},
                                    {data: 'title'},
                                    {data: 'prComment'},
                                    {data: 'finalCloseDate'},
                                    {data: 'businessType'},
                                    {data: 'daysLeft'},
                                    {data: 'announceApprovalDiff'},
                                    {data: 'announceApprovalDiff'},
                                    {data: 'submitLastdate'},
                                    {
                                        data: 'prValue',
                                        className: 'text-end'
                                    },
                                    {data: 'poNo'},
                                    {data: 'poDate'},
                                    {
                                        data: 'poValue',
                                        className: 'text-end'
                                    },
                                    {data: 'vendorCode'}
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

                            $('#applyDateFilter').on('click', function () {

                                table.ajax.reload();

                                $('#searchModal').modal('hide');

                            });

                            $('#thead_1 input').on('keyup change', function () {

                                table.ajax.reload();

                            });
                            $('#thead_1 select').on('change', function () {

                                table.ajax.reload();

                            });                            

                            var $bottomInfo = $('#prRegisterTable_wrapper > .table-bottom-info');
                            $('.table-responsive').after($bottomInfo);

                        });
                        
                        $('#exportExcelBtn').on('click', function () {

                            var searchValue = $('#searchBox').val() || '';
                            var fromdate = $('#fromDate').val() || '';
                            var todate = $('#toDate').val() || '';
                            var id = $('#id').val() || '';
                            var prNo = $('#prNo').val() || '';
                            var prAdmin = $('#prAdmin').val() || '';
                            var announceDate = $('#announceDate').val() || '';
                            var prAuthorizeUser = $('#prAuthorizeUser').val() || '';
                            var prAuthorizeDate = $('#prAuthorizeDate').val() || '';
                            var tenderAssignDate = $('#tenderAssignDate').val() || '';
                            var statusFilter = $('#statusFilter').val() || '';
                            var tenderCreaterId = $('#tenderCreaterId').val() || '';
                            var tenderCreaterDate = $('#tenderCreaterDate').val() || '';
                            var prReworkDate = $('#prReworkDate').val() || '';
                            var title = $('#title').val() || '';
                            var prComment = $('#prComment').val() || '';
                            var finalCloseDate = $('#finalCloseDate').val() || '';
                            var businessType = $('#businessType').val() || '';
                            var announceApprovalDiff = $('#announceApprovalDiff').val() || '';
                            var prReworkDiff = $('#prReworkDiff').val() || '';
                            var submitLastdate = $('#submitLastdate').val() || '';
                            var value = $('#value').val() || '';
                            var poNo = $('#poNo').val() || '';
                            var poDate = $('#poDate').val() || '';
                            var poValue = $('#poValue').val() || '';
                            var vendorCode = $('#vendorCode').val() || '';

                            // fix: get order from table object
                            var order = table.order();
                            var orderColumn = order[0][0];
                            var orderDir = order[0][1];

                            var exportUrl = 'dashboard.htm?act=reportExcel'
                                + '&searchValue=' + searchValue
                                + '&orderColumn=' + orderColumn
                                + '&orderDir=' + orderDir
                                + '&fromdate=' + fromdate
                                + '&todate=' + todate
                                + '&id=' + id
                                + '&prNo=' + prNo
                                + '&prAdmin=' + prAdmin
                                + '&announceDate=' + announceDate
                                + '&prAuthorizeUser=' + prAuthorizeUser
                                + '&prAuthorizeDate=' + prAuthorizeDate
                                + '&tenderAssignDate=' + tenderAssignDate
                                + '&statusFilter=' + statusFilter
                                + '&tenderCreaterId=' + tenderCreaterId
                                + '&tenderCreaterDate=' + tenderCreaterDate
                                + '&prReworkDate=' + prReworkDate
                                + '&title=' + title
                                + '&prComment=' + prComment
                                + '&finalCloseDate=' + finalCloseDate
                                + '&businessType=' + businessType
                                + '&announceApprovalDiff=' + announceApprovalDiff
                                + '&prReworkDiff=' + prReworkDiff
                                + '&submitLastdate=' + submitLastdate
                                + '&value=' + value
                                + '&poNo=' + poNo
                                + '&poDate=' + poDate
                                + '&poValue=' + poValue
                                + '&vendorCode=' + vendorCode;

                            window.location.href = exportUrl;
                        });
                    </script>

                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>

