
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PR Approval Tender Dashboard</title>
        <style>
            .badge {
                position: absolute;
                top: -5px;
                right: -10px;
                background: #22a7df;
                color: white;
                width: 18px;
                height: 18px;
                font-size: 12px;
                font-weight: bold;
                text-align: center;
                line-height: 18px;
                border-radius: 50%!important;
                margin-right: -7px!important;
            }


        </style>

        <style>
            /* Only affect the active tab, keep other button styles intact */
            ul li.active a {
                border-bottom: 2px solid #007bff; /* small underline to show active */
                font-weight: 600;                 /* slightly bolder text */
            }
        </style>
    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action=".htm?act=" commandName="departmentMaster" method="post">

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">PR Approval Tender Dashboard</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>

                        </div>
                    </div>

                    <hr>

                    <div id="exTab" style="width: 100%;">
                        <ul style="display: flex; list-style: none; padding: 0; margin: 0; gap: 18px;">

                            <li class="active">
                                <a href="prMaster.htm?act=assignDashboard" style="color: black; position: relative;">
                                    PR Approval

                                    <span class="badge">${tenderPriceApprovalSize}</span>

                                </a>
                            </li>
                        </ul>
                    </div>
                    <br>
                    <div class="row my-3">
                        <div class="col-md-1 pr-md-1">
                            <select id="entriesPerPage" class="select-input">
                                <option value="10">10</option>
                                <option value="25">25</option>
                                <option value="50">50</option>
                                <option value="-1">All</option>
                            </select>
                        </div>
                        <div class="col-md-11 pl-md-1">
                            <input id="searchBox" type="text" class="input-field" placeholder="Search here...">
                        </div>
                    </div>

                    <table id="commonTable" class="table table-striped bg-white" style="width: 100%" align="Center"  >

                        <thead>
                            <tr>

                                <th>PR No.</th>
                                <th>Create By</th>
                                <th>Approval Status</th>
                                <th data-dt-order="disable" >View</th>

                            </tr>
                        </thead>
                        <c:set var="count" value="0" scope="page" />
                        <tbody>

                            <c:forEach var="list1" items="${list1}" varStatus="status">
                            <input type="hidden" name="id" id="id" value="${list1[0].id}">
                            <input type="hidden" name="prNo" id="prNo" value="${list1[0].prNo}">
                            <tr>

                                <td>${list1[0].prNo}</td>
                                <td>${list1[0].userId}</td>
                                <c:if test="${list1[0].approvalStatus == 0}">
                                    <td>Pending</td>
                                </c:if>
                                <c:if test="${list1[0].approvalStatus == 1}">
                                    <td>Approve</td>
                                </c:if>

                                <c:if test="${list1[0].approvalStatus == 2}">
                                    <td>Rework</td>
                                </c:if>

                                <c:if test="${list1[0].approvalStatus == 3}">
                                    <td>Reject</td>
                                </c:if>

                                <td><a href="prMaster.htm?act=viewapprovePR&id=${list1[0].prNo}">View</a></td>

                            </tr>

                        </c:forEach> 



                        </tbody>


                    </table>



                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
