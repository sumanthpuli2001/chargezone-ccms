<%-- 
    Document   : VendorInvitationView
    Created on : 13 Oct, 2025, 03:19:29 PM
    Author     : fnp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>Vendor Invitation</title>
    </head>

    <body>
        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

            <section class="main-content">
                <form:form class="form-horizontal" role="form1" action="vendorInvitation.htm?act=editInvitationDetails" method="post" name='form' onsubmit='return saveSubmit11();'>
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)" alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)" alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Vendor Invitation</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>
                            <button type="submit" class="btn theme-btn" id="submit1" >Submit</button>
                        </div>
                    </div>
                    <hr>
                     <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.
                        </div>
                    </div>
                    <c:if test="${!empty successMessage}">
                        <div id="successMsg" class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                    </c:if>
                    <c:if test="${!empty failureMessage}">
                        <div id="failureMsg" class="fadeOutEffect alert alert-danger" style="padding: 0px" role="alert">${failureMessage}</div>
                    </c:if>

                    <input type="hidden" name="vendorInformation" id="vendorInformation" value="${vendorInformation.id}">

                    <input type="hidden" name="vendorInvitationid" id="vendorInvitationid" value="${vendorInformation.vendorInvitationId}">
                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-6 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">Company Name :<span class="text-danger">*</span></label>
                                    <input type="text" name="companyName"  class="input-field" required="required" readonly="true" value="${vendorInformation.companyName}"/>
                                </div>
                            </div>                            

                            <div class="col-lg-6 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">Email ID :<span class="text-danger">*</span></label>
                                    <input type="email"  placeholder="Eg: abc@gmail.com" name="vendorEmailId"  class="input-field"  readonly="true" value="${vendorInformation.vendorEmailId}"/>
                                </div>
                            </div> 

                            <c:if test="${!empty buyer}">
                                <div class="col-lg-6 col-md-6">
                                    <div class="form-group">
                                        <label for="buyer">Buyer Approval :<span class="text-danger">*</span></label>
                                        <select class="select-input" id="buyer" name="buyer" style="font-size: 12px; padding: 5px;" required="required">
                                            <option value="">--SELECT--</option>
                                            <c:forEach var="list21" items="${list21}">
                                                <c:choose>
                                                    <c:when test="${list21 eq buyer}" >
                                                        <option value="${list21}" selected="true">${list21}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${list21}">${list21}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </c:if>

                            <c:if test="${!empty vendorInformation.technicalApproval}">
                                <div class="col-lg-6 col-md-6">
                                    <div class="form-group">
                                        <label for="technicalApproval">Technical Approval :<span class="text-danger">*</span></label>
                                        <select class="select-input" id="technicalApproval" name="technicalApproval" style="font-size: 12px; padding: 5px;" required="required">
                                            <option value="">--SELECT--</option>
                                            <c:forEach var="technicalList" items="${technicalList}">
                                                <c:choose>
                                                    <c:when test="${technicalList  eq vendorInformation.technicalApproval}">
                                                        <option value="${technicalList}" selected="true" >${technicalList}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${technicalList}">${technicalList}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </c:if>

                            <c:if test="${!empty hr}">
                                <div class="col-lg-6 col-md-6">
                                    <div class="form-group">
                                        <label for="hrApproval">HR Approval :<span class="text-danger">*</span></label>
                                        <select class="select-input" id="hrApproval" name="hrApproval" style="font-size: 12px; padding: 5px;" required="required">
                                            <option value="">--SELECT--</option>
                                            <c:forEach var="hrList" items="${hrList}">
                                                <c:choose>
                                                    <c:when test="${hrList   eq vendorInformation.hrApproval}">
                                                        <option value="${hrList}" selected="true">${hrList}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${hrList}">${hrList}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </c:if>

                            <c:if test="${!empty safety}">
                                <div class="col-lg-6 col-md-6">
                                    <div class="form-group">
                                        <label for="safetyApproval">Safety Approval: <span class="text-danger">*</span></label>
                                        <select class="select-input" id="safetyApproval" name="safetyApproval" style="font-size: 12px; padding: 5px;" required="required">
                                            <option value="">--SELECT--</option>
                                            <c:forEach var="safetyList" items="${safetyList}">
                                                <c:choose>
                                                    <c:when test="${safetyList    eq safety}">
                                                        <option value="${safetyList}" selected="true"> ${safetyList}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${safetyList}" >${safetyList}</option>
                                                    </c:otherwise>
                                                </c:choose>        
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </c:if>

                            <c:if test="${!empty financial}">
                                <div class="col-lg-6 col-md-6">
                                    <div class="form-group">
                                        <label for="financialApproval">Financial Approval:<span class="text-danger">*</span></label>
                                        <select class="select-input" id="financialApproval" name="financialApproval" style="font-size: 12px; padding: 5px;" required="required">
                                            <option value="">--SELECT--</option>
                                            <c:forEach var="financialList" items="${financialList}">
                                                <c:choose>
                                                    <c:when test="${financialList    eq financial}">
                                                        <option value="${financialList}" selected="true">${financialList}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${financialList}">${financialList}</option>
                                                    </c:otherwise>
                                                </c:choose>     
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </c:if>

                            <c:if test="${!empty it}">
                                <div class="col-lg-6 col-md-6">
                                    <div class="form-group">
                                        <label for="itApproval">IT Approval:<span class="text-danger">*</span></label>
                                        <select class="select-input" id="itApproval" name="itApproval" style="font-size: 12px; padding: 5px;" required="required">
                                            <option value="">--SELECT--</option>
                                            <c:forEach var="itList" items="${itList}">
                                                <c:choose>
                                                    <c:when test="${itList    eq it}">
                                                        <option value="${itList}" selected="true"> ${itList}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${itList}" >${itList}</option>
                                                    </c:otherwise>
                                                </c:choose>        
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </c:if>


                        </div>
                    </div>

                                
                        <div class="form-group">
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
