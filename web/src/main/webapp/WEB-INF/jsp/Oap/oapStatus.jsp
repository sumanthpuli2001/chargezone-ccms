
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OAP Status</title>
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

                            <h5 class="fw-600 mb-0">OAP Status</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>

                        </div>
                    </div>

                    <hr>


                    <div class="rounded-4 mt-4"> 
                        <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                            <div class="row buyer-info">
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Document No</label>
                                        <p class="fw-600">${oapForm.documentNo}</p>

                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Pcs Name</label>
                                        <p class="fw-600">${oapForm.pcsName}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-8 pb-1">
                                    <div class="form-group">
                                        <label>Project Name</label>
                                        <p class="fw-600">${oapForm.projectName}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Pcs CoOrdinates</label>
                                        <p class="fw-600">${oapForm.pcsCoordinates}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Client Name</label>
                                        <p class="fw-600">${oapForm.mobileNo}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Department</label>
                                        <p class="fw-600">${oapForm.department}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Date</label>
                                        <p class="fw-600">${oapForm.createdDate}</p>
                                    </div>
                                </div>
                            
                            </div>
                        </div>  
                    </div>  
<br>
                                 
                                   
<h6>Activity Milestone</h6>
                                        <table id="commonTable" class="table table-striped bg-white" style="width: 100%" align="center">
                                            <thead>
                                                <tr>
                                                    <th>Sr No</th>
                                                    <th style="min-width: 190px;">Activity</th>
                                                    <th style="min-width: 190px;">Activity By</th>
                                                    <th style="min-width: 190px;">Date</th>
                                                    <th>Status</th>
                                                    <th>Comments</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="oaplogmaster" items="${oaplogmaster}" varStatus="status">
                                                    <tr>

                                                        <td>${status.count}</td>
                                                        <td>${oaplogmaster.activity}</td>
                                                        <td>${oaplogmaster.activityBy}</td>
                                                        <td>${oaplogmaster.date}</td>
                                                        <td>${oaplogmaster.status}</td>
                                                        <td>${oaplogmaster.comments}</td>

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
