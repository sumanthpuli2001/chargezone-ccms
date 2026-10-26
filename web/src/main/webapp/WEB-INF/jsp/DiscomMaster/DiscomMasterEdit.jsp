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
        <title> Discom Master Edit</title>
    </head>
    <body>
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="discomMaster.htm?act=DiscomMasterEditSubmit" method="post"  commandName="sapConnection">

                    <input type="hidden" name="id" value="${discomMaster.id}">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Discom Master Edit</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a href="discomMaster.htm?act=showlist" class="btn theme-btn light-btn mr-3">Back</a>
                        </div>
                    </div>
                    <hr>
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
                                    <label class="control-label">Discom<span style="color: red;font-size: 12px;">*</span></label>                    
                                    <input class="input-field"  name="discomtype" id="discomtype" value="${discomMaster.discomType}" required/>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-12">
                                <label class="label">
                                    State <span style="color:red; font-size:10px;">*</span>
                                </label>
                                <select class="select-input" id="state" name="state" required="required">
                                    <option value="">--SELECT--</option>
                                    <c:forEach var="list" items="${list}">
                                        <c:choose>
                                            <c:when test="${list.locationName eq State}">
                                                <option selected="true" value="${list.locationName}">${list.locationName}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${list.locationName}">${list.locationName}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
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
