<%-- 
    Document   : ItRequestTypeCreate
    Created on : Nov 30, 2015, 2:53:41 PM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
         <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create IT Request Type</title>
        <script>
        var flag3 = true;
        function saveSubmit11() {
            if (flag3) {
                flag3 = false;
                document.getElementById('saveSubmit1').innerHTML = 'Saving ... .. .';
                document.form1.submit();
                return true;
            } else {
                return false;
            }
        }
    </script>
    </head>
    <body>
 <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Create IT Request Type: </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Create IT Request</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="itRequestType.htm?act=createSubmit" method="post" commandName="itRequestType"
                   name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                  <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                <div class="box-header">
                                </div><!-- /.box-header -->
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <div class="col-sm-2">
                                                    <label>IT Request Type:<span style="color: red;font-size: 12px;">*</span></label>
                                                </div>
                                                <div class="col-sm-8">
                                                    <form:input path="text" class="form-control" placeholder="Enter IT Request"></form:input>
                                                    <form:errors path="text" cssClass="errorDiv"></form:errors>
                                                </div>
                                            </div>

                                                <!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div><!-- /.tab-content -->
                                    <hr/>
                                      <div class="form-group">
                                          <div class="col-sm-6 col-sm-offset-5">
                                    <button type="submit" class="btn btn-primary" id="saveSubmit1" >Submit</button>
                                    </div>
                                    </div>
                                </div><!-- nav-tabs-custom -->
                            </div><!-- /.col -->
                        </div>
                </section>
        </form:form>
        <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
        <!-- /.content -->
    </div>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
            </body>
</html>
