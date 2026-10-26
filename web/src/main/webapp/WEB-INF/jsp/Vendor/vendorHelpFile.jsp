
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VENDER HELP FILE</title>
    </head>

    <body >

        <script>
            $('#select_all').on('change', function () {
                $('.switch-input').prop('checked', this.checked).trigger('change');
            });
        </script>
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNewVendor.jsp"%>
            <section class="main-content">
                <form:form action=".htm?act=" method="post" enctype="multipart/form-data" commandName="vendorInvitation"
                                           class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">VENDER HELP FILE</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Cancel</a>
                        </div>
                    </div>  
                     <hr>
                    <br>
                   
                   <div class="form-group">
                                        <div class="col-sm-6">
                                          <h5 class="fw-600">  <a href="#" class="label">Download Self-Service Tutorial For Vendor Information</a></h5>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-6">
                                            <h5 class="fw-600">  <a href="#" class="label">Download Vendor Information In Excel</a></h5>
                                        </div>
                                    </div>
                                    <!--                                    <div class="form-group">
                                                                            <div class="col-sm-3">
                                                                                <a href="#" class="control-label">Download Excel</a>
                                                                            </div>
                                                                           
                                                                        </div>-->
                        </form:form>  
                </section>
            </main>
        </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
  </html>
