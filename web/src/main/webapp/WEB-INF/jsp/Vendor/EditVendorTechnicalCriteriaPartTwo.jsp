<%--
    Document   : EditVendorTechnicalCriteriaPartTwo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>Vendor Technical Criteria Edit</title>
    </head>

    <body>
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

            <section class="main-content">
                <form:form action="vendorCriteriaMaster.htm?act=editVendorTechnicalCriteriaPartTwoSubmit" method="post" commandName="vendorTechnicalCriteria"
                           class="form-horizontal" role="form">
                    <input type="hidden" name="id" value="${vendorTechnicalCriteria.id}">

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)" alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)" alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Vendor Technical Criteria Edit</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>
                            <button type="submit" class="btn theme-btn" onclick="return Validate()" value="SUBMIT">Submit</button>
                        </div>
                    </div>
                    <hr>
                  

                    <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <strong>Note:</strong> Ensure your file size is within <strong>5MB</strong> for a smooth upload. <br>
                            <span style="font-weight: bold;">*</span>  Indicate That Attachment Are Mandatory
                        </div>
                    </div>                    
                    <input type="hidden" name="id" value="${vendorCriteriaMasterDetails.id}">
                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-md-4">
                                <label class="control-label">Criteria Name<span style="color: red;font-size: 12px;">*</span></label>
                                <textarea class="textarea-field"  name="criteriaName" id="criteriaName" required="required">${vendorTechnicalCriteria.criteriaName}</textarea>
                            </div>
                            <div class="col-md-4">
                                <label class="control-label">Criteria Description<span style="color: red;font-size: 12px;">*</span></label>
                                <textarea  class="textarea-field" style="resize: vertical;"  name="criteriaDescription" id="criteriaDescription"  value="${vendorTechnicalCriteria.criteriaDescription}" required="required">${vendorTechnicalCriteria.criteriaDescription}</textarea>
                            </div>

                            <div class="col-md-4">
                                <label class="control-label">Attachment Required :<span style="color: red;font-size: 12px;">*</span></label>
                                <select name="mandatory" id="mandatory" class="select-input" required="required">
                                    <option value="">-- Select --</option>
                                    <option value="Yes" <c:if test="${vendorTechnicalCriteria.mandatory == 'Yes'}">selected</c:if>>Yes</option>
                                    <option value="No" <c:if test="${vendorTechnicalCriteria.mandatory == 'No'}">selected</c:if>>No</option>
                                </select>
                            </div>                        
                        </div>
                    </div>
                </form:form>
            </section>
        </main> 
    </body>

    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
