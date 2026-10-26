<%-- 
    Document   : EditAuditor
    Created on : 17 Oct, 2023, 11:31:29 AM
    Author     : Seth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>Edit Auditor</title>
    </head>

    <body>
        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

            <section class="main-content">
                <form:form class="form-horizontal" role="form1" action="auditorMaster.htm?act=editPageSubmit" method="post" name='form' onsubmit='return saveSubmit11();'>
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)" alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)" alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Edit Auditor</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a href="auditorMaster.htm?act=showList" class="btn theme-btn light-btn mr-3">Back</a>
                        </div>
                    </div>
                    <c:if test="${!empty failureMessage}">
                    <div class="fadeOutEffect alert alert-danger mt-2 mb-2" style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <strong>Note:</strong> <strong class="text-danger fs-13">${failureMessage} </strong><br>                            
                        </div>
                    </div>
                </c:if>
                <c:if test="${!empty successMessage}">
                    <div class="fadeOutEffect alert alert-info mt-2 mb-2" style="display: flex; align-items: center; gap: 12px; background: #F0FFF4; color: #0F5132; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #198754; box-shadow: 2px 2px 10px rgba(25, 135, 84, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">                        
                        <div style="background: #198754; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px; ">✓</div>  
                        <div>                             
                            <strong>Note:</strong> <strong class="text-success fs-13">${successMessage} </strong><br>                            
                        </div>
                    </div>
                </c:if>
                    <hr>
                    
                     <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.
                        </div>
                    </div>
                   
                        
                    <input type="hidden" id="id" name="id" value="${auditorMaster.id}">
                    
                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">Auditor Code <span class="text-danger">*</span></label>
                                    <input type="text" name="auditor_code" value="${auditorMaster.auditorCode}" class="input-field" required="required"/>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">Auditor Company Name <span class="text-danger">*</span></label>
                                    <input type="text" name="auditor_name" value="${auditorMaster.auditorName}"  class="input-field" maxlength="100" required="required"/>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">Auditor Email Id <span class="text-danger">*</span></label>
                                    <input type="email"  placeholder="Eg: abc@gmail.com" value="${auditorMaster.auditorEmail}" name="auditor_email_id" class="input-field" maxlength="100" required="required"/>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">Auditor Mobile No. <span class="text-danger">*</span></label>
                                    <input type="text" pattern="[+][0-9]{1,4}[0-9]{6,}" placeholder="Eg: +91 8765432198" name="auditor_mobile_no" value="${auditorMaster.auditorMobileNo}" class="input-field" maxlength="100" required="required"/>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label for="auditorRole">Auditor Role : <span class="text-danger">*</span></label>
                                    <select class="select-input" id="auditorRole" name="auditorRole" style="font-size: 12px; padding: 5px;">
                                        <option value="">--SELECT--</option>
                                        <option value="Risk Evaluator" <c:if test="${auditorMaster.auditorRole == 'Risk Evaluator'}">selected="selected"</c:if>>Risk Evaluator</option>
                                        <option value="Internal Auditor" <c:if test="${auditorMaster.auditorRole == 'Internal Auditor'}">selected="selected"</c:if>>Internal Auditor</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="col-lg-4 col-md-6">
                                    <div class="form-group">

                                        <div class="row">
                                            <div class="col-12">
                                                <label class="control-label">Auditor Status <span class="text-danger">*</span></label>
                                            </div>
                                            <div class="col-12 d-flex justify-content-center">
                                                <div class="form-check form-check-inline">
                                                    <input type="radio" name="auditor_status" <c:if test="${auditorMaster.auditorStatus == 1}">checked</c:if> value="1" class="form-check-input" required="required"/>&nbsp;<label class="form-check-label"> Active </label> 
                                                </div>
                                                <div class="form-check form-check-inline">
                                                    <input type="radio" name="auditor_status" value="0" <c:if test="${auditorMaster.auditorStatus == 0}">checked</c:if> class="form-check-input" required="required"/>&nbsp;<label class="form-check-label"> InActive </label>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div>

                                <div class="col-lg-4 col-md-6">
                                    <div class="form-group">
                                        <label class="control-label">Auditor Remark <span class="text-danger"></span></label>
                                        <textarea type="text" name="auditor_remark" class="textarea-field" row="8" >${auditorMaster.auditorRemark}</textarea>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">Auditor Address <span class="text-danger">*</span></label>
                                    <textarea type="text" name="auditor_address" value="" class="textarea-field" maxlength="100" required="required">${auditorMaster.auditorAddress}</textarea>
                                </div>
                            </div>

                        </div>
                    </div>
 <br>
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
