<%-- 
    Document   : FinancialExecutiveApprovalList
    Created on : 10 Oct, 2026, 11:40:55 AM
    Author     : Admin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>Financial Executive Approval List</title>

    </head>

    <body>
        <main class="d-flex align-items-end justify-content-end">

            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <div class="content-top rounded-3 mb-3 d-flex align-items-center justify-content-between sticky-model0">
                    <div class="page-title d-flex align-items-center">
                        <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                            <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)" alt="Menu collapse">
                            <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)" alt="Menu collapse">
                        </div>
                        <h5 class="fw-600 mb-0">Financial Executive Approval List</h5>
                    </div>


                </div>
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
                    <table id="commonTable"
                           class="table table-striped bg-white"
                           style="width:100%">

                        <thead>
                            <tr>
                                <th>PO Number</th>
                                <th>Tender Number</th>
                                <th style="min-width:190px;">PO Date</th>
                                <th>PO Value</th>
                                <th>Vendor Name</th>
                                <th>No of Document Attached</th>
                                <th>Status</th>
                                <th data-dt-order="disable">Action</th>
                            </tr>
                        </thead>


                        <tbody>
                            <c:forEach var="financialExecutiveList" items="${financialExecutiveList}">
                                <tr>
                                    <td>${financialExecutiveList[0]}</td>
                                    <td>${financialExecutiveList[1]}</td>
                                    <td>${financialExecutiveList[2]}</td>
                                    <td>${financialExecutiveList[3]}</td>
                                    <td>${financialExecutiveList[4]}</td>
                                    <td>${financialExecutiveList[5]}</td>
                                    <td>
                                        <c:if test="${financialExecutiveList[11]==0}">
                                            Pending
                                        </c:if>
                                            <c:if test="${financialExecutiveList[11]==1}">
                                            Approved
                                        </c:if>
                                        <c:if test="${financialExecutiveList[11]==3}">
                                            Recycle
                                        </c:if>
                                    </td>
                                    <td>
                                        <div class="d-flex align-items-center justify-content-center">
                                            <a href="poDetails.htm?act=viewFinancialApproval&id=${financialExecutiveList[10]}&vendorCode=${financialExecutiveList[9]}"
                                               class="nav-link theme-btn light-btn rounded-2">
                                                View Document
                                            </a>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>
                </div>
            </section>
        </main>
    </body>
    <script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>



