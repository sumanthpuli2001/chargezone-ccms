
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TECHNICAL APPROVE USER PRICE BID LIST</title>
    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="tenderMaster.htm?act=vendorReviseBid" method="post" commandName="employeeMaster"
                           name='form1' class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">TECHNICAL APPROVE USER PRICE BID LIST</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                        </div>
                    </div>

                    <hr>
                    <input type="hidden" name="refNo" value="${refNo}">
                    <input type="hidden" name="id" value="${id}">

                    <table id="commonTable" class="table table-striped bg-white" style="width: 100%" align="Center"  >
                        <thead>
                            <tr>
                                <th>Tender No.</th>
                                <th>User Id</th>
                                <th>Employee Name</th>
                                <th>Level</th>
                                <th data-dt-order="disable">Approval Status</th>
                            </tr>
                        </thead>
                        <c:set var="count" value="0" scope="page" />
                        <tbody>
                            <c:forEach var="li" items="${li}" varStatus="status">
                                <tr>
                                    <td>${li[0]}</td>
                                    <td>${li[1]}</td>
                                    <td>${li[4]}</td>
                                    <td>${li[2]}</td>
                                    <c:if test="${li[3] == 0}">
                                        <td>Pending</td>
                                    </c:if>
                                    <c:if test="${li[3] == 1}">
                                        <td>Approve</td>
                                    </c:if>

                                    <c:if test="${li[3] == 2}">
                                        <td>Rework</td>
                                    </c:if>
                                    <c:if test="${li[3] == 3}">
                                        <td>Reject</td>
                                    </c:if>
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
