
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PR Details</title>
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

                            <h5 class="fw-600 mb-0">PR Details</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>

                        </div>
                    </div>

                    <hr>
                    <table id="commonTable" class="table table-striped bg-white" style="width: 100%" align="Center"  >
                        <c:choose>
                            <c:when test="${empty prMaster}">

                            </c:when>
                            <c:otherwise>
                                <thead>
                                    <tr>
                                        <th>Sr. No.</th>
                                        <th>PR Number</th>
                                        <th>Title</th>
                                        <th>Created By</th>
                                        <th style="min-width: 180px;">Date Time</th>
                                        <th>Approval Status</th>
                                        <th data-dt-order="disable" style="min-width: 160px;">View</th>

                                    </tr>
                                </thead>
                                <c:set var="count" value="0" scope="page" />
                                <tbody>
                                    <c:forEach var="list" items="${prMaster}" varStatus="status">
                                    <input type="hidden" name="id" id="id" value="${list.id}">
                                    <tr>
                                        <td>${status.count}</td>
                                        <td>${list.prNo}</td>
                                        <td>${list.title}</td>
                                        <td>${list.contactPerson}</td>
                                        <td>${list.announceDate}</td>
                                        <c:if test="${list.authorizeFlag == 0}">
                                            <td>Pending</td>
                                        </c:if>

                                        <c:if test="${list.authorizeFlag == 1}">
                                            <td>Approve</td>
                                        </c:if>

                                        <td>

                                            <a href="prMaster.htm?act=searchView&id=${list.id}">View</a>
                                            <c:if test="${list.authorizeFlag == 1}">
                                                <br><a href="prMaster.htm?act=searchView1&id=${list.id}">Create Tender</a>
                                            </c:if>
                                            <br><a href="prMaster.htm?act=searchView4&id=${list.id}">Offline Tender</a>                                                
                                        </td>

                                    </tr>
                                </c:forEach>
                                </tbody>

                            </c:otherwise>
                        </c:choose>
                    </table>
                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
