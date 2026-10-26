<%-- 
    Document   : bifurcationOAPEthanWise
    Created on : May 8, 2026, 10:33:09 AM
    Author     : Sumanth
--%>





<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>Bifurcation OAP Ethan Wise</title>
    </head>

    <body>
        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

            <section class="main-content">
                <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                    <div class="page-title d-flex align-items-center">
                        <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                            <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                 alt="Menu collapse">
                            <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                 alt="Menu collapse">
                        </div>
                        
                       
                    <h5 class="fw-600 mb-0">Bifurcation OAP Ethan Wise - <span style="color:${param.color};">${param.label}</span> - ${MonthName}</h5>                    </div>
                   
                    <div class="cta d-flex align-items-center">
                     <a onclick="history.back();" class="btn theme-btn light-btn mr-3 no-print">Back</a>

                    </div>

                </div>
                <hr>
                <c:if test="${!empty successMessage}">
                    <div id="successMsg" class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                </c:if>
                <c:if test="${!empty failureMessage}">
                    <div id="failureMsg" class="fadeOutEffect alert alert-danger" style="padding: 0px" role="alert">${failureMessage}</div>
                </c:if>
                <c:if test="${not empty list}">

                    <%@include file="/WEB-INF/jsp/Common/TablePageNew.jsp"%>
                </c:if>
                <div class="bg-white card-full-h">
                    <table id="commonTable" class="table table-striped" style="width:100%">
                        <c:choose>
                            <c:when test="${empty list} "></c:when>
                            <c:otherwise>
                                <thead>
                                    <tr>

                                        <th>Sr.No</th>
                                        <th style="min-width: 190px;">Document No</th>
                                        <th style="min-width: 190px;">Pcs Name</th>
                                        <th style="min-width: 190px;">Project Name</th>
                                        <th style="min-width: 190px;">Department</th>
                                        <th style="min-width: 190px;">Date</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:set var="visibleCount" value="0" scope="page"/>
                                    <c:forEach var="list" items="${OAPEthanWise}" varStatus="status">
                                        <%--<c:if test="${list.flagStatus != 8 && list.flagStatus != 9 && list.flagStatus != 10 && list.flagStatus != 100 }">--%>
                                        <c:set var="visibleCount" value="${visibleCount + 1}" scope="page"/>
                                        <tr>
                                            <td>${visibleCount}</td>
                                            <td>${list.documentNo}</td> 
                                            <td> ${list.pcsName}</td>
                                            <td> ${list.projectName}</td>
                                            <td> ${list.department}</td>
                                            <td>${list.createdDate}</td>


                                        </tr>
                                        <%--</c:if>--%>
                                    </c:forEach>
                                </tbody>
                            </c:otherwise>
                        </c:choose>


                    </table>
                </div>

            </section>
        </main> 
    </body>

    <script src="StorageYard/assets/js/TableScript/OapList.js"></script>
    <script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>



</html>



