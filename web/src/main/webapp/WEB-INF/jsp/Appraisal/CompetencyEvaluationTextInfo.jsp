<%-- 
    Document   : competencyEvaluation
    Created on : Nov 17, 2015, 2:28:10 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Competency Evaluation Text Info</title>
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
            <h1>COMPETENCY EVALUATION TEXT INFO</h1>
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
        <form:form action="competencyEvaluationTextmaster.htm?act=createSubmit" method="post" commandName="competencyEvaluationTextmaster"
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
                                                        <label>Competency Evaluation Title:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:select path="competencyEvaluationMaster.id" id="competencyEvaluationMaster" class="form-control"> 
                                                        <!--<select path="competencyEvaluationMaster" class="form-control">-->
                                                        <option value="">--SELECT--</option>
                                                        <%--<c:forEach var="competencyMap" items="${competencyMap}">--%>
                                                            <form:options items="${competencyMap}"></form:options> 
                                                            <!--<option value="${competencyMap.key}">${competencyMap.value}</option>-->
                                                        <%--</c:forEach>--%>
                                                    </form:select> 
                                                    <%--<form:input path="competencyEvaluationMaster" class="form-control" placeholder="Enter Competency Evaluation"></form:input>--%>
                                                    <%--<form:errors path="competencyEvaluationMaster" cssClass="errorDiv"></form:errors>--%>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label>Competency Evaluation Text Info:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="infoText" class="form-control" placeholder="Enter Competency Evaluation Text Info"></form:input>
                                                    <form:errors path="infoText" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
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

        <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->

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
