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
        <title>SELECT TYPE</title>

    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">

                <c:if test="${!empty successMessage}">
                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                </c:if>
                <c:if test="${!empty failureMessage}">
                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                </c:if>
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
                            <h5 class="fw-600 mb-0">SELECT TYPE</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>
                        </div>
                    </div>

                    <hr>
                    <div class="form-group row">
                        <div class="col-sm-3 fw-600 ">
                            <h5> <a href="tenderMaster.htm?act=selectTender" class="text-decoration-none">From SAP

                                </a></h5>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-3 fw-600">
                            <h5> <a href="tenderMaster.htm?act=selectManualTender" class="text-decoration-none">Manual

                                </a></h5>
                        </div>
                    </div>





                </form:form>
            </section>
        </main>
    </body>

</html>
