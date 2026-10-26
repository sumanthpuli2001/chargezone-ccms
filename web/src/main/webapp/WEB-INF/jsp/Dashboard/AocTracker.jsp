
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AOC Tracker</title>
    </head>

    <body >
        <style>

            ul li.active a {
                border-bottom: 2px solid #007bff; 
                font-weight: 600;                 
            }
        </style>

        <script>
            $('#select_all').on('change', function () {
            $('.switch-input').prop('checked', this.checked).trigger('change');
            });        </script>
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            
            
            
            <section class="main-content">
                       <form:form action="dashboard.htm?act=aocTracker" method="post" commandName="" name='form1' class="form-horizontal" role="form">

                    <div class="card-box rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">AOC Tracker</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <button type="button" class="btn theme-btn mr-3" style="margin-right: 10px;"
                                    onclick="window.location = 'dashboard.htm?act=aocTrackerExcel&id=${id}&Fromdate=${Fromdate}&Todate=${Todate}'">
                                Export Excel
                            </button>

                            <button type="button" class="btn theme-btn mr-3" data-toggle="modal" data-target="#searchModal">
                                Filter
                            </button>
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
                                        <div class="form-horizontal">
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">From Date :</label>
                                                <div class="col-sm-12">
                                                    <input autocomplete="off" name="Fromdate" id="Fromdate" type="text" class="input-field" />
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">To Date :</label>
                                                <div class="col-sm-12">
                                                    <input  autocomplete="off" name="Todate" id="Todate" type="text" class="input-field" />
                                                </div>
                                            </div>                                              
                                        </div>
                                    </div>

                                    <script type="text/javascript">
                                                $(function () {
                                                flatpickr("#Fromdate", {
                                                enableTime: false,
                                                        dateFormat: "d-m-Y",
                                                        allowInput: true
                                                });
                                                        flatpickr("#Todate", {
                                                        enableTime: false,
                                                                dateFormat: "d-m-Y",
                                                                allowInput: true
                                                        });
                                                });                                    </script>

                                    <div class="modal-footer">
                                        <button type="submit" class="btn theme-btn" name="btn" value="1">Apply</button>
                                        <a  class="btn theme-btn light-btn mr-3" data-dismiss="modal">Close</a>
                                    </div>
                                </div>
                            </div>
                        </div>                                                     
                    </div>
                 

                    <div class="card-box rounded-3 mt-2 py-2 px-3 top-0 sticky-model1">
                        <ul class="list-unstyled mb-0 d-flex align-items-center overflow-auto">
                            <li class="tab-item mr-2">
                                <a href="dashboard.htm?act=tenderDashboard" class="tab-link transition-0 ">Dashboard</a>
                            </li>
                            <li class="tab-item mr-2">
                                <a href="oapForm.htm?act=oapAndAocDashboard" class="tab-link transition-0">OAP & AOC DashBoard</a>
                            </li>
                            <li class="tab-item mr-2">
                                <a href="dashboard.htm?act=report" class="tab-link transition-0">PR Register</a>
                            </li>
                            <li class="tab-item mr-2">
                                <a href="dashboard.htm?act=activeVendorDashboard" class="tab-link transition-0 ">Active Vendor</a>
                            </li>
                            <li class="tab-item mr-2">
                                <a href="dashboard.htm?act=oapTracker" class="tab-link transition-0 ">OAP Tracker</a>
                            </li>
                            <li class="tab-item mr-2">
                                <a href="dashboard.htm?act=aocTracker" class="tab-link transition-0 active">AOC Tracker</a>
                            </li>

                        </ul>
                    </div>
                     <div class="content-top mb-0 d-flex align-items-center justify-content-between row my-3">
                        <div class="col-md-1 pr-md-1">
                            <select id="entriesPerPage" class="select-input">
                                <option value="10">10</option>
                                <option value="25">25</option>
                                <option value="50">50</option>
                                <option value="100">100</option>
                                <option value="-1">All</option>
                            </select>
                        </div>
                      <div class="col-md-3 pl-md-1" >
                            <input id="searchBox" type="text" class="input-field" placeholder="Search here...">
                        </div>
                        </div>
                     
                    <table id="commonTable" class="table  table-striped bg-white " style="min-width: 100%;" align="Center">



                        <thead>
                            <tr>
                                <th class="centered-header">Sr No.</th>
                                <th class="centered-header" style="min-width: 190px;">Document Number</th>
                                <th class="centered-header"style="min-width: 230px;">Depo.Name</th>
                                <th class="centered-header" style="min-width: 230px;">Project Name</th>
                                <th class="centered-header"style="min-width: 190px;">Created By</th>
                                <th class="centered-header"style="min-width: 190px;">Client Name</th>
                                <th class="centered-header"style="min-width: 190px;">Created Date</th>
                                <th class="centered-header" style="min-width: 190px;">Status</th>
                                <th class="centered-header"style="min-width: 190px;">Approved By</th>
                                <th class="centered-header"style="min-width: 190px;">Approved Date</th>
                                <th class="centered-header"style="min-width: 190px;">Days To Approve AOC Form</th>
                                <th class="centered-header"style="min-width: 190px;">Kick Off Form Assign By</th>
                                <th class="centered-header"style="min-width: 190px;">Kick Off Form Assign Date</th>
                                <th class="centered-header"style="min-width: 190px;">Kick Off Form Assign To</th>
                                <th class="centered-header"style="min-width: 190px;">Days To Assign KickOff Form</th>
                                <th class="centered-header"style="min-width: 190px;">Kick Off Form Created Date</th>
                                <th class="centered-header"style="min-width: 190px;">Days to Create Kick Off Form</th>
                                <th class="centered-header"style="min-width: 190px;">Kick Off Form Approved By</th>
                                <th class="centered-header"style="min-width: 190px;">Kick Off Form Approved Date</th>
                                <th class="centered-header"style="min-width: 190px;">Days To Approve Kick Off Form </th>
                                <th class="centered-header"style="min-width: 190px;">Design Deliverables Assign By</th>
                                <th class="centered-header"style="min-width: 190px;">Design Deliverables Assign Date</th>
                                <th class="centered-header"style="min-width: 190px;">Design Coordinator</th>
                                <th class="centered-header"style="min-width: 190px;">Deliverable Created Date</th>
                                <th class="centered-header"style="min-width: 190px;">Deliverable Approved By</th>
                                <th class="centered-header"style="min-width: 190px;">Deliverable Approved Date</th>
                                <th class="centered-header"style="min-width: 190px;">Project Manager</th>
                                <th class="centered-header"style="min-width: 190px;">Project Manager Approved Date</th>
                            </tr>
                        </thead>


                        <tbody>
                            <c:set var="previousPrNo" value="" scope="page" />
                            <c:set var="serialNo" value="0" scope="page" />
                            <c:set var="totalPRValue" value="0" scope="page" />
                            <c:set var="totalPO" value="0" scope="page" />

                            <!-- First List -->
                            <c:forEach var="item" items="${list1}" varStatus="status">
                                <c:set var="currentPrNo" value="${item[0]}" />

                                <c:if test="${currentPrNo != previousPrNo}">
                                    <c:set var="serialNo" value="${serialNo + 1}" scope="page" />
                                </c:if>

                                <tr>
                                    <td>${serialNo}</td>
                                    <td>${item[1]}</td>
                                    <td>${item[2]}</td>
                                    <td>${item[3]}</td>
                                    <td>${item[4]}</td>
                                    <td>${item[5]}</td>
                                    <td>${item[6]}</td>
                                    <td>
                                        <c:if test="${item[7] ==1}">
                                            Pending to Approve
                                        </c:if>
                                        <c:if test="${item[7] == 2}">
                                            Recycle
                                        </c:if>
                                        <c:if test="${item[7] == 3}">
                                            Rejected 
                                        </c:if>
                                        <c:if test="${fn:contains(item[7], 4) or fn:contains(item[7], '6') or fn:contains(item[7], '7') or fn:contains(item[7], '11')or fn:contains(item[7], '12')or fn:contains(item[7], '13')}">
                                            Approved
                                        </c:if>

                                        <c:if test="${item[7] == 5}">
                                            Rejected KOM
                                        </c:if>
                                        <c:if test="${item[7] == 8}">
                                            Project Manager Cancel
                                        </c:if>
                                        <c:if test="${item[7] == 9}">
                                            Project Manager Rejected
                                        </c:if>
                                        <c:if test="${item[7] == 10}">
                                            Project Manager Closed
                                        </c:if>
                                    </td> 

                                    <td>${item[8]}</td>
                                    <td>${item[9]}</td>
                                    <td>${item[13]}</td>
                                    <td>${item[10]}</td>
                                    <td>${item[11]}</td>
                                    <td>${item[12]}</td>
                                    <td>${item[14]}</td>
                                    <td>${item[15]}</td>
                                    <td>${item[16]}</td>
                                    <td>${item[17]}</td>
                                    <td>${item[18]}</td>
                                    <td>${item[19]}</td>
                                    <td>${item[20]}</td>
                                    <td>${item[21]}</td>
                                    <td>${item[22]}</td>
                                    <td>${item[23]}</td>
                                    <td>${item[24]}</td>
                                    <td>${item[25]}</td>
                                    <td>${item[26]}</td>
                                    <td>${item[27]}</td>
                                </tr>

                                <c:set var="previousPrNo" value="${currentPrNo}" scope="page" />
                            </c:forEach>
                            <c:forEach var="list" items="${list}" varStatus="status">
                                <c:set var="currentPrNo" value="${list[0]}" />

                                <c:if test="${currentPrNo != previousPrNo}">
                                    <c:set var="serialNo" value="${serialNo + 1}" scope="page" />
                                </c:if>

                                <tr>
                                    <td>${serialNo}</td>
                                    <td>${list[1]}</td>
                                    <td>${list[2]}</td>
                                    <td>${list[3]}</td>
                                    <td>${list[4]}</td>
                                    <td>${list[5]}</td>
                                    <td>${list[6]}</td>
                                    <td>
                                        <c:if test="${list[7] == '1'}">
                                            Pending to Approve
                                        </c:if>
                                        <c:if test="${list[7] == '2'}">
                                            Recycle
                                        </c:if>
                                        <c:if test="${list[7]== '3'}">
                                            Rejected
                                        </c:if>

                                        <c:if test="${fn:contains(list[7], '4') or fn:contains(list[7], '6') or fn:contains(list[7], '7') or fn:contains(list[7], '11')or fn:contains(list[7], '12')or fn:contains(list[7], '13')}">
                                            Approved
                                        </c:if>  
                                        <c:if test="${item[7] == 5}">
                                            Rejected KOM
                                        </c:if>
                                        <c:if test="${item[7] == 8}">
                                            Project Manager Cancel
                                        </c:if>
                                        <c:if test="${item[7] == 9}">
                                            Project Manager Rejected
                                        </c:if>
                                        <c:if test="${item[7] == 10}">
                                            Project Manager Closed
                                        </c:if>
                                    </td>
                                    <td>${list[8]}</td>
                                    <td>${list[9]}</td>
                                    <td>${list[10]}</td>
                                    <td>${list[11]}</td>
                                    <td>${list[12]}</td>
                                    <td>${list[13]}</td>
                                    <td>${list[14]}</td>
                                    <td>${list[15]}</td>
                                    <td>${list[16]}</td>
                                    <td>${list[17]}</td>
                                    <td>${list[18]}</td>
                                    <td>${list[19]}</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <c:set var="previousPrNo" value="${currentPrNo}" scope="page" />
                            </c:forEach>
                    </table>                 
                </form:form>  
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
    <script>
                setTimeout(insertMiddleScroll, 100);
                function insertMiddleScroll() {
                const dtScroll = $('#commonTable').closest('.dt-scroll');
                        const head = dtScroll.find('.dt-scroll-head');
                        const headInner = head.find('.dt-scroll-headInner');
                        const body = dtScroll.find('.dt-scroll-body');
                        const foot = dtScroll.find('.dt-scroll-foot');
                        if (!dtScroll.length || !body.length) return;
                        if (!dtScroll.find('.middle-scrollbar').length) {
                $('<div class="middle-scrollbar"><div></div></div>').insertAfter(head);
                }

                const middleScroll = dtScroll.find('.middle-scrollbar');
                        const inner = middleScroll.find('div');
                        inner.width(body.get(0).scrollWidth);
                        middleScroll.off('scroll');
                        body.off('scroll');
                        head.off('scroll');
                        foot.off('scroll');
                        function syncScroll(source, scrollLeft) {
                        if (source !== 'middle') middleScroll.scrollLeft(scrollLeft);
                                if (source !== 'body') body.scrollLeft(scrollLeft);
                                if (source !== 'head') head.scrollLeft(scrollLeft);
                                if (source !== 'foot') foot.scrollLeft(scrollLeft);
                        }

                middleScroll.on('scroll', function () {
                syncScroll('middle', $(this).scrollLeft());
                });
                        body.on('scroll', function () {
                        syncScroll('body', $(this).scrollLeft());
                        });
                        head.on('scroll', function () {
                        syncScroll('head', $(this).scrollLeft());
                        });
                        foot.on('scroll', function () {
                        syncScroll('foot', $(this).scrollLeft());
                        });
                }
    </script>
</html>
