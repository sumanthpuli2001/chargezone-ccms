
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Approve Tender Work Flow</title>
    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="tenderMaster.htm?act=approvalWorkFlowSubmit" method="post" commandName="tenderMaster"
                           class="form-horizontal" role="form" enctype="multipart/form-data">           
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Approve Tender Work Flow</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                            <button type="submit" class="btn theme-btn">Submit</button>
                        </div>
                    </div>

                    <hr>
                    <c:if test="${!empty successMessage}">
                        <div id="successMsg" class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                    </c:if>
                    <c:if test="${!empty failureMessage}">
                        <div id="failureMsg" class="fadeOutEffect alert alert-danger" style="padding: 0px" role="alert">${failureMessage}</div>
                    </c:if>
                    <input type="hidden" id="id" name="id" value="${id}">                    
                  <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.
                        </div>
                    </div>                                        
                        <input type="hidden" name="policyCount" id="policyCount" value="1"/>

                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label for="department-name" class="label">Tender No</label>

                                    <input type="text" class="input-field" id="refNo" name="refNo" value="${refNo}" readonly="true">
                                </div>
                            </div>
                        </div>
                    </div> 

                    <h5 class="fw-600">Tender Approval</h5>       

                    <table id="commonDocTable" class="table table-striped bg-white dt-scroll" style="width: 100%" align="Center"  >
                        <thead>
                            <tr>
                                <th >Approval List</th>
                        </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td id="policyId1"><div>
                                        <select id="tenderApprovalSetting"  name="tenderApprovalSetting"   class="select-input">
                                            <c:forEach var="tenderApprovalSetting" items="${tenderApprovalSetting}" varStatus = "status">
                                                <option value="${tenderApprovalSetting.id}">${tenderApprovalSetting.approvalName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <span id="policyError1" style="color: red;"></span>
                                </td>

                            </tr>
                        </tbody>
                    </table>

                    <div class="col-12 p-0">
                        <div class="form-group comment-box">
                            <label class="control-label">Comment :<span class="text-danger">*</span></label>
                            <textarea type="text" maxlength="250" class="textarea-field comment" id="comment" name="comment"  required="true"></textarea>
                        </div>
                    </div> 
                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label for="department-name" class="label">Upload File<span
                                            class="text-danger">*</span></label>

                                    <input type="file" id="technicalfile"  name="technicalfile" class="input-field">
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div style="display: flex;  justify-content: center;">
                            <button type="submit" class="btn theme-btn" style="width: 100px;" onclick="return Validate()" title="" value="">SUBMIT</button>
                        </div>
                    </div>



                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
