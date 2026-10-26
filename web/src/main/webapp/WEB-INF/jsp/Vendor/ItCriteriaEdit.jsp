<%-- 
    Document   : ItCriteriaEdit
    Created on : 23 Aug, 2025, 3:15:27 PM
    Author     : bulwarks-2
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HR Criteria Edit</title>
    </head> 
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">

            <div style="display: flex; height: 25px;
                 justify-content: space-between;
                 align-items: center;">
                <h4 style="margin-top: 1px;">HR Criteria Edit</h4>
                <input type="button"  class="btn btn-primary" style="" onclick="history.back();" title="" value="Back" >
            </div>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if> 
                                <form:form action="group.htm?act=itCriteriaEditSubmit" method="post" commandName="hrCriteria"
                                           class="form-horizontal" role="form">

                                    <input type="hidden" name="id" value="${vendorItCriteria.id}">

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Group  Name :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <select class="form-control" id="groupName" name="groupName" required="true" onchange="fetchGroupCategory(this.value)">
                                                <option value="">--select--</option>
                                                <c:forEach var="list" items="${list}">
                                                    <c:choose>
                                                        <c:when test="${vendorItCriteria.groupId==list.id}">
                                                            <option selected="true" value="${list.id}">${list.groupName}</option>

                                                        </c:when>
                                                        <c:otherwise>
                                                            <option  value="${list.id}">${list.groupName}</option>

                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:forEach>
                                            </select>              
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Criteria Name<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input class="form-control"  name="criteriaName" id="criteriaName" value="${vendorItCriteria.criteriaName}" required="required"/>
                                        </div>

                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Criteria Description <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <textarea  class="form-control"   name="criteriaDescription" id="criteriaDescription"  value="${vendorItCriteria.criteriaDescription}" required="required">${vendorItCriteria.criteriaDescription}</textarea>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Mandatory :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <select name="mandatory" id="mandatory" class="form-control" required="required">
                                                <option value="">-- Select --</option>
                                                <option value="Yes" <c:if test="${vendorItCriteria.mandatory == 'Yes'}">selected</c:if>>Yes</option>
                                                <option value="Yes" <c:if test="${vendorItCriteria.mandatory == 'No'}">selected</c:if>>No</option>
                                            </select>


                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Compulsory :<span style="color: red; font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <select name="checkbox" id="mandatory" class="form-control" required="required">
                                                <option value="">-- Select --</option>
                                                <option value="1" <c:if test="${vendorItCriteria.compulsaryFlag == '1'}">selected</c:if>>Yes</option>
                                                <option value="0" <c:if test="${vendorItCriteria.compulsaryFlag == '0'}">selected</c:if>>No</option>
                                            </select>
                                        </div>
                                    </div>



                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;" onclick="return Validate()" title="" value="SUBMIT">
                                        </div>
                                    </div>
                                </form:form>

                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer1.jsp"%>

</html>

