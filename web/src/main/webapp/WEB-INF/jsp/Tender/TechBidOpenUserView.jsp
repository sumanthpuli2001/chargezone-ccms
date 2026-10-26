
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Technical Bid Open Page</title>
    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="tenderMaster.htm?act=techBidOpenUserSubmit" method="post" commandName="employeeMaster"
                           name='form1' class="form-horizontal" role="form">

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Technical Bid Open Page</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                            <!--<button type="submit" class="btn theme-btn">Open</button>-->
                        </div>
                    </div>

                    <hr>

                    <input type="hidden" name="refNo" value="${refNo}">
                    <input type="hidden" name="id" value="${id}">
                    <input type="hidden" name="vendor_list" value="${vendor_list}">


                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label">User Name </label>
                                            <input type="text" name="username1" value="${username}" class="input-field"   maxlength="30" required/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label">Password</label>
                                            <input type="password" name="password1" value="" class="input-field"   maxlength="30" required/>
                                </div>
                            </div>
                        </div>
                    </div>
                                
                    <div class="form-group">
                                        <div style="display: flex;  justify-content: center;">
                                            <button type="submit" class="btn theme-btn" style="width: 100px;"  >Open</button>
                                        </div>
                                    </div>
                                
                                
                                
                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
