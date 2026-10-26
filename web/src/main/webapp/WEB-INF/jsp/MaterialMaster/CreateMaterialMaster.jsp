<%-- 
    Document   : CreateDepartment
    Created on : 29 March, 2025, 9:35:37 AM
    Author     : Prachi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Material Master</title>
    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="materialMaster.htm?act=createMaterial" method="post" commandName="sapConnection"
                           class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-3 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Create Material Master</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a href="materialMaster.htm?act=searchPage" class="btn theme-btn light-btn ">Back</a>
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
                    
                    <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.
                        </div>
                    </div>                                
                    
                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-6 col-md-6">
                                <div class="form-group">
                                    <label for="group">Material Group :<span style="color: red;font-size: 12px">* </span> </label>                         
                                    <select class="select-input" id="group" name="group" required>
                                        <option value="">-- Select --</option>
                                        <c:forEach var="group" items="${group}">
                                            <c:choose>
                                                <c:when test="${materialGroupMaster.materialGroupName==group.materialGroupName}">
                                                    <option value="${group.id}" selected="true">${group.materialGroupName}</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${group.id}">${group.materialGroupName}</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </select>  
                                </div>
                                 </div> 
                            <div class="col-lg-6 col-md-6">
                                <div class="form-group">
                                    <label for="type">Material type :<span style="color: red;font-size: 12px">* </span> </label>                         
                                    <select class="select-input " id="type" name="type" required>
                                        <option value="">-- Select --</option>
                                        <c:forEach var="type" items="${type}">   
                                            <c:choose>
                                                <c:when test="${materialTypeMaster.materialType==type.materialType}">
                                                    <option value="${type.id}" selected="true">${type.materialType}</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${type.id}">${type.materialType}</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </select>  
                                </div>
                                 </div>

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label for="materialCode" class="control-label">Enter Material Code:<span style="color: red;font-size: 12px;">*</span></label>                       
                                    <input name="materialCode" id="materialCode" class="input-field"  required/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">Enter Material Description:<span style="color: red;font-size: 12px;">*</span></label>

                                    <input name="materialDescription" id="materialDescription" class="input-field"   required/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label name="control-label">Enter Material Long Description:<span style="color: red;font-size: 12px;">*</span></label>

                                    <input name="materialLongDescription" id="materialLongDescription" class="input-field"   required/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">Enter UMO:<span style="color: red;font-size: 12px;">*</span></label>

                                    <input name="umo" id="umo" class="input-field"   required/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">Enter HSN no.:<span style="color: red;font-size: 12px;">*</span></label>

                                    <input name="hsnNo" id="hsnNo" class="input-field"   required/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">Enter GST:<span style="color: red;font-size: 12px;">*</span></label>

                                    <input name="gst" id="gst" class="input-field"   required/>
                                </div>
                            </div>


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
