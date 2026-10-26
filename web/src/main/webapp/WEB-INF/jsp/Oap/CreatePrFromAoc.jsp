

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>Create PR From AOC</title>
    </head>
  <style>
        .text-width-btn {
            width: fit-content;
            white-space: nowrap;
        }

    </style>
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

                        <h5 class="fw-600 mb-0">Create PR From AOC</h5>
                    </div>

                    <!-- If No data available then Hide this button -->
                    <div class="cta d-flex align-items-center">
                        <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>

                    </div>
                </div>
                <hr>
                <c:if test="${!empty successMessage}">
                    <div id="successMsg" class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                </c:if>
                <c:if test="${!empty failureMessage}">
                    <div id="failureMsg" class="fadeOutEffect alert alert-danger" style="padding: 0px" role="alert">${failureMessage}</div>
                </c:if>


                <%@include file="/WEB-INF/jsp/Common/TablePageNew.jsp"%>
                <div class="bg-white card-full-h">
                    <table id="commonTable" class="table table-striped bg-white" style="width:100%">
                        <c:choose>
                            <c:when test="${empty list}">

                            </c:when>
                            <c:otherwise>
                                <thead>
                                    <tr>

                                        <th>Sr.No</th>
                                        <th style="min-width: 230px;">Description</th>
                                        <th style="min-width: 190px;">Design Co-Ordinator </th>
                                        <th style="min-width: 190px;">Form </th>
                                        <th>Type </th>
                                        <th data-dt-order="disable">View</th>
                                        <th data-dt-order="disable">Action</th>

                                    </tr>  
                                </thead>
                                <c:set var="count" value="0" scope="page" />
                                <tbody>
                                    <c:forEach var="list" items="${list}" varStatus="status">
                                    <input type="hidden" name="id" value="${list[0].id}">
                                    <c:if test="${list[0].flagStatus != '6'}">
                                        <tr>
                                            <td> ${status.count}</td>
                                            <td>${list[0].description}</td>
                                            <td>${list[0].designCoordinator}</td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${not empty list[0] and list[0].oapId eq '0'}">
                                                        AOC Form
                                                    </c:when>
                                                    <c:when test="${not empty list[0] and list[0].aocId eq '0'}">
                                                        OAP Form
                                                    </c:when>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${not empty list[1] and list[1].flagStatus == '3'}">
                                                        Service
                                                    </c:when>
                                                    <c:when test="${not empty list[1] and list[1].flagStatus == '0'}">
                                                        Goods
                                                    </c:when>
                                                    <c:when test="${not empty list[1] and list[1].flagStatus == '4'}">
                                                        Contract
                                                    </c:when>
                                                </c:choose>
                                            </td>

                                            <td>
                                                <div style="display: flex; gap: 10px;">
                                                <button type="button" class="btn theme-btn light-btn text-width-btn" onclick="window.location = 'aocForm.htm?act=AllFormsView2&id=${aocformid}'">
                                                    AOC View
                                                </button>
                                                <button type="button" class="btn theme-btn light-btn text-width-btn" onclick="window.location = 'aocForm.htm?act=AllFormsView3&id=${aocformid}'">
                                                    Kick-Off View
                                                </button>
                                                    </div>
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${not empty list[1] and list[1].flagStatus == '3'}">
                                                        <button type="button" class="btn theme-btn light-btn text-width-btn" onclick="window.location = 'prMaster.htm?act=createPR1&prType=Service&ref_no=${ref_no}&itemId=${list[0].id}&aocId=${list[0].aocId}'">
                                                            &nbsp; Create PR
                                                        </button>
                                                    </c:when>
                                                    <c:when test="${not empty list[1] and list[1].flagStatus == '4'}">
                                                        <button type="button" class="btn theme-btn light-btn text-width-btn" onclick="window.location = 'prMaster.htm?act=createPR1&prType=Contract&ref_no=${ref_no}&itemId=${list[0].id}&aocId=${list[0].aocId}'">
                                                            &nbsp; Create PR
                                                        </button>
                                                    </c:when>
                                                    <c:when test="${not empty list[1] and list[1].flagStatus == '0'}">
                                                        <button type="button" class="btn theme-btn light-btn text-width-btn" onclick="window.location = 'prMaster.htm?act=createPR1&prType=Goods&ref_no=${ref_no}&itemId=${list[0].id}&aocId=${list[0].aocId}'">
                                                            &nbsp; Create PR
                                                        </button>
                                                    </c:when>
                                                </c:choose>
                                            </td>
                                        </tr>
                                    </c:if>
                                </c:forEach>
                                </tbody>
                            </c:otherwise>
                        </c:choose>


                    </table>
                </div>

            </section>
        </main> 
    </body>

    <script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>


</html>


