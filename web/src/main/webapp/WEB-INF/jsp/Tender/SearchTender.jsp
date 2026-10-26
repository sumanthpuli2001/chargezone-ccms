<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tender Report</title>
    </head>
    <body>


        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="tenderMaster.htm?act=searchTenderSubmit" method="post" commandName="tenderMaster"
                           name='form1'  class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Tender Report</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>
                            <button type="submit" class="btn theme-btn" >Search</button>
                        </div>
                    </div>

                    <hr>

                    <br>


                    <div class="row rounded-4 mt-6">
                        <div class="col-lg-4 col-md-4">
                            <div class="form-group">
                                <label class="label">Tender No.</label>
                                <input type="text" name="tender_no" value="${tender_no}" class="input-field"  maxlength="30" />
                            </div>
                        </div>
                    </div>

                    <br>
                    <c:if test="${not empty tenderMaster.refNo}">                        
                        <div class="row rounded-4 mt-6">

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">Tender Type :</label>
                                    <form:input path="type" value="Procurment" class="input-field"   maxlength="30" readonly="true"/>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">Tender Reference No.</label>
                                    <form:input path="refNo" id="refNo" class="input-field" value="${refNo}"  maxlength="30" required="required" readonly="true"/>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">Title :</label>
                                    <form:input path="title" class="input-field"   readonly="true" />
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">Tender Location :</label>
                                    <form:input path="location" class="input-field" maxlength="30" readonly="true"/>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">Tender Date :</label>
                                    <form:input path="announceDate" class="input-field" value="${formattedDate}"  maxlength="30" required="required" readonly="true"/>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">Tender Due Date :</label>
                                    <div class="form-group date" id="datetimepickers6">
                                        <input class="input-field form_datetime" style="background: white;" placeholder="dd-mm-yyyy --:--" name="submitLastdate" name="submitLastdate" id="submitLastdate" value="${submitLastdate}" />
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-12 col-md-6 text-center mt-3">
                                <div class="form-group">
                                    <div style="display: flex;  justify-content: center;">
                                        <input type="submit" class="btn theme-btn " style="width: 100px;" formaction="tenderMaster.htm?act=submitPreponeDate" title="" value="Submit" >
                                    </div>
                                </div>
                            </div>

                        </div>
                    </c:if>


                </form:form>
            </section>
        </main>
             <script>
$(function () {
    flatpickr("#submitLastdate", {
        enableTime: true,
        enableSeconds: true,
        time_24hr: true,
        dateFormat: "d-m-Y H:i:S"
    });
});
</script>
      

        
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
