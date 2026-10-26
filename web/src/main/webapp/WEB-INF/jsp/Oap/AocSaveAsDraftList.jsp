

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>AOC Save As Draft List</title>
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

                        <h5 class="fw-600 mb-0">AOC Save As Draft List</h5>
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
                    <table id="commonTable" class="table  table-striped bg-white" align="center">
                        <thead>
                            <tr>
                                <th>Sr.No</th>
                                <th style="min-width: 180px;">Document Number</th>
                                <th style="min-width: 180px;">Depo.Name</th>
                                <th style="min-width: 180px;">Project Name</th>
                                <th style="min-width: 180px;">Created By</th>
                                <th style="min-width: 180px;">Client Name</th>
                                <th style="min-width: 150px;">Date</th>
                                <th style="min-width: 140px;">Status</th>
                                <th data-dt-order="disable">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="list" items="${list}" varStatus="status">
                                <tr >
                                    <td>${status.count}</td>
                                    <td>${list.documentNo}</td>
                                    <td>${list.hubDepoName}</td>
                                    <td>${list.clientProjectName}</td>
                                    <td>${list.userId}</td>
                                    <td>${list.mobileNo}</td>
                                    <td>${list.createdDate}</td>
                                    <td>
                                        <c:if test="${list.flagStatus == '0'}">
                                            Save As Draft
                                        </c:if>

                                    </td> 
                                    <td>
                                        <div class="btn-group">
                                               <a href="#" class="btn btn theme-btn light-btn dropdown-toggle" style="margin-left: 10px;" 
                                               onclick="window.location = 'aocForm.htm?act=AocSaveAsDraftView&id=${list.id}'">
                                                Edit
                                            </a>
                                            &nbsp; &nbsp; 
                                            
                                         <a href="aocForm.htm?act=aocFormDelete&id=${list.id}"class="d-block text-danger p-1 mx-1"data-toggle="tooltip" data-placement="left"  title="Delete"><img src="StorageYard/assets/images/delete-icon.svg" onload="SVGInject(this)"alt="Delete Icon" style="width: 22px; height: 22px;">
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
<script>
document.addEventListener("DOMContentLoaded", function() {
    document.querySelectorAll('a[href*="aocFormDelete"]').forEach(function(el) {
        el.addEventListener('click', function(e) {
            e.preventDefault();
            let url = this.getAttribute('href');

            Swal.fire({
                title: 'Are you sure?',
                text: "This will delete the AOC!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#6c757d',
                confirmButtonText: 'Yes, delete it!'
            }).then((result) => {
                if (result.isConfirmed) {
                    // After confirmation, show success and redirect
                    Swal.fire({
                        icon: 'success',
                        title: 'AOC deleted successfully.',
                        showConfirmButton: false,
                        timer: 1500
                    }).then(function() {
                        window.location.href = url;
                    });
                }
            });
        });
    });
});
</script>

</html>


