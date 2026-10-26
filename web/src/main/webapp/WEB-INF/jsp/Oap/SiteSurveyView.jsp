
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Site Survey View</title>
    </head>
    <body>

        <script>
            $('#select_all').on('change', function () {
                $('.switch-input').prop('checked', this.checked).trigger('change');
            });
        </script>
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action=".htm?act=" commandName="" method="post">

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Site Survey View</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>

                        </div>
                    </div>
                     <hr>
 <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                   

                 <div class="rounded-4 mt-4"> 
                        <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                            <div class="row buyer-info">
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Site Name</label>
                                        <p class="fw-600">${siteSurvey.siteName}</p>

                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Site Address</label>
                                        <p class="fw-600">${siteSurvey.siteAddress}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-8 pb-1">
                                    <div class="form-group">
                                        <label>Description</label>
                                        <p class="fw-600">${siteSurvey.description}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Start Date</label>
                                        <p class="fw-600">${siteSurvey.startDate}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>End Date</label>
                                        <p class="fw-600">${siteSurvey.endDate}</p>
                                    </div>
                                </div>
                                
                                  <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Google Coordinates Of The Location</label>
                                        <p class="fw-600">${siteSurvey.googleCoordinates}</p>
                                    </div>
                                </div>  
                                    
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Type Of Charge</label>
                                        <p class="fw-600">${siteSurvey.typeOfCharge}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>No Of Charges</label>
                                        <p class="fw-600">${siteSurvey.noOfCharges}</p>
                                    </div>
                                </div>
                                   
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Name of Location Partner</label>
                                        <p class="fw-600">${siteSurvey.nameofLocationPartner}</p>
                                    </div>
                                </div>
                                    <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Mobile No of Location Partner</label>
                                        <p class="fw-600">${siteSurvey.mobileNoLocationPartner}</p>
                                    </div>
                                </div>
                                 <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Location</label>
                                        <p class="fw-600">${siteSurvey.location}</p>
                                    </div>
                                </div>
                            
                            </div>
                        </div>  
                    </div>   
                          <br>
                                    <table id="commonTable" class="table table-striped bg-white " style="width: 100%" align="center">
                                        <thead>
                                            <tr>
                                                <th >Sr No</th>
                                                <th >Description</th>
                                                <th >Attachment</th>
                                            </tr>
                                        </thead>
                                        <c:forEach var="SurveyAttach" items="${SurveyAttach}" varStatus="status">
                                            <tr>
                                                <td ><span>${status.count}</span>
                                                </td> 
                                                <td ><span>${SurveyAttach.description}</span>
                                                </td> 
                                            <td >
                                                <a class="fw-600 text-break gradient-text" href="oapForm.htm?act=surveydownload&fileName=${SurveyAttach.attachment}&id2=${siteSurvey.id}"> ${SurveyAttach.attachment}</a>
                                            </td> 
                                            </tr>
                                        </c:forEach>  
                                    </table>
                                    <c:if test="${siteSurvey.flagStatus == 100}">
                                        <div class="col-12 p-0">
                                            <div class="form-group comment-box">
                                                <label class="control-label">Remark :</label>
                                                <textarea type="text" maxlength="250" class="textarea-field comment" id="comment" name="comment"  readonly="true">${siteSurvey.remark}</textarea>
                                            </div>
                                        </div> 
                                    </c:if>
                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
