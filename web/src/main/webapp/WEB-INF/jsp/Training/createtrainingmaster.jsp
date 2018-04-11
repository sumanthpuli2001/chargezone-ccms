<%-- 
    Document   : createtrainingmaster
    Created on : 3 Mar, 2018, 4:50:33 PM
    Author     : Dell-1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head> 
        <title>Training Type Master </title>

    </head>
    <script>
        function checkBlankField() {
            var flag = true;
            if ($('#training').val().replace(/\s/g, "") == '') {
                document.getElementById('trainingError').innerHTML = '-It must not be empty or white space.';
                flag = false;
            }
            return flag;
        }
        function trainerOnchangeFunction(idString) {
            if (document.getElementById(idString).innerHTML != null) {
                document.getElementById(idString).innerHTML = '';
            }
        }
    </script>

    <div class="content-wrapper">
        <section class="content-header">
            <h1>Training Type Master</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Training Type Master</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <form:form class="form-horizontal" role="form1" action="trainingType.htm?act=Submittraningtype"  method="post" name='form' commandName="trainingType" onsubmit='return checkBlankField();'>
            <form:hidden path="id"></form:hidden>
            <form:hidden path="createdby"></form:hidden>
            <form:hidden path="createddate"></form:hidden>
                <section class="content">
                    <div class="col-md-12">
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <div class="col-sm-6"><span style="color: red;font-size: 12px;"></span>
                                                    <label>Training Type:<span style="color: red;font-size: 12px;">*</span></label>
                                                <form:input path="training" id="training" class="form-control" placeholder="Training" onchange="trainerOnchangeFunction('trainingError');"></form:input>
                                                <form:errors path="training" cssClass="errorDiv"></form:errors>
                                                    <span style="font-size: 14px; color: #dd4b39;" id="trainingError"></span>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label>Status:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <fieldset>
                                                        <!--                                                    <input type="radio" name="status" id="status" value="0" checked>Active&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                                                            <input type="radio" name="status" id="status" value="1">Inactive-->
                                                    <form:radiobutton path="status" id="status" name="status" required="required"  value="0"/>Active&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                    <form:radiobutton path="status" id="status" name="status" required="required" value="1"/>Inactive
                                                </fieldset>
                                            </div>

                                        </div>


                                        <%--</c:if>--%>
                                        <div class="form-group">
                                            <div class=" col-sm-6 col-sm-offset-5">
                                                <button type="submit" class="btn btn-primary" style="width: 100px;" data-original-title="" title="" >SUBMIT</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form:form>
    </div>

    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
