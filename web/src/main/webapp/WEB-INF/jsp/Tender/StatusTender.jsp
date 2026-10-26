<%-- 
    Document   : EmployeeCreate
    Created on : Jun 11, 2020, 2:39:39 PM
    Author     : Aman Bahukhandi
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tender Status</title>

    </head>

    <body>
        <style>
            .status-box {
                width: 100%;
                height: 200px;
                background-color: #ffffff;
                border: 2px solid #3498db;
                border-radius: 10px;
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                text-align: center;
                box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            }

            .status-title {
                font-size: 22px;
                color: #3498db;
                margin-bottom: 20px;
            }

            .status-button {
                padding: 10px 20px;
                font-size: 16px;
                background-color: #3498db;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }

            .status-button:hover {
                background-color: #2980b9;
            }

        </style>
        <script>
            $('#select_all').on('change', function () {
                $('.switch-input').prop('checked', this.checked).trigger('change');
            });
        </script>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="tenderMaster.htm?act=createTender" method="post" commandName="tenderMaster"
                           class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">Tender Status</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>
                        </div>
                    </div>
                    <hr>
                    <h5> PR Details</h5>
                    <div class="card-box rounded-3 mb-4 pt-3 pb-2">
                        <div class="row buyer-info">

                            <!-- Row 1 -->
                            <div class="col-lg-4 col-md-4 pb-2">
                                <label class="text-muted">Pr Number</label>
                                <div class="fw-600">${pr_no}</div>
                            </div>

                            <div class="col-lg-4 col-md-4 pb-2">
                                <label class="text-muted">Title</label>
                                <div class="fw-600">${prTitle}</div>
                            </div>
                            <!-- Row 2 -->
                            <div class="col-lg-4 col-md-4 pb-2">
                                <label class="text-muted">Delivery Period</label>
                                <div class="fw-600">${deliveryPeriod}</div>
                            </div>

                            <div class="col-lg-4 col-md-4 pb-2">
                                <label class="text-muted">Category</label>
                                <div class="fw-600">${category}</div>
                            </div>


                        </div>
                    </div>



                    <h5> Tender Details</h5> 

                    <div class="card-box rounded-3 mb-4 pt-3 pb-2">
                        <div class="row buyer-info">

                            <!-- Row 1 -->
                            <div class="col-lg-4 col-md-4 pb-2">
                                <label class="text-muted">Title</label>
                                <div class="fw-600">${prTitle}</div>
                            </div>
                            <div class="col-lg-4 col-md-4 pb-2">
                                <label class="text-muted">Department</label>
                                <div class="fw-600">${tenderDepartment}</div>
                            </div>
                            
                        </div>
                    </div>






                    
                  
                    <div class="status-box">
                        <div class="status-title">Status</div>
                        <button disabled="true" class="status-button">${techbid}</button>
                    </div>
                </form:form>
                </div>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
