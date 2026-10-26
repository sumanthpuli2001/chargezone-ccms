<%-- 
    Document   : AddVendor
    Created on : 17 Oct, 2023, 11:31:29 AM
    Author     : Seth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>

    <head>
        <title>Edit Email</title>
    </head>
    <script>
        function viewClick(id) {
            window.location = 'specialCoupon.htm?act=editPunched&id=' + id;
        }
    </script>


    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">

            <div style="display: flex; height: 25px;
                 justify-content: space-between;
                 align-items: center;">
                <h4 style="margin-top: 1px;">Edit Email</h4>
                <input type="button"  class="btn btn-primary" style="" onclick="history.back();" title="" value="Back" >
            </div>
        </section>


        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form1" action="employeeMaster.htm?act=emailEditPageSubmit" method="post" name='form' onsubmit='return saveSubmit11();'>
         
            <input type="hidden" value="${email.id}" name="id" id ="id" />
            
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--form horizontal starts here-->

                                <div class="box-header">

                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">


                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <label class="control-label">Email Title <span style="color: red;font-size: 12px;">*</span></label>
                                                </div>
                                                <div class="col-sm-3">
                                                    <input type="text" name="title" value="${email.title}" readonly  class="form-control" required="required"/>
                                                </div>

                                            </div>


                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <label class="control-label">Email Subject <span style="color: red;font-size: 12px;">*</span></label>
                                                </div>
                                                <div class="col-sm-3">
                                                    <input type="text" name="subject" value="${email.subject}"  class="form-control"   required="required"/>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <label class="control-label">BodyText <span style="color: red;font-size: 12px;">*</span></label>
                                                </div>
                                                <div class="col-sm-8 row-10">
                                                    <textarea type="text" name="bodyText" value="" class="form-control" rows="10"   required="required">${email.bodytext}</textarea>
                                                </div>
                                            </div>

                                        



                                            <div class="form-group">
                                                <div class="col-sm-6 col-sm-offset-5">
                                                    <input type="submit" class="btn btn1" id="submit1" title="submit1" value="SUBMIT" >
                                                </div>
                                            </div>


                                        </div>
                                    </div><!-- /.col -->
                                </div><!-- /.row -->

                            </div><!-- /.box-body -->

                            <div class="tab-pane" id="tab_3"></div>
                        </div>
                    </div>
                </div>

            </section>
        </form:form>

    </div>

    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>