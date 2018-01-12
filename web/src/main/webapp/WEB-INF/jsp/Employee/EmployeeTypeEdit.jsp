
<%--
    Document   : LeaveTypeMasterView
    Created on : Oct 14, 2015, 2:36:39 PM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Type Edit</title>
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
            <h1>Employee Type Edit </h1>
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
        <form:form action="employeeType.htm?act=editSubmit" method="post" commandName="employeeTypeMaster"
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
                                            <div class="col-sm-3">
                                                <label class="control-label">Enter Employee Type:<span style="color: red;font-size: 12px;">*</span></label>
                                            </div>
                                            <div class="col-sm-7">
                                            <form:input path="typeOfEmployee" class="form-control"  placeholder="Enter Employee Type" onblur="checkLength(this)" maxlength="30"/>
                                            <form:errors path="typeOfEmployee" cssClass="errorDiv"/>
                                        </div>
                                        </div>



                                                <!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                        <hr/>
                                        <div class="col-md-12" style="text-align: center;">
                                            <button type="submit" class="btn btn-primary" id="saveSubmit1">Submit</button>
                                        </div>
                                    </div><!-- /.tab-content -->
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
    <script>
        function checkLength(el) {
  if (el.value.length != 30) {
    alert("length must be exactly 30 characters")
  }
}
        </script>
</html>

