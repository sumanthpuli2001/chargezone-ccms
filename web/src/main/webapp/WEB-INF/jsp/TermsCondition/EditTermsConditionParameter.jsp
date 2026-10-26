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
        <title>Edit Terms Condition Parameter</title>
    </head>

    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="termsConditionParameter.htm?act=editTermsConditionParameterSubmit" method="post" commandName="bpGroup">
                    <input type="hidden" name="id" value="${list1[0][0]}">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Edit TERMS CONDITION PARAMETER</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a href="termsConditionParameter.htm?act=showList" class="btn theme-btn light-btn mr-3">Back</a>
                        </div>
                    </div>

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
                                    <label>Terms Condition Name :<span class="text-danger">*</span></label>
                                    <select class="select-input" id="termsConditionName" name="termsConditionName" required="required">
                                        <c:forEach var="list" items="${list}">   
                                            <c:choose>
                                                <c:when test="${list1[0][2]==list.name}">
                                                    <option value="${list.id}" selected="true">${list.name}</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${list.id}" >${list.name}</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </select> 
                                </div>
                            </div>

                            <div class="col-lg-6 col-md-6">
                                <div class="form-group">
                                    <label>Name :<span class="text-danger">*</span></label>
                                    <input  class="input-field" name="name" id="name" value="${list1[0][1]}" required="true"/>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-12">
                                <div class="form-group">
                                    <label>Description :<span class="text-danger">*</span></label>
                                    <textarea class="textarea-field comment" name="description"rows="5"  required="required">${list1[0][3]}</textarea>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">    
                        <div style="display: flex; justify-content: center;">
                            <button type="submit" class="btn theme-btn">Submit</button>
                        </div>
                    </div>

                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
