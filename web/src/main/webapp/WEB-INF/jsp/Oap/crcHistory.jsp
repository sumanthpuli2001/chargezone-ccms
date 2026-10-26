
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>
  
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRC Form History List</title>
    </head>
    <body>
       
    <main class="d-flex align-items-end justify-content-end">
         <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
         <section class="main-content">
              <form:form action="employeeMaster.htm?act=submitDepartment" commandName="departmentMaster" method="post">
           
                <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                    <div class="page-title d-flex align-items-center">
                        <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                            <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                alt="Menu collapse">
                            <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                alt="Menu collapse">
                        </div>

                        <h5 class="fw-600 mb-0">CRC Form History List</h5>
                    </div>

                    <div class="cta d-flex align-items-center">
                        <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                    </div>
                </div>

                <hr>
<div class="row my-3">
                        <div class="col-md-1 pr-md-1">
                            <select id="entriesPerPage8" class="select-input">
                                <option value="10">10</option>
                                <option value="25">25</option>
                                <option value="50">50</option>
                                <option value="-1">All</option>
                            </select>
                        </div>
                        <div class="col-md-11 pl-md-1">
                            <input id="searchBox8" type="text" class="input-field" placeholder="Search here...">
                        </div>

                    </div>
                 <table id="CRCFormHistory" class="table  table-striped bg-white" style="width: 100%;" align="Center"  >
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
                                                                            <button type="button" class="btn theme-btn light-btn" onclick="window.location = 'oapForm.htm?act=crcHistoryview&id=${list.id}'">
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
                
                
                
                
              </form:form>
        </section>
    </main>
</body>
 <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
 
 <script>
                function initTable(selector, obj = {}) {
                return $(selector).DataTable({
                paging: true,
                        lengthChange: false,
                        searching: true,
                        info: true,
                        autoWidth: true,
                        ordering: true,
                        scrollX: true,
                        dom: 't<"table-bottom-info d-flex align-items-center justify-content-between pt-3"i p>',
                        ...obj,
                });
                        }

                if ($("#CRCFormHistory").length) {
                let obj = {
                columnDefs: [
                { orderable: false, targets: [] }
                ],
                        order: [[0, 'asc']]
                };
                        const table1 = initTable("#CRCFormHistory", obj);
                        $("#entriesPerPage8").on("change", function () {
                table1.page.len($(this).val()).draw();
                });
                        $("#searchBox8").on("keyup", function () {
                table1.search(this.value).draw();
                });
                        }
    </script>
</html>
