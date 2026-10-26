<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tender Search By Item Code</title>
    </head>
    <body>


        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                      <form:form action="tenderMaster.htm?act=searchByItemSubmit" method="post" commandName="employeeMaster"
                   name='form1'  class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                   

                            <h5 class="fw-600 mb-0">Tender Search By Item Code</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-2">Back</a>
                            <button type="submit" class="btn theme-btn mr-2">Search</button>



                        </div>
                    </div>
                    <hr>
                    
                     <div class="form-group" id="xl">
                                                <div class="col-sm-3">
                                                    <label class="control-label">Search Item Code :</label>
                                                </div>
                                                <div class="col-sm-4">
                                                        <input name="item_code" type="text" class="input-field"   required="true" maxlength="30"/>
                                                        
                                                </div>        
                                            </div>
                      

                        


                    </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
