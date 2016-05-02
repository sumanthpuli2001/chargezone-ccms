<%--
    Document   : ShiftRotationInfoView
    Created on : Nov 8, 2015, 11:02:29 AM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shift Rotation Edit</title>
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
            <h1>Shift Rotation Edit </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Edit</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="shiftRotationInfo.htm?act=editRotationSubmit" method="post" commandName="shiftRotationInfo"
                   name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
            <form:hidden path="id"></form:hidden>

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
                                                        <label>Shift Name:</label>

                                                        <select name="shiftId" id="shiftId" class="form-control">
                                                            <!--<option value="" label="-- Select --" ></option>-->
                                                        <c:forEach var="shift1" items="${rotationMap}">
                                                            <option value="${shift1.key}">${shift1.value}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label>Shift Rotation Date:</label>

                                                    <div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                        <form:input path="rotationDate" class="form-control" size="16" value="" readonly="true"></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    <form:errors path="rotationDate" cssClass="errorDiv"></form:errors>

                                                    </div>
                                                </div>

                                                <!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div><!-- /.tab-content -->
                                    <hr/>
                                    <button type="submit" class="btn btn-primary" id="saveSubmit1" >Submit</button>
                                </div><!-- nav-tabs-custom -->
                            </div><!-- /.col -->
                        </div>
                    </div>
                </section>

        </form:form>
        <!--</div>-->
        <!--Employee detail completes here-->
        <!--read only entries ends here-->

        <!--form horizontal ends here-->       <!--</div>-->
        <!--Employee detail completes here-->
        <!--read only entries ends here-->

        <!--form horizontal ends here-->
        <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
        <!-- /.content -->
    </div>

    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <script>
        $(document).ready(function () {
            if ($('#carriedForwardStatus1').attr('checked')) {
                $('#chechBoxDivId').show(500);
            }
        });
        $('#carriedForwardStatus1').on('ifChecked', function (event) {
            $('#chechBoxDivId').show(500);
        });
        $('#carriedForwardStatus1').on('ifUnchecked', function (event) {
            $('#chechBoxDivId').hide(500);
        });


    </script>
</html>
