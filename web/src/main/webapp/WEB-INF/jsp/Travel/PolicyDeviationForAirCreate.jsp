<%--
    Document   : PolicyDeviationForAirCreate
    Created on : Oct 23, 2015, 10:39:17 AM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Policy Deviation For Air Create</title>
    </head>
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




    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Policy Deviation For Air Create: </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Policy Deviation For Air Create</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="policyDeviationForAir.htm?act=createSubmit" method="post" commandName="policyDeviationForAir"
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
                                                <div class="col-sm-6">
                                                    <label>Level:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:select path="levelMaster" class="form-control">
                                                        <%--<form:option value="" label="-- Select --" ></form:option>--%>
                                                        <form:options items="${level}"></form:options>
                                                    </form:select>
                                                    <form:errors path="levelMaster" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class=" col-sm-6">
                                                        <label>Air Travel:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:select path="deviation" class="form-control">
                                                        <form:option value="" label="-- Select --" ></form:option>
                                                        <form:option value="Yes" label="Yes" ></form:option>
                                                        <form:option value="No" label="No" ></form:option>
                                                        <%--<form:options items="${level}"></form:options>--%>
                                                    </form:select>
                                                    <form:errors path="deviation" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>

                                                <!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div><!-- /.tab-content -->
                                    <br/>
                                    <div class="form-group">
                                        <div class=" col-sm-6 col-sm-offset-5">
                                            <button type="submit" class="btn btn-primary" id="saveSubmit1" style="width: 100px;">SUBMIT</button>
                                        </div>
                                    </div>
                                </div><!-- nav-tabs-custom -->
                            </div><!-- /.col -->
                        </div>
                    </div>
                </section>

        </form:form>
        <!--</div>-->
        <!--Employee detail completes here-->
        <!--read only entries ends here-->

        <!--form horizontal ends here-->
        <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
        <!-- /.content -->
    </div>


    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

</html>
