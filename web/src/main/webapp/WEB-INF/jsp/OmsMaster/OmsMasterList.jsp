<%--
    Document   : OmsMasterList
    Created on : 8 May, 2026, 1:54:51 PM
    Author     : bulwarks-2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>OMS Data</title>
    </head>

    <body>
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <%--<form:form >--%>
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)" alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)" alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">OMS Data</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <button type="button" id="deleteSelected" class="btn theme-btn delete-btn d-none">
                                <img src="StorageYard/assets/images/delete-icon.svg" class="icon" onload="SVGInject(this)"
                                     alt="Delete Icon">
                                Delete Selected
                            </button>
                        </div>
                        <%--<a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>--%>
                    </div>
                    <hr>
                    <c:if test="${!empty successMessage}">
                        <div id="successMsg" class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                    </c:if>
                    <c:if test="${!empty failureMessage}">
                        <div id="failureMsg" class="fadeOutEffect alert alert-danger" style="padding: 0px" role="alert">${failureMessage}</div>
                    </c:if>

                    <div class="content-top mb-0 d-flex align-items-center justify-content-between row my-3">
                        <div class="col-md-1 pr-md-1">
                            <select id="entriesPerPage" class="select-input">
                                <option value="10">10</option>
                                <option value="25">25</option>
                                <option value="50">50</option>
                                <option value="-1">All</option>
                            </select>
                        </div>
                        <div class="col-md-3 pl-md-1" >
                            <input id="searchBox" type="text" class="input-field" placeholder="Search here...">
                        </div>
                    </div>
                    <table id="OmsTable" class="table table-striped bg-white" style="width:100%">
                        <c:choose>
                            <c:when test="${empty omsMasterList}"></c:when>
                            <c:otherwise>
                                <thead>
                                    <tr>
<%--                                        <th class="text-center" data-dt-order="disable">
                                            <input type="checkbox" name="select_all_rows" id="select_all">
                                        </th>--%>
                                        <th>Sr.No.</th>
                                        <th>Ticket Id </th>
                                        <th>OMS PR Id </th>
                                        <th>Date Time </th>
                                        <th style="width: 300px;" data-dt-order="disable">Actions</th>                                        
                                    </tr>
                                </thead>
                                <c:set var="count" value="0" scope="page" />
                                <tbody>
                                    <c:forEach var="omsMasterList" items="${omsMasterList}" varStatus="status">
                                        <tr>
<%--                                            <td class="text-center" style="width: 5%;">
                                                <input type="checkbox" name="select_current_row" value="${omsMasterList.id}" class="rowCheckbox">
                                            </td>--%>
                                            <td class="" style="width: 10%;">${status.count}</td>
                                            <td>${omsMasterList.ticketId}</td>
                                            <td>${omsMasterList.omsPrId}</td>
                                            <td>${omsMasterList.dateTime}</td>
                                            <td>
                                                <div class="btn-group" style="display: flex; gap: 10px; align-items: center;">
                                                    <span class="icon-slot d-flex align-items-center">
                                                        <c:choose>
                                                            <c:when test="${omsMasterList.prFlag == 0}">
                                                                <a href="prMaster.htm?act=selectPR&omsMasterId=${omsMasterList.id}" class="btn theme-btn">
                                                                    Create PR
                                                                </a>
                                                            </c:when>
                                                            <c:when test="${omsMasterList.prFlag >= 1 && omsMasterList.prFlag <= 14}">
                                                                <a href="prMaster.htm?act=searchViewForOms&id=${omsMasterList.prNumber}" class="btn theme-btn light-btn">
                                                                    View
                                                                </a>
                                                                <a href="prMaster.htm?act=PRHistory&pr_no=${omsMasterList.prNumber}" class="btn theme-btn light-btn ml-3">
                                                                    Status
                                                                </a>
                                                            </c:when>
                                                            <c:otherwise></c:otherwise>
                                                        </c:choose>

<%--                                                            <a data-id="${omsMasterList.id}" class="ml-3 btn theme-btn delete-btn deleteoms-btn" data-toggle="tooltip"
                                                               data-placement="left" title="Delete">
                                                                <img src="StorageYard/assets/images/delete-icon.svg" class="mr-1" onload="SVGInject(this)"
                                                                     alt="Delete Icon">
                                                                Delete 
                                                            </a>--%>
                                                    </span>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </c:otherwise>
                        </c:choose>
                    </table>

                <%--</form:form>--%>
            </section>
        </main>
    </body>

    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>

    <script>
        $(document).on('click', '.deleteoms-btn', function (e) {
            e.preventDefault(); 
            var $row = $(this).closest('tr');
            var id = $(this).data('id');
            Swal.fire({
                title: 'Are you sure?',
                text: "Do you really want to delete this OMS Master ?",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonText: 'Yes, delete it!',
                reverseButtons: true,
                customClass: {
                    confirmButton: 'confirm-delete',
                    cancelButton: 'theme-btn light-btn'
                }
            }).then((result) => {
                if (result.isConfirmed) {
                    $.ajax({
                        url: 'omsMaster.htm?act=deleteOms' ,
                        type: 'POST',
                        data: {
                            omsid:id 
                        },
                        success: function (data) {
                            if (data.status === 'success') {
                                Swal.fire({
                                    icon: 'success',
                                    title: 'Deleted!',
                                    text: data.message
                                });
                                $('#OmsTable').DataTable().row($row).remove().draw();
                            } else if (data.status === 'error') {
                                Swal.fire({
                                    icon: 'error',
                                    title: 'Error!',
                                    text: data.message
                                });
                            } else {
                                Swal.fire({
                                    icon: 'warning',
                                    title: 'Unexpected response',
                                    text: 'Please try again.'
                                });
                            }
                        },
                        error: function(xhr, status, error) {
                            Swal.fire({
                                icon: 'error',
                                title: 'Server Error',
                                text: 'Could not delete record. Please try again.'
                            });
                        }
                    });
                }
            });
        });
    </script>

    <script src="StorageYard/assets/js/TableScript/OmsMaster.js" type="text/javascript"></script>

</html>
