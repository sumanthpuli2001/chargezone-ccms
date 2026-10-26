<%-- 
    Document   : EditGroupSubCategory
    Created on : Nov 30, 2024, 12:13:20 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>Edit Group Sub Category</title>
    </head>

    <body>
        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

            <section class="main-content">
                <form:form action="group.htm?act=editGroupSubCategorySubmit" method="post" enctype="multipart/form-data"
                           class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)" alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)" alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Edit Group Sub Category</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a href="group.htm?act=showGroupSubCategoryList" class="btn theme-btn light-btn mr-3">Back</a>
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
                    <input type="hidden" name="id" value="${groupSubCategory.id}">
                    
                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">Group  Name :<span class="text-danger">*</span></label>
                                    <select class="select-input" id="groupName" name="groupName" required="true" onchange="fetchGroupCategory(this.value)">
                                        <c:forEach var="list" items="${list}">   
                                            <c:choose>
                                                <c:when test="${GroupMaster.groupName==list.groupName}">
                                                    <option value="${list.id}" selected="true">${list.groupName}</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${list.id}">${list.groupName}</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </select>              
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">Group Category Name :<span class="text-danger">*</span></label>
                                    <select class="select-input" id="groupCategoryName" name="groupCategoryName" required="true">
                                        <option value="${groupCategory.id}" selected="true">${groupCategory.groupCatogryName}</option>
                                    </select>              
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">Group Sub Category Name :<span class="text-danger">*</span></label>
                                    <input class="input-field" name="subCategoryName" id="groupSubCategoryName" value="${groupSubCategory.subCategoryName}" required="required" />
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label for="riskCategory">Risk Category: <span class="text-danger">*</span></label>
                                    <select class="select-input" id="riskCategory" name="riskCategory" style="font-size: 12px; padding: 5px;" required="required">
                                        <option value="">--SELECT--</option>
                                        <c:forEach var="list" items="${list1}">
                                            <option value="${list.category}"
                                                    <c:if test="${list.category eq groupSubCategory.riskCategory}">selected="selected"</c:if>>
                                                ${list.category}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <div class="row m-0 p-0 d-flex justify-content-between">
                                        <label for="attachment">Attachment: <c:if test="${groupSubCategory.attachment==null && empty groupSubCategory.attachment}"><span class="text-danger">*</span></c:if></label>                                       
                                    </div>                                    
                                    <span class="attachment-link">
                                        <a id="attachmentLink" class="text-break gradient-text fw-600" 
                                           href="group.htm?act=downloadFile&amp&id=${groupSubCategory.id}&fileName=${groupSubCategory.attachment}" 
                                           data-toggle="tooltip" data-placement="bottom" title="${groupSubCategory.attachment}">
                                            ${groupSubCategory.attachment}</a>
                                    </span>
                                    <input type="file" class="input-field" id="attachment" name="attachment" onchange="checkFileSize1(this);" <c:if test="${groupSubCategory.attachment==null && empty groupSubCategory.attachment}">required</c:if> />
                                    <input type="hidden" class="input-field" id="attachment" name="attachment1" onchange="checkFileSize1(this);" value="${groupSubCategory.attachment}" />
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">Category Name :<span class="text-danger">*</span></label>
                                    <div class="d-flex align-items-end justify-content-between">
                                        <div>
                                            <c:if test="${groupSubCategory.hr == '1'}">
                                                <input id="hr" name="hr" checked="true" type="checkbox" value="1" />
                                            </c:if>
                                            <c:if test="${groupSubCategory.hr == '0' || empty groupSubCategory.hr}">
                                                <input id="hr" name="hr" type="checkbox" value="1" />
                                            </c:if>
                                            <label style="font-weight: normal">HR</label>
                                        </div>

                                        <div>
                                            <c:if test="${groupSubCategory.it == '1'}">
                                                <input id="it" name="it" checked="true" type="checkbox" value="1" />
                                            </c:if>
                                            <c:if test="${groupSubCategory.it == '0' || empty groupSubCategory.it}">
                                                <input id="it" name="it" type="checkbox" value="1" />
                                            </c:if>
                                            <label style="font-weight: normal">IT</label>
                                        </div>

                                        <div>
                                            <c:if test="${groupSubCategory.hsc == '1'}">
                                                <input id="hse" name="hse" checked="true" type="checkbox" value="1" />
                                            </c:if>
                                            <c:if test="${groupSubCategory.hsc == '0' || empty groupSubCategory.hsc}">
                                                <input id="hse" name="hse" type="checkbox" value="1" />
                                            </c:if>
                                            <label style="font-weight: normal">HSE</label>
                                        </div>

                                        <div>
                                            <c:if test="${groupSubCategory.technical == '1'}">
                                                <input id="technical" name="technical" checked="true" type="checkbox" value="1" />
                                            </c:if>
                                            <c:if test="${groupSubCategory.technical == '0' || empty groupSubCategory.technical}">
                                                <input id="technical" name="technical" type="checkbox" value="1" />
                                            </c:if>
                                            <label style="font-weight: normal">TECHNICAL</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="col-12">
                                <div class="form-group">
                                    <label for="remark">Remark <span class="text-danger">*</span></label>
                                    <textarea type="text" class="textarea-field" id="remark" name="remark" required>${groupSubCategory.remark}</textarea>
                                </div>
                            </div>
                                
                            <div class="col-12">
                                <div class="form-group">    
                                    <div style="display: flex;  justify-content: center;">
                                        <button type="submit" class="btn theme-btn">Submit</button>
                                    </div>
                                </div>
                            </div>
                            
                        </div>
                    </div>

                </form:form>
            </section>
        </main> 
    </body>

    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
    
    <script>
        function fetchGroupCategory(groupName) {
            var groupMasterId = document.getElementById("groupName").value;

            $.ajax({
                data: 'groupName=' + groupName,
                url: "group.htm?act=selectgroupCategoryByGroupName",
                success: function (content) {
                    var data1 = "";
                    var obj = JSON.parse(content);
                    var objLength = Object.keys(obj['groupCategory']).length;
                    var object = obj['groupCategory'];

                    for (var i = 0; i < objLength; i++) {
                        if (i === 0) {
                            data1 = "<option value=''>-- Select --</option><option value='" + object[i].id + "'>" + object[i].groupCategoryName + "</option>";

                        } else {
                            data1 += "<option value='" + object[i].id + "'>" + object[i].groupCategoryName + "</option>";
                        }
                        document.getElementById('groupCategoryName').innerHTML = data1;
                        $('.select-input').selectpicker('refresh');
                    }
                }
            });
        }
        
        
    </script>
    
    <script>
        function truncateMiddle(filename, maxLength = 20) {
            if (filename.length <= maxLength) return filename;

            const extIndex = filename.lastIndexOf('.');
            const extension = extIndex !== -1 ? filename.substring(extIndex) : '';
            const base = extIndex !== -1 ? filename.substring(0, extIndex) : filename;

            const visibleChars = maxLength - extension.length - 3;
            const startChars = Math.ceil(visibleChars / 2);
            const endChars = Math.floor(visibleChars / 2);

            return base.substring(0, startChars) + '...' + base.substring(base.length - endChars) + extension;
        }

        document.addEventListener("DOMContentLoaded", function () {
            const link = document.getElementById("attachmentLink");
            const fullName = link.textContent.trim();
            const truncated = truncateMiddle(fullName, 17);

            link.textContent = truncated;
        });
    </script>

    
</html>
