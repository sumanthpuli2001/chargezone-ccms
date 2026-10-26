
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>APPROVE PRICE BID</title>
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

                            <h5 class="fw-600 mb-0">APPROVE PRICE BID</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                        </div>
                    </div>

                    <hr>
                    <c:if test="${!empty successMessage}">
                        <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                    </c:if>
                    <c:if test="${!empty failureMessage}">
                        <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                    </c:if>
                    <c:if test="${!empty list1}">
                    <%@include file="/WEB-INF/jsp/Common/TablePageNew.jsp"%>
                    </c:if>
                    <table id="commonTable" class="table table-striped bg-white" style="width: 100%" align="Center"  >
                         <c:choose>
                            <c:when test="${empty list1}"></c:when>
                            <c:otherwise>
                        <thead>
                            <tr>
                                <th>Tender No.</th>
                                <th>View</th>
                            </tr>
                        </thead>
                        <c:set var="count" value="0" scope="page" />
                        <tbody>
                            <c:forEach var="list1" items="${list1}" varStatus="status">
                            <input type="hidden" name="id" id="id" value="${list1[0].id}">
                            <tr>
                                <td>${list1[0].tenderNo}</td>
                                <td><a href="tenderMaster.htm?act=viewapprovePriceBid&id=${list1[0].id}">View</a></td>
                            </tr>
                        </c:forEach>
                             </c:otherwise>
                            </c:choose>
                        </tbody>
                    </table>    
                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
