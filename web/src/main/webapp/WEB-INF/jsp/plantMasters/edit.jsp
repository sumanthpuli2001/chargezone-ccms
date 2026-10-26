<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Plant edit</title>
    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="plantMasters.htm?act=plantseditssubmit" method="post" commandName="sapConnection"
                           class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Plant edit</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a href="plantMasters.htm?act=showlist" class="btn theme-btn light-btn mr-3">Back</a>
                        </div>
                    </div>

                    <hr>
                    <input type="hidden" name="id" value="${plantMasters.id}">
                    <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.
                        </div>
                    </div>                    

                    <div class="rounded-4 mt-4">
                        <div class="row g-3">
                            <!-- Company Code -->
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">
                                        Company Code <span class="text-danger">*</span>
                                    </label>
                                    <select class="select-input" id="comapnycode" name="comapnycode" style="width:225px; font-size: 12px; padding: 5px;" required>
                                        <option value="">--SELECT--</option>

                                        <c:forEach var="list10" items="${list10}">
                                            <c:choose>
                                                <c:when test="${list10.companyCode eq companymaster}">
                                                    <option selected="true" value="${list10.companyCode}">${list10.companyCode}</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${list10.companyCode}">${list10.companyCode}</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>




                                    </select>
                                </div>
                            </div>


                            <!-- Purchasing Organisation -->
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">
                                        Purchasing Organisation <span class="text-danger">*</span>
                                    </label>
                                    <select class="select-input" id="purchasing" name="purchasing" style="width:225px; font-size: 12px; padding: 5px;" required>
                                        <option value="">--SELECT--</option>

                                        <c:forEach var="list11" items="${list11}">
                                            <c:choose>
                                                <c:when test="${list11.purchasingOrganisation eq purchase}">
                                                    <option selected="true" value="${list11.purchasingOrganisation}">${list11.purchasingOrganisation}</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${list11.purchasingOrganisation}">${list11.purchasingOrganisation}</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>




                                    </select>
                                </div>
                            </div>


                            <!-- Plant Code -->
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">
                                        Plant Code <span class="text-danger">*</span>
                                    </label>
                                    <input  class="input-field"  name="plantcode" id="plantcode" value="${plantMasters.plantCode}"  required/>

                                </div>
                            </div>


                            <!-- Plant Name -->
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">
                                        Plant Name <span class="text-danger">*</span>
                                    </label>
                                    <input  class="input-field"  name="plantname" id="plantname" value="${plantMasters.plantName}"  required/>

                                </div>
                            </div>


                            <!-- Address -->
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">
                                        Address <span class="text-danger">*</span>
                                    </label>
                                    <input  class="input-field"  name="address" id="address" value="${plantMasters.address}" required/>

                                </div>
                            </div>


                            <!-- GST -->
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">
                                        GST <span class="text-danger">*</span>
                                    </label>
                                    <input  class="input-field"  name="gst" id="gst" value="${plantMasters.gst}" required/>

                                </div>
                            </div>


                            <!-- Postal Code -->
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">
                                        Postal Code <span class="text-danger">*</span>
                                    </label>
                                    <input  class="input-field"  name="postalcode" id="postalcode" value="${plantMasters.postalCode}" required/>

                                </div>
                            </div>


                            <!-- Country -->
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">
                                        Country <span class="text-danger">*</span>
                                    </label>
                                    <input  class="input-field"  name="country" id="country" value="${plantMasters.country}" required/>

                                </div>
                            </div>


                            <!-- Region -->
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">
                                        Region <span class="text-danger">*</span>
                                    </label>
                                    <input  class="input-field"  name="region" id="region" value="${plantMasters.region}" required/>

                                </div>
                            </div>


                            <!-- Language -->
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">
                                        Language <span class="text-danger">*</span>
                                    </label>
                                    <input  class="input-field"  name="language" id="language" value="${plantMasters.language}" required/>

                                </div>
                            </div>

                        </div>
                    </div>
                    <div style="display: flex;  justify-content: center;">
                        <button type="submit" class="btn theme-btn">Submit</button>
                    </div>
                    </div>  
                </form:form>
            </section>
        </main>

    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>


