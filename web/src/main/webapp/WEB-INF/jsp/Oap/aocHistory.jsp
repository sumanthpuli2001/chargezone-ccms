
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>
  
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AOC Form History List</title>
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

                        <h5 class="fw-600 mb-0">AOC Form History List</h5>
                    </div>

                    <div class="cta d-flex align-items-center">
                        <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                    </div>
                </div>

                <hr>
 <%@include file="/WEB-INF/jsp/Common/TablePageNew.jsp"%>
 <div class="bg-white card-full-h">
                <table id="commonTable" class="table  table-striped bg-white" style="" align="Center"  >
                                                <c:choose>
                                                    <c:when test="${empty list}">
                                                       
                                                    </c:when>
                                                    <c:otherwise>
                                                        <thead>
                                                            <tr>

                                                                <th>Sr.No</th>
                                                                <th>Document No</th>
                                                                <th>Date&Time</th>
                                                                <th>Revison No</th>
                                                                <th data-dt-order="disable">Action</th>

                                                            </tr>
                                                        </thead>
                                                        <c:set var="count" value="0" scope="page" />
                                                      
                                                        <tbody>
                                                            <c:forEach var="list" items="${list}" varStatus="status">
                                                                <tr>
                                                                    
                                                                    <td>${status.count}</td>
                                                                    <td>${list.documentNo}</td>
                                                                    <td>${list.dateTime}</td>
                                                                    <td>${list.history}</td>



                                                                    <td>
                                                                        <div class="btn-group">
                                                                            <button type="button" class="btn theme-btn light-btn" onclick="window.location = 'aocForm.htm?act=aocHistoryview&id=${list.id}'">
                                                                                View
                                                                            </button>
                                                                        </div>
                                                                    </td>

                                                                </tr>
                                                            </c:forEach>
                                                        </tbody> 
                                                        </tbody>

                                                    </c:otherwise>
                                                </c:choose>
                                            </table>
                </div>
                
                
                
                
                
                
              </form:form>
        </section>
    </main>
</body>
 <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
