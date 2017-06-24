<%--
    Document   : ShiftCreate
    Created on : Oct 9, 2015, 10:47:55 AM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>



    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Device Management</title>
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
            <h1>Edit Device Management: </h1>

        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="deviceMaster.htm?act=editSubmit" method="post" commandName="deviceMaster"
                   name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
            <form:hidden path="id"></form:hidden>
                <!--<form class="form-horizontal" role="form" commandName>-->

                <!--Read only entries Starts here-->
                <!--<div class="box box-info collapsed-box ">-->
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Custom Tabs -->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                    <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>

                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="box-header">
                                                    <h3 class="box-title col-sm-3">Device Information:</h3>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>IP Address:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div>
                                                        <form:input path="ipAddress" class="form-control" placeholder="Enter Ip Address"></form:input>
                                                        </div>

                                                    <form:errors path="ipAddress" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class=" col-sm-6">
                                                        <label>Port:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="portNo" class="form-control" placeholder="Enter Ip Address"></form:input>
                                                    <form:errors path="portNo" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class=" col-sm-6">
                                                        <label>Sequence NO:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="seqNumber" class="form-control" placeholder="Enter Ip Address"></form:input>

                                                    <form:errors path="seqNumber" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class=" col-sm-6">
                                                        <label>Device Location:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:select path="zydexLocationMaster.id" value="" class="form-control">
                                                        <c:forEach var="Map" items="${deptMap}">
                                                            <form:option value="${Map.key}">${Map.value}</form:option>
                                                        </c:forEach>
                                                    </form:select>  
                                                    <form:errors path="zydexLocationMaster.id" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class=" col-sm-6">
                                                        <label>No. of Attempts:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="countConnectionOut" class="form-control" placeholder="Enter No. of Attempts"></form:input>
                                                    <form:errors path="countConnectionOut" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <br/>
                                                <button  type="submit" class="btn btn-primary center-block" style="width: 100px;font-weight: bold;" id="saveSubmit1" >SUBMIT</button>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div><!-- /.tab-content -->
                            </div><!-- nav-tabs-custom -->
                        </div><!-- /.col -->
                    </div>
                </section>

        </form:form>

        <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->

    </div>

    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

</html>
