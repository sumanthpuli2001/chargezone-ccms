<%-- 
    Document   : ServiceRightEdit
    Created on : 16 Jun, 2022, 1:58:46 PM
    Author     : admin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Service Right</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Edit Service Right</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Edit Service Right</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <span style="color: red;font-size: 14px;">* Indicates Mandatory Field.</span>
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                                <form:form action="right.htm?act=editServiceRightsSubmit" method="post" commandName="serviceRights"
                                           class="form-horizontal" role="form">
                                    <input type="hidden" name="id" value="${id}">
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Department :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="department" readonly="true"  class="form-control"   required="required"/>
                                        </div>
                                    </div>
                                        
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Location :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="location" readonly="true"  class="form-control"   required="required"/>
                                        </div>
                                    </div>    
                                        
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <c:if test="${sap == '1'}">
                                                <input id="sap" name="sap" checked="true" type="checkbox" value="1" />
                                            </c:if>
                                            <c:if test="${sap == '0'}">
                                                <input id="sap" name="sap" type="checkbox" value="1" />
                                            </c:if>
                                        </div>
                                        <div class="col-sm-3">
                                            <label style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >SAP</label>
                                        </div>
                                    </div>
                                        
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <c:if test="${service1 == '1'}">
                                                <input id="service1" name="service1" checked="true" type="checkbox" value="1" />
                                            </c:if>
                                            <c:if test="${service1 == '0'}">
                                                <input id="service1" name="service1" type="checkbox" value="1" />
                                            </c:if>
                                        </div>
                                        <div class="col-sm-3">
                                            <label style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Service 1</label>
                                        </div>
                                    </div>    
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <c:if test="${service2 == '1'}">
                                                <input id="service2" name="service2" checked="true" type="checkbox" value="1" />
                                            </c:if>
                                            <c:if test="${service2 == '0'}">
                                                <input id="service2" name="service2" type="checkbox" value="1" />
                                            </c:if>
                                        </div>
                                        <div class="col-sm-3">
                                            <label style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Service 2</label>
                                        </div>
                                    </div>
                                        
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <c:if test="${service3 == '1'}">
                                                <input id="service3" name="service3" checked="true" type="checkbox" value="1" />
                                            </c:if>
                                            <c:if test="${service3 == '0'}">
                                                <input id="service3" name="service3" type="checkbox" value="1" />
                                            </c:if>
                                        </div>
                                        <div class="col-sm-3">
                                            <label style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Service 3</label>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <c:if test="${service4 == '1'}">
                                                <input id="service4" name="service4" checked="true" type="checkbox" value="1" />
                                            </c:if>
                                            <c:if test="${service4 == '0'}">
                                                <input id="service4" name="service4" type="checkbox" value="1" />
                                            </c:if>
                                        </div>
                                        <div class="col-sm-3">
                                            <label style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Service 4</label>
                                        </div>
                                    </div>
                                        
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <c:if test="${service5 == '1'}">
                                                <input id="service5" name="service5" checked="true" type="checkbox" value="1" />
                                            </c:if>
                                            <c:if test="${service5 == '0'}">
                                                <input id="service5" name="service5" type="checkbox" value="1" />
                                            </c:if>
                                        </div>
                                        <div class="col-sm-3">
                                            <label style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Service 5</label>
                                        </div>
                                    </div>
                                        
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <c:if test="${service6 == '1'}">
                                                <input id="service6" name="service6" checked="true" type="checkbox" value="1" />
                                            </c:if>
                                            <c:if test="${service6 == '0'}">
                                                <input id="service6" name="service6" type="checkbox" value="1" />
                                            </c:if>
                                        </div>
                                        <div class="col-sm-3">
                                            <label style="font-weight: normal" data-toggle="tooltip" data-placement="bottom" >Service 6</label>
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
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

</html>
