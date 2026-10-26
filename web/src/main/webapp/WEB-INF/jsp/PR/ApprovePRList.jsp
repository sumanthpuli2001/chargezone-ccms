<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PR List</title>
        <style>
            .icon-slot {
                width: 32px; 
            }
        </style>
    </head>
    <body>
       
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="prMaster.htm?act=approvePRList" method="post" commandName="employeeMaster"
                           name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Approve PR List</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <%--<a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>--%>
                        </div>
                    </div>
                    <hr>

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
                    <c:if test="${not empty list1}">
                        
                        <%@include file="/WEB-INF/jsp/Common/TablePageNew.jsp"%>
                        
                        </c:if>

                   

                    <!-- Table for list1 -->
                    <table id="commonTable" class="table table-striped bg-white" align="center">
                        <c:choose>
                            <c:when test="${empty list1 && empty list2}"></c:when>
                            <c:otherwise>
                        <thead>
                            <tr>

                                <th>PR No.</th>
                                <th>Create By</th>
                                <th>Approval Status</th>
                                <th data-dt-order="disable">View</th>

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

                                <td><span class="icon-slot">
                                        <a href="prMaster.htm?act=viewapprovePR&id=${list1[0].prNo}" class="d-flex text-info p-1 mx-1 action-link" data-toggle="tooltip"
                                           data-placement="left" title="View">
                                            <img src="StorageYard/assets/images/eye-open.svg" onload="SVGInject(this)" alt="View Icon">
                                        </a>
                                    </span></td>

                            </tr>

                        </c:forEach> 

                        <c:forEach var="list2" items="${list2}" varStatus="status">

                            <tr>

                                <td>${list2.prNo}</td>
                                <td>${list2.prAdmin}</td>

                                <td>Recycle By Tender Admin</td>
                                
                                         <td><span class="icon-slot">
                                        <a href="prMaster.htm?act=viewapprovePR&id=${list2.prNo}" class="d-flex text-info p-1 mx-1 action-link" data-toggle="tooltip"
                                           data-placement="left" title="View">
                                            <img src="StorageYard/assets/images/eye-open.svg" onload="SVGInject(this)" alt="View Icon">
                                        </a>
                                    </span>
                                         </td>

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
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
    <script src="StorageYard/assets/js/TableScript/pr-scripts1.js" type="text/javascript"></script>
</html>

