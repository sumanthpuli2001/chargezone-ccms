<%-- 
    Document   : ShowDepartmentList
    Created on : 2 Jan, 2024, 6:01:06 PM
    Author     : Bulwark-5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>Declaration Letter</title>
    </head>

    <body>
        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

            <section class="main-content">
                <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                    <div class="page-title d-flex align-items-center">
                        <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                            <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                 alt="Menu collapse">
                            <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                 alt="Menu collapse">
                        </div>

                        <h5 class="fw-600 mb-0">Declaration Letter</h5>
                    </div>

                    <div class="cta d-flex align-items-center">
                        <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>
                    </div>

                </div>

                <hr>
                <c:if test="${!empty successMessage}">
                    <div id="successMsg" class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                </c:if>
                <c:if test="${!empty failureMessage}">
                    <div id="failureMsg" class="fadeOutEffect alert alert-danger" style="padding: 0px" role="alert">${failureMessage}</div>
                </c:if>

                <form:form action="declarationLetter.htm?act=submitLetter" method="post" enctype="multipart/form-data" commandName="declarationLetter"
                                           class="form-horizontal" role="form"> 
                    
                    <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <span style="color: red;font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.
                        </div>
                    </div> 
                    <br>
                    
                    <c:choose>
                        <c:when test="${Value == 0}">

                            <div class="form-group">
                                <div class="col-sm-3">
                                    <label class="control-label">Select Letter To upload<span style="color: red;font-size: 10px;">*</span></label>
                                </div>
                                <div class="col-sm-5">
                                    <input type="file" class="input-field" id="decLetter" name="decLetter" onchange="checkFileSize1(this);" required />
                                </div>
                            </div>      


                            <c:forEach var="item" items="${list}">
                                <div class="col-sm-3">
                                    View file:
                                </div>
                                <c:choose>
                                    <c:when test="${not empty item.declarationLetter}">
                                        <div class="col-sm-3">
                                            <a class="fw-600 text-break gradient-text" href="declarationLetter.htm?act=downloadFile&amp;fileName=${item.declarationLetter}&amp;id=${item.id}">
                                                ${item.declarationLetter}
                                            </a>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        No file available
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>


                            <div class="form-group">
                                <div style="display: flex;  justify-content: center;">
                                    <input type="submit" class="btn theme-btn" id="submit1" title="submit1" value="Update Policy" onclick="return fileValidation();">
                                </div>
                            </div>
                        </c:when>
                        <c:when test="${Value == 1}">


                            <div class="form-group">
                                <div class="col-sm-3">
                                    <label class="control-label">Select Letter To upload<span style="color: red;font-size: 10px;">*</span></label>
                                </div>
                                <div class="col-sm-5">
                                    <input type="file" class="input-field" id="decLetter" name="decLetter" onchange="checkFileSize1(this);" required />
                                </div>
                            </div>         



                            <div class="form-group">
                                <div style="display: flex;  justify-content: center;">
                                    <input class="btn theme-btn" type="submit" class="input-field" style="min-width: 180px !important;" id="submit1" title="submit1" value="Save Policy" onclick="return fileValidation();">
                                </div>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <%-- Value is neither 0 nor 1, do nothing or show a message --%>
                        </c:otherwise>
                    </c:choose>








                </form:form>



            </section>
        </main> 
    </body>

    <script src="StorageYard/assets/js/TableScript/risk.js"></script>
    <script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
    <script>
                                                        document.addEventListener("DOMContentLoaded", function () {
                                                            document.querySelectorAll('a[href*="riskCategory.htm?act=deleteRiskById"]').forEach(function (el) {
                                                                el.addEventListener('click', function (e) {
                                                                    e.preventDefault();
                                                                    let
                                                                    url = this.getAttribute('href');
                                                                    Swal.fire({
                                                                    title: 'Are you sure?',
                                                                            text: "Do you really want to delete this Risk Category ?",
                                                                            icon: 'warning',
                                                                            showCancelButton: true,
                                                                            confirmButtonColor: '#3085d6',
                                                                            cancelButtonColor: '#6c757d',
                                                                            confirmButtonText: 'Yes, delete it!',
                                                                            cancelButtonText: 'No, cancel'
                                                                    }).then((result) = > {
                                                                    if (result.isConfirmed) {
                                                                        Swal.fire({
                                                                            icon: 'success',
                                                                            title: 'Risk Category is deleted successfully',
                                                                            showConfirmButton: false,
                                                                            timer: 1500
                                                                        }).then(function () {
                                                                            window.location.href = url;
                                                                        });
                                                                    }
                                                                });
                                                            });
                                                        });
                                                        });
    </script>



</html>


